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
public class MetodoRungekutta {
        float h;
        float xi;
        float xf;
        float y1;
        private static MetodoRungekutta rungekutta;
    private MetodoRungekutta() {
        
        
    }
    
    public static MetodoRungekutta getInstance() {
        return MetodoRungekuttaHolder.INSTANCE;
    }
    
    private static class MetodoRungekuttaHolder {

        private static final MetodoRungekutta INSTANCE = new MetodoRungekutta();
    }

    public float getH() {
        return h;
    }

    public  void setH(float h) {
        this.h = h;
    }

    public float getXi() {
        return xi;
    }

    public void setXi(float xi) {
        this.xi = xi;
    }

    public float getXf() {
        return xf;
    }

    public void setXf(float xf) {
        this.xf = xf;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }
    
}
