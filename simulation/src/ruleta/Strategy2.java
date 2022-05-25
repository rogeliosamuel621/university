package ruleta;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Strategy2 {
    int initialQuantityToBet = 1;
    int quantityToBet = 1;
    int betColor = 1;
    int initialBalance = 200;
    int currentBalance = this.initialBalance;
    int goal = 1000;
    int successes = 0;
    ArrayList<Record> records = new ArrayList<>();
    boolean prevIsWinner = true;
    boolean moreThanTwiceLost = false;

    public boolean play(double randomNumber, int color, int iteration, boolean prevColorIsGreen, boolean currentColorIsGreen) {

        int prevBalance = this.currentBalance;
        this.updateQuantityToBet(this.prevIsWinner, color, prevColorIsGreen);

        boolean isWinner = this.getIsWinner(color);

        this.prevIsWinner = isWinner;
        this.upgradeSuccesses(isWinner, prevColorIsGreen, currentColorIsGreen);
        this.updateBalanceAfterResult(isWinner, this.quantityToBet, prevColorIsGreen, currentColorIsGreen);

        int balanceAfterBet = this.currentBalance;

        boolean isGoalReached = this.getIsGoalReached(this.currentBalance);

        String textColor = this.getTextColor(color);
        String textWin = this.getTextWin(color);
        String textGoalReached = this.getTextGoalReached(isGoalReached);
        String textRandomNumber = new DecimalFormat("0.00000").format(randomNumber);

        Record newRecord = new Record(iteration, prevBalance, this.quantityToBet, textRandomNumber, textColor, textWin, balanceAfterBet, textGoalReached, this.successes);

        this.records.add(newRecord);

        return (isGoalReached || this.currentBalance <= 0);
    }

    private void updateQuantityToBet(boolean isWinner, int color, boolean prevColorIsGreen) {
        if (prevColorIsGreen) return;

        if (!isWinner) {
            this.quantityToBet = this.quantityToBet * 2;
            return;
        }

        this.quantityToBet = this.initialQuantityToBet;


    }

    private void updateBalanceAfterResult(boolean won, int currentBet, boolean prevColorIsGreen, boolean currentColorIsGreen) {
        if (currentColorIsGreen) return;

        if (prevColorIsGreen && !won) {
            this.currentBalance = this.currentBalance - currentBet;
            return;
        };

        if (prevColorIsGreen) return;

        if (won) {
            this.currentBalance = this.currentBalance + currentBet;
            return;
        }

        this.currentBalance = this.currentBalance - currentBet;
    }

    private void upgradeSuccesses(boolean isWinner, boolean prevColorIsGreen, boolean currentColorIsGreen) {
        if (isWinner && !prevColorIsGreen && !currentColorIsGreen) {
            this.successes++;
            return;
        }

        return;
    }

    private boolean getIsGoalReached(int balance) {
        return balance == this.goal;
    }

    private boolean getIsWinner(int color) {
        if (color == 3) return true;

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
