package newton_raphson;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Simulation {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double x1 = getX1();
        double errorRange = getErrorRange();

        simulation(x1, errorRange);
    }

    static private String simulation(double initialValueX1, double initialValueErrorRange) {
        Calculations calculations = new Calculations();
        double x1 =  initialValueX1;
        double f1 = calculations.getFx(x1);
        double f2 = 0.0;
        double errorRange = initialValueErrorRange;
        String f2Formatted = "";

        int i = 0;

        do {
            i++;
            double f1Dx = calculations.getFxDx(x1);
            double x2 = calculations.newtonRaphsonMethod(x1, f1, f1Dx);
            f2 = calculations.getFx(x2);

            NumberFormat formatter = new DecimalFormat("###.##########");

            f2Formatted = formatter.format(f2);

            System.out.println(i + " x1: " + x1 + " F(x1): " + f1 + " F'(x1): " + f1Dx + " X2: " + x2 + " F(x2): " + f2Formatted);

            x1 = x2;
            f1 = f2;
        }while(Math.abs(f2) > errorRange);

        return f2Formatted;
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
