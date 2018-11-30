/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf17002;

import static com.sun.javafx.fxml.expression.Expression.modulo;
import java.util.Scanner;

/**
 *
 * @author Franklin Fuentes
 */
public class MetodoMC {
    
    
    public void MetodoMC(){
Scanner entrada = new Scanner(System.in); 
   MontCaux stdin = new MontCaux();  
 
System.out.print("Escriba una semilla: ");
stdin.setSem(entrada.nextInt());
System.out.print("Escriba una constante multiplicativa: ");
 stdin.setCmult(entrada.nextInt());
System.out.print("Escriba el módulo: ");
stdin.setMod(entrada.nextInt());

for (stdin.i=1; stdin.i<=20; stdin.i++){
     stdin.n1 = (stdin.getCmult()*stdin.getSem()) % stdin.getMod();   
     stdin.n2 = (int) ((double)stdin.n1 / (double)(stdin.getMod()-1));
   System.out.printf("%d. %d (%.4f)\n", stdin.i ,stdin.n1 ,stdin.n2 ); 
   stdin.sem = stdin.n1; 
}
    }
    
}
