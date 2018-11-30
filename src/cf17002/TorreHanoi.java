
package cf17002;

import java.util.Scanner;

/**
 *
 * @author Franklin Fuentes
 */
public class TorreHanoi extends graficar {
     public void TorreHanoi(){
     Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Numero de discos: ");
        n =sc.nextInt();
         System.out.println("Torre INICIAL!");
        //drawtorre(n,1,0,0);//numero de anillos, fila inicial,anillos en la fila 2, anillos en la fila 3
        this.dibujarTH(n, 1, 0, 0);
        fila3=0;fila2=0;tam=n;
        Hanoi(n,1,2,3);  //1:origen  2:auxiliar 3:destino
    }
  public static int fila3;//representa los discos en la fila 3 que se acumulan
  public static int fila2;//representan los discos en la fila 2 que se acumulan
  public static int tam;//representa el numero total de discos de la torre
 
  public void Hanoi(int nn, int origen,  int auxiliar, int destino) {
     
      
  if(nn==1){
  System.out.println("  +----------------------+\n" +
                     "  | Mover Disco de "+origen+" a "+destino+" |\n" +
                     "  +----------------------+");
  if(destino==3){
      fila3++;
  }else if(destino ==2){
      fila2++;
  }
  if(origen==2){
    fila2--;
  }else if(origen==3){
    fila3--;
  }
  this.dibujarTH(tam, 1, fila2, fila3);
  }else{
     Hanoi(nn-1, origen, destino, auxiliar);
    System.out.println("  +----------------------+\n" +
                       "  | Mover Disco de "+origen+" a "+destino+" |\n" +
                       "  +----------------------+");
     
     if(destino==3){
      fila3++; 
     }else if(destino ==2){
      fila2++;
     }
     if(origen==2){
         fila2--;
     }else if(origen==3){
         fila3--;
     }
       
    this.dibujarTH(tam, 1, fila2, fila3);
     Hanoi(nn-1, auxiliar, origen, destino);
   }
 }
    
    @Override       ///###NOTA: SOLO SE PUEDE PARA UN MAXIMO DE 8 DISCOS!!
    public void dibujarTH(int nn, int lugar, int n2, int n3) {
        String top = "        ++         ++         ++";//string que representa la punta de la torre
      String base =  "        ++         ++         ++";//representa la base de la torre
      String vacio = "        ||         ||         ||";//representa zonas en dodne no hay anillos
      String[] discos = {
          "       xxxx       ","      xxxxxx      ","     xxxxxxxx     ","    xxxxxxxxxx    ","   xxxxxxxxxxxx   ","  xxxxxxxxxxxxxx  "," xxxxxxxxxxxxxxxx ","xxxxxxxxxxxxxxxxxx"
      };
      String part = " ||";
      String space = "       ";
     
      int comp=nn; 
      int acm = 0;
      int nt2=n2,nt3=n3;
      
      if(nt2==nn){
          nt2=0;
          lugar=2;
      }else if(nt3==nn){
          nt3=0;
          lugar=3;
      }
      System.out.println(" ");
      for(int i=10;i>0;i--){
          if(i==10){
              System.out.println(top);
          }else if(comp==i){
              
                  for(int j=i;comp>acm;j--){
                  if(nt2>0 || nt3 >0){
                      if(nt3>0){
                          System.out.println(space+part+space+" "+part+" "+discos[acm]);
                          nt3--;
                      }else if(nt2>0){
                          System.out.println(space+part+" "+discos[acm]+" ||");
                          nt2--;
                      }
                  }else{
                      
                      if(lugar==1){
                        System.out.println(discos[acm]+part+space+" "+part);
                    }else if(lugar==2){
                        System.out.println(space+part+" "+discos[acm]+" ||");
                    }else if(lugar==3){
                        System.out.println(space+part+space+" "+part+" "+discos[acm]);
                    }
                  }
                    
                    acm++;
                    i=j;       
                  }
              
          }else if(i!=1){
              System.out.println(vacio);
          }
          if(i==1){
              System.out.println(base);
          }
      }
    }
  
}

 

