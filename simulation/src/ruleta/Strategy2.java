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

    public boolean play(double randomNumber, int color, int iteration, boolean prevColorIsGreen) {

        int prevBalance = this.currentBalance;
        if (this.moreThanTwiceLost) {
            this.updateQuantityToBet(false, color, prevColorIsGreen);
        } else {
            this.updateQuantityToBet(true, color, prevColorIsGreen);
        }

        boolean isWinner = this.getIsWinner(color);

        
        if (!this.prevIsWinner && !isWinner) {
            this.moreThanTwiceLost = true;
        } else if(isWinner) {
            this.moreThanTwiceLost = false;
        }
        /*
        if (!this.prevIsWinner && !isWinner) {
            this.updateQuantityToBet(this.prevIsWinner, color, prevColorIsGreen);
        } else if (isWinner) {
            this.updateQuantityToBet(isWinner, color, prevColorIsGreen);
        }
         */

        this.prevIsWinner = isWinner;
        this.upgradeSuccesses(isWinner, prevColorIsGreen);
        this.updateBalanceAfterResult(isWinner, this.quantityToBet, prevColorIsGreen);

        int balanceAfterBet = this.currentBalance;

        boolean isGoalReached = this.getIsGoalReached(this.currentBalance);

        String textColor = this.getTextColor(color);
        String textWin = this.getTextWin(color);
        String textGoalReached = this.getTextGoalReached(isGoalReached);
        String textRandomNumber = new DecimalFormat("0.00000").format(randomNumber);

        Record newRecord = new Record(iteration, prevBalance, this.quantityToBet, textRandomNumber, textColor, textWin, balanceAfterBet, textGoalReached, this.successes);

        /*
        System.out.println("i: " + newRecord.iteration);
        System.out.println("$ antes: " + newRecord.prevBalance);
        System.out.println("apuesta: " + newRecord.bet);
        System.out.println("ale: " + newRecord.randomNumber);
        System.out.println("color: " + newRecord.color);
        System.out.println("ganó?: " + newRecord.won);
        System.out.println("$ after: " + newRecord.nextBalance);
        System.out.println("meta: " + newRecord.goalReached);
        System.out.println("exitos: " + newRecord.successes);
        System.out.println("CUrrent balance: " + this.currentBalance);
        System.out.println();
        */

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

    private void updateBalanceAfterResult(boolean won, int currentBet, boolean prevColorIsGreen) {
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
