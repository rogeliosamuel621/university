package Cartas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.io.File;

public class Panel extends JPanel implements Runnable
{
    public int cycle;
    private int turns = -2;
    private Departure game = new Departure();

    public Panel(int cycle) {
        this.cycle = cycle;
        setBackground(Color.DARK_GRAY);
        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        if(cycle > 0)
            playing(g2d);
        else{
            Player player_1 = game.turns();
            Player player_2 = game.turns();
            Player player_3 = game.turns();
            Player player_4 = game.turns();

            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue(player_1.gamertag, game.scoreboard.get(0));
            data.setValue(player_2.gamertag, game.scoreboard.get(1));
            data.setValue(player_3.gamertag, game.scoreboard.get(2));
            data.setValue(player_4.gamertag, game.scoreboard.get(3));

            JFreeChart graphics = ChartFactory.createPieChart(
                    "Graphic - Wins",
                    data,
                    true,
                    true,
                    false
            );

            ChartPanel panel = new ChartPanel(graphics);
            panel.setPreferredSize(new Dimension(1000, 800));

            this.setLayout(new BorderLayout());
            this.add(panel);
            this.revalidate();
        }
    }

    public void playing(Graphics2D g2d){
        int count = 0, pixel = 0;
        Image image_1, image_2, image_3, image_4;
        Player player_1 = game.turns();
        Player player_2 = game.turns();
        Player player_3 = game.turns();
        Player player_4 = game.turns();

        while(count != 10){
            Cards card_1 = player_1.getHand().get(count);
            Cards card_2 = player_2.getHand().get(count);
            Cards card_3 = player_3.getHand().get(count);
            Cards card_4 = player_4.getHand().get(count);
            image_1 = new ImageIcon(search_directory("Dark.png")).getImage();
            image_2 = new ImageIcon(search_directory("Dark.png")).getImage();
            image_3 = new ImageIcon(search_directory("Dark.png")).getImage();
            image_4 = new ImageIcon(search_directory("Dark.png")).getImage();

            if(count == turns){
                image_1 = new ImageIcon(search_directory(card_1.type.toString().toLowerCase(), card_1.number + ".jpg")).getImage();
                image_2 = new ImageIcon(search_directory(card_2.type.toString().toLowerCase(), card_2.number + ".jpg")).getImage();
                image_3 = new ImageIcon(search_directory(card_3.type.toString().toLowerCase(), card_3.number + ".jpg")).getImage();
                image_4 = new ImageIcon(search_directory(card_4.type.toString().toLowerCase(), card_4.number + ".jpg")).getImage();

                g2d.drawImage(image_1, 465, 420, 86, 120, null);
                g2d.rotate(Math.toRadians(90));
                g2d.drawImage(image_4, 395, -400, 86, 120, null);
                g2d.rotate(Math.toRadians(90));
                g2d.drawImage(image_3, -460, -350, 86, 120, null);
                g2d.rotate(Math.toRadians(90));
                g2d.drawImage(image_2, -365, 530, 86, 120, null);
                g2d.rotate(Math.toRadians(90));

                Player final_1 = player_1.major_card(player_3, count);
                Player final_2 = player_2.major_card(player_4, count);

                final_1.major_card(final_2, count).score++;
                count++;
                pixel = 30 * count;
                continue;
            }
            else if(count < turns){
                image_1 = new ImageIcon(search_directory(card_1.type.toString().toLowerCase(), card_1.number + ".jpg")).getImage();
                image_2 = new ImageIcon(search_directory(card_2.type.toString().toLowerCase(), card_2.number + ".jpg")).getImage();
                image_3 = new ImageIcon(search_directory(card_3.type.toString().toLowerCase(), card_3.number + ".jpg")).getImage();
                image_4 = new ImageIcon(search_directory(card_4.type.toString().toLowerCase(), card_4.number + ".jpg")).getImage();
            }

            g2d.setColor(Color.ORANGE);
            g2d.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 25));
            g2d.drawImage(image_1, 285 + pixel, 620, 86, 120, null);
            g2d.drawString(player_1.gamertag, 720, 650);
            g2d.drawString("Score: " + player_1.score, 760, 700);
            g2d.rotate(Math.toRadians(90));
            g2d.drawImage(image_4, 190 + pixel, -140, 86, 120, null);
            g2d.drawString(player_4.gamertag, 580, -120);
            g2d.drawString("Score: " + player_4.score, 600, -70);
            g2d.rotate(Math.toRadians(90));
            g2d.drawImage(image_3, -655 + pixel, -140, 86, 120, null);
            g2d.drawString(player_3.gamertag, -225, -120);
            g2d.drawString("Score: " + player_3.score, -205, -50);
            g2d.rotate(Math.toRadians(90));
            g2d.drawImage(image_2, -580 + pixel, 844, 86, 120, null);
            g2d.drawString(player_2.gamertag, -185, 844);
            g2d.drawString("Score: " + player_2.score, -175, 925);
            g2d.rotate(Math.toRadians(90));

            count++;
            pixel = 30 * count;
        }

        if(turns == 10){
            game.winner();
        }
    }

    @Override
    public void run() {
        while(cycle > -1){
            try {
                if(turns == 10){
                    turns = -2;
                    Departure temp_game = game;
                    game = new Departure();
                    game.scoreboard = temp_game.scoreboard;
                    cycle--;
                }
                turns++;
                Thread.sleep(1000);
                repaint();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public String search_directory(String file, String name){
        return new File("Cartas/"+file+"/"+name)
                .getAbsoluteFile()
                .toString();
    }

    public String search_directory(String name){
        return new File("Cartas/"+name)
                .getAbsoluteFile()
                .toString();
    }
}
