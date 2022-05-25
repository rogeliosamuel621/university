package ruleta;

/*
COLORS
- 1: RED
- 2: BLACK
- 3: GREEN
 */

import java.util.ArrayList;

public class Strategy1 {
    int quantityToBet = 1;
    int betColor = 1;
    int initialBalance = 200;
    int currentBalance = this.initialBalance;
    int goal = 1000;
    int successes = 0;
    ArrayList<Record> records = new ArrayList<>();

    public boolean play(double randomNumber, int color, int iteration, boolean prevColorIsGreen) {

        int prevBalance = this.currentBalance;

        boolean isWinner = this.getIsWinner(color);
        this.upgradeSuccesses(isWinner, prevColorIsGreen);
        this.updateBalanceAfterResult(isWinner, this.quantityToBet, prevColorIsGreen);

        int balanceAfterBet = this.quantityToBet;

        boolean isGoalReached = this.getIsGoalReached(this.currentBalance);

        String textColor = this.getTextColor(color);
        String textWin = this.getTextWin(color);
        String textGoalReached = this.getTextGoalReached(isGoalReached);

        Record newRecord = new Record(iteration, prevBalance, this.quantityToBet, randomNumber, textColor, textWin, balanceAfterBet, textGoalReached, this.successes);
        this.records.add(newRecord);

        return isGoalReached;


    }

    private void updateBalanceAfterResult(boolean won, int currentBet, boolean prevColorIsGreen) {
        if (prevColorIsGreen) return;

        if (won) {
            this.currentBalance = this.currentBalance + currentBet;
            return;
        }

        this.currentBalance = this.currentBalance - currentBet;
    }

    private void upgradeSuccesses(boolean isWinner, boolean prevColorIsGreen) {
        if (isWinner && !prevColorIsGreen) {
            this.successes++;
            return;
        }

        return;
    }

    private boolean getIsGoalReached(int balance) {
        return balance == this.goal;
    }

    private boolean getIsWinner(int color) {
        return color == this.betColor;
    }

    private String getTextColor(int color) {
        if (color == 1) return "Red";
        if (color == 2) return "Black";

        return  "Green";
    }

    private String getTextWin(int color) {
        if (color == 1) return "Si";
        if (color == 2) return "No";

        return "Nulo";
    }

    private String getTextGoalReached(boolean goalReached) {
        return goalReached ? "Si" : "No";
    }

}
