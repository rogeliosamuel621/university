package barajita;

import javax.swing.*;

public class Player {
    private int victories;
    private JLabel[] cards;

    public Player(JLabel[] cards) {
        this.cards = cards;
        this.victories = 0;
    }

    public void upgradeVictoriesCount() {
        this.victories++;
    }

    public int getVictories() {
        return victories;
    }

    public JLabel[] getCards() {
        return cards;
    }
}
