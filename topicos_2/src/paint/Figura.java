package paint;

import java.awt.*;
import java.io.Serializable;

class Figura implements Serializable {
    private Shape figura;
    private Color color;
    private boolean relleno;

    public Figura(Shape figura, Color color, boolean relleno) {
        this.figura = figura;
        this.color = color;
        this.relleno = relleno;
    }

    public void dibujar(Graphics2D g2d) {

        g2d.setColor(color);
        if (relleno) {
            g2d.fill( figura );
        } else {
            g2d.draw( figura );
        }

    }
}