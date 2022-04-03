package draw;

import javax.swing.*;
import java.awt.*;

public class App extends JPanel {
    int initialPoint = 300;
    public static void main(String[] args) {

        JFrame window = new JFrame("Rogelio Samuel");
        App obj = new App();
        //Definir la ventana
        window.add(obj);
        window.setSize(1200, 800);
        window.setLocationRelativeTo(window);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void  paint(Graphics g){
        // borders
        Graphics2D border = (Graphics2D) g;
        BasicStroke borderWidth = new BasicStroke(1);
        border.setStroke(borderWidth);


        // background
        g.setColor(new Color(0, 0, 200));
        g.fillRect(initialPoint - initialPoint, 0, 1200, 800);

        // 1er edificio
        g.setColor(new Color(140, 158, 162));
        g.fillRect(initialPoint, 600, 200, 200);

        // 2do edificio
        g.setColor(new Color(140, 158, 162));
        g.fillRect(initialPoint + 201, 400, 200, 400);

        // 3er edificio
        g.setColor(new Color(140, 158, 162));
        g.fillRect(initialPoint + 402, 200, 200, 600);

        // windows 1st building
        g.setColor(new Color(191, 201, 205));
        g.fillRect(initialPoint + 20, 700, 160, 30);
        border.setColor(new Color(0,0,0));
        border.drawRect(initialPoint + 20, 700, 160, 30);
        //lineas
        int separation = 160/4;
        g.setColor(new Color(0,0,0));
        g.drawLine((initialPoint + 20) + (separation * 1), 700, (initialPoint + 20) + (separation * 1), 730);
        g.drawLine((initialPoint + 20) + (separation * 2), 700, (initialPoint + 20) + (separation * 2), 730);
        g.drawLine((initialPoint + 20) + (separation * 3), 700, (initialPoint + 20) + (separation * 3), 730);

        g.setColor(new Color(191, 201, 205));
        g.fillRect(initialPoint + 20, 660, 160, 30);
        border.setColor(new Color(0,0,0));
        border.drawRect(initialPoint + 20, 660, 160, 30);
        //lines
        g.setColor(new Color(0,0,0));
        g.drawLine((initialPoint + 20) + (separation * 1), 660, (initialPoint + 20) + (separation * 1), 690);
        g.drawLine((initialPoint + 20) + (separation * 2), 660, (initialPoint + 20) + (separation * 2), 690);
        g.drawLine((initialPoint + 20) + (separation * 3), 660, (initialPoint + 20) + (separation * 3), 690);

        g.setColor(new Color(191, 201, 205));
        g.fillRect(initialPoint + 20, 620, 160, 30);
        border.setColor(new Color(0,0,0));
        border.drawRect(initialPoint + 20, 620, 160, 30);
        // lines
        g.setColor(new Color(0,0,0));
        g.drawLine((initialPoint + 20) + (separation * 1), 620, (initialPoint + 20) + (separation * 1), 650);
        g.drawLine((initialPoint + 20) + (separation * 2), 620, (initialPoint + 20) + (separation * 2), 650);
        g.drawLine((initialPoint + 20) + (separation * 3), 620, (initialPoint + 20) + (separation * 3), 650);

        // windows 3rd building
        g.setColor(new Color(191, 201, 205));
        int count = 700;
        int countForLines;
        for(int i = 0; i<13; i++) {
            g.setColor(new Color(191, 201, 205));
            g.fillRect(initialPoint + 420, count, 160, 30);
            border.setColor(new Color(0,0,0));
            border.drawRect(initialPoint + 420, count, 160, 30);

            int initialPointWindow = initialPoint + 420;
            int _separation = 160/4;

            for(int j=1; j<5; j++) {
                g.setColor(new Color(0,0,0));
                g.drawLine(initialPointWindow + (_separation * j), count, initialPointWindow + (_separation * j), count + 30);
            }
            count = count - 40;
        }

        // roof 1
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint - 10, 550, 220, 50);
        g.setColor(new Color(0,0,0));
        int baseLineRoof1 = 550;
        for(int i=0; i<55; i+=5) {
            g.drawLine(initialPoint - 10, baseLineRoof1 + i, initialPoint + 210, baseLineRoof1 + i);
        }

        // roof 1 roof
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint + 20, 520, 160, 30);
        g.setColor(new Color(0,0,0));
        int baseLineRoof1Rof = 520;
        for(int i=0; i<55; i+=5) {
            g.drawLine(initialPoint + 20, baseLineRoof1Rof + i, initialPoint + 180, baseLineRoof1Rof + i);
        }

        // roof 3
        /*
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint + 400, 550, 220, 50);
        g.setColor(new Color(0,0,0));
        int baseLineRoof2 = 550;
        for(int i=0; i<55; i+=5) {
            g.drawLine(initialPoint - 10, baseLineRoof1 + i, initialPoint + 210, baseLineRoof1 + i);
        }
        */
    }

    public void drawWindow(Graphics g) {
        g.setColor(new Color(191, 201, 205));
        g.fillRect(initialPoint + 20, 700, 160, 30);
    }
}
