
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class Histograma {

    public static void main(String[] args) {
        
        String op = "";
        
        Scanner sc = new Scanner(System.in);

        String nums;

        do {

            System.out.print("Ingrese la cadena de numeros: ");
            nums = sc.nextLine();
            
            while(!nums.matches("(([0-2]?[0-9]{1}(\\.\\d+)?)|(30(\\.0+)?))(( [0-2]?[0-9]{1}(\\.\\d+)?)|( 30(\\.0+)?))*")){
                System.out.println("ERROR! Ingrese solo numeros del 0 al 30 separados por un espacio");
                System.out.print("Digite nuevamente: ");
                nums = sc.nextLine();
            }

            imprimirHistograma(nums);
            
            System.out.print("Desea continuar S/N: ");
            op = sc.nextLine();
            
            while(!op.matches("[nNsS]")){
                System.out.print("ERROR! Ingrese S/N: ");
                op = sc.nextLine();
            }
        }while(!op.matches("N|n"));
       
    
    }

    public static void imprimirHistograma(String s) {
        String[] arregloCad = s.split(" ");
        double[] arregloNum = new double[arregloCad.length];

        for (int i = 0; i < arregloCad.length; i++) {
            arregloNum[i] = Double.parseDouble(arregloCad[i]);
        }
        
        
        int contRangos[] = new int[9];
        String rangos[] = {"0-5","5-10","10-14","14-17","17-20","20-24","24-27","27-30","30"};
        
        for (double elem : arregloNum) {
            if(elem==30){
                contRangos[8]++;
            }else if(elem >= 27){
                contRangos[7]++;
            }else if(elem >= 24){
                contRangos[6]++;
            }else if(elem >= 20){
                contRangos[5]++;
            }else if(elem >= 17){
                contRangos[4]++;
            }else if(elem >= 14){
                contRangos[3]++;
            }else if(elem >= 10){
                contRangos[2]++;
            }else if(elem >= 5){
                contRangos[1]++;
            }else if(elem >= 0){
                contRangos[0]++;
            }
        }
        
        for (int i = 0; i < rangos.length; i++) {
            System.out.print(rangos[i]+"\t");
            for (int j = 0; j < contRangos[i]; j++) {
                System.out.print("+ ");
            }
            System.out.println("");
        }
        
    }
}
