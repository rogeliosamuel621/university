package proyecto_final;

public class TableRecord {
    double randomNumber_1;
    int timeBetweenArrives;
    float arriveHour;
    float serviceStartHour;
    double randomNumber_2;
    int serviceTime;
    int deathTime;
    int timeToWaitForBus;
    int inQueue;


    public TableRecord(double randomNumber_1, int timeBetweenArrives, float arriveHour, float serviceStartHour, double randomNumber_2, int serviceTime, int deathTime, int timeToWaitForBus, int inQueue) {
        this.randomNumber_1 = randomNumber_1;
        this.timeBetweenArrives = timeBetweenArrives;
        this.arriveHour = arriveHour;
        this.serviceStartHour = serviceStartHour;
        this.randomNumber_2 = randomNumber_2;
        this.serviceTime = serviceTime;
        this.deathTime = deathTime;
        this.timeToWaitForBus = timeToWaitForBus;
        this.inQueue = inQueue;
    }

}
