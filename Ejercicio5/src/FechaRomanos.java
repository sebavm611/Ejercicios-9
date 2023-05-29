import java.util.Calendar;
import java.util.Scanner;
/**
 *
 * @author Rodrigo Ortiz y Pablo Vélez
 */
public class FechaRomanos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String cad,op;
        do{
            System.out.print("Ingrese fecha en el formato DD/MM/AAAA: ");
            cad = sc.nextLine();
            while(!validarFormato(cad) || !validarFecha(cad)){
                System.out.print("Error! Ingrese fecha valida hasta hoy en el formato DD/MM/AAAA: ");
                cad = sc.nextLine();
            };
            
            System.out.println("Fecha en numeros romanos: "+fechaRomana(cad));
           
            System.out.print("Desea continuar S/N: ");
            op = sc.nextLine();
            
            while(!op.matches("[nNsS]")){
                System.out.print("ERROR! Ingrese S/N: ");
                op = sc.nextLine();
            }
            
            System.out.println("");
        }while(!op.matches("N|n"));
    }
    
    public static boolean validarFormato(String s){
        return s.matches("(([1-2][0-9])|(3[0-1])|(0?[1-9]))/((1[0-2])|(0?[1-9]))/[1-9][0-9]?[0-9]?[0-9]?");   
    }
    
    public static boolean validarFecha(String s){
        String fecha[] = s.split("/");
        int mes = Integer.parseInt(fecha[1]);
        int dias = 30;
        
        if(((mes<=7)&&(mes%2!=0))||((mes>=8)&&(mes%2==0))){
           dias = 31; 
        }else if(mes==2){
            dias = 28;
        }
        
        if( !(Integer.parseInt(fecha[0]) <= dias)){
            return false;
        }
        
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaIngresada = Calendar.getInstance();
        fechaIngresada.set(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1])-1, Integer.parseInt(fecha[0]));
        
        if(fechaIngresada.compareTo(fechaActual)>0){
            return false;
        }
        return true;
    }
    
    public static String fechaRomana(String s){
       String fecha[] = s.split("/");
       StringBuilder fechaRomana = new StringBuilder();
       
        for (String string : fecha) {
            fechaRomana.append(convertirANumerosRomanos(Integer.parseInt(string)));
            fechaRomana.append("-");
        }
        fechaRomana.deleteCharAt(fechaRomana.length()-1);
       
        return fechaRomana.toString();
    }
    
    public static String convertirANumerosRomanos(int numero) {
        int[] valoresNumericos = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] simbolosRomanos = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valoresNumericos.length; i++) {
            while (numero >= valoresNumericos[i]) {
                resultado.append(simbolosRomanos[i]);
                numero -= valoresNumericos[i];
            }
        }

        return resultado.toString();
    }
}
