package ruleta;

import java.util.ArrayList;

public class Game {
    public void startSimulation() {
        boolean prevColorIsGreen = false;
        boolean strategy1ReachedTheGoal = false;
        boolean strategy2ReachedTheGoal = false;

        Strategy1 strategy1 = new Strategy1();
        Strategy2 strategy2 = new Strategy2();

        int iteration = 0;
        int prevColor = 0;

        while (true) {
            iteration++;

            double randomNumber = Math.random();
            int color = this.getColor(randomNumber);
            boolean currentColorIsGreen = color == 3;

            if (prevColor == 3) {
                prevColorIsGreen = true;
            } else {
                prevColorIsGreen = false;
            }

            if(!strategy1ReachedTheGoal) strategy1ReachedTheGoal = strategy1.play(randomNumber, color, iteration, prevColorIsGreen, currentColorIsGreen);
            if(!strategy2ReachedTheGoal) strategy2ReachedTheGoal = strategy2.play(randomNumber, color, iteration, prevColorIsGreen, currentColorIsGreen);

            if (strategy1ReachedTheGoal && strategy2ReachedTheGoal) break;

            prevColor = color;
        }

        ArrayList<Record> recordStrategy1 = strategy1.records;
        ArrayList<Record> recordStrategy2 = strategy2.records;

        System.out.println("Strategy 1");
        System.out.println("i $antes \t bet \t #ale \t color \t ganó? \t $despues \t meta? \t exito");
        for (int i = 0; i < recordStrategy1.size(); i++) {
            Record c = recordStrategy1.get(i);
            System.out.println(c.iteration + " \t " + c.prevBalance + " \t " + c.bet + " \t " + c.randomNumber + " \t " + c.color + " \t " + c.won + " \t " + c.nextBalance + " \t\t " + c.goalReached + " \t " + c.successes);
        }
        System.out.println();

        System.out.println("Strategy 2");
        System.out.println("i $antes \t bet \t #ale \t color \t ganó? \t $despues \t meta? \t exito");
        for (int i = 0; i < recordStrategy2.size(); i++) {
            Record c = recordStrategy2.get(i);
            System.out.println(c.iteration + " \t " + c.prevBalance + " \t " + c.bet + " \t " + c.randomNumber + " \t " + c.color + " \t " + c.won + " \t " + c.nextBalance + " \t\t " + c.goalReached + " \t " + c.successes);
        }
        System.out.println();


    }

    private int getColor(double randomNumber) {
        if (randomNumber <= 0.45d) return 1;
        if (randomNumber > 0.45d && randomNumber <= 0.9d) return 2;

        return 3;
    }
}
