package proyecto_final;

public class TableRecord {
    double randomNumber_1;
    int timeBetweenArrives;
    double arriveHour;
    double serviceStartHour;
    double randomNumber_2;
    double serviceTime;
    double serviceFinishTime;
    double deathTime;
    double timeToWaitForBus;
    int inQueue;


    public TableRecord(double randomNumber_1, int timeBetweenArrives, double arriveHour, double serviceStartHour, double randomNumber_2, double serviceTime, double serviceFinishTime, double deathTime, double timeToWaitForBus, int inQueue) {
        this.randomNumber_1 = randomNumber_1;
        this.timeBetweenArrives = timeBetweenArrives;
        this.arriveHour = arriveHour;
        this.serviceStartHour = serviceStartHour;
        this.randomNumber_2 = randomNumber_2;
        this.serviceTime = serviceTime;
        this.serviceFinishTime = serviceFinishTime;
        this.deathTime = deathTime;
        this.timeToWaitForBus = timeToWaitForBus;
        this.inQueue = inQueue;
    }

}
