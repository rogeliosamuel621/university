package barajita;

import javax.swing.*;

public class Card {
    private int value;
    private JLabel image;

    public Card(int value, JLabel image) {
        this.value = value;
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public JLabel getImage() {
        return image;
    }
}
