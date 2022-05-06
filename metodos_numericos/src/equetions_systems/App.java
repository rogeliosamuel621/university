package equetions_systems;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String problem = askForProblem();
        int numOfVariables = 3;
        int[][] equationsSystem = askForVariables(numOfVariables);
        int errorToTolerate = 1;
        int totalCalculations = 50;
        double[] initialValues = {5,5,5};
        int decimalFigures = 6;

        GaussSeidelMethod gaussSeidelMethod = new GaussSeidelMethod(numOfVariables, initialValues, equationsSystem, errorToTolerate, totalCalculations, decimalFigures);
        gaussSeidelMethod.runMethod();
        
    }

    private static String askForProblem() {
        System.out.println("Digite el problema: ");
        return sc.nextLine();
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
        int[][] equationsSystem = new int[numOfVariables][numOfVariables + 1];
        int[][] temEquationsSystem = {{5500, 2500, 700, 107900}, {350, 500, 120, 13640}, {300, 600, 2500, 67000}};
        /*
        for(int i=0; i<numOfVariables; i++) {
            System.out.println("\n** Variables de ecuacion " +  (i+1) + "**");
            for (int j = 0; j < numOfVariables + 1; j++) {
                if (j == numOfVariables) {
                    System.out.print("Resultado = ");
                    int result = sc.nextInt();
                    equationsSystem[i][j] = result;
                    continue;
                }

                System.out.print("x" + (j+1) + " = ");
                int value = sc.nextInt();
                equationsSystem[i][j] = value;
            }
        }
         */

        return temEquationsSystem;
    }

    private static int askForErrorToTolerate() {
        System.out.println("Digite el error a tolerar: ");
        return sc.nextInt();
    }

    private static int askForTotalCalculations() {
        System.out.println("Digite el total de calculos: ");
        return sc.nextInt();
    }

    private static double[] askForInitialValues(int numOfVariables) {
        double[] initialValues = new double[numOfVariables];
        for (int i = 0; i < numOfVariables; i++) {
            System.out.println("Digite el valor inicial de x" + (i+1) + ": " );
            initialValues[i] =  sc. nextDouble();
        }
        return initialValues;
    }

    private static int askForDecimalFigures() {
        System.out.println("Digite el número de cifras decimales: ");
        return sc.nextInt();
    }
}
