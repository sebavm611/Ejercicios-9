/*
6. Escribir un programa que permita realizar operaciones con fechas
@autor Pablo Vélez y Rodrigo Ortiz  MARZO - JULIO 2023
 */

import java.util.Scanner;
import java.util.Calendar;

public class operacionesFechas {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in, "ISO-8859-1");
        String op;

        do {

            System.out.print("Ingrese la fecha y la operación: ");
            String entrada = s.nextLine();

            boolean flag = verificarFormato(entrada);

           while (!flag) {

                System.out.print("ERROR! el formato debe ser DD-Nombre de mes-AAAA con las operaciones (+/-/cmp) separadas por espacios antes y despues: ");
                entrada = s.nextLine();

                flag = verificarFormato(entrada);
            }

            String[] partes = entrada.split(" ");

            String fecha = partes[0];

            String operacion = partes[1];

            int dia = Integer.parseInt(fecha.substring(0, 2));

            String mes = fecha.substring(3, fecha.indexOf("-", 3));

            int anio = Integer.parseInt(fecha.substring(fecha.lastIndexOf("-") + 1));

            Calendar calendario = Calendar.getInstance();

            calendario.clear();

            calendario.set(Calendar.DAY_OF_MONTH, dia);

            calendario.set(Calendar.MONTH, obtenerIndiceMes(mes));

            calendario.set(Calendar.YEAR, anio);

            if (operacion.equals("+")) {

                int diasASumar = Integer.parseInt(partes[2]);

                calendario.add(Calendar.DAY_OF_MONTH, diasASumar);

            } else if (operacion.equals("-")) {

                int diasARestar = Integer.parseInt(partes[2]);

                calendario.add(Calendar.DAY_OF_MONTH, -diasARestar);

            } else if (operacion.equals("cmp")) {

                String fecha2 = partes[2];

                int dia2 = Integer.parseInt(fecha2.substring(0, 2));

                String mes2 = fecha2.substring(3, fecha2.indexOf("-", 3));

                int anio2 = Integer.parseInt(fecha2.substring(fecha2.lastIndexOf("-") + 1));

                Calendar calendario2 = Calendar.getInstance();

                calendario2.clear();

                calendario2.set(Calendar.DAY_OF_MONTH, dia2);

                calendario2.set(Calendar.MONTH, obtenerIndiceMes(mes2));

                calendario2.set(Calendar.YEAR, anio2);

                int comparacion = compararFechas(calendario, calendario2);

                if (comparacion < 0) {

                    System.out.println(fecha + " es menor que " + fecha2);

                } else if (comparacion > 0) {

                    System.out.println(fecha + " es mayor que " + fecha2);

                } else {

                    System.out.println(fecha + " es igual a " + fecha2);

                }

                //return;
            }

            int resultadoDia = calendario.get(Calendar.DAY_OF_MONTH);

            int resultadoMes = calendario.get(Calendar.MONTH);

            int resultadoAnio = calendario.get(Calendar.YEAR);

            String nombreMesResultado = obtenerNombreMes(resultadoMes);

            String resultado = String.format("%02d-%s-%04d", resultadoDia, nombreMesResultado, resultadoAnio);

            System.out.println("El resultado es: " + resultado);

            System.out.print("Desea continuar S/N: ");

            op = s.nextLine();

            while (!op.matches("[nNsS]")) {
                System.out.print("ERROR! Ingrese S/N: ");
                op = s.nextLine();

            }

        } while (!op.matches("[nN]"));

    }

    public static int obtenerIndiceMes(String mes) {

        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        for (int i = 0; i < nombresMeses.length; i++) {

            if (mes.equalsIgnoreCase(nombresMeses[i])) {

                return i;

            }
        }

        return -1;
    }

    public static String obtenerNombreMes(int indiceMes) {

        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        if (indiceMes >= 0 && indiceMes < nombresMeses.length) {

            return nombresMeses[indiceMes];

        }

        return "";

    }

    public static int compararFechas(Calendar fecha1, Calendar fecha2) {

        return fecha1.compareTo(fecha2);

    }

    public static boolean verificarFormato(String cadena) {

        if (!cadena.matches("((0?[1-9]|([1-2][0-9])|30|31)-([A-Z][a-z]+)-(([1][0-9]+)|((20)[0-1][0-9])|((20)[0-2][0-3])))( )(//D)( )(\\d+|(0?[1-9]|([1-2][0-9])|30|31)-([A-Z][a-z]+)-(([1][0-9]+)|((20)[0-2][0-3])))")) {

            return false;

        }

        return true;

    }

}
