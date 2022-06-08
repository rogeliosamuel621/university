package proyecto_final;

import java.util.Scanner;

public class Simulation {
    Scanner sc = new Scanner(System.in);
    SimulationRecord simulationRecord3 = new SimulationRecord(3);
    SimulationRecord simulationRecord4 = new SimulationRecord(4);
    SimulationRecord simulationRecord5 = new SimulationRecord(5);
    SimulationRecord simulationRecord6 = new SimulationRecord(6);

    float initialHour = 23.00f;
    float limitHour = 7.00f;


    public void startSimulation() {
        //this.simulate3(true);
        this.simulateTeam3();
    }

    private void simulateTeam3() {
        double random1 = this.generateRandomNumber();
        boolean areBusesWaiting = this.areBusesWaiting(random1);
        double arriveTime = 11.00;
        double startService = 11.00;
        double random2 = this.generateRandomNumber();
        int serviceTime = areBusesWaiting ? InverseTransform.getServiceTimeTeam3(random2) : 0;
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
            simulationRecord3.updateRecord(newTableRecord);

            arriveTime = arriveTime + (timeBetweenArrives * 0.01);
            startService = (arriveTime < serviceTimeFinish) ? serviceTimeFinish : arriveTime;
            random2 = this.generateRandomNumber();
            serviceTime = InverseTransform.getServiceTimeTeam3(random2);
            serviceTimeFinish = startService + (double)((double)(serviceTime) * 0.01);
            leisurePersonalTime = (prevServiceTimeFinish < arriveTime) ? Math.abs(prevServiceTimeFinish - arriveTime) : 0;

            timeToWaitForNextBus = (arriveTime < prevServiceTimeFinish) ? Math.abs(arriveTime - prevServiceTimeFinish) : 0;
            prevServiceTimeFinish = serviceTimeFinish;


            if (serviceTimeFinish >= 17.00d || count == 60) break;
            count++;
            prevTimeBetweenArrives = timeBetweenArrives;
        }

        for (int i = 0; i < this.simulationRecord3.getRecordLength(); i++) {
            TableRecord currentRecord = this.simulationRecord3.getRecord(i);
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
        }
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
