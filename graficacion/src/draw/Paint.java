package draw;

import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel {
    Graphics graphic;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.graphic = g;
        this.drawRect();
    }

    private void drawRect() {
        float[] hehe = new float[1];
        this.graphic.fillRect(0, 500, 100, 100);
    }
}
