package simpson_rule;

import java.text.DecimalFormat;

public class SimpsonRuleMethod {
    public void startSimulation(double a, double b, int[] nValues, double realValue) {
        for (int i = 0; i < nValues.length; i++) {
            int currentNValue = nValues[i];
            this.process(a, b, currentNValue);
        }
    }

    private void process(double a, double b, int n) {
        double h = (b - a) / n;
        int pointsXY = n + 1;
        int numOfX = n - 1;

        double[] xValues = new double[numOfX];
        for (int i = 0; i < numOfX; i++) {
            xValues[i] = a + ((i+1) * h);
        }

        Calculations calculations = new Calculations();

        double fa = calculations.fx(a);
        double fb = calculations.fx(b);

        double[] fxValues = new double[numOfX];
        for (int i = 0; i < fxValues.length; i++) {
            fxValues[i] = calculations.fx(xValues[i]);
        }


        double[] fxFactorValues = new double[fxValues.length];
        int[] factorValues = new int[fxValues.length];
        for (int i = 0; i < fxValues.length; i++) {
            int factor = this.getFactor(n, i + 1);
            factorValues[i] = factor;
            fxFactorValues[i] = factor * fxValues[i];
        }

        double summationFx = fa + fb;
        for (int i = 0; i < fxFactorValues.length; i++) {
            summationFx = summationFx + fxFactorValues[i];
        }

        double finalResult = this.getRuleValue(n, h) * summationFx;

        //show table
        DecimalFormat d = new DecimalFormat();
        String aText = new DecimalFormat("0.00000").format(a);
        String faText = new DecimalFormat("0.00000").format(fa);
        String bText = new DecimalFormat("0.00000").format(b);
        String fbText = new DecimalFormat("0.00000").format(fb);

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Pxy \t\t x \t\t f(x) \t\t Factor \t\t Area \t\t");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(1 + "\t\t  " + aText + "\t" + faText + "\t\t" + 1 + "\t\t\t" + faText);
        for (int i = 0; i < fxValues.length; i++) {
            String xValueText = new DecimalFormat("0.00000").format(xValues[i]);
            String fxValueText = new DecimalFormat("0.00000").format(fxValues[i]);
            String factorValueText = Integer.toString(factorValues[i]);
            String fxFactorValueText = new DecimalFormat("0.00000").format(fxFactorValues[i]);

            System.out.println((i + 1) + "\t\t  " + xValueText + "\t" + fxValueText + "\t\t" + factorValueText + "\t\t\t" + fxFactorValueText);
        }
        System.out.println(pointsXY + "\t\t  " + bText + "\t" + fbText + "\t\t" + 1 + "\t\t\t" + fbText);
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
