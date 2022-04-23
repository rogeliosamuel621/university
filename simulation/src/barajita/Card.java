package barajita;

import javax.swing.*;

public class Card {
    private int value;
    private JLabel image;
    private String name;

    public Card(int value, JLabel image, String name) {
        this.value = value;
        this.image = image;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public JLabel getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
