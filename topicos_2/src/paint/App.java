package paint;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        Dibujador window = new Dibujador("Paint");
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}

