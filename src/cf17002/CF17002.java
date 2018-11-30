/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf17002;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franklin Fuentes
 */
public class CF17002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rungekutta rk = new Rungekutta();
        newtonaux exe=new newtonaux();
        TorreHanoi Th = new TorreHanoi();
        MetodoMC Mc = new MetodoMC();
        
        int op;
        boolean rep=true;
        Scanner sc = new Scanner(System.in);
        System.out.println("    _/_/_/    _/                                                      _/        _/           \n" +
                           "   _/    _/        _/_/    _/_/_/    _/      _/    _/_/    _/_/_/          _/_/_/    _/_/    \n" +
                           "  _/_/_/    _/  _/_/_/_/  _/    _/  _/      _/  _/_/_/_/  _/    _/  _/  _/    _/  _/    _/   \n" +
                           " _/    _/  _/  _/        _/    _/    _/  _/    _/        _/    _/  _/  _/    _/  _/    _/    \n" +
                           "_/_/_/    _/    _/_/_/  _/    _/      _/        _/_/_/  _/    _/  _/    _/_/_/    _/_/       ");
        while(rep){
           
            System.out.print(  "               +----------+\n" +
                               "               |  MENU:   |\n" +
                               "    +----------+----------+-----------+\n" +
                               "    +> 1-Calcular metodo RugenKutta   |\n" +
                               "    |                                 |\n" +
                               "    +> 2|Calcular metodo newtonRamsok |\n" +
                               "    |                                 |\n" +
                               "    +> 3|Bitacora Matematica          |\n" +
                               "    |                                 |\n" +
                               "    +> 4| Simular Torre De Hanoi      |\n" +
                               "    |                                 |\n" +
                               "    +> 5|Simular metodo Montecarlo    |\n" +
                               "    |                                 |\n" +
                               "    +> 6-SALIR                        |\n" +
                               "    +---------------------------------+\n");
            do{
            System.out.print("    |\n"+"+-->OPCION:");
            op = sc.nextInt();
            }while(op<1 || op>6);
            
            switch(op){
                case 1:{
                    System.out.println("    Escriba el valor inicial de x \n    |");
                    System.out.print("    +-->:");
                    float xi=sc.nextFloat();
                    System.out.println("    Escriba el valor Final de x \n    |");
                    System.out.print("    +-->:");
                    float xf=sc.nextFloat();
                    System.out.println("    Escriba el valor de la altura h \n    |");
                    System.out.print("    +-->:");
                    float h=sc.nextFloat();
                    System.out.println("    Escriba el valor inicial de y \n    |");
                    System.out.print("    +-->:");
                    float y1=sc.nextFloat();
                    rk.calcular(h, xi, xf, y1);
                    System.out.println("    MOSTRANDO RESULTADOS!");
                    rk.mostrarConsola();
                    break;
                }
                case 2:{
                     
                    exe.metodo();
                    break;
                }
                case 3:{
                    try {
                        System.out.println(rk.load("Bitacora.txt"));
                    } catch (IOException ex) {
                        Logger.getLogger(CF17002.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
                    break;
                }
                case 4:{
                    
                    Th.TorreHanoi();
                    break;
                }
                case 5:{
                    
                    Mc.MetodoMC();
                    break;
                }
                case 6:{
                    rep = false;
                    break;
                }
            }
            
        }
        System.out.println("  _|_|_|  _|_|_|      _|_|      _|_|_|  _|_|_|    _|_|      _|_|_|  \n" +
                           "_|        _|    _|  _|    _|  _|          _|    _|    _|  _|        \n" +
                           "_|  _|_|  _|_|_|    _|_|_|_|  _|          _|    _|_|_|_|    _|_|    \n" +
                           "_|    _|  _|    _|  _|    _|  _|          _|    _|    _|        _|  \n" +
                           "  _|_|_|  _|    _|  _|    _|    _|_|_|  _|_|_|  _|    _|  _|_|_|   ");
        System.exit(0);
    }
    
}
