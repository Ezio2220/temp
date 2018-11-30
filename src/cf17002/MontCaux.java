/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf17002;

/**
 *
 * @author Franklin Fuentes
 */
public class MontCaux {    //DELARACION DE VARIABLES DE SimultaorMontecarlo

    //DELARACION DE VARIABLES DE RTORRE
    int n;
    
    int sem;
    int cmult;
    int cad;
    int mod;
    int i, n1;  
    double n2; 
    
    public MontCaux(){
        
    }
    public  MontCaux(int semilla, int cmultiplicativa, int caditiva, int modulo){
            this.sem=semilla;
            this.cmult=cmultiplicativa;
            this.cad=caditiva;
            this.mod=modulo;
        }
    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public int getCmult() {
        return cmult;
    }

    public void setCmult(int cmult) {
        this.cmult = cmult;
    }

    public int getCad() {
        return cad;
    }

    public void setCad(int cad) {
        this.cad = cad;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    
}
