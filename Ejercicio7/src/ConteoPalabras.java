
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rodrigo Ortiz y Pablo Velez
 */
public class ConteoPalabras {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String cadena,op ;
    

        do {

            System.out.print("Ingrese la palabra: ");
            cadena = s.nextLine();

            while (!cadena.matches("([A-Za-z,\\.]+ ?)+")) {
                System.out.print("ERROR! La cadena solo puede contener letras y signos de puntuacion: ");
                cadena = s.nextLine();

            }
            contarPalabras(cadena);

            System.out.print("Desea continuar S/N: ");
            op = s.nextLine();

            while (!op.matches("[nNsS]")) {
                System.out.print("ERROR! Ingrese S/N: ");
                op = s.nextLine();

            }

        } while (!op.matches("[nN]"));
    }

    public static void contarPalabras(String s) {
        String palabras = s.toLowerCase();
        palabras = palabras.replaceAll("[,//.]", "");

        String arregloPalabras[] = palabras.split(" ");

        for (String arregloPalabra : arregloPalabras) {
            contarChar(arregloPalabra);
        }

        ArrayList<String> datosUnicos = new ArrayList<>();
        boolean existente;
        for (int i = 0; i < arregloPalabras.length; i++) {
            existente = false;
            for (int j = i - 1; j >= 0; j--) {
                if (arregloPalabras[i].equals(arregloPalabras[j])) {
                    existente = true;
                    break;
                }
            }
            if (!existente) {
                datosUnicos.add(arregloPalabras[i]);
            }
        }

        if (datosUnicos.size() != arregloPalabras.length) {
            System.out.print("\nExisten las siguientes palabras que se repiten");
            System.out.println("\nPalabra\t\tVeces que aparece");
            int cont;
            for (String datosUnico : datosUnicos) {
                cont = 0;
                for (String arregloPalabra : arregloPalabras) {
                    if (arregloPalabra.equals(datosUnico)) {
                        cont++;
                    }

                }
                if (cont >= 2) {
                    System.out.printf("%s%13d%n", datosUnico, cont);
                }
            }

        } else {
            System.out.println("\nNo existen palabras que se repitan");
        }

    }

    public static void contarChar(String s) {
        char[] caracteres = s.toCharArray();
        ArrayList<Character> datosUnicos = new ArrayList<>();

        boolean existente;
        for (int i = 0; i < caracteres.length; i++) {
            existente = false;
            for (int j = i - 1; j >= 0; j--) {
                if (caracteres[i] == caracteres[j]) {
                    existente = true;
                    break;
                }
            }
            if (!existente) {
                datosUnicos.add(caracteres[i]);
            }
        }

        System.out.println("\nPalabra: " + s);
        System.out.println("Caracter\tVeces que aparece");
        int cont;
        int total = 0;
        for (Character datosUnico : datosUnicos) {
            cont = 0;
            for (char caractere : caracteres) {
                if (datosUnico.charValue() == caractere) {
                    cont++;
                }
            }
            total += cont;
            System.out.println(datosUnico.charValue() + "\t\t" + cont);
        }
        System.out.println("Total: \t\t" + total);

    }
}
