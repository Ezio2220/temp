/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf17002;

import java.util.ArrayList;

/**
 *
 * @author Franklin Fuentes
 */
public class metodoNR {
    
    //se calcula la ecuacion del newton rapshon en caso que sea diferente de 0
    public double raiz(Ifuncion f, Ifuncion df, double x,double e, int n){
        double r=Double.NaN;
        int k=0;
        while(Math.abs(f.eval(x))>e && k<n)
        {
            x=x-f.eval(x)/df.eval(x);
            k++;
        }
        if(k<n)r=x;
        return r;
        
    }

}
