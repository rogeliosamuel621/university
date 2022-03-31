package dardos_experimento;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Scanner;

public class Dardos extends JPanel{
    public static int dardos;
    public static void main(String[] args) {
        numDardos();
        ventana();
    }
    public static void numDardos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el numero de dardos que desea lanzar");
        dardos = sc.nextInt();
    }
    public static void ventana() {
        JFrame ventana = new JFrame("Dardos");
        Dardos obj  = new Dardos();
        ventana.add(obj);
        ventana.setSize(700,700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        //Fondo
        g.setColor(Color.black);
        g.fillRect(0,0,700,700);
        //Circulo rojo 1
        g.setColor(Color.red);
        g.fillOval(100,100,500,500);
        //Circulo Blanco 1
        g.setColor(Color.white);
        g.fillOval(150,150,400,400);
        //Circulo Rojo 2
        g.setColor(Color.red);
        g.fillOval(200,200,300,300);
        //Circulo Blanco 2
        g.setColor(Color.white);
        g.fillOval(250,250,200,200);
        //Circulo Rojo 3
        g.setColor(Color.red);
        g.fillOval(300,300,100,100);
        asiertos(g);
        g.drawString("Pi= " + (double)4*asiertos(g)/dardos , 200,50);
        g.drawString("Asiertos= " + asiertos(g),400,50);
    }

    public long asiertos(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        BasicStroke n = new BasicStroke(2);
        g2d.setStroke(n);
        g.setColor(Color.green);
        int asiertos = 0;
        for(int i=0; i<dardos;i++) {
            int x = (int)(100+Math.random()*500),y= (int)(100+Math.random()*500);
            g2d.drawLine(x,y,x,y);
            if(circuloUnitario(x,y)) {
                asiertos++;
            }

        }
        return asiertos;

    }

    public boolean circuloUnitario(int x, int y) {
        return ((x*x) - 350*2*x + 350*350 + (y*y) - 350*2*y + 350*350) <= 62500;
    }
}