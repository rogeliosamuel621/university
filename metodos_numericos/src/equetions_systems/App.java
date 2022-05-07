package equetions_systems;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String problem = askForProblem();
        String unity = askForUnity();
        int numOfVariables = askForNumOfVariables();
        Variable variables = askForVariables(numOfVariables);
        int errorToTolerate = askForErrorToTolerate();
        int totalCalculations = askForTotalCalculations();
        double[] initialValues = askForInitialValues(numOfVariables);
        int decimalFigures = askForDecimalFigures();

        int[][] equationsSystem = variables.equationSystem;
        String[] nameOfVariables = variables.nameOfVariables;

        GaussSeidelMethod gaussSeidelMethod = new GaussSeidelMethod(numOfVariables, initialValues, equationsSystem, errorToTolerate, totalCalculations, decimalFigures);
        double[][] records = gaussSeidelMethod.run();

        printHeader(problem);

        generateTableHeader(nameOfVariables);
        generateTableBody(records, decimalFigures, nameOfVariables);

        double[] results = gaussSeidelMethod.results;

        printResults(results, nameOfVariables, decimalFigures, unity);

    }

    private static String askForProblem() {
        System.out.println("Digite el problema: ");
        return sc.nextLine();
    }

    private static String askForUnity() {
        System.out.println("Digite la unidad del problema: ");
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

    private static Variable askForVariables(int numOfVariables) {
        int[][] equationsSystem = new int[numOfVariables][numOfVariables + 1];
        int[][] tempEquationsSystem = {{5500, 2500, 700, 107900}, {350, 500, 120, 13640}, {300, 600, 2500, 67000}};
        String[] nameOfVariables = new String[numOfVariables];

        for(int i=0; i<numOfVariables; i++) {
            System.out.print("Digite el nombre de la variable x" + (i+1) + ": ");
            nameOfVariables[i] = sc.next();
        }


        return new Variable(tempEquationsSystem, nameOfVariables);
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

    private static String getFormattedRecord(int numOfDecimals, double numToFormat) {
        String decimals = "#";

        for (int i = 0; i < numOfDecimals - 1; i++) {
            decimals = decimals + "#";
        }

        return new DecimalFormat("#."+decimals).format(numToFormat);
    }

    private static void printHeader(String problem) {
        System.out.println("\t\t\t INSTITUTO TECNOLÓGICO DE CULIACÁN");
        System.out.println("\t\t\t\t ING. EN SISTEMAS");
        System.out.println();
        System.out.println("Meza Valenzuela Alan");
        System.out.println("Moreno Corrales Rogelio Samuel");
        System.out.println("Solución de Sistemas de Ecuaciones");
        System.out.println("Método de Gauss Seidel");
        System.out.println("de 10:00 a 11:00 horas");
        System.out.println("Pregunta: " +  problem);
    }

    private static void generateTableHeader(String[] nameOfVariables) {
        System.out.println();
        System.out.println();
        System.out.print("|\t No. \t |");
        for (int i = 0; i < nameOfVariables.length; i++) {
            System.out.print("\t\t " + nameOfVariables[i] + " \t\t|");
        }
        System.out.print(" \t Error total \t|");
        System.out.println();
    }

    private static void generateTableBody(double[][] records, int decimalFigures, String[] nameOfVariables) {
        boolean areResultsFinished = false;

        for (int i = 0; i < records.length; i++) {
            System.out.print("\t  " + i + " \t");

            for (int j = 0; j < records[i].length; j++) {
                String recordFormatted = getFormattedRecord(decimalFigures, records[i][j]);
                String moreSpaces = "";
                if (recordFormatted.length() < 9) {
                    int spacesToAdd = (9 - recordFormatted.length()) / 2;
                    for (int k = 0; k < spacesToAdd; k++) {
                        moreSpaces = moreSpaces + " ";
                    }
                }
                String space = "";
                for (int k = 0; k < nameOfVariables.length; k++) {
                    space = space + " ";
                }
                if (recordFormatted.equals("0") && i >= 1) {
                    areResultsFinished = true;
                    break;
                }
                System.out.print("|\t " + space + moreSpaces + recordFormatted + space + moreSpaces + " \t");
            }

            if (areResultsFinished == true) {
                break;
            }

            System.out.println();
        }
    }

    static private void printResults(double[] results, String[] nameOfVariables, int decimalFigures, String unity) {
        System.out.println();
        System.out.println("Resultados del problema");
        for (int i = 0; i < results.length; i++) {
            String resultFormatted = getFormattedRecord(decimalFigures, results[i]);
            System.out.println(nameOfVariables[i] + " = " + resultFormatted +  " " + unity);
        }
    }
}

class Variable {
    int[][] equationSystem;
    String[] nameOfVariables;

    public Variable(int[][] equationSystem, String[] nameOfVariables) {
        this.equationSystem = equationSystem;
        this.nameOfVariables = nameOfVariables;
    }
}
