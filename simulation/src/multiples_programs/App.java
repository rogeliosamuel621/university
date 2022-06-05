package multiples_programs;

public class App {
    public static void main(String[] args) {
        double[] randomNumbers = generateRandomNumber(64);

        ChiSquareMethod chiSquareMethod = new ChiSquareMethod(randomNumbers);
        chiSquareMethod.startSimulation();
    }


    static double[] generateRandomNumber(int limit) {
        double[] randomNumbers = new double[limit];
        for (int i = 0; i < limit; i++) {
            randomNumbers[i] = Math.random();
        }

        return randomNumbers;
    }
}
