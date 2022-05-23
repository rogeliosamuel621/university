package equetions_systems;

import java.util.Arrays;

public class GaussSeidelMethod {
    double[] unknowns;
    double[] initialValues;
    int[][] equationsSystem;
    double errorToTolerate;
    int totalCalculations;
    int decimalFigures;
    double currentError = 0.0d;
    double[][] records;
    double[] results;

    public GaussSeidelMethod(int numOfVariables, double[] initialValues, int[][] equationsSystem, double errorToTolerate, int totalCalculations, int decimalFigures) {
        this.unknowns = new double[numOfVariables];
        this.initialValues = initialValues;
        this.equationsSystem = equationsSystem;
        this.errorToTolerate = errorToTolerate;
        this.totalCalculations = totalCalculations;
        this.decimalFigures = decimalFigures;

        this.records = new double[totalCalculations][numOfVariables + 1];
        this.results = new double[numOfVariables];
    }

    public double[][] run() {
        fillUnknowns(this.initialValues);
        this.recordData(this.initialValues, 0);

        for (int i = 0; i < this.totalCalculations; i++) { // for del total de casos
            double[] prevValues = Arrays.copyOf(this.unknowns, this.unknowns.length);

            for (int j = 0; j < this.unknowns.length; j++) { // despejar y encontrar incógnitas
                this.unknowns[j] = getUnknownValue(this.equationsSystem[j], j);
            }

            boolean isFinished = this.calculateError(prevValues, this.unknowns);
            this.recordData(this.unknowns, i + 1);


            if (isFinished) {
                this.results = this.unknowns;
                break;
            }
        }

        return this.records;
    }

    private void fillUnknowns(double[] values) {
        for (int i = 0; i < this.unknowns.length; i++) {
            this.unknowns[i] = values[i];
        }
    }

    private double getUnknownValue(int[] equation, int positionToEvaluate) {

        int[] auxEquation = Arrays.copyOf(equation, equation.length);

        double equationResult = auxEquation[auxEquation.length - 1];
        double unknown = auxEquation[positionToEvaluate];
        auxEquation[positionToEvaluate] = 0;

        double summation = equationResult;

        for (int i = 0; i < auxEquation.length - 1; i++) {
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

        this.currentError = summationResult;
        return summationResult <= this.errorToTolerate;
    }

    private void recordData(double[] currentValues, int numOfCalculation) {
        for (int i = 0; i < currentValues.length + 1; i++) {
            if (i == currentValues.length) {
                this.records[numOfCalculation][i] = this.currentError;
                break;
            }

            this.records[numOfCalculation][i] = currentValues[i];
        }
    }
}
