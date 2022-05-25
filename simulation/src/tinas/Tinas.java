package tinas;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tinas {
    public static Scanner sc = new Scanner(System.in);
    static DecimalFormat formato1 = new DecimalFormat("0.000");

    public static void main(String[] args) {
        System.out.println("¿Cuantos años deseas simular?");
        int years = sc.nextInt();
        process (years);
    }

    static void process (int years) {
        System.out.println("Año\tDia\tTina\t#AleR\tPeso Simulado\tPeso simulado acum.\tExcede capacidad\tDinero acumulado");
        int contYears = 0;
        int totalCost = 0;
        for (int i=0; i < years; i++) {

            double random;
            int tubWeight = 0;

            int rentMoney = 0;
            int contDays = 0;
            String excede = "";
            contYears++;

            for (int j=0; j < 260; j++) {

                contDays++;
                int totalWeight = 0;

                for (int k=0; k < 5; k++) {
                    random = Math.random();
                    tubWeight = getTubWeight(random);
                    totalWeight = totalWeight + tubWeight;
                    if (totalWeight > 1000) {
                        rentMoney = rentMoney + 200;
                        totalCost = totalCost + 200;
                        excede = "Si";
                    }
                    else {
                        excede = "No";
                    }


                    if (k == 0) {
                        System.out.println((contYears + "\t") + ( contDays + "\t") + ( (k+1) + "\t")
                                + (formato1.format(random) + "\t\t") + (tubWeight + "\t\t") +
                                (totalWeight + "\t\t\t") + (excede + "\t\t\t") + rentMoney);
                    }
                    else {
                        System.out.println(("\t") + ("\t") + ( (k+1) + "\t") + (formato1.format(random)
                                + "\t\t") + (tubWeight + "\t\t") + (totalWeight + "\t\t\t") +
                                (excede + "\t\t\t") + rentMoney);
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        double rentAnualCost = totalCost / years;
        System.out.println("El costo promedio anual de la renta es: " + rentAnualCost);

        if (rentAnualCost >= 50000) {
            System.out.println("Recomendación: Comprar un camión");
        }
        else {
            System.out.println("Recomendación: No comprar un camión");
        }
    }

    static int getTubWeight (double random) {
        int tub = 0;

        if (random < 0.5) {
            tub = (int) (190 + Math.sqrt(800 * random));
        }

        else if (random == 0.5) {
            tub = 210;
        }

        else {
            tub = (int) (230 - Math.sqrt(800 * (1 - random)));
        }
        return tub;
    }
}
