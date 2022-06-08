package cinco_ejercicios;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite la cantidad de numeros aleatorios: ");
        int n = sc.nextInt();

        double[] randomNumbers = generateRandomNumber(n);

        System.out.println("Qué programa desea correr?: ");
        System.out.println("1- Chi cuadrado");
        System.out.println("2- Kolmogorov");
        System.out.println("3- Prueba de aleatoriedad");
        System.out.println("4- ");
        System.out.println("5- ");

        int option = sc.nextInt();

        switch (option) {
            case 1:
                ChiSquareMethod chiSquareMethod = new ChiSquareMethod(randomNumbers);
                chiSquareMethod.startSimulation();
                break;
            case 2:
                break;
            case 3:
                new PSerie(randomNumbers);
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    static double[] generateRandomNumber(int limit) {
        double[] randomNumbers = new double[limit];
        for (int i = 0; i < limit; i++) {
            randomNumbers[i] = Math.random();
        }

        return randomNumbers;
    }
}
