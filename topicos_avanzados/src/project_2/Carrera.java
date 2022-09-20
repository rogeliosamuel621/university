package project_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carrera extends JFrame{
    JPanel[] paneles;
    JLabel [] labels;
    String[] nombres = {"conejo", "tortuga", "perro", "gatoguapo"};
    JButton boton;
    int ancho = 700;

    public Carrera () {
        setLayout(new GridLayout(0,1));
        paneles = new JPanel[4];
        labels = new JLabel[4];

        // Codigo que agrega la imagen de meta
        /*
        JPanel metaComponent = new JPanel();
        add(metaComponent);
        JLabel metaIcon = new JLabel();
        ImageIcon metaImg = new ImageIcon(getClass().getResource("meta.jpeg"));
        metaIcon.setIcon(metaImg);
        metaComponent.add(metaIcon);
        metaIcon.setLocation(700, 0);
         */

        for (int i = 0; i < labels.length; i++) {
            paneles[i] = new JPanel();
            add(paneles[i]);
            labels[i] = new JLabel(nombres [i]);
            ImageIcon img = new ImageIcon(getClass().getResource(nombres[i] + ".png"));
            labels[i].setIcon(img);
            paneles[i].add(labels[i]);
            labels[i].setLocation(0,0);
        }
        boton = new JButton("Comenzar Carrera");
        Animal conejo = new Animal("Conejo", ancho -250, labels[0]);
        Animal tortuga = new Animal("Tortuga", ancho -250, labels[1]);
        Animal zorro = new Animal("Perro", ancho -250, labels[2]);
        Animal gatoguapo = new Animal("Gatoguapo", ancho -250, labels[3]);

        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                conejo.start();
                tortuga.start();
                zorro.start();
                gatoguapo.start();
                boton.setText("Corriendo...");
            }
        });

        BackGround bg = new BackGround();
        add(bg);
        add(boton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200,250);
        setSize(ancho,700);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Carrera();
    }

    private void crearAnimal(int i) {
        this.paneles[i] = new JPanel();
        add(this.paneles[i]);
        this.labels[i] = new JLabel(this.nombres[i]);
        ImageIcon img = new ImageIcon(getClass().getResource(this.nombres[i] + ".png"));
        this.labels[i].setIcon(img);
        this.paneles[i].add(this.labels[i]);
        this.labels[i].setLocation(0,0);
    }
}
