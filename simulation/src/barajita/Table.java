package barajita;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Table extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    static String currentPath = "";
    int turnos;
    static int puntos;
    static Game game;

    public static void main(String[] args){
        game = new Game();
        game.generateCards();
        game.distributeCards();
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
        play(g, turnos);
        run();
    }

    public static void play (Graphics g, int turnos) {
        printTable(g, 0);

        Player player1 = game.player1;
        Player player2 = game.player2;
        Player player3 = game.player3;
        Player player4 = game.player4;

        printTable(g, turnos);

        if (turnos >= 10) {
            printTable(g, 0);
            return;
        } else {
            printTable(g, turnos + 1);
        }

        ArrayList<Card> cardsToPlay = new ArrayList<Card>();
        cardsToPlay.add(player1.getCards().get(turnos));
        cardsToPlay.add(player2.getCards().get(turnos));
        cardsToPlay.add(player3.getCards().get(turnos));
        cardsToPlay.add(player4.getCards().get(turnos));

        printCenterCards(g, cardsToPlay);
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

    static private void printTable(Graphics g, int numOfCards) {
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

        for (int i=0; i < (300 - (30 * numOfCards)); i = i + 30) {
            g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
        }

        x = 720;
        y = 170;

        for (int i=0; i < (300 - (30 * numOfCards)); i = i + 30) {
            g.drawImage(cartaReverso.getImage(), x, (y + i), 138, 90, null);
        }

        x = 270;
        y = 40;

        for (int i=0; i < (300 - (30 * numOfCards)); i = i + 30) {
            g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
        }

        x = 270;
        y = 520;

        for (int i=0; i < (300 - (30 * numOfCards)); i = i + 30) {
            g.drawImage(cartaReverso2.getImage(), (x + i), y, 90, 138, null);
        }
    }

    static private void printCenterCards(Graphics g, ArrayList<Card> cardsToPlay) {
        Coordinates[] coordinates = {
                new Coordinates(410, 190, 90, 138),
                new Coordinates(540, 270, 90, 138),
                new Coordinates(410, 340, 90, 138),
                new Coordinates(280, 270, 90, 138)
        };

        for(int i=0; i<cardsToPlay.size(); i++) {
            ImageIcon carta = new ImageIcon(currentPath + "images/" + cardsToPlay.get(i).getName() + ".jpg");
            g.drawImage(carta.getImage(), coordinates[i].x, coordinates[i].y, coordinates[i].w, coordinates[i].h, null);
        }
    }
}

class Coordinates {
    int x;
    int y;
    int w;
    int h;

    public Coordinates(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}