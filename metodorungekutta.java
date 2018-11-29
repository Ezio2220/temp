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
public abstract class metodorungekutta {
    float h;
    float xi;
    float xf;
    float y1;
    ArrayList <Float> Xs = new ArrayList<Float>();
    ArrayList <Float> Ys = new ArrayList<Float>();
    ArrayList <Float> Ks = new ArrayList<Float>();
    
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
        //System.out.println("i   |"+"x   |"+"y   |"+"k1  |"+"k2  |"+"k3  |"+"k4  |");
        for(acum=0;acum<(It+1);acum++){
             //   System.out.print((acum+1)+"   |");
              //  System.out.print(x[acum]+"   |");
              //  System.out.print(y[acum]+"|");
                Xs.add(x[acum]);
                Ys.add(y[acum]);
                a =x[acum];
                b = y[acum];
                k[0] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                a = x[acum]+(float)(0.5)*h;
                b= y[acum]+(float)(0.5)*k[0]*h;
                //System.out.println(y[0]+"+"+"1/2"+h);
                k[1] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                b= y[acum]+(float)(0.5)*k[1]*h;
                k[2] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                a=x[acum]+h;
                b=y[acum]+k[2]*h;
                k[3] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                t = (float)(k[0]+2*k[1]+2*k[2]+k[3])/6;
                y[acum+1] = y[acum]+(t)*h;
                
           for(int j=0;j<4;j++){
                    Ks.add(k[j]);
  //                   System.out.print(k[j]+"|");
                     if(j==3){
    //                     System.out.println(" ");
                     }
                 }
           x[acum+1]=x[acum]+h;
           
        }
    }
    public abstract void setxi();
    public abstract void setxf();
    public abstract void seth();
    public abstract void sety1();
    
    public abstract float getxi(float x);
    public abstract float getxf(float x2);
    public abstract float geth(float hr);
    public abstract float gety1(float y);
    
    public void mostrar(){
        int ac = 0;
        int kc = 0;
        System.out.println("i   |"+"x   |"+"y   |"+"k1  |"+"k2  |"+"k3  |"+"k4  |");
        
        for(float i : Ys){
            System.out.print((ac+1)+" |");
            System.out.print(Xs.get(ac)+"   |");
            System.out.print(i+"|");
            for(int j=kc;j<kc+4;j++){
                System.out.print(Ks.get(j)+"|");
                if(j==(kc+3)){
                    System.out.println(" ");
                }
            }
            kc +=4;
        }
    }
}
