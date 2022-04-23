package barajita;

import javax.swing.*;
import java.awt.*;

public class Table extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    static String currentPath = "";
    int turnos;
    static int puntos;

    public static void main(String[] args) {

        try {
            currentPath = new java.io.File(".").getCanonicalPath() + "/src/barajita/";
        } catch (Exception e) {
            System.out.println("Error in constructor");
            e.printStackTrace();
        }

        ventana();
    }

    public static void ventana() {
        JFrame ventana = new JFrame("Juego");
        Table obj = new Table();
        ventana.add(obj);
        ventana.setSize(900, 900);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        cartas(g, turnos);
        run();
    }

    public static void cartas (Graphics g, int turnos) {
        int x = 30;
        int y = 170;
        ImageIcon fondo = new ImageIcon(currentPath + "images/fondo.jpg");
        ImageIcon cartaReverso = new ImageIcon(currentPath + "images/back2.png");
        ImageIcon cartaReverso2 = new ImageIcon(currentPath + "images/back.png");

        g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
        g.setColor (Color.black);

        g.drawString("Jugador 1", 370, 20);
        g.drawString("Score: " + puntos, 500, 20);

        g.drawString("Jugador 2", 720, 140);
        g.drawString("Score: " + puntos, 800, 140);

        g.drawString("Jugador 3", 370, 510);
        g.drawString("Score: " + puntos, 500, 510);

        g.drawString("Jugador 4", 40, 140);
        g.drawString("Score: " + puntos, 115, 140);

        for (int i=0; i < 300; i = i + 30) {
            g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
        }

        x = 720;
        y = 170;

        for (int i=0; i < 300; i = i + 30) {
            g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
        }

        x = 270;
        y = 40;

        for (int i=0; i < 300; i = i + 30) {
            g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
        }

        x = 270;
        y = 520;

        for (int i=0; i < 300; i = i + 30) {
            g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
        }

        if (turnos == 1) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 270; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 270; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 270; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 270; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "E" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "E" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "E" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "E" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 2) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 240; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 240; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 240; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 240; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "O" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "O" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "O" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "O" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 3) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 210; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 210; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 210; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 210; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "E" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "E" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "E" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "E" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 4) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 180; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 180; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 180; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 180; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "O" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "O" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "O" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "O" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 5) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 150; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 150; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 150; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 150; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "E" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "E" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "E" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "E" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 6) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 120; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 120; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 120; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 120; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "O" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "O" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "O" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "O" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 7) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 90; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 90; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 90; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 90; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "E" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "E" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "E" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "E" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 8) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 60; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 60; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 60; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 60; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "O" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "O" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "O" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "O" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 9) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);
            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            x = 30;
            y = 170;

            for (int i=0; i < 30; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 720;
            y = 170;
            for (int i=0; i < 30; i = i + 30) {
                g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
            }
            x = 270;
            y = 40;

            for (int i=0; i < 30; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }

            x = 270;
            y = 520;

            for (int i=0; i < 30; i = i + 30) {
                g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
            }
            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "E" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "E" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "E" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "E" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }

        if (turnos == 10) {
            g.drawImage(fondo.getImage(), 0, 0, 900, 900, null);

            g.drawString("Jugador 1", 370, 20);
            g.drawString("Score: " + puntos, 500, 20);

            g.drawString("Jugador 2", 720, 140);
            g.drawString("Score: " + puntos, 800, 140);

            g.drawString("Jugador 3", 370, 510);
            g.drawString("Score: " + puntos, 500, 510);

            g.drawString("Jugador 4", 40, 140);
            g.drawString("Score: " + puntos, 115, 140);

            //Jugador 1
            ImageIcon carta = new ImageIcon(currentPath + "images/" + "O" + "2" + ".jpg");
            g.drawImage(carta.getImage(), 410, 190, 90, 138, null);
            //Jugador 2
            ImageIcon carta4 = new ImageIcon(currentPath + "images/" + "O" + "3" + ".jpg");
            g.drawImage(carta4.getImage(), 540, 270, 90, 138, null);
            //Jugador 3
            ImageIcon carta2 = new ImageIcon(currentPath + "images/" + "O" + "4" + ".jpg");
            g.drawImage(carta2.getImage(), 410, 340, 90, 138, null);
            //Jugador 4
            ImageIcon carta3 = new ImageIcon(currentPath + "images/" + "O" + "5" + ".jpg");
            g.drawImage(carta3.getImage(), 280, 270, 90, 138, null);
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            turnos++;
            Thread.sleep(1500);
            repaint();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
