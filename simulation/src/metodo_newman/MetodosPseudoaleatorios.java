package metodo_newman;

import java.util.Scanner;

public class MetodosPseudoaleatorios {

    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        boolean control = true;

        do {
            System.out.print("\tMenu\n"
                    + "\n1.- Metodo de medios cuadrados."
                    + "\n2.- Metodo de Newman."
                    + "\n3.- Salir."
                    + "\n\nOPCION: ");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    menuCuadratico();
                    break;
                case 2:
                    menuNewman();
                    break;
                case 3:
                    control = false;
                    break;
                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }

        }while(control);
    }

    public static void menuCuadratico () {
        int option;
        boolean control = true;

        do {
            System.out.print("\tMenu\n"
                    + "\n1.- Semilla x teclado."
                    + "\n2.- Semilla x funcion random."
                    + "\n3.- Salir."
                    + "\n\nOPCION: ");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    String semilla = obtenerSemilla();
                    int almacenaNumeros[] = new int [999];
                    generarNumeros(semilla, almacenaNumeros);
                    break;
                case 2:
                    String semillaRandom = generar4digitos();
                    int almacenaNumeros2[] = new int [999];
                    generarNumeros(semillaRandom, almacenaNumeros2);
                    break;
                case 3:
                    control = false;
                    break;
                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }

        }while(control);
    }

    public static void menuNewman () {
        int option;
        boolean control = true;

        do {
            System.out.print("\tMenu\n"
                    + "\n1.- Semilla x teclado."
                    + "\n2.- Semilla x funcion random."
                    + "\n3.- Salir."
                    + "\n\nOPCION: ");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    long semilla1 = obtenerSemilla10();
                    empezarSimulacionNewman(semilla1);
                    break;
                case 2:
                    long semillaRandom = generar10digitos();
                    empezarSimulacionNewman(semillaRandom);

                    break;
                case 3:
                    control = false;
                    break;
                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }

        }while(control);
    }

    public static String generar4digitos () {
        int numero = (int)(10000 * Math.random());
        String numeroFinal = convertir4digitos(numero);
        return numeroFinal;
    }

    public static long generar10digitos() {
        int fiveDigits1 = (int)(10000 + Math.random() * 90000);
        int fiveDigits2 = (int)(10000 + Math.random() * 90000);

        String tenDigitsNum =  "" + fiveDigits1 + fiveDigits2;
        return Long.parseLong(tenDigitsNum);
    }

    private static void empezarSimulacionNewman(long num) {
        long x0 = newmanElevarAl2(num);

        // paso a string
        String x0EnString = x0 + "";

        // obtengo 5 digitos y esa es la semilla 2
        char digit1 = x0EnString.charAt(7);
        char digit2 = x0EnString.charAt(8);
        char digit3 = x0EnString.charAt(9);
        char digit4 = x0EnString.charAt(10);
        char digit5 = x0EnString.charAt(11);
        String x1 = "" + digit1 + digit2 + digit3 + digit4 + digit5;
        System.out.println(x1);

        long result = Long.parseLong(x1);
        long prevResult = result;

        // se eleva al cuadrado la semilla 2 y se obtienen los 5 digitos del medio ( si es par, agg un 0 a la izquierda)

        // se repite (se eleva al cuadrado la semilla 2 y se obtienen los 5 digitos del medio ( si es par, agg un 0 a la izquierda))

        // el bucle para hasta que un valor se repita o de 0

        while (result != 0 && prevResult != result) {
            long resultAl2 = result * result;
        }

    }

    private static void obtener5Digitos(long num) {
        String numInString = num + "";
        int numLength = numInString.length();
    }

    public static long newmanElevarAl2 (long num) {
        long result = num * num;

        if (String.valueOf(result).length() == 19) return result;

        if (result < 0) {
            result = result * -1;
            String resultInString = "0" + result;
            return  Long.parseLong(resultInString);
        }

        String resultInString = "0" + result;
        return  Long.parseLong(resultInString);
    }

    public static String elevarAl2 (String numero) {
        int num = Integer.parseInt(numero);
        int numeroElevado = (int) (Math.pow(num,2));
        return convertir8digitos(numeroElevado);

    }

    public static String obtenerSemilla () {
        int semillaObtenida;
        System.out.println("Ingresa la semilla de 4 digitos");
        semillaObtenida = leer.nextInt();
        String semilla = convertir4digitos(semillaObtenida);
        return semilla;
    }

    public static long obtenerSemilla10 () {
        System.out.println("Ingresa la semilla de 10 digitos");
        long semillaObtenida = leer.nextLong();
        return semillaObtenida;
    }

    public static String convertir4digitos (int numero) {
        String numero4digitos;
        numero4digitos = "" + numero;

        for(int i = numero4digitos.length(); i < 4; i++){
            numero4digitos = "0" + numero4digitos;
        }
        return numero4digitos;
    }

    public static String convertir8digitos (int numero) {
        String numero8digitos = "";
        numero8digitos = "" + numero;

        for(int i = numero8digitos.length(); i < 8; i++){
            numero8digitos = "0" + numero8digitos;
        }
        return numero8digitos;
    }

    public static String obtenerNumMitad8 (String numero) {
        String numMedio = numero.substring(2,6);
        return numMedio;
    }

    public static boolean validar0 (String semilla) {
        if (semilla.charAt(0) == '0' & semilla.charAt(1) == '0' & semilla.charAt(2) == '0' & semilla.charAt(3) == '0') {
            return true;
        }
        return false;

    }

    public static boolean validarRepetido (int array[], int variable) {
        for(int z = 0; z < variable; z++) {
            if (array[variable] == array[z]) {
                return true;
            }
        }
        return false;
    }

    public static void generarNumeros (String semilla, int array []) {
        for (int i = 0; i <= 1000; i++) {
            int semillaInt = Integer.parseInt(semilla);
            array [i] = semillaInt;

            if (validarRepetido(array, i)) break;
            if (validar0(semilla)) break;

            System.out.println("X" + i + " = " + semilla);
            semilla = elevarAl2(semilla);
            semilla = obtenerNumMitad8(semilla);
        }
    }
}
