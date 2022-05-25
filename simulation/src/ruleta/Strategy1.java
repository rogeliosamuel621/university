package ruleta;

/*
COLORS
- 1: RED
- 2: BLACK
- 3: GREEN
 */

public class Strategy1 {
    int quantityToBet = 1;
    int betColor = 1;
    int initialBalance = 200;
    int currentBalance = this.initialBalance;
    int goal = 1000;

    public String getTextColor(int color) {
        if (color == 1) return "Red";
        if (color == 2) return "Black";

        return  "Green";
    }

    public void updateBalanceAfterResult(boolean won, int currentBet) {
        if (won) {
            this.currentBalance = this.currentBalance + currentBet;
            return;
        }

        this.currentBalance = this.currentBalance - currentBet;
    }

}
