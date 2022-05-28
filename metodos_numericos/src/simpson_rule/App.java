package simpson_rule;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double realValue = getRealValue();
        int lowerLimit = getLowerLimit();
        int upperLimit = getUpperLimit();
        int[] nValues = getEnValues();

        SimpsonRuleMethod simpsonRuleMethod = new SimpsonRuleMethod();
        simpsonRuleMethod.startSimulation(lowerLimit, upperLimit, nValues, realValue);

    }

    static private double getRealValue() {
        System.out.println("Digite el valor real: ");
        return sc.nextDouble();
    }

    static private int getLowerLimit() {
        System.out.println("Digite el limite inferior: ");
        return sc.nextInt();
    }

    static private int getUpperLimit() {
        System.out.println("Digite el limite superior: ");
        return sc.nextInt();
    }

    static private int[] getEnValues() {
        System.out.println();
        System.out.println("**Valores de N**");
        System.out.println("Digite la cantidad de los valores de n");
        int numOfN = sc.nextInt();
        int[] nValues = new int[numOfN];

        for (int i = 0; i < numOfN; i++) {
            System.out.println("Digite el valor de N " + (i + 1));
            nValues[i] = sc.nextInt();
        }

        return nValues;
    }
}
