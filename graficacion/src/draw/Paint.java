package draw;

import javax.swing.*;
import java.awt.*;

public class Pain extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0,0, 100, 100);
    }
}