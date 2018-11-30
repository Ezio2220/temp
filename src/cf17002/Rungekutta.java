/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf17002;

import java.util.ArrayList;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franklin Fuentes
 */
public class Rungekutta extends Bitacora implements auxMetodo {
    ArrayList <Float> Xs = new ArrayList<Float>();
    ArrayList <Float> Ys = new ArrayList<Float>();
    
    ArrayList <Float> K1s = new ArrayList<Float>();
    ArrayList <Float> K2s = new ArrayList<Float>();
    ArrayList <Float> K3s = new ArrayList<Float>();
    ArrayList <Float> K4s = new ArrayList<Float>();
    
    public  void calcular(float h,float xi,float xf,float y1){
        this.Ys.clear();
        this.K1s.clear();
        this.K2s.clear();
        this.K3s.clear();
        this.K4s.clear();
        this.Xs.clear();
        int It = Math.round(xf/h);

        float[] y = new float[It+2];
        
        y[0] = y1;
        float[] k = new float[4];
        
        float[] x = new float[It+2];
        x[0]=xi;
        
        int acum,ac;
        float a;float b;float t;
    
        for(acum=0;acum<(It+1);acum++){
                Xs.add(x[acum]);
                Ys.add(y[acum]);
                a =x[acum];
                b = y[acum];
                k[0] = this.funcion(a,b);
                a = x[acum]+(float)(0.5)*h;
                b= y[acum]+(float)(0.5)*k[0]*h;
    
                k[1] = this.funcion(a,b);
                b= y[acum]+(float)(0.5)*k[1]*h;
                k[2] = this.funcion(a,b);
                a=x[acum]+h;
                b=y[acum]+k[2]*h;
                k[3] = this.funcion(a,b);
                t = (float)(k[0]+2*k[1]+2*k[2]+k[3])/6;
                y[acum+1] = y[acum]+(t)*h;
                K1s.add(k[0]);
                K2s.add(k[1]);
                K3s.add(k[2]);
                K4s.add(k[3]);
                
           x[acum+1]=x[acum]+h;
           
        }
    }
    public void mostrarConsola(){
        this.mostrar(Ys, Xs, K1s, K2s, K3s, K4s);
    }

    @Override
    public void mostrar(ArrayList <Float>  Ys,ArrayList <Float>  Xs,ArrayList <Float>  K1s,ArrayList <Float>  K2s,ArrayList <Float>  K3s,ArrayList <Float>  K4s){
        int ac = 0;
        int kc = 0;
        String txt ="Tabla de RESULTADOS: \n";
        System.out.println("i   |"+"x   |"+"y   |"+"k1  |"+"k2  |"+"k3  |"+"k4  |");
        txt+="i   |"+"x   |"+"y   |"+"k1  |"+"k2  |"+"k3  |"+"k4  |";
        txt+="\n";
        for(float i : Ys){
            System.out.print((ac+1)+" |");
            
            System.out.print(Xs.get(ac)+"   |");
            System.out.print(i+"|");
            System.out.print(K1s.get(ac)+"|");
            System.out.print(K2s.get(ac)+"|");
            System.out.print(K3s.get(ac)+"|");
            System.out.println(K4s.get(ac)+"|");
            txt+=(ac+1)+" |"+Xs.get(ac)+"   |"+i+"|"+K1s.get(ac)+"|"+K2s.get(ac)+"|"+K3s.get(ac)+"|"+K4s.get(ac)+"|";
            txt+="\n";
            kc +=4;
            ac++;
        }
        try {
            save("Bitacora.txt",txt);
        } catch (IOException ex) {
            Logger.getLogger(Rungekutta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public float funcion(float a, float b) {
        return (b*(float)Math.pow(a,2))-(float)1.2*(b);
    }

    @Override
    public void save(String ruta, String texto)throws FileNotFoundException, IOException {
        texto = "   || METODO RUNGEKUTTA||--- \n "+texto;
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
