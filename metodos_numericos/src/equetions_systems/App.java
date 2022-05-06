package equetions_systems;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String problem = askForProblem();
        int numOfVariables = askForNumOfVariables();
        int[][] equationsSystem = askForVariables(numOfVariables);
        int errorToTolerate = askForErrorToTolerate();
        int totalCalculations = askForTotalCalculations();
        int initialValues = askForInitialValues();
        int decimalFigures = askForDecimalFigures();

        /*
        System.out.println("PROBLEM: " + problem);
        System.out.println("Numero de variables: " + numOfVariables);

        System.out.println();
        System.out.println("Sistemas de ecuaciones");
        for (int i = 0; i < equationsSystem.length; i++) {
            for (int j = 0; j < equationsSystem.length; j++) {
                if (j == 0) {
                    System.out.print(equationsSystem[i][j] + "x" + (j+1));
                    continue;
                }

                System.out.print(" + " + equationsSystem[i][j] + "x" + (j+1));

                if (j == equationsSystem.length - 1) {
                    System.out.print(" = " + equationsSystem[i][j + 1]) ;
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Error a tolerar: " + errorToTolerate);
        System.out.println("Total de calculos: " + totalCalculations);
        System.out.println("Valores iniciales: " + initialValues);
        System.out.println("Cifras decimales: " + decimalFigures);
         */
        
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

        return equationsSystem;
    }

    private static int askForErrorToTolerate() {
        System.out.println("Digite el error a tolerar: ");
        return sc.nextInt();
    }

    private static int askForTotalCalculations() {
        System.out.println("Digite el total de calculos: ");
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
