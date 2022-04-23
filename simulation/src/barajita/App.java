package barajita;

public class App  {
    public static void main(String[] args) {
        Game game = new Game();

        game.generateCards();
        game.distributeCards();
    }
}
