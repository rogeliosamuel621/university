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
                    String semilla = obtenerSemilla10();
                    int almacenaNumeros[] = new int [999];
                    generarNewman(semilla,almacenaNumeros);
                    break;
                case 2:
                    String semillaRandom = generar10digitos();
                    int almacenaNumeros2[] = new int [999];
                    generarNewman(semillaRandom, almacenaNumeros2);
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

    public static String generar10digitos () {
        int fiveDigits1 = (int)(100000 * Math.random());
        int fiveDigits2 = (int)(100000 * Math.random());
        String numero10digitos =  "" + fiveDigits1 + fiveDigits2;
        numero10digitos = convertir10digitos(numero10digitos);
        return numero10digitos;
    }

    public static String elevarAl2 (String numero) {
        int num = Integer.parseInt(numero);
        int numeroElevado = (int) (Math.pow(num,2));
        return convertir8digitos(numeroElevado);

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

    public static String obtenerSemilla () {
        int semillaObtenida;
        System.out.println("Ingresa la semilla de 4 digitos");
        semillaObtenida = leer.nextInt();
        String semilla = convertir4digitos(semillaObtenida);
        return semilla;
    }

    public static String obtenerSemilla10 () {
        long semillaObtenida;
        System.out.println("Ingresa la semilla de 10 digitos");
        semillaObtenida = leer.nextLong();
        String semilla = convertir10digitos(semillaObtenida);
        return semilla;
    }

    public static String convertir4digitos (int numero) {
        String numero4digitos;
        numero4digitos = "" + numero;

        for(int i = numero4digitos.length(); i < 4; i++){
            numero4digitos = "0" + numero4digitos;
        }
        return numero4digitos;
    }

    public static String convertir10digitos (long numero) {
        String numero10digitos;
        numero10digitos = "" + numero;

        for(int i = numero10digitos.length(); i < 10; i++){
            numero10digitos = "0" + numero10digitos;
        }
        return numero10digitos;
    }

    public static String convertir8digitos (int numero) {
        String numero8digitos = "";
        numero8digitos = "" + numero;

        for(int i = numero8digitos.length(); i < 8; i++){
            numero8digitos = "0" + numero8digitos;
        }
        return numero8digitos;
    }

    public static String convertir10digitos (String numero10digitos) {
        for(int i = numero10digitos.length(); i < 10; i++){
            numero10digitos = "0" + numero10digitos;
        }
        return numero10digitos;
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

    private static String obtener5Digitos(String numero) {
        StringBuilder numInString = new StringBuilder(numero);
        int numLength = numInString.length();

        char digit1 = '1';
        char digit2 = '0';
        char digit3 = '0';
        char digit4 = '0';
        char digit5 = '0';

        // TODO: Validar casos cuando el numero es de menos dígitos
        /**
         * En ocaciones el numero elevado al cuadrado no es de 5 dígitos validos
         * en ocaciones son 05219, como se ve sí tiene 5 digitos pero uno no vale
         * haciendo que su resultado no sea de 9, 10 u 11 digitos, evitando que se tomen sus 5 digitos
         */
        switch (numLength) {
            case 3:
                String tempString0Aux = "00" + numInString;
                digit1 = tempString0Aux.charAt(0);
                digit2 = tempString0Aux.charAt(1);
                digit3 = tempString0Aux.charAt(2);
                digit4 = tempString0Aux.charAt(3);
                digit5 = tempString0Aux.charAt(4);
                break;
            case 4:
                String tempString0Aux1 = "0" + numInString;
                digit1 = tempString0Aux1.charAt(0);
                digit2 = tempString0Aux1.charAt(1);
                digit3 = tempString0Aux1.charAt(2);
                digit4 = tempString0Aux1.charAt(3);
                digit5 = tempString0Aux1.charAt(4);
                break;
            case 5:
                digit1 = numInString.charAt(0);
                digit2 = numInString.charAt(1);
                digit3 = numInString.charAt(2);
                digit4 = numInString.charAt(3);
                digit5 = numInString.charAt(4);
                break;
            case 6:
                String tempString0 = "0" + numInString;
                digit1 = tempString0.charAt(1);
                digit2 = tempString0.charAt(2);
                digit3 = tempString0.charAt(3);
                digit4 = tempString0.charAt(4);
                digit5 = tempString0.charAt(5);
                break;
            case 7:
                digit1 = numInString.charAt(1);
                digit2 = numInString.charAt(2);
                digit3 = numInString.charAt(3);
                digit4 = numInString.charAt(4);
                digit5 = numInString.charAt(5);
                break;
            case 8:
                String tempString1 = "0" + numInString;
                digit1 = tempString1.charAt(2);
                digit2 = tempString1.charAt(3);
                digit3 = tempString1.charAt(4);
                digit4 = tempString1.charAt(5);
                digit5 = tempString1.charAt(6);
                break;
            case 9:
                digit1 = numInString.charAt(2);
                digit2 = numInString.charAt(3);
                digit3 = numInString.charAt(4);
                digit4 = numInString.charAt(5);
                digit5 = numInString.charAt(6);
                break;
            case 10:
                String tempString2 = "0" + numInString;

                digit1 = tempString2.charAt(3);
                digit2 = tempString2.charAt(4);
                digit3 = tempString2.charAt(5);
                digit4 = tempString2.charAt(6);
                digit5 = tempString2.charAt(7);
                break;
            case 11:
                digit1 = numInString.charAt(3);
                digit2 = numInString.charAt(4);
                digit3 = numInString.charAt(5);
                digit4 = numInString.charAt(6);
                digit5 = numInString.charAt(7);
                break;
        }

        String result = "" + digit1 + digit2 + digit3 + digit4 + digit5;

        return result;

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

    public static void generarNewman (String semilla, int array []) {
        long x0 = Long.parseLong(semilla);
        x0 = newmanElevarAl2(x0);

        // paso a string
        String x0EnString = x0 + "";

        System.out.println("X0 = " + semilla);

        // obtengo 5 digitos y esa es la semilla 2
        char digit1 = x0EnString.charAt(7);
        char digit2 = x0EnString.charAt(8);
        char digit3 = x0EnString.charAt(9);
        char digit4 = x0EnString.charAt(10);
        char digit5 = x0EnString.charAt(11);

        String x1 = "" + digit1 + digit2 + digit3 + digit4 + digit5;

        for (int i = 0; i <= 1000; i++) {
            int semillaInt = Integer.parseInt(x1);
            array [i] = semillaInt;

            if (validarRepetido(array, i)) break;
            if (validar0(x1)) break;

            System.out.println("X" + (i+1) + " = " + x1);
            long semillaElevada = Long.parseLong(x1);
            semillaElevada = semillaElevada * semillaElevada;
            x1 = "" + semillaElevada;
            x1 = obtener5Digitos(x1);
        }
    }
}