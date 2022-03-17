package random_number;

import java.util.Scanner;

public class NumeroAleatorio {
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
                    int cantidad;
                    System.out.println("Inserte la cantidad de numeros a generar");
                            cantidad = leer.nextInt();
                    System.out.println();
                    for (int i=1; i <= cantidad; i++) {
                        System.out.println(i +". "+(int)(Math.random()*(1000- 0+1)+0));
                    }
                    break;
                case 2:
                    System.out.println((int)(Math.random()*(1000-0+1)+0));
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
}

