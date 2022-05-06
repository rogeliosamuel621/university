package equetions_systems;

public class GaussSeidelMethod {
    double[] unknowns;
    double initialValues;
    int[][] equationsSystem;
    int errorToTolerate;
    int totalCalculations;
    int decimalFigures;

    public GaussSeidelMethod(int numOfVariables, double initialValues, int[][] equationsSystem, int errorToTolerate, int totalCalculations, int decimalFigures) {
        this.unknowns = new double[numOfVariables];
        this.initialValues = initialValues;
        this.equationsSystem = equationsSystem;
        this.errorToTolerate = errorToTolerate;
        this.totalCalculations = totalCalculations;
        this.decimalFigures = decimalFigures;
    }

    public void runMethod() {
        double[] initialValues = generateInitialValues(this.initialValues);
        fillUnknowns(initialValues);

        for (int i = 0; i < this.totalCalculations; i++) { // for del total de casos
            double[] newUnknowns = new double[this.unknowns.length];

            for (int j = 0; j < this.unknowns.length; j++) {
                newUnknowns[i] = getUnknownValue(this.equationsSystem[i], i);
            }

            fillUnknowns(newUnknowns);


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
        double equationResult = equation[equation.length - 1];
        double unknown = equation[positionToEvaluate];
        equation[positionToEvaluate] = 0;

        double summation = equationResult;

        for (int i = 0; i < equation.length - 1; i++) {
            summation = summation - (equation[i] * this.unknowns[i]);
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

        return summationResult <= this.errorToTolerate;
    }
}
