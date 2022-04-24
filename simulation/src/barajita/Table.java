package barajita;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Table extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    static String currentPath = "";
    int turnos;
    static Game game;
    static JFrame ventana;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("digite el numero de simulaciones");
        int numOfSimulations = sc.nextInt();

        int player1Win = 0;
        int player2Win = 0;
        int player3Win = 0;
        int player4Win = 0;

        for(int i=1; i<=numOfSimulations; i++) {
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
            try {
                Thread.sleep(14000);
                ventana.setVisible(false);
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }

            Player winner = game.getWinner();
            switch (winner.getName()) {
                case "Jugador 1":
                    player1Win++;
                    break;
                case "Jugador 2":
                    player2Win++;
                    break;
                case "Jugador 3":
                    player3Win++;
                    break;
                case "Jugador 4":
                    player4Win++;
                    break;
            }
        }

        int position = 0;
        int bigger = 0;
        Player winner = null;
        int[] scores = {player1Win, player2Win, player3Win, player4Win};
        for(int i=0; i<4; i++) {
            if (bigger < scores[i]) {
                bigger = scores[i];
                position = i;
            }
        }

        switch (position) {
            case 0:
                winner = game.player1;
                break;
            case 1:
                winner = game.player2;
                break;
            case 2:
                winner = game.player3;
                break;
            case 3:
                winner = game.player4;
                break;
        }

        JOptionPane.showMessageDialog(null, "Ganador: " + winner.getName());

        System.exit(0);

    }

    public static void ventana() {
        ventana = new JFrame("Juego");
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
        //printTable(g, 0);

        Player player1 = game.player1;
        Player player2 = game.player2;
        Player player3 = game.player3;
        Player player4 = game.player4;

        if (turnos >= 10) {
            printTable(g, 0);
            if (turnos == 10) {
                Player winner = game.getWinner();
                JOptionPane.showMessageDialog(ventana, "Ganador: " + winner.getName());
            }
        } else {
            ArrayList<Card> cardsToPlay = new ArrayList<Card>();
            cardsToPlay.add(player1.getCards().get(turnos));
            cardsToPlay.add(player2.getCards().get(turnos));
            cardsToPlay.add(player3.getCards().get(turnos));
            cardsToPlay.add(player4.getCards().get(turnos));


            game.recordWhoWins(cardsToPlay);
            printTable(g, turnos + 1);
            printCenterCards(g, cardsToPlay);
        }
/*
        printTable(g, turnos);

        if (turnos >= 10) {
            printTable(g, 0);

            if (turnos == 10) {
                Player winner = game.getWinner();
                JOptionPane.showMessageDialog(ventana, "Ganador: " + winner.getName());
            }

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
        game.recordWhoWins(cardsToPlay);

 */

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            turnos++;
            Thread.sleep(1000);
            if (turnos == 11) {
                return;
            }
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
        g.drawString("Score: " + game.player1.getVictories(), 500, 20);

        g.drawString("Jugador 2", 720, 140);
        g.drawString("Score: " + game.player2.getVictories(), 800, 140);

        g.drawString("Jugador 3", 370, 510);
        g.drawString("Score: " + game.player3.getVictories(), 500, 510);

        g.drawString("Jugador 4", 40, 140);
        g.drawString("Score: " + game.player4.getVictories(), 115, 140);

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