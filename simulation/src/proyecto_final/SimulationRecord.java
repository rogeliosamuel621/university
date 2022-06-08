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
    public ArrayList<Double> totalPrices = new ArrayList<>();
    public ArrayList<PricesRecord> pricesRecords = new ArrayList<>();

    public double totalNormalSalary = 0.0d;
    public double totalExtraSalary = 0.0d;
    public double totalOciBus = 0.0d;
    public double totalOperation = 0.0d;
    public double totalCostFinal = 0.0d;

    public SimulationRecord(int teamMates) {
        this.normalSalary = this.salaryPerHour * this.workHours * teamMates;
        this.teamMates = teamMates;
    }

    public int getServiceTime(int teamMates, double randomNumber) {
        if (teamMates == 3) return InverseTransform.getServiceTimeTeam3(randomNumber);
        if (teamMates == 4) return InverseTransform.getServiceTimeTeam4(randomNumber);
        if (teamMates == 5) return InverseTransform.getServiceTimeTeam5(randomNumber);
        if (teamMates == 6) return InverseTransform.getServiceTimeTeam6(randomNumber);

        return InverseTransform.getServiceTimeTeam3(randomNumber);
    }

    public void updatePriceRecord(PricesRecord priceToRecord) {
        this.totalNormalSalary = this.totalNormalSalary + priceToRecord.normalSalary;
        this.totalExtraSalary = this.totalExtraSalary + priceToRecord.extraSalary;
        this.totalOciBus = this.totalOciBus + priceToRecord.ociBus;
        this.totalOperation = this.totalOperation + priceToRecord.operation;
        this.totalCostFinal = this.totalCostFinal + priceToRecord.totalCost;

        this.pricesRecords.add(priceToRecord);
    }

    public void updateRecord(TableRecord record) {
        this.records.add(record);
    }

    public TableRecord getRecord(int index) {
        return records.get(index);
    }

    public int getRecordLength() {
        return this.records.size();
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

    public void clearRecord() {
        this.records.clear();
    }
}

class PricesRecord {
    double normalSalary;
    double extraSalary;
    double ociBus;
    double operation;
    double totalCost;

    public PricesRecord(double normalSalary, double extraSalary, double ociBus, double operation, double totalCost) {
        this.normalSalary = normalSalary;
        this.extraSalary = extraSalary;
        this.ociBus = ociBus;
        this.operation = operation;
        this.totalCost = totalCost;
    }
}