package proyecto_final;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Simulation {
    DecimalFormat formatAle = new DecimalFormat("0.0000");
    DecimalFormat formatTime = new DecimalFormat("0.00");
    SimulationRecord simulationRecord3 = new SimulationRecord(3);
    SimulationRecord simulationRecord4 = new SimulationRecord(4);
    SimulationRecord simulationRecord5 = new SimulationRecord(5);
    SimulationRecord simulationRecord6 = new SimulationRecord(6);


    public void startSimulation() {
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
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");

        String n3 = decimalFormat.format(simulationRecord3.totalNormalSalary);
        String n4 = decimalFormat.format(simulationRecord4.totalNormalSalary);
        String n5 = decimalFormat.format(simulationRecord5.totalNormalSalary);
        String n6 = decimalFormat.format(simulationRecord6.totalNormalSalary);

        String e3 = decimalFormat.format(simulationRecord3.totalExtraSalary);
        String e4 = decimalFormat.format(simulationRecord4.totalExtraSalary);
        String e5 = decimalFormat.format(simulationRecord5.totalExtraSalary);
        String e6 = decimalFormat.format(simulationRecord6.totalExtraSalary);

        String o3 = decimalFormat.format(simulationRecord3.totalOciBus);
        String o4 = decimalFormat.format(simulationRecord4.totalOciBus);
        String o5 = decimalFormat.format(simulationRecord5.totalOciBus);
        String o6 = decimalFormat.format(simulationRecord6.totalOciBus);

        String op3 = decimalFormat.format(simulationRecord3.totalOperation);
        String op4 = decimalFormat.format(simulationRecord4.totalOperation);
        String op5 = decimalFormat.format(simulationRecord5.totalOperation);
        String op6 = decimalFormat.format(simulationRecord6.totalOperation);

        double _t3 = simulationRecord3.totalNormalSalary + simulationRecord3.totalExtraSalary + simulationRecord3.totalOciBus + simulationRecord3.totalOperation;
        double _t4 = simulationRecord4.totalNormalSalary + simulationRecord4.totalExtraSalary + simulationRecord4.totalOciBus + simulationRecord4.totalOperation;
        double _t5 = simulationRecord5.totalNormalSalary + simulationRecord5.totalExtraSalary + simulationRecord5.totalOciBus + simulationRecord5.totalOperation;
        double _t6 = simulationRecord6.totalNormalSalary + simulationRecord6.totalExtraSalary + simulationRecord6.totalOciBus + simulationRecord6.totalOperation;

        String t3 = decimalFormat.format(_t3);
        String t4 = decimalFormat.format(_t4);
        String t5 = decimalFormat.format(_t5);
        String t6 = decimalFormat.format(_t6);

        System.out.println("Resultados");
        System.out.println("Tam equipo " + "| Salario normal " + "| Salario extra"  + "| Ocio del camion " + "| Operaciones " + "| \tTotales");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(3 + "\t\t\t" + n3 + "\t\t\t" + e3 + "\t\t" + o3 + "\t\t " + op3 + "\t\t\t" + t3);
        System.out.println(4 + "\t\t\t" + n4 + "\t\t\t" + e4 + "\t\t" + o4 + "\t\t " + op4 + "\t\t\t" + t4);
        System.out.println(5 + "\t\t\t" + n5 + "\t\t\t" + e5 + "\t\t" + o5 + "\t\t " + op5 + "\t\t\t" + t5);
        System.out.println(6 + "\t\t\t" + n6 + "\t\t\t" + e6 + "\t\t" + o6 + "\t\t    " + op6 + "\t\t\t" + t6);
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
        double extraTime = 0.0d;

        while (true) {
            double prevRandomNumber1 = random1;
            random1 = this.generateRandomNumber();
            int timeBetweenArrives = InverseTransform.getArriveTime(random1);

            boolean isInQueue = (arriveTime + (timeBetweenArrives * 0.01)) < serviceTimeFinish;

            // System.out.println("HOUR BEFORE SAVE: " + arriveTime);
            TableRecord newTableRecord = new TableRecord(prevRandomNumber1, prevTimeBetweenArrives, arriveTime, startService, random2, serviceTime, serviceTimeFinish, leisurePersonalTime, timeToWaitForNextBus, isInQueue ? 1 : 0);
            getTeam(team).updateRecord(newTableRecord);

            arriveTime = arriveTime + (timeBetweenArrives * 0.01);
            arriveTime = this.transformHour(arriveTime);
            // System.out.println("HORAAAA: " + arriveTime);
            startService = (arriveTime < serviceTimeFinish) ? serviceTimeFinish : arriveTime;
            random2 = this.generateRandomNumber();
            serviceTime = getTeam(team).getServiceTime(team, random2);
            serviceTimeFinish = startService + (double)((double)(serviceTime) * 0.01);
            serviceTimeFinish = this.transformHour(serviceTimeFinish);
            leisurePersonalTime = (prevServiceTimeFinish < arriveTime) ? Math.abs(prevServiceTimeFinish - arriveTime) : 0;

            timeToWaitForNextBus = (arriveTime < prevServiceTimeFinish) ? Math.abs(arriveTime - prevServiceTimeFinish) : 0;
            prevServiceTimeFinish = serviceTimeFinish;


            if (serviceTimeFinish >= 15.00d) {
                extraTime = serviceTimeFinish - 15.00d;
                arriveTime = arriveTime + 0.3d;
                arriveTime = this.transformHour(arriveTime);

            }

            if (serviceTimeFinish >= 17.00d || count == 60) break;
            count++;
            prevTimeBetweenArrives = timeBetweenArrives;
        }

        double busWaitingTime = 0.0d;
        double workingTime = 0.0d;
        System.out.println("#ale \t| Tiempo entre llegadas | Tiempo de llegada | Inicio del servicio | #ale \t| Tiempo de servicio | Terminacion del servicio | Ocio del personal | Tiempo de espera del camión | Longitud de la cola ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

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

        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        double totalPrice = getTeam(team).getTotalCost();
        DecimalFormat format = new DecimalFormat("0.00000");

        double normalSalary = this.getTeam(team).getNormalSalary();
        double ociBus = getTeam(team).getBusAwaitTimePrice(busWaitingTime);
        double operations = getTeam(team).getServicePrice(workingTime * 0.01);
        //System.out.println(workingTime);
        PricesRecord newPricesRecord = new PricesRecord(normalSalary, extraTime, ociBus, operations, totalPrice);
        this.getTeam(team).updatePriceRecord(newPricesRecord);

        System.out.println("Resultados");
        System.out.println("Tam equipo " + "| Salario normal " + "| Salario extra"  + "| Ocio del camion " + "| Operaciones " + "| \tTotales");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(team + "\t\t\t\t" + format.format(normalSalary) + "\t\t" + format.format(extraTime) + "\t\t\t" + format.format(ociBus) + "\t\t\t" + format.format(operations) + "\t\t" + format.format(totalPrice));
        System.out.println();
        System.out.println();

    }

    private SimulationRecord getTeam(int teamMates) {
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

    private double transformHour(double hour) {
        double minutes = hour % 1;

        double _hour = hour;

        if (minutes > 0.60d) {
            _hour = (_hour + 1) - minutes;
            _hour = _hour + (minutes - 0.60d);
        }

        double minutes2 = _hour % 1;
        if (minutes2 == 0.60d) {
            _hour = (_hour + 1) - 0.60d;
        }
        return _hour;
    }

    private double getTimesInMinutes(double time) {
        return time * 0.01;
    }

    private double getTotalNormalSalary(ArrayList<PricesRecord> arr) {
        double summation = 0.0d;
        for (int i = 0; i < arr.size(); i++) {
            summation = summation + arr.get(i).normalSalary;
        }

        return summation;
    }

    private double getTotalExtraSalary(ArrayList<PricesRecord> arr) {
        double summation = 0.0d;
        for (int i = 0; i < arr.size(); i++) {
            summation = summation + arr.get(i).extraSalary;
        }

        return summation;
    }

    private double getTotalOciBus(ArrayList<PricesRecord> arr) {
        double summation = 0.0d;
        for (int i = 0; i < arr.size(); i++) {
            summation = summation + arr.get(i).ociBus;
        }

        return summation;
    }

    private double getTotalOperation(ArrayList<PricesRecord> arr) {
        double summation = 0.0d;
        for (int i = 0; i < arr.size(); i++) {
            summation = summation + arr.get(i).operation;
        }

        return summation;
    }

    private double getTotalCost(ArrayList<PricesRecord> arr) {
        double summation = 0.0d;
        for (int i = 0; i < arr.size(); i++) {
            summation = summation + arr.get(i).totalCost;
        }

        return summation;
    }

}
