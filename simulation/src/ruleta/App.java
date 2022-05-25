package ruleta;

//

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Digite el numero de veces que desea ejecutar la simulacion: ");
        int times = sc.nextInt();

        for (int i = 0; i < times; i++) {
            System.out.println("Simulacion " + (i + 1));
            Game game = new Game();
            game.startSimulation();
            System.out.println();

        }
    }
}
