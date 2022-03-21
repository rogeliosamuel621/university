package newton_raphson;

public class Calculations {
    public double f1(double x) {
        return x - (5 * Math.cos(2 * x)) + 5;
    }

    public double f1Dx(double x) {
        return 1 + (10 * Math.sin(2 * x));
    }

    public double newtonRaphsonMethod(double x, double f1, double f1Dx) {
        return x - (f1 / f1Dx);
    }
}
