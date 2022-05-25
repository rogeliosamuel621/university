package ruleta;

public class Record {
    int iteration;
    int prevBalance;
    int bet;
    double randomNumber;
    String color;
    String won;
    int nextBalance;
    String goalReached;
    int successes;

    public Record(int iteration, int prevBalance, int bet, double randomNumber, String color, String won, int nextBalance, String goalReached, int successes) {
        this.iteration = iteration;
        this.prevBalance = prevBalance;
        this.bet = bet;
        this.randomNumber = randomNumber;
        this.color = color;
        this.won = won;
        this.nextBalance = nextBalance;
        this.goalReached = goalReached;
        this.successes = successes;
    }

}
