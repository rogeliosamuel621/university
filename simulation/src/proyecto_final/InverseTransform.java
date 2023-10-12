package proyecto_final;

public class InverseTransform {
    static public int getBusesWaiting(double numeroRandom) {
        if (numeroRandom >= 0.0d && numeroRandom < 0.5d) return 0;
        if (numeroRandom >= 0.5d && numeroRandom < 0.75d) return 1;
        if (numeroRandom >= 0.75d && numeroRandom < 0.90d) return 2;

        return 3;
    }

    static public int getArriveTime(double numeroRandom) {
        if (numeroRandom >= 0.0d && numeroRandom < 0.02d) return 20;
        if (numeroRandom >= 0.02d && numeroRandom < 0.10d) return 25;
        if (numeroRandom >= 0.10d && numeroRandom < 0.22d) return 30;
        if (numeroRandom >= 0.22d && numeroRandom < 0.47d) return 35;
        if (numeroRandom >= 0.47d && numeroRandom < 0.67d) return 40;
        if (numeroRandom >= 0.67d && numeroRandom < 0.82d) return 45;
        if (numeroRandom >= 0.82d && numeroRandom < 0.92d) return 50;
        if (numeroRandom >= 0.92d && numeroRandom < 0.97d) return 55;

        return 60;
    }

    static public int getServiceTimeTeam3(double numeroRandom) {
        if (numeroRandom >= 0.0d && numeroRandom < 0.05d) return 20;
        if (numeroRandom >= 0.05d && numeroRandom < 0.15d) return 25;
        if (numeroRandom >= 0.15d && numeroRandom < 0.35d) return 30;
        if (numeroRandom >= 0.35d && numeroRandom < 0.60d) return 35;
        if (numeroRandom >= 0.60d && numeroRandom < 0.72d) return 40;
        if (numeroRandom >= 0.72d && numeroRandom < 0.82d) return 45;
        if (numeroRandom >= 0.82d && numeroRandom < 0.90d) return 50;
        if (numeroRandom >= 0.90d && numeroRandom < 0.96d) return 55;

        return 60;
    }

    static public int getServiceTimeTeam4(double numeroRandom) {
        if (numeroRandom >= 0.0d && numeroRandom < 0.05d) return 15;
        if (numeroRandom >= 0.05d && numeroRandom < 0.20d) return 20;
        if (numeroRandom >= 0.20d && numeroRandom < 0.40d) return 25;
        if (numeroRandom >= 0.40d && numeroRandom < 0.60d) return 30;
        if (numeroRandom >= 0.60d && numeroRandom < 0.75d) return 35;
        if (numeroRandom >= 0.75d && numeroRandom < 0.87d) return 40;
        if (numeroRandom >= 0.87d && numeroRandom < 0.95d) return 45;
        if (numeroRandom >= 0.95d && numeroRandom < 0.99d) return 50;

        return 55;
    }

    static public int getServiceTimeTeam5(double numeroRandom) {
        if (numeroRandom >= 0.00d && numeroRandom < 0.10d) return 10;
        if (numeroRandom >= 0.10d && numeroRandom < 0.28d) return 15;
        if (numeroRandom >= 0.28d && numeroRandom < 0.50d) return 20;
        if (numeroRandom >= 0.50d && numeroRandom < 0.68d) return 25;
        if (numeroRandom >= 0.68d && numeroRandom < 0.78d) return 30;
        if (numeroRandom >= 0.78d && numeroRandom < 0.86d) return 35;
        if (numeroRandom >= 0.86d && numeroRandom < 0.92d) return 40;
        if (numeroRandom >= 0.92d && numeroRandom < 0.97d) return 45;

        return 50;
    }

    static public int getServiceTimeTeam6(double numeroRandom) {
        if (numeroRandom >= 0.00d && numeroRandom < 0.12d) return 5;
        if (numeroRandom >= 0.12d && numeroRandom < 0.27d) return 10;
        if (numeroRandom >= 0.27d && numeroRandom < 0.53d) return 15;
        if (numeroRandom >= 0.53d && numeroRandom < 0.68d) return 20;
        if (numeroRandom >= 0.68d && numeroRandom < 0.80d) return 25;
        if (numeroRandom >= 0.80d && numeroRandom < 0.88d) return 30;
        if (numeroRandom >= 0.88d && numeroRandom < 0.94d) return 35;
        if (numeroRandom >= 0.94d && numeroRandom < 0.98d) return 40;

        return 45;
    }
}
