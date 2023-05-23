
import java.util.Scanner;


/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class CombinacionesTriangulos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,op;
        
        do{
            System.out.println("Ingrese números reales positivos separados por un espacio en blanco:");
            s = sc.nextLine();
            while(!s.matches("([0-9]+(\\.[0-9]+)?)(\\s[0-9]+(\\.[0-9]+)?){2,}")){
                System.out.println("Error! Debe ingresar numeros reales positivos separados por un espacio: ");
                s = sc.nextLine();
            }
            calcularPosibilidades(s);
            
            System.out.print("Desea continuar?(s/n): ");
            op = sc.nextLine();
            while(!op.matches("[sSnN]")){
                System.out.print("Error! Debe ingresar (s/n): ");
                op = sc.nextLine();
            }
            System.out.print("\n");
            
        }while(!op.matches("[nN]"));
        
        /*
        s = sc.nextLine();
        
        boolean b = s.matches("([0-9]+(\\.[0-9]+)?)(\\s[0-9]+(\\.[0-9]+)?){2,}");
        System.out.println(b);*/
        
    }
    
    public static void calcularPosibilidades(String s){
        String cadNum[] = s.split(" ");
        double nums[] = new double [cadNum.length];
        
        for (int i = 0; i < cadNum.length; i++) {
            nums[i] = Double.parseDouble(cadNum[i]);
        }
        
        
        double aux;
        boolean intercambio;
        for (int i = 0; i < nums.length-1; i++) {
            intercambio = false;
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    aux = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = aux;
                    intercambio = true;
                }
            }
            if(!intercambio)
                break;
        }
        
        System.out.println("\n---COMBINACIONES POSIBLES---");
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i-1; j++) {
                for (int k = j+1; k < i; k++) {
                    if((nums[j]+nums[k])>nums[i]){
                        System.out.println(nums[j]+"\t"+nums[k]+"\t"+nums[i]);
                    }
                    
                    //System.out.println(nums[j]+"\t"+nums[k]+"\t"+nums[i]);
                }
            }
        }
        
    }
}
