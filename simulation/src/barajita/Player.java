package barajita;

import javax.swing.*;
import java.util.ArrayList;

public class Player {
    private int victories;
    private ArrayList<Card> cards;

    public Player() {
        this.cards = new ArrayList<Card>();
        this.victories = 0;
    }

    public void upgradeVictoriesCount() {
        this.victories++;
    }

    public int getVictories() {
        return victories;
    }

    public void addCard(String cardName) {
        try {
            String currentPath = new java.io.File(".").getCanonicalPath() + "/src/barajita/";
            JLabel image = new JLabel(new ImageIcon(currentPath + "images/" + cardName));

            StringBuilder _cardName = new StringBuilder(cardName);
            int cardValue = Integer.parseInt(_cardName.deleteCharAt(0).toString());

            Card newCard = new Card(cardValue, image);

            this.cards.add(newCard);

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
