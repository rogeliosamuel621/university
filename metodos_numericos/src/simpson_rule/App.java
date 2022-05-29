package simpson_rule;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
/*
        String problem = getProblem();
        double realValue = getRealValue();
        int lowerLimit = getLowerLimit();
        int upperLimit = getUpperLimit();
        int[] nValues = getEnValues();
        */
        int[] nValues = {2, 3, 8, 15};

        showHeader("problem");


        SimpsonRuleMethod simpsonRuleMethod = new SimpsonRuleMethod();
        simpsonRuleMethod.startSimulation(1, 6, nValues, 10);

    }

    static private String getProblem() {
        System.out.println("Digite el problema: ");
        return sc.nextLine();
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

    static private void showHeader(String problem) {
        System.out.println();
        System.out.println();
        System.out.println("Instituto Tecnológico de Culiacán");
        System.out.println("Ing. en Sistemas");
        System.out.println();
        System.out.println("Meza Valenzuela Alan");
        System.out.println("Moreno Corrales Rogelio Samuel");
        System.out.println("Integración Numérica-Método de Simpson");
        System.out.println("De 10:00 –11:00 horas");

        System.out.println("Pregunta: " + problem);
    }
}
