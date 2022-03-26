package newton_raphson;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Simulation {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double x1 = getX1();
        double errorRange = getErrorRange();
        int start = -15;
        int end = 10;
        int i = 0;

        while(x1 >= start && x1 <= end) {
            double factor = (i % 2) == 0 ? 0.5 : 0.05;
            i++;
            double x2 = simulation(x1, errorRange);
            x1 = x2 + factor;
            System.out.println();
            System.out.println();
        }
    }

    static private double simulation(double x1, double initialValueErrorRange) {
        Calculations calculations = new Calculations();
        double f1 = calculations.getFx(x1);
        double f2 = 0.0;
        double errorRange = initialValueErrorRange;
        String f2Formatted = "";
        double x2;

        int i = 0;

        do {
            i++;
            double f1Dx = calculations.getFxDx(x1);
            x2 = calculations.newtonRaphsonMethod(x1, f1, f1Dx);
            f2 = calculations.getFx(x2);

            NumberFormat formatter = new DecimalFormat("###.##########");

            f2Formatted = formatter.format(f2);

            System.out.println(i + " x1: " + x1 + " F(x1): " + f1 + " F'(x1): " + f1Dx + " X2: " + x2 + " F(x2): " + f2Formatted);

            x1 = x2;
            f1 = f2;
            // if (i == 100) break;
        }while(Math.abs(f2) > errorRange);

        return x2;
    }

    static private double getX1() {
        System.out.println("Digite el punto inicial (x1): ");
        return sc.nextDouble();
    }

    static private double getErrorRange() {
        System.out.println("Digite el rango de error: ");
        return sc.nextDouble();
    }
}
