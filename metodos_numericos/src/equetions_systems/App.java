package equetions_systems;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Works");
    }

    private static String askForProblem() {
        System.out.println("Digite el problema: ");
        return sc.next();
    }

    private static int askForNumOfVariables() {
        boolean isInputOk = false;
        int numOfVariables = 0;

        do {
            System.out.println("Digite el número de variables: ");
            numOfVariables = sc.nextInt();

            if (numOfVariables >=2 && numOfVariables <= 6) {
                isInputOk = true;
            }
        }while (!isInputOk);

        return numOfVariables;
    }

    private static int[][] askForVariables(int numOfVariables) {
        int[][] equationsSystem = new int[numOfVariables][numOfVariables];

        for(int i=0; i<numOfVariables; i++) {
            System.out.println("\n** Variables de ecuacion 1 **");
            for (int j = 0; j < numOfVariables; j++) {
                System.out.print("x" + (j+1) + " = ");
                int value = sc.nextInt();
                equationsSystem[i][j] = value;

                if (j == numOfVariables - 1) {
                    System.out.println("Resultado = ");
                    int result = sc.nextInt();
                    equationsSystem[i][j] = result;
                }
            }
        }

        return equationsSystem;
    }

    private static int askForErrorToTolerate() {
        System.out.println("Digite el error a tolerar: ");
        return sc.nextInt();
    }

    private static int askForTotalCalculations() {
        System.out.println("Digite el error tolerante: ");
        return sc.nextInt();
    }

    private static int askForInitialValues() {
        System.out.println("Digite los valores iniciales: ");
        return sc.nextInt();
    }

    private static int askForDecimalFigures() {
        System.out.println("Digite el número de cifras decimales: ");
        return sc.nextInt();
    }
}
