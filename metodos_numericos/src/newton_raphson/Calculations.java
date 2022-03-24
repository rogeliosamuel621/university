package newton_raphson;

public class Calculations {
    public double getFx(double x) {
        return Math.sin(x);
    }

    public double getFxDx(double x) {
        return Math.cos(x);
    }

    public double newtonRaphsonMethod(double x, double f1, double f1Dx) {
        return x - (f1 / f1Dx);
    }
}
