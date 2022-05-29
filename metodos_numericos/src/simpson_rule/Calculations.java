package simpson_rule;

public class Calculations {
    public double simpleRule3(double h, double a, double x1, double b) {
        return (h/3) * (this.fx(a) + (4 * this.fx(x1)) + this.fx(b));
    }

    public double complexRule3(double h, double a, double[] x, double b) {
        double summation = 0.0d;

        for (int i = 0; i < x.length; i++) {
            int factor = this.getFactorForComplexRule3(i + 1);
            summation = summation + (factor * this.fx(x[i]));
        }

        return (h/3) * (this.fx(a) + summation + this.fx(b));
    }

    public double simpleRule8(double h, double a, double x1, double x2, double b) {
        return ((3*h) / 8) * (this.fx(a) + this.fx(x1) + this.fx(x2) + this.fx(b));
    }

    public double complexRule8(double h, double a, double[] x, double b) {
        double summation = 0.0d;

        for (int i = 0; i < x.length; i++) {
            int factor = this.getFactorForComplexRule8(i + 1);
            summation = summation + (factor * this.fx(x[i]));
        }

        return ((3*h) / 8) * (this.fx(a) + summation + this.fx(b));
    }

    /*
    public double fx(double x) {
        return 8 + (5 * (x * x));
    }

     */

    public double fx(double x) {
        return 2 + Math.sin(2 * Math.sqrt(x));
    }

    public int getFactorForComplexRule3(int index) {
        return (index % 2) == 0 ? 2 : 4;
    }

    public int getFactorForComplexRule8(int index) {
        return (index % 2) == 0 ? 2 : 3;

    }
}
