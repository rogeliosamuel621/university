package barajita;

import javax.swing.*;
import java.util.ArrayList;

public class Game {
    ArrayList<Card> oro = new ArrayList<Card>();
    ArrayList<Card> copas = new ArrayList<Card>();
    ArrayList<Card> espadas = new ArrayList<Card>();
    ArrayList<Card> bastos = new ArrayList<Card>();
    int[] values = {2, 3, 4, 5, 6, 7, 10, 11, 12, 13};

    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Player player4 = new Player();

    public void distributeCards() {
        for (int i=0; i<10; i++) {
            Card randomCard = null;
            do {
                randomCard = this.getRandomCard();
            }while (randomCard == null);

            this.player1.addCard(randomCard);
        }

        System.out.println("JUGDOR 1 FINISHED");
        for(int i=0; i<10; i++) {
            System.out.println(this.player1.getCards().get(i).getName());
        }

        for (int i=0; i<10; i++) {
            Card randomCard = null;
            do {
                randomCard = this.getRandomCard();
            }while (randomCard == null);

            this.player2.addCard(randomCard);
        }

        /*
        System.out.println("JUGDOR 2 FINISHED");
        for(int i=0; i<10; i++) {
            System.out.println(this.player2.getCards().get(i).getName());
        }
         */

        for (int i=0; i<10; i++) {
            Card randomCard = null;
            do {
                randomCard = this.getRandomCard();
            }while (randomCard == null);

            this.player3.addCard(randomCard);
        }

        /*
        System.out.println("JUGDOR 3 FINISHED");
        for(int i=0; i<10; i++) {
            System.out.println(this.player3.getCards().get(i).getName());
        }
         */

        for (int i=0; i<10; i++) {
            Card randomCard = null;
            do {
                randomCard = this.getRandomCard();
            }while (randomCard == null);

            this.player4.addCard(randomCard);
        }

        /*
        System.out.println("JUGDOR 4 FINISHED");
        for(int i=0; i<10; i++) {
            System.out.println(this.player4.getCards().get(i).getName());
        }
        */
    }

    public void generateCards() {
        // oro
        for(int i=0; i<10; i++) {
            String cardName = "O" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            Card card = new Card(values[i], cardImage, cardName);
            this.oro.add(card);
        }

        // copas
        for(int i=0; i<10; i++) {
            String cardName = "C" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            Card card = new Card(values[i], cardImage, cardName);
            this.copas.add(card);
        }

        // espadas
        for(int i=0; i<10; i++) {
            String cardName = "E" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            Card card = new Card(values[i], cardImage, cardName);
            this.espadas.add(card);
        }

        // bastos
        for(int i=0; i<10; i++) {
            String cardName = "B" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            Card card = new Card(values[i], cardImage, cardName);
            this.bastos.add(card);
        }
    }

    public Card getRandomCard() {
        double num1 = Math.random();
        double num2 = Math.random();

        if(num1 >= 0.0d && num1 < 0.25d) { // oro
            int cardValue = this.getCardValue(num2);
            String cardName = "O" + cardValue;
            Card cardToGive = this.getCardInArray(cardName, this.oro);
            return cardToGive;
        }

        if (num1 >= 0.25d && num1 < 0.50d) { // copas
            int cardValue = this.getCardValue(num2);
            String cardName = "C" + cardValue ;
            Card cardToGive = this.getCardInArray(cardName, this.copas);
            return cardToGive;
        }

        if (num1 >= 0.50d && num1 < 0.75d) { // espadas
            int cardValue = this.getCardValue(num2);
            String cardName = "E" + cardValue;
            Card cardToGive = this.getCardInArray(cardName, this.espadas);
            return cardToGive;
        }

        if (num1 >= 0.75d && num1 < 1.0d) { // bastos
            int cardValue = this.getCardValue(num2);
            String cardName = "B" + cardValue;
            Card cardToGive = this.getCardInArray(cardName, this.bastos);
            return cardToGive;
        }

        return null;

    }

    private int getCardValue(double num) {
        if (num > 0.0d && num < 0.1d) return 2;
        if (num >= 0.1d && num < 0.2d) return 3;
        if (num >= 0.2d && num < 0.3d) return 4;
        if (num >= 0.3d && num < 0.4d) return 5;
        if (num >= 0.4d && num < 0.5d) return 6;
        if (num >= 0.5d && num < 0.6d) return 7;
        if (num >= 0.6d && num < 0.7d) return 10;
        if (num >= 0.7d && num < 0.8d) return 11;
        if (num >= 0.8d && num < 0.9d) return 12;
        return 13;
    }

    private JLabel createCardImage(String cardName) {
        try {
            String currentPath = new java.io.File(".").getCanonicalPath() + "/src/barajita/";
            JLabel image = new JLabel(new ImageIcon(currentPath + "images/" + cardName + ".jpg"));

            return image;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    private Card getCardInArray(String cardName, ArrayList<Card> cards) {
        Card cardFound = null;
        for(int i=0; i<cards.size(); i++) {
            if (cards.get(i) == null) continue;

            String currentCardName = cards.get(i).getName();
            if (cardName.equals(currentCardName)) {
                cardFound = cards.get(i);
                cards.set(i, null);
            }
        }

        return cardFound;
    }

}
