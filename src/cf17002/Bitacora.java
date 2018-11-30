/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf17002;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Franklin Fuentes
 */
public abstract class Bitacora {
    
    public abstract void save(String ruta, String texto)throws FileNotFoundException, IOException;
    public  String load(String ruta)throws FileNotFoundException, IOException{
         BufferedReader bfrd;
        File archivotxt = new File(ruta);//se inicializa el archivo en la ruta
        String lineas;String total="none";//se cran variables para lineas y para total
        bfrd = new BufferedReader(new FileReader(archivotxt));
            
            lineas = bfrd.readLine();
          if(lineas!=null){
          
           total = lineas+"\n";//se agrega la primera linea
            while((lineas = bfrd.readLine())!=null) {
                total += lineas +"\n";//se agregan las demas
            }
          }
            bfrd.close();
            return total;//se retorna un string de todas las lineas del documento para que puedan imprimirse o mostrarse
        
    }
    
}
