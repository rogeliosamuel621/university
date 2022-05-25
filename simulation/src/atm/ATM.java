package atm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public static Scanner sc = new Scanner(System.in);
    static DecimalFormat formato1 = new DecimalFormat("0.000");
    static DecimalFormat formato2 = new DecimalFormat("0.00");

    public static void main(String[] args) {
        System.out.println("¿Cuantas simulaciones desea simular?");
        int simulations = sc.nextInt();
        process(simulations);
    }

    static void process (int simulations) {
        for (int j=0; j < simulations; j++) {
            double timeBetweenArrival = 0;
            double roundTBA = 0;
            int tbaInSeconds = 0;
            int arrivalTime = 0;
            ArrayList<Integer> previousArrivalTime = new ArrayList<>();
            int timeStartsService = 0;
            int waitTime = 0;
            int totalWaitTime = 0;
            int operationTime = 0;
            int timeServiceEnds = 0;
            String operation = "";
            int cont = 0;

            System.out.println("Usuario\t#alea1\tTiempo entre llegada\tMomento llegada\t"
                    + "Tiempo inicia servicio\tTiempo espera\t#Alea2\tOperación\t"
                    + "\tTiempo operación\tTiempo termina");
            for (int i=0; i < 100; i++) {
                cont++;
                double random = Math.random();
                double random2 = Math.random();

                timeBetweenArrival = (-Math.log(1 - random) / 30) * 60;
                roundTBA= Math.round(timeBetweenArrival*100.0)/100.0;
                tbaInSeconds = (int) (roundTBA * 60);

                if (i == 0) {
                    arrivalTime = tbaInSeconds;
                    previousArrivalTime.add(arrivalTime);
                    timeStartsService = tbaInSeconds;
                    waitTime = timeStartsService - arrivalTime;
                    totalWaitTime = totalWaitTime + waitTime;
                    if (arrivalTime <= timeServiceEnds) {
                        timeStartsService = timeServiceEnds;
                    }
                    else {
                        timeStartsService = arrivalTime;
                    }

                    waitTime = timeStartsService - arrivalTime;

                    operation = getOperation(random2);
                    operationTime = getTime(operation);

                    timeServiceEnds = timeStartsService + operationTime;
                }
                else {
                    arrivalTime = previousArrivalTime.get(i-1) + tbaInSeconds;
                    previousArrivalTime.add(arrivalTime);

                    if (arrivalTime <= timeServiceEnds) {
                        timeStartsService = timeServiceEnds;
                    }
                    else {
                        timeStartsService = arrivalTime;
                    }

                    waitTime = timeStartsService - arrivalTime;
                    totalWaitTime = totalWaitTime + waitTime;

                    operation = getOperation(random2);
                    operationTime = getTime(operation);

                    timeServiceEnds = timeStartsService + operationTime;
                }

                System.out.println((cont+ "\t") + (formato1.format(random) + "\t\t") +
                        ((CalcularTiempo(tbaInSeconds)) + "\t\t\t") + (CalcularTiempo(arrivalTime) + "\t\t")
                        + (CalcularTiempo(timeStartsService) + "\t\t\t") + (CalcularTiempo(waitTime) + "\t")
                        + (formato1.format(random2) + "\t") + (operation + "\t\t") +
                        (operationTime + "\t\t\t") + CalcularTiempo(timeServiceEnds));
            }
            System.out.println();
            System.out.println("Tiempo de espera total = " + CalcularTiempo(totalWaitTime));
        }

    }

    static String CalcularTiempo (int num) {
        int hor=num/3600;
        int min=(num-(3600*hor))/60;
        int seg=num-((hor*3600)+(min*60));
        return Integer.toString(hor) + ":" + Integer.toString(min) + ":" + Integer.toString(seg);
    }

    static String getOperation (double random) {
        if (random <= 0.25) {
            return "Consulta de saldo";
        }
        else if (random > 0.25 && random <= 0.50) {
            return "Otros            ";
        }
        else if (random > 0.50 && random <= 0.85) {
            return "Retiros          ";
        }
        else {
            return "Transferencia    ";
        }
    }

    static int getTime (String operation) {
        if (operation == "Consulta de saldo") {
            return 80;
        }
        else if (operation == "Otros            ") {
            return 50;
        }
        else if (operation == "Retiros          ") {
            return 120;
        }
        else {
            return 60;
        }
    }
}
