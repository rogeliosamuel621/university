package newton_raphson;

public class Calculations {
    public double getFx(double x) {
        return (x * x) - 4;
    }

    public double getFxDx(double x) {
        return 2 * x;
    }

    public double newtonRaphsonMethod(double x, double f1, double f1Dx) {
        return x - (f1 / f1Dx);
    }
}
