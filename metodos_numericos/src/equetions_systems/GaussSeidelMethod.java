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
            for (int j = 0; j < this.unknowns.length; j++) {

            }
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
}
