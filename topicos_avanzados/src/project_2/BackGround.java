package project_2;

import javax.swing.*;
import java.awt.*;

public class BackGround extends JPanel {
    public void paintComponent (Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("meta.jpeg"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
