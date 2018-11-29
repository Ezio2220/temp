/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clave2;

import java.util.ArrayList;

/**
 *
 * @author Franklin Fuentes
 */
public class rugenkutta {
    ArrayList <Float> Xs = new ArrayList<Float>();
    ArrayList <Float> Ys = new ArrayList<Float>();
    ArrayList <Float> Ks = new ArrayList<Float>();
    
    ArrayList <Float> K1s = new ArrayList<Float>();
    ArrayList <Float> K2s = new ArrayList<Float>();
    ArrayList <Float> K3s = new ArrayList<Float>();
    ArrayList <Float> K4s = new ArrayList<Float>();
    
    public  void calcular(float h,float xi,float xf,float y1){
        this.Ys.clear();
        this.Ks.clear();
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
                k[0] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                a = x[acum]+(float)(0.5)*h;
                b= y[acum]+(float)(0.5)*k[0]*h;
    
                k[1] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                b= y[acum]+(float)(0.5)*k[1]*h;
                k[2] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                a=x[acum]+h;
                b=y[acum]+k[2]*h;
                k[3] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                t = (float)(k[0]+2*k[1]+2*k[2]+k[3])/6;
                y[acum+1] = y[acum]+(t)*h;
                K1s.add(k[0]);
                K2s.add(k[1]);
                K3s.add(k[2]);
                K4s.add(k[3]);
                
           x[acum+1]=x[acum]+h;
           
        }
    }
    
    public  void mostrar(){
        int ac = 0;
        int kc = 0;
        System.out.println("i   |"+"x   |"+"y   |"+"k1  |"+"k2  |"+"k3  |"+"k4  |");
        
        for(float i : Ys){
            System.out.print((ac+1)+" |");
            System.out.print(Xs.get(ac)+"   |");
            System.out.print(i+"|");
            System.out.print(K1s.get(ac)+"|");
            System.out.print(K2s.get(ac)+"|");
            System.out.print(K3s.get(ac)+"|");
            System.out.println(K4s.get(ac)+"|");
            kc +=4;
            ac++;
        }
    }
}
