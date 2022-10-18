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

        for (int i = 0; i < labels.length; i++) {
            this.crearAnimal(i);
        }

        // Creamos los animales
        boton = new JButton("Comenzar Carrera");
        Animal conejo = new Animal("Conejo", ancho -250, labels[0]);
        Animal tortuga = new Animal("Tortuga", ancho -250, labels[1]);
        Animal zorro = new Animal("Perro", ancho -250, labels[2]);
        Animal gatoguapo = new Animal("Gatoguapo", ancho -250, labels[3]);

        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Inicializamos los hilos
                conejo.start();
                tortuga.start();
                zorro.start();
                gatoguapo.start();
                boton.setText("Corriendo...");
            }
        });

        /**
         * Añade elementos a la vista como el botón y marca las posiciones de las ventanas y sus dimenciones
         */
        add(boton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200,250);
        setSize(ancho,700);
        setVisible(true);
    }

    /**
     * Método que asigna la imagen para el animal y el nombre
     * @param i
     */
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
