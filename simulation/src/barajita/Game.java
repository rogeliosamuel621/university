package barajita;

import javax.swing.*;
import java.util.ArrayList;

public class Game {
    ArrayList<JLabel> oro = new ArrayList<JLabel>();
    ArrayList<JLabel> copas = new ArrayList<JLabel>();
    ArrayList<JLabel> espadas = new ArrayList<JLabel>();
    ArrayList<JLabel> bastos = new ArrayList<JLabel>();
    int[] values = {2, 3, 4, 5, 6, 7, 10, 11, 12, 13};

    public void generateCards() {
        // oro
        for(int i=0; i<10; i++) {
            String cardName = "O" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            this.oro.add(cardImage);
        }

        // copas
        for(int i=0; i<10; i++) {
            String cardName = "C" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            this.copas.add(cardImage);
        }

        // espadas
        for(int i=0; i<10; i++) {
            String cardName = "e" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            this.espadas.add(cardImage);
        }

        // bastos
        for(int i=0; i<10; i++) {
            String cardName = "b" + this.values[i];
            JLabel cardImage = this.createCardImage(cardName);
            this.bastos.add(cardImage);
        }


    }

    public void distributeCards() {
        double num1 = Math.random();
        double num2 = Math.random();

        if(num1 >= 0.0d && num1 < 0.25d) { // oro
            int cardValue = this.getCardValue(num2);
            String cardName = "O" + cardValue + ".jpg";
        }

        if (num1 >= 0.25d && num1 < 0.50d) { // copas
            int cardValue = this.getCardValue(num2);
            String cardName = "C" + cardValue + ".jpg";
        }

        if (num1 >= 0.50d && num1 < 0.75d) { // espadas
            int cardValue = this.getCardValue(num2);
            String cardName = "E" + cardValue + ".jpg";
        }

        if (num1 >= 0.75d && num1 < 1.0d) { // bastos
            int cardValue = this.getCardValue(num2);
            String cardName = "B" + cardValue + ".jpg";
        }

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
            JLabel image = new JLabel(new ImageIcon(currentPath + "images/" + cardName));

            return image;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }
}
