package exame_alb;

import java.util.Scanner;

/**
 * 100 por flores
 * vener 160 c/u
 * siguiente día 50 c/u
 *
 * cuantas flores desea comprar? 100
 *
 *
 */

public class App {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        proceso();
    }

    static public void proceso() {
        System.out.println("Cunatas flores desea comprar");
        int flores = scn.nextInt();

        System.out.println("x     Día\t       #Ale    Demanda x día        x flores (compra)      vendidas      costo    ing.vta     utilidad");
        System.out.println(" ");

        for (int i = 0; i < 365; i++) {
            System.out.println( (i) + "   " + (obtenerNumeroRandom()) + "  " + (12) + "  " + (flores + 12) + "  " + (flores - 12) + "  " + (flores *  100) + "  " + (flores * 160) + "  " + ((flores - 12) * 50));
        }

    }
    static private double obtenerNumeroRandom() {
        return Math.random();
    }
}
