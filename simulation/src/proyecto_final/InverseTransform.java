package proyecto_final;

public class InverseTransform {
    static public int getBusesWaiting(double randomNumber) {
        if (randomNumber >= 0.0d && randomNumber < 0.5d) return 0;
        if (randomNumber >= 0.5d && randomNumber < 0.75d) return 1;
        if (randomNumber >= 0.75d && randomNumber < 0.90d) return 2;

        return 3;
    }

    static public int getArriveTime(double randomNumber) {
        if (randomNumber >= 0.0d && randomNumber < 0.02d) return 20;
        if (randomNumber >= 0.02d && randomNumber < 0.10d) return 25;
        if (randomNumber >= 0.10d && randomNumber < 0.22d) return 30;
        if (randomNumber >= 0.22d && randomNumber < 0.47d) return 35;
        if (randomNumber >= 0.47d && randomNumber < 0.67d) return 40;
        if (randomNumber >= 0.67d && randomNumber < 0.82d) return 45;
        if (randomNumber >= 0.82d && randomNumber < 0.92d) return 50;
        if (randomNumber >= 0.92d && randomNumber < 0.97d) return 55;

        return 60;
    }

    static public int getServiceTimeTeam3(double randomNumber) {
        if (randomNumber >= 0.0d && randomNumber < 0.05d) return 20;
        if (randomNumber >= 0.05d && randomNumber < 0.15d) return 25;
        if (randomNumber >= 0.15d && randomNumber < 0.35d) return 30;
        if (randomNumber >= 0.35d && randomNumber < 0.60d) return 35;
        if (randomNumber >= 0.60d && randomNumber < 0.72d) return 40;
        if (randomNumber >= 0.72d && randomNumber < 0.82d) return 45;
        if (randomNumber >= 0.82d && randomNumber < 0.90d) return 50;
        if (randomNumber >= 0.90d && randomNumber < 0.96d) return 55;

        return 60;
    }

    static public int getServiceTimeTeam4(double randomNumber) {
        if (randomNumber >= 0.0d && randomNumber < 0.05d) return 15;
        if (randomNumber >= 0.05d && randomNumber < 0.20d) return 20;
        if (randomNumber >= 0.20d && randomNumber < 0.40d) return 25;
        if (randomNumber >= 0.40d && randomNumber < 0.60d) return 30;
        if (randomNumber >= 0.60d && randomNumber < 0.75d) return 35;
        if (randomNumber >= 0.75d && randomNumber < 0.87d) return 40;
        if (randomNumber >= 0.87d && randomNumber < 0.95d) return 45;
        if (randomNumber >= 0.95d && randomNumber < 0.99d) return 50;

        return 55;
    }

    static public int getServiceTimeTeam5(double randomNumber) {
        if (randomNumber >= 0.00d && randomNumber < 0.10d) return 10;
        if (randomNumber >= 0.10d && randomNumber < 0.28d) return 15;
        if (randomNumber >= 0.28d && randomNumber < 0.50d) return 20;
        if (randomNumber >= 0.50d && randomNumber < 0.68d) return 25;
        if (randomNumber >= 0.68d && randomNumber < 0.78d) return 30;
        if (randomNumber >= 0.78d && randomNumber < 0.86d) return 35;
        if (randomNumber >= 0.86d && randomNumber < 0.92d) return 40;
        if (randomNumber >= 0.92d && randomNumber < 0.97d) return 45;

        return 50;
    }

    static public int getServiceTimeTeam6(double randomNumber) {
        if (randomNumber >= 0.00d && randomNumber < 0.12d) return 5;
        if (randomNumber >= 0.12d && randomNumber < 0.27d) return 10;
        if (randomNumber >= 0.27d && randomNumber < 0.53d) return 15;
        if (randomNumber >= 0.53d && randomNumber < 0.68d) return 20;
        if (randomNumber >= 0.68d && randomNumber < 0.80d) return 25;
        if (randomNumber >= 0.80d && randomNumber < 0.88d) return 30;
        if (randomNumber >= 0.88d && randomNumber < 0.94d) return 35;
        if (randomNumber >= 0.94d && randomNumber < 0.98d) return 40;

        return 45;
    }
}
