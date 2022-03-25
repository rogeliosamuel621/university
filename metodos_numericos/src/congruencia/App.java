package congruencia;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = getA();
        int x = getX();
        int c = getC();
        int m = getM();

        int[] arr = new int[100];

        generarNumeros(x, a, c, m, arr);
    }

    public static void generarNumeros (int x, int a, int c, int m, int array []) {
        System.out.println("n\tx\taxn+c\t(axn+c)/m\txn+1");
        for (int i = 0; i <= 1000; i++) {
            array [i] = x;
            if (validarRepetido(array, i)) {
                int calculo = (a * x) + c;
                int modulo = calculo % m;
                System.out.println(i + "\t"+ x+ "\t" +calculo + "\t " +calculo + " % " + modulo + "\t         " + modulo);

                break;
            }
            int calculo = (a * x) + c;
            int modulo = calculo % m;

            System.out.println(i + "\t"+ x+ "\t" +calculo + "\t " +calculo + " % " + modulo + "\t         " + modulo);

            x = modulo;

        }
    }

    public static boolean validarRepetido (int array[], int variable) {
        for(int z = 0; z < variable; z++) {
            if (array[variable] == array[z]) {
                return true;
            }
        }
        return false;
    }

     private static int getA() {
        int a;
        boolean esDivisible3, esDivisible5;
        do {
            System.out.println("Digite el valor de A: ");
            a = sc.nextInt();

            esDivisible3 = (a % 3) == 0;
            esDivisible5 = (a % 5) == 0;

            if (esDivisible3 || esDivisible5) System.out.println("Error al introducir A (no debe ser divisible de 3 ni de 5)");

        } while (esDivisible3 || esDivisible5);

        return a;
    }

    public static int getX() {
        int x = 0;
        int option;
        boolean control = true;

        do {
            System.out.println("Introducir variable x.");
            System.out.print("\tMenu\n"
                    + "\n1.- Por teclado."
                    + "\n2.- Aleatorio."
                    + "\n\nOPCION: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Introducir variable x:");
                    x = sc.nextInt();
                    control = false;
                    break;
                case 2:
                    x = (int)((Math.random() * 100) + 1);
                    System.out.println("numero aleatorio: " + x);
                    control = false;
                    break;
                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }
        }while(control);
        return x;
    }

    private static int getC() {
        int c;

        do {
            System.out.println("Digite el valor para C: ");
            c = sc.nextInt();

            if (c % 200 != 21) System.out.println("Error al introducir c \n");
        } while (c % 200 != 21);

        return c;
    }

    private static int getM() {
        int m = 0;
        int option;
        boolean control = true;

        do {
            System.out.println("Introducir variable M.");
            System.out.print("\tMenu\n"
                    + "\n1.- Aleatorio."
                    + "\n2.- Numero primo."
                    + "\n\nOPCION: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    m = (int)((Math.random() * 100) + 1);
                    System.out.println("numero aleatorio "+ m);
                    control = false;
                    break;
                case 2:
                    System.out.println("digite el numero primo");
                    m = sc.nextInt();
                    String str = "El numero primo mas grande posible es:" + m;
                    System.out.println( str );
                    control = false;
                    break;

                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }

        }while(control);
        return m;
    }
}
