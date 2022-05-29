package simpson_rule;

public class SimpsonRuleMethod {
    public void startSimulation(double a, double b, int[] nValues, double realValue) {
        for (int i = 0; i < nValues.length; i++) {
            int currentNValue = nValues[i];
            this.process(a, b, currentNValue);
            System.out.println("----------------------------------------------");
        }
    }

    private void process(double a, double b, int n) {
        double h = (b - a) / n;
        int pointsXY = n + 1;
        int numOfX = n - 1;

        // get X1, ..., Xn
        double[] xValues = new double[numOfX];
        for (int i = 0; i < numOfX; i++) {
            xValues[i] = a + ((i+1) * h);
        }

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("n: " + n);
        System.out.println("h: " + h);

        for (int i = 0; i < xValues.length; i++) {
            System.out.println("x" + (i+1) + ": " + xValues[i]);
        }

        Calculations calculations = new Calculations();
        // f(xn)
        double fa = calculations.fx(a);
        double fb = calculations.fx(b);
        System.out.println("fa: " + fa);

        double[] fxValues = new double[numOfX];
        for (int i = 0; i < fxValues.length; i++) {
            fxValues[i] = calculations.fx(xValues[i]);
            System.out.println("fx" + (i + 1) + ": " + fxValues[i]);
        }

        System.out.println("fb: " + fb);

        // f(xn) * factor
        double[] fxFactorValues = new double[fxValues.length];
        for (int i = 0; i < fxValues.length; i++) {
            int factor = this.getFactor(n, i + 1);
            //System.out.println("factor: " + factor);
            fxFactorValues[i] = factor * fxValues[i];
            System.out.println("fxFactor" + (i + 1) + ": " + fxFactorValues[i]);
        }
        // sum f(a), f(Xn), f(b)
        double summationFx = fa + fb;
        for (int i = 0; i < fxFactorValues.length; i++) {
            summationFx = summationFx + fxFactorValues[i];
        }

        double finalResult = this.getRuleValue(n, h) * summationFx;
        System.out.println("Reusltado final: " + finalResult);
        //show table
    }

    private int getFactor(int n, int index) {
        boolean isRule3 = n >= 2 && (n % 2) == 0;
        boolean isRule8 = n >= 3 && (n % 2) != 0;

        if (isRule3) return this.getFactorForComplexRule3(index);
        if (isRule8) return this.getFactorForComplexRule8(index);

        return 1;
    }

    private int getFactorForComplexRule3(int index) {
        return (index % 2) == 0 ? 2 : 4;
    }

    private int getFactorForComplexRule8(int index) {
        return (index % 3) == 0 ? 2 : 3;

    }

    private double getRuleValue(int n, double h) {
        boolean isRule3 = n >= 2 && (n % 2) == 0;
        boolean isRule8 = n >= 3 && (n % 2) != 0;

        if (isRule3) return h / 3;
        if (isRule8) return (3 * h) / 8;
        return 1;
    }
}
