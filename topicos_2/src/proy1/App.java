package proy1;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        Editor window = new Editor("EDITOR DE TEXTO");
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}