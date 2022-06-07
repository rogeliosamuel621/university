package proyecto_final;

import java.util.ArrayList;

public class SimulationRecord {
    private final int salaryPerHour = 25; // dollars
    private final int workHours = 8;
    private final float salaryPerExtraHour = 37.5f; // dollars
    private final int servicePricePerHour = 500; // dollars
    private final int waitBusPricePerHour = 100; // dollars

    private ArrayList<TableRecord> records = new ArrayList<>();
    private int normalSalary = 0;
    private double extraSalary = 0;
    private double busAwaitTimePrice = 0;
    private double servicePrice = 0;
    private double totalCost;
    private int teamMates;

    public SimulationRecord(int teamMates) {
        this.normalSalary = this.salaryPerHour * this.workHours * teamMates;
        this.teamMates = teamMates;
    }

    public int getServiceTime(double randomNumber) {
        if (this.teamMates == 3) return InverseTransform.getServiceTimeTeam3(randomNumber);
        if (this.teamMates == 4) return InverseTransform.getServiceTimeTeam4(randomNumber);
        if (this.teamMates == 5) return InverseTransform.getServiceTimeTeam5(randomNumber);
        if (this.teamMates == 6) return InverseTransform.getServiceTimeTeam6(randomNumber);

        return InverseTransform.getServiceTimeTeam3(randomNumber);
    }

    public void updateRecord(TableRecord record) {
        this.records.add(record);
    }

    public TableRecord getRecord(int index) {
        return records.get(index);
    }

    public int getNormalSalary() {
        return this.normalSalary;
    }

    public double getExtraSalary(double extraTime) {
        return this.salaryPerExtraHour * this.extraSalary * extraTime;
    }

    public double getServicePrice(double timeService) {
        this.servicePrice = this.servicePricePerHour * timeService;
        return this.servicePrice;
    }

    public double getBusAwaitTimePrice(double busAwaitTime) {
        this.busAwaitTimePrice = this.waitBusPricePerHour * busAwaitTime;
        return this.busAwaitTimePrice;
    }

    public double getTotalCost() {
        this.totalCost = this.normalSalary + this.extraSalary + this.servicePrice + this.busAwaitTimePrice;

        return this.totalCost;
    }
}
