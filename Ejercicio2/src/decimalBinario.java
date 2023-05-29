
import java.util.Scanner;

public class decimalBinario {

    public static void convertirEnteros(double enteros[], String enterosBin[]) {

        for (int i = 0; i < enteros.length; i++) {

            enterosBin[i] = "";

            while (enteros[i] >= 2) {

                enterosBin[i] = String.valueOf((int) enteros[i] % 2) + enterosBin[i];

                enteros[i] /= 2;

            }

            enterosBin[i] = String.valueOf((int) enteros[i]) + enterosBin[i];

        }
    }

    public static void convertirDecimales(double decimales[], String decimalesBin[]) {

        for (int i = 0; i < decimales.length; i++) {

            decimalesBin[i] = "";

            while (decimales[i] != 0 && decimalesBin[i].length() < 32) {

                decimales[i] *= 2;

                if (decimales[i] >= 1) {

                    decimalesBin[i] += "1";

                    decimales[i] -= 1;

                } else {

                    decimalesBin[i] += "0";

                }
            }
            decimalesBin[i] = "0." + decimalesBin[i];
        }
    }

    public static void escribirArray(String array1[], String array2[], String array3[]) {

        System.out.println("Decimal\tBinario");

        for (int i = 0; i < array1.length; i++) {

            System.out.println(array3[i] + "\t" + array1[i] + "." + array2[i]);

        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String op;
        
        do {

            System.out.print("Ingrese los números en decimal: ");

            String cadena = scanner.nextLine();

            while (!cadena.matches("((((\\+)?[0-9]+\\.[0-9]+)|((\\+)?[0-9]))( )?)+")) {

                System.out.print("ERROR! Ingrese números reales positivos en sistema decimal separados por un espacio en blanco: ");

                cadena = scanner.nextLine();
            }

            String[] separar = cadena.split(" ");

            double[] enteros = new double[separar.length];

            double[] decimales = new double[enteros.length];

            String[] enterosBin = new String[enteros.length];

            String[] decimalesBin = new String[decimales.length];

            for (int i = 0; i < enteros.length; i++) {

                double numero = Double.parseDouble(separar[i]);

                enteros[i] = Math.floor(numero);

                decimales[i] = numero - enteros[i];

            }

            convertirEnteros(enteros, enterosBin);

            convertirDecimales(decimales, decimalesBin);

            escribirArray(enterosBin, decimalesBin, separar);

            System.out.print("Desea continuar S/N: ");
            
            op = scanner.nextLine();

            while (!op.matches("[nNsS]")) {
                System.out.print("ERROR! Ingrese S/N: ");
                op = scanner.nextLine();

            }

        } while (!op.matches("[nN]"));

    }
}
