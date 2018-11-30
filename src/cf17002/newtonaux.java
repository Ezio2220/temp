/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf17002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franklin Fuentes
 */
public class newtonaux extends Bitacora {
    Scanner tec=new Scanner(System.in);
    
    public void metodo(){
         Ifuncion f= new Ifuncion() {
                    @Override
                    //se predofina 
                    public double eval(double x) {
                    return x*x-2;   
                        }
                    };
        //derivada
                Ifuncion df= new Ifuncion() {
                    @Override
                    public double eval(double x) {
                    return 2*x;
                    }
                };
               //toma de los valores en los set de newton rapshon
                ;
                
                System.out.println("valor de x incial");
                double x1 = tec.nextDouble();
                
                System.out.println("numero de ciclo maximo");
                int x2 =tec.nextInt();
                
                metodoNR nr = new metodoNR();
                //se uestra en pantalla ya el resultado 
                String txt="";
               
                System.out.println(nr.raiz(f, df, x1, 1e-6, x2));
                txt+=" x="+x1+" ciclos maximos: "+x2+" \n R: "+nr.raiz(f, df, x1, 1e-6, x2)+"\n";
        try {
            save("Bitacora.txt",txt);
        } catch (IOException ex) {
            Logger.getLogger(newtonaux.class.getName()).log(Level.SEVERE, null, ex);
        }
                

    }

    @Override
    public void save(String ruta, String texto) throws FileNotFoundException, IOException {
        texto = "   || METODO Newton Ransoph||--- \n "+texto;
        BufferedWriter bfwr;
        BufferedReader bfrd;
        File archivotxt = new File(ruta);
        if(archivotxt.exists()) {//verifica si ya esta creado el archivo
            String lineas;String anterior="";//se inicializan el que guardara cada linea y el que guardara todo el contenido previo
            bfrd = new BufferedReader(new FileReader(archivotxt));//se inicializa un bufer de lectura del archivo que especificamos en la ruta
           lineas = bfrd.readLine();//se iguala lineas al primer dato en el buffer de lectura
           if(lineas!=null){
           anterior = lineas+"\n";//anterior almacena este primer dato mas un salto de linea ya que el bufer llega hasta el salto de linea
            while((lineas = bfrd.readLine())!=null) {//se iran iterando cada una de las lineas hasta que haya una en blanco
                anterior += lineas +"\n";//a anterior se iran agregando cada linea separada por saltos de linea
            }
           }
            bfrd.close();//se libera el buffer de lectura dando chanse a iniciar otro bufer
            bfwr = new BufferedWriter(new FileWriter(archivotxt));//se inicia el bufer de escritura del mismo archivo
            bfwr.write(anterior);//se borra todo y se escribe los datos que ya tenian
            bfwr.write(texto+"\n");//se agrega el dato que queriamos
        }else{//en el caso que el archivo no exista se crea
            bfwr = new BufferedWriter(new FileWriter(archivotxt));//se inicia el bufer de escritura
            bfwr.write(texto+"\n");           //se agrega de un solo la linea que queriamos mas un salto de linea
        }
        bfwr.close();//se libera el bufer de escritura
        
    }
    
}
