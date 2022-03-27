package newton_raphson_v2;

public class Calculations {
    public double getFx(double x) {
        return x * (Math.cos(x * x)) - 4;
    }

    public double getFxDx(double x) {
        return Math.cos(x * x) - ((2 * (x * x)) * Math.sin(x * x));
    }

    public double newtonRaphsonMethod(double x, double f1, double f1Dx) {
        return x - (f1 / f1Dx);
    }
}
