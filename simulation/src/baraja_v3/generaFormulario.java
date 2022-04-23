package baraja_v3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class generaFormulario extends JFrame implements ActionListener {

    JTextField txtNumeroJuegos;
    JButton btnComienzaJuego;
    Tablero baraja;
    String currentPath = "";

    public static void main(String[] args) {
        new generaFormulario();
    }

    // genera el diseño del formulario
    public generaFormulario() {
        try {
            this.currentPath = new java.io.File(".").getCanonicalPath() + "/src/baraja_v3/";
        } catch (Exception e) {
            System.out.println("Error in constructor");
            e.printStackTrace();
        }
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        setTitle("Juego de cartas");
        setSize(900, 1000);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel pregunta = new JLabel("Número de juegos:");
        pregunta.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(pregunta);

        txtNumeroJuegos = new JTextField(10);
        panel.add(txtNumeroJuegos);

        btnComienzaJuego = new JButton("Comenzar juego");
        btnComienzaJuego.setFont(new Font("Arial", Font.PLAIN, 15));
        btnComienzaJuego.addActionListener(this);
        panel.add(btnComienzaJuego);
        add(panel, BorderLayout.NORTH);

        baraja = new Tablero();
        baraja.setBackground(Color.white);
        add(baraja);

        setVisible(true);
    }

    // código del botón btnComienzaJuego
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnComienzaJuego) {
            baraja.crearBaraja(Integer.parseInt(txtNumeroJuegos.getText()));
            baraja.repaint();
            baraja.generaGrafica();
        }
    }
}
