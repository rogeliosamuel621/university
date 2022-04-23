package barajita;

import javax.swing.*;

public class Game {
    JLabel[] oro = new JLabel[9];
    JLabel[] copas = new JLabel[9];
    JLabel[] espadas = new JLabel[9];
    JLabel[] bastos = new JLabel[9];

    public void generateCards() {
        double num1 = Math.random();
        double num2 = Math.random();

        if(num1 >= 0.0d && num1 < 0.25d) { // oro
            /*
            const value = getCardValue(num2);
            const cardName = getCard(value)

             */
        }

        if (num1 >= 0.25d && num1 < 0.50d) { // copas

        }

        if (num1 >= 0.50d && num1 < 0.75d) { // espadas

        }

        if (num1 >= 0.75d && num1 < 1.0d) { // bastos

        }

    }
}
