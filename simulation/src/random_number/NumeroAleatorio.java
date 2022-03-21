package random_number;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NumeroAleatorio {
    static DecimalFormat formato1 = new DecimalFormat("0.00000");
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {


        int option;
        boolean control = true;

        do {
            System.out.print("\tMenu\n"
                    + "\n1.- Teclado."
                    + "\n2.- Función random."
                    + "\n3.- Salir."
                    + "\n\nOPCION: ");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    int cantidad = obtenerCantidad();
                    generarNum(cantidad);
                    break;
                case 2:
                    generarNum (1);
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

    public static int obtenerCantidad () {
        int cantidad = 0;

        do {
            System.out.println("Inserte la cantidad de numeros a generar");
            cantidad = leer.nextInt();

            if(cantidad < 1) System.out.println("Inserte un valor valido");

        } while(cantidad < 1);

        return cantidad;
    }

    public static void generarNum (int cantidad) {
        for (int i=0; i < cantidad; i++) {
            double numRandom =  Math.random();
            if (Double.compare(numRandom, 0.9999) == 0) {
                System.out.println((i+1 + ". " + 1));
            }
            System.out.println((i+1 + ". " + formato1.format(numRandom)));
        }
    }
}

