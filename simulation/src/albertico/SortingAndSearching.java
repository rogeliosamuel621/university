package albertico;

import java.util.Random;
import java.util.Scanner;

public class SortingAndSearching {

    public static void main(String[] args) {
        Scanner Scn = new Scanner(System.in);
        Ordybusq Ordy = new Ordybusq();

        boolean salir = false;
        int opcion, elem = 0;
        int numeros [];
        numeros = new int [10];
        Random numero = new Random();


        //generar numeros
        for(int i = 0; i<10; i++) {
            numeros[i] = numero.nextInt(100);
        }


        //menu
        while(!salir) {

            for(int i = 0; i<10; i++) {
                System.out.print(numeros[i] + ", ");
            }
            System.out.println(" ");

            System.out.println("1) Ordenamiento por Selección\n"
                    + "2) Ordenamiento por Inserción\n"
                    + "3) Ordenamiento de Burbuja\n"
                    + "4) Ordenamiento Rápido\n"
                    + "5) Ordenamiento por Mezcla\n"
                    + "6) Búsqueda Lineal\n"
                    + "7) Búsqueda Binaria\n"
                    +"8) Salir");

            System.out.println("Introduce el numero de la opcion a realizar: ");
            opcion = Scn.nextInt();


            switch(opcion){
                case 1:
                    Ordy.Seleccion(numeros);
                    break;
                case 2:
                    Ordy.OrdenInsercion(numeros);
                    break;
                case 3:
                    Ordy.Burbuja(numeros);
                    break;
                case 4:
                    Ordy.quickSort(args, elem, elem);
                    break;
                case 5:
                    Ordy.Mezcla(args, opcion, elem);
                    break;
                case 6:
                    System.out.println("introduce el valor a buscar: ");
                    elem = Scn.nextInt();
                    Ordy.Lineal(args, opcion, elem, null);
                    break;
                case 7:
                    System.out.println("introduce el valor a buscar: ");
                    elem = Scn.nextInt();
                    Ordy.Binaria(args, elem, elem, elem);
                    break;
                case 8:
                    System.out.println("Bye...");
                    salir = true;
            }

        }

    }

}
