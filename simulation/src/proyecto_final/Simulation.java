package proyecto_final;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Simulation {
    DecimalFormat formatAle = new DecimalFormat("0.0000");
    DecimalFormat formatTime = new DecimalFormat("0.00");
    Scanner sc = new Scanner(System.in);
    SimulationRecord simulationRecord3 = new SimulationRecord(3);
    SimulationRecord simulationRecord4 = new SimulationRecord(4);
    SimulationRecord simulationRecord5 = new SimulationRecord(5);
    SimulationRecord simulationRecord6 = new SimulationRecord(6);

    float initialHour = 23.00f;
    float limitHour = 7.00f;


    public void startSimulation() {
        //this.simulate3(true);
        for (int i = 0; i < 60; i++) {
            this.simulateTeam3(3);
            this.simulateTeam3(4);
            this.simulateTeam3(5);
            this.simulateTeam3(6);
        }

        double sum1 = 0.0d;
        double sum2 = 0.0d;
        double sum3 = 0.0d;
        double sum4 = 0.0d;
        for (int i = 0; i < simulationRecord3.totalPrices.size(); i++) {
            sum1 = sum1 + simulationRecord3.totalPrices.get(i);
            sum2 = sum2 + simulationRecord4.totalPrices.get(i);
            sum3 = sum3 + simulationRecord5.totalPrices.get(i);
            sum4 = sum4 + simulationRecord6.totalPrices.get(i);
        }

        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("en","US"));

        System.out.println("Resultados");
        System.out.println(simulationRecord3.totalPrices.size());
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Precio total de la 3: " + formatoImporte.format(sum1 / simulationRecord3.totalPrices.size()));
        System.out.println("Precio total de la 4: " + formatoImporte.format(sum2 / simulationRecord4.totalPrices.size()));
        System.out.println("Precio total de la 5: " + formatoImporte.format(sum3 / simulationRecord5.totalPrices.size()));
        System.out.println("Precio total de la 6: " + formatoImporte.format(sum4 / simulationRecord6.totalPrices.size()));
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    private void simulateTeam3(int team) {
        this.getTeam(team).clearRecord();
        double random1 = this.generateRandomNumber();
        boolean areBusesWaiting = this.areBusesWaiting(random1);
        double arriveTime = 11.00;
        double startService = 11.00;
        double random2 = this.generateRandomNumber();
        int serviceTime = areBusesWaiting ? getTeam(team).getServiceTime(team, random2) : 0;
        double serviceTimeFinish = startService + (double)((serviceTime > 0 ? serviceTime : 0) * 0.01);
        double prevServiceTimeFinish= serviceTimeFinish;
        double leisurePersonalTime = 0;
        double timeToWaitForNextBus = 0;
        int count = 0;
        int prevTimeBetweenArrives = 0;

        while (true) {
            double prevRandomNumber1 = random1;
            random1 = this.generateRandomNumber();
            int timeBetweenArrives = InverseTransform.getArriveTime(random1);

            boolean isInQueue = (arriveTime + (timeBetweenArrives * 0.01)) < serviceTimeFinish;

            TableRecord newTableRecord = new TableRecord(prevRandomNumber1, prevTimeBetweenArrives, arriveTime, startService, random2, serviceTime, serviceTimeFinish, leisurePersonalTime, timeToWaitForNextBus, isInQueue ? 1 : 0);
            getTeam(team).updateRecord(newTableRecord);

            arriveTime = arriveTime + (timeBetweenArrives * 0.01);
            startService = (arriveTime < serviceTimeFinish) ? serviceTimeFinish : arriveTime;
            random2 = this.generateRandomNumber();
            serviceTime = getTeam(team).getServiceTime(team, random2);
            serviceTimeFinish = startService + (double)((double)(serviceTime) * 0.01);
            leisurePersonalTime = (prevServiceTimeFinish < arriveTime) ? Math.abs(prevServiceTimeFinish - arriveTime) : 0;

            timeToWaitForNextBus = (arriveTime < prevServiceTimeFinish) ? Math.abs(arriveTime - prevServiceTimeFinish) : 0;
            prevServiceTimeFinish = serviceTimeFinish;


            if (serviceTimeFinish >= 17.00d || count == 60) break;
            count++;
            prevTimeBetweenArrives = timeBetweenArrives;
        }

        double busWaitingTime = 0.0d;
        double workingTime = 0.0d;
        System.out.println("#ale \t| Tiempo entre llegadas | Tiempo de llegada | Inicio del servicio | #ale \t| Tiempo de servicio | Terminacion del servicio | Ocio del personal | Tiempo de espera del camión | Longitud de la cola ");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < this.getTeam(team).getRecordLength(); i++) {

            TableRecord currentRecord = this.getTeam(team).getRecord(i);

            busWaitingTime = busWaitingTime + currentRecord.timeToWaitForBus;
            workingTime = workingTime + currentRecord.serviceTime;

            String ale1 = formatAle.format(currentRecord.randomNumber_1);
            String tB = formatTime.format(currentRecord.timeBetweenArrives);
            String arrH = formatTime.format(currentRecord.arriveHour);
            String stS = formatTime.format(currentRecord.serviceStartHour);
            String ale2 = formatAle.format(currentRecord.randomNumber_2);
            String sT = formatTime.format(currentRecord.serviceTime);
            String fS = formatTime.format(currentRecord.serviceFinishTime);
            String oP = formatTime.format(currentRecord.deathTime);
            String wB = formatTime.format(currentRecord.timeToWaitForBus);
            String queue = formatTime.format(currentRecord.inQueue);

            System.out.println(ale1 + "\t\t\t" + tB + "\t\t\t\t  " + arrH + "\t\t\t\t\t" + stS + "\t\t\t" + ale2 + "\t\t\t" + sT + "\t\t\t\t\t" + fS + "\t\t\t\t\t" + oP + "\t\t\t\t\t" + wB + "\t\t\t\t\t" + queue);
            System.out.println("--------------------------------------------------------------------------------------------------------");
/*
            System.out.println("RECORD");
            System.out.println("ale: " + currentRecord.randomNumber_1);
            System.out.println("tiempoEntreLlegadas: " + currentRecord.timeBetweenArrives);
            System.out.println("tiempo de llegada: " + currentRecord.arriveHour);
            System.out.println("inicio servicio " + currentRecord.serviceStartHour);
            System.out.println("ale2: " + currentRecord.randomNumber_2);
            System.out.println("service time: " + currentRecord.serviceTime);
            System.out.println("fin service: " + currentRecord.serviceFinishTime);
            System.out.println("ocio: " + currentRecord.deathTime);
            System.out.println("timepo espera bus: " + currentRecord.timeToWaitForBus);
            System.out.println("en cola: " + currentRecord.inQueue);
            System.out.println("RECORD");
            System.out.println();
 */
        }

        double d1 = getTeam(team).getBusAwaitTimePrice(busWaitingTime);
        double d2 = getTeam(team).getServicePrice(workingTime * 0.01);
        double d3 = getTeam(team).getNormalSalary();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("bus wait: " + d1 + " jkn " + busWaitingTime);
        System.out.println("service price: " + d2 + " cdjkdsc " + workingTime);
        System.out.println("normal salary: " + d3);

        double totalPrice = getTeam(team).getTotalCost();
        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("en","US"));

        System.out.println("Total Price: " + formatoImporte.format(totalPrice));
        System.out.println("--------------------------------------------------------------------------------------------------------");
        this.getTeam(team).totalPrices.add(totalPrice);


    }

    private SimulationRecord getTeam(int teamMates) {
        //System.out.println("Team");
        //System.out.println(teamMates);
        //System.out.println("team");
        if (teamMates == 3) return simulationRecord3;
        if (teamMates == 4) return simulationRecord4;
        if (teamMates == 5) return simulationRecord5;
        if (teamMates == 6) return simulationRecord6;

        return simulationRecord3;
    }


    private double generateRandomNumber() {
        return Math.random();
    }

    private boolean areBusesWaiting(double randomNumber) {
        return InverseTransform.getBusesWaiting(randomNumber) != 0;
    }

    private double getTimesInMinutes(double time) {
        return time * 0.01;
    }

}
