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
    private int servicePrice = 0;
    private int totalCost;
    private int teamMates;

    public SimulationRecord(int teamMates) {
        this.normalSalary = this.salaryPerHour * this.workHours * teamMates;
        this.teamMates = teamMates;
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
        return servicePrice * timeService;
    }

    public double getBusAwaitTimePrice(double busAwaitTime) {
        return this.busAwaitTimePrice * busAwaitTime;
    }
}
