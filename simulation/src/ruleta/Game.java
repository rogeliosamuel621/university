package ruleta;

public class Game {
    public void startSimulation() {
        boolean prevColorIsGreen = false;

        Strategy1 strategy1 = new Strategy1();
        Strategy2 strategy2 = new Strategy2();

        int iteration = 0;
        int prevColor = 0;

        while (true) {
            iteration++;

            double randomNumber = Math.random();
            int color = this.getColor(randomNumber);

            if (color == 3 || prevColor == 3) {
                prevColorIsGreen = true;
            } else {
                prevColorIsGreen = false;
            }

            boolean strategy1ReachedTheGoal = strategy1.play(randomNumber, color, iteration, prevColorIsGreen);
            boolean strategy2ReachedTheGoal = strategy2.play(randomNumber, color, iteration, prevColorIsGreen);

            if (strategy1ReachedTheGoal || strategy2ReachedTheGoal) break;

            prevColor = color;
        }
    }

    private int getColor(double randomNumber) {
        if (randomNumber <= 0.45d) return 1;
        if (randomNumber > 0.45d && randomNumber <= 0.9d) return 2;

        return 3;
    }
}
