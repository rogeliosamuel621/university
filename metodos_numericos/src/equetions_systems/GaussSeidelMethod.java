package equetions_systems;

import java.util.Arrays;

public class GaussSeidelMethod {
    double[] unknowns;
    double[] initialValues;
    int[][] equationsSystem;
    int errorToTolerate;
    int totalCalculations;
    int decimalFigures;

    public GaussSeidelMethod(int numOfVariables, double[] initialValues, int[][] equationsSystem, int errorToTolerate, int totalCalculations, int decimalFigures) {
        this.unknowns = new double[numOfVariables];
        this.initialValues = initialValues;
        this.equationsSystem = equationsSystem;
        this.errorToTolerate = errorToTolerate;
        this.totalCalculations = totalCalculations;
        this.decimalFigures = decimalFigures;
    }

    public void runMethod() {
        fillUnknowns(this.initialValues);

        for (int i = 0; i < this.totalCalculations; i++) { // for del total de casos
            double[] prevValues = Arrays.copyOf(this.unknowns, this.unknowns.length);

            //
            System.out.println("\n Prev values");
            for (int j = 0; j < prevValues.length; j++) {
                System.out.print("x" + (j+1) + " = " + prevValues[j] + " ");
            }
            //

            for (int j = 0; j < this.unknowns.length; j++) { // despejar y encontrar incógnitas
                this.unknowns[j] = getUnknownValue(this.equationsSystem[j], j);
            }

            //
            System.out.println("\n New Values");
            for (int j = 0; j < this.unknowns.length; j++) {
                System.out.print("x" + (j+1) + " = " + this.unknowns[j] + " ");
            }
            //

            //fillUnknowns(newUnknowns);

            boolean isFinished = this.calculateError(prevValues, this.unknowns);

            if (isFinished) break;
        }

    }

    private void fillUnknowns(double[] values) {
        for (int i = 0; i < this.unknowns.length; i++) {
            this.unknowns[i] = values[i];
        }
    }

    private double[] generateInitialValues(double num) {
        double [] initialValues = new double[this.unknowns.length];
        for (int i = 0; i < this.unknowns.length; i++) {
            initialValues[i] = num;
        }

        return initialValues;
    }

    private double getUnknownValue(int[] equation, int positionToEvaluate) {

        int[] auxEquation = Arrays.copyOf(equation, equation.length);

        /*
        System.out.println();
        System.out.println("ECUACION");
        for (int i = 0; i < equation.length; i++) {
            System.out.print(equation[i] +  " ");
        }
        System.out.println();
         */


        /*
        System.out.println("Sistemas de ecuaciones");
            for (int j = 0; j < equation.length; j++) {
                if (j == 0) {
                    System.out.print(equation[j] + "x" + (j+1));
                    continue;
                }

                System.out.print(" + " + equation[j] + "x" + (j+1));

                if (j == equation.length) {
                    System.out.print(" = " + equation[j]) ;
                }
            }
            System.out.println();

         */

        double equationResult = auxEquation[auxEquation.length - 1];
        double unknown = auxEquation[positionToEvaluate];
        // System.out.println("divisor: " + unknown);
        auxEquation[positionToEvaluate] = 0;

        double summation = equationResult;

        for (int i = 0; i < auxEquation.length - 1; i++) {
            //System.out.println("num: " + equation[i]);
            //System.out.println("incognita: " + this.unknowns[i]);
            summation = summation - (auxEquation[i] * this.unknowns[i]);
        }

        return summation / unknown;
    }

    private boolean calculateError(double[] prevValues, double[] currentValues) {
        double[] summationValues = new double[this.unknowns.length];

        for (int i = 0; i < summationValues.length; i++) {
            summationValues[i] = Math.abs(Math.abs(currentValues[i]) - Math.abs(prevValues[i]));
        }

        double summationResult = 0.0d;
        for (int i = 0; i < summationValues.length; i++) {
            summationResult = summationResult + summationValues[i];
        }

        System.out.println("\n Suma de las diferencias absolutas: " + summationResult);

        return summationResult <= this.errorToTolerate;
    }
}
