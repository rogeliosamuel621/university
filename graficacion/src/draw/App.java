package draw;

import javax.swing.*;
import java.awt.*;

public class App extends JPanel {
    int initialPoint = 300;
    Graphics g;
    Graphics2D border;

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

    public void  paint(Graphics graphics){
        g = graphics;
        // borders
        border = (Graphics2D) g;
        BasicStroke borderWidth = new BasicStroke(1);
        border.setStroke(borderWidth);


        // background
        GradientPaint ventana_azul= new GradientPaint(0,0,new Color(20, 95, 165),10,10, new Color(63, 136, 205), true);
        g.setColor(new Color(0, 0, 200));
        g.fillRect(initialPoint - initialPoint, 0, 1200, 800);

        // 1st building
        firstBuilding();

        // 2nd building
        secondBuilding();

        // 3rd building
        thirdBuilding();

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

    public void firstBuilding() {
        // Shape
        g.setColor(new Color(140, 158, 162));
        g.fillRect(initialPoint, 600, 200, 200);

        // windows
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

        // Roof
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint - 10, 570, 220, 30);
        g.setColor(new Color(0,0,0));
        int baseLineRoof1 = 570;
        for(int i=0; i<35; i+=5) {
            g.drawLine(initialPoint - 10, baseLineRoof1 + i, initialPoint + 210, baseLineRoof1 + i);
        }

        // Roof 1.1
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint + 20, 540, 160, 30);
        g.setColor(new Color(0,0,0));
        int baseLineRoof1Rof = 540;
        for(int i=0; i<35; i+=5) {
            g.drawLine(initialPoint + 20, baseLineRoof1Rof + i, initialPoint + 180, baseLineRoof1Rof + i);
        }
    }

    public void secondBuilding() {
        // Shape
        g.setColor(new Color(140, 158, 162));
        g.fillRect(initialPoint + 201, 400, 200, 400);

        // Window
        g.setColor(new Color(191, 201, 205));
        g.fillRect(initialPoint + 221, 450, 160, 30);
        border.setColor(new Color(0,0,0));
        border.drawRect(initialPoint + 221, 450, 160, 30);
        int separation = 160/4;
        g.setColor(new Color(0,0,0));
        g.drawLine((initialPoint + 221) + (separation * 1), 450, (initialPoint + 221) + (separation * 1), 480);
        g.drawLine((initialPoint + 221) + (separation * 2), 450, (initialPoint + 221) + (separation * 2), 480);
        g.drawLine((initialPoint + 221) + (separation * 3), 450, (initialPoint + 221) + (separation * 3), 480);

        // panel
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint + 201, 500, 200, 30);
        g.setColor(new Color(0,0,0));
        int baseLinePanel = 500;
        for(int i=0; i<35; i+=5) {
            g.drawLine(initialPoint + 201, baseLinePanel + i, initialPoint + 410, baseLinePanel + i);
        }

        // Window
        g.setColor(new Color(191, 201, 205));
        g.fillRect(initialPoint + 221, 550, 160, 30);
        border.setColor(new Color(0,0,0));
        border.drawRect(initialPoint + 221, 550, 160, 30);
        int separation3 = 160/4;
        g.setColor(new Color(0,0,0));
        g.drawLine((initialPoint + 221) + (separation3 * 1), 550, (initialPoint + 221) + (separation3 * 1), 580);
        g.drawLine((initialPoint + 221) + (separation3 * 2), 550, (initialPoint + 221) + (separation3 * 2), 580);
        g.drawLine((initialPoint + 221) + (separation3 * 3), 550, (initialPoint + 221) + (separation3 * 3), 580);

        // Panel
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint + 201, 600, 200, 30);
        g.setColor(new Color(0,0,0));
        int baseLinePanel2 = 600;
        for(int i=0; i<35; i+=5) {
            g.drawLine(initialPoint + 201, baseLinePanel2 + i, initialPoint + 410, baseLinePanel2 + i);
        }

        // Roof
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint + 191, 400, 220, 30);
        g.setColor(new Color(0,0,0));
        int baseLineRoof1 = 400;
        for(int i=0; i<35; i+=5) {
            g.drawLine(initialPoint + 191, baseLineRoof1 + i, initialPoint + 410, baseLineRoof1 + i);
        }

        // Door
        g.setColor(new Color(191, 201, 205));
        g.fillRect(initialPoint + 221, 650, 160, 150);
        border.setColor(new Color(0,0,0));
        border.drawRect(initialPoint + 221, 650, 160, 150);
        int separation4 = 160/2;
        g.setColor(new Color(0,0,0));
        g.drawLine((initialPoint + 221) + (separation4 * 1), 650, (initialPoint + 221) + (separation4 * 1), 800);
    }

    private void thirdBuilding() {
        // Shape
        g.setColor(new Color(140, 158, 162));
        g.fillRect(initialPoint + 402, 200, 200, 600);

        // Windows
        g.setColor(new Color(191, 201, 205));
        int count = 700;
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

        // Roof
        g.setColor(new Color(125, 156, 176));
        g.fillRect(initialPoint + 392, 180, 220, 20);
        g.setColor(new Color(0,0,0));
        int baseLineRoof1 = 180;
        for(int i=0; i<25; i+=5) {
            g.drawLine(initialPoint + 392, baseLineRoof1 + i, initialPoint + 612, baseLineRoof1 + i);
        }


    }
}
