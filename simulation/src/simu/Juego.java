package simu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class Juego extends JFrame implements ActionListener {

    
    private JTextField cantidadSimulaciones;
    private JLabel[] labels;
    private JButton[] btns;
    private Timer timer;
    private List<String> cards;
    private int [] puntosJugadoresMano;
    private int [] puntosJugadoresJuegos;
    private int contador = 0, simulaciones, contadorSimulaciones = 0;

    private static final int CANTIDAD_JUGADORES = 4;
    
    public Juego() {
        timer = new Timer(500, this);
        cards = new Cards().getCards();
        puntosJugadoresMano = new int[CANTIDAD_JUGADORES];
        puntosJugadoresJuegos = new int[CANTIDAD_JUGADORES];
        btns = new JButton[CANTIDAD_JUGADORES];
        hazInterfaz();
        hazEscuchas();
    }

    private void hazInterfaz() {
        setSize(1000, 700);
        setLocationRelativeTo( null );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        labels = new JLabel[CANTIDAD_JUGADORES];

        //Pedir datos
        JPanel panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDatos.setBackground(Color.LIGHT_GRAY);
        
        cantidadSimulaciones = new JTextField();//Cuadro blanco de texto
        cantidadSimulaciones.setPreferredSize(new Dimension(100, 30));//witdh, height
        panelDatos.add(new JLabel("Cantidad Simulaciones"));
        panelDatos.add( cantidadSimulaciones );
        
        //Panel jugadores
        JPanel panelJugadores = new JPanel();
        panelJugadores.setBackground(Color.white);
        panelJugadores.setLayout(new GridLayout(0, 1));
        panelJugadores.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel("Jugador " + (i + 1) + ": 0    ", JLabel.LEFT);
            panelJugadores.add( labels[i] );
        }

        JPanel panelCartas = new JPanel();
        panelCartas.setLayout(new BorderLayout());

        JPanel cartasJugadores = new JPanel();
        cartasJugadores.setBackground(Color.black);
        cartasJugadores.setLayout(new GridLayout(1, 4));
//        JButton btn;
        JLabel players;
        for (int i = 0; i < 4; i++) {
//            btn = new JButton();
        	players = new JLabel("Jugador "+ (i+1));
        	players.setForeground(Color.white);
//            btn.setIcon(new ImageIcon("images/back.png"));
            cartasJugadores.add(players);
        }

        panelCartas.add( cartasJugadores, BorderLayout.NORTH );

        JPanel cartasManos = new JPanel();
        cartasManos.setLayout(new GridLayout(1, 4, 15, 5));
        for (int i = 0; i < 4; i++) {
            btns[i] = new JButton();
            btns[i].setBackground(Color.white);
            cartasManos.add( btns[i] );
        }

        panelCartas.add( cartasManos );

        add( panelCartas );
        add( panelDatos, BorderLayout.NORTH );
        add( panelJugadores, BorderLayout.EAST);
        setVisible( true );

    }

    private Card verificarCarta() {
        int numCarta;
        char tipoCarta;
        do {

            numCarta = Montecarlo.generarNumeroCarta();
            tipoCarta = Montecarlo.generarTipo();


        } while( !cards.contains( numCarta + "" + tipoCarta ) );

        return new Card( numCarta, tipoCarta );
    }

    private void verificarGanadorMano(Card[] cartas) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        posiciones.add( 0 );
        int numeroMayor = cartas[0].getNumero();

        for (int i = 1; i < cartas.length; i++) {
            if (cartas[i].getNumero() > numeroMayor) {
                numeroMayor = cartas[i].getNumero();
                posiciones.set( 0, i);
            }
        }

        for (int i = 0; i < cartas.length; i++) {
            if ( i == posiciones.get(0) ) {
                continue;
            }

            if ( cartas[i].getNumero() == numeroMayor ) {
                posiciones.add( i );
            }
        }

        if ( posiciones.size() == 1 ) {
            puntosJugadoresMano[posiciones.get(0)]++;
        }


        Card cartaMayor = cartas[posiciones.get(0)];
        int posicion = posiciones.get(0);
        for (int i = 1; i < posiciones.size(); i++) {

            if (cartas[posiciones.get(i)].getNivel() > cartaMayor.getNivel() ) {
                cartaMayor = cartas[posiciones.get(i)];
                posicion = posiciones.get(i);
            }

        }

        puntosJugadoresMano[posicion]++;
    }

    private void verificarGanadorJuego() {

        int numeroMayor = Arrays.stream( puntosJugadoresMano ).max().getAsInt();
        for (int i = 0; i < puntosJugadoresMano.length; i++) {

            if (puntosJugadoresMano[i] == numeroMayor ) {
                puntosJugadoresJuegos[i]++;
            }
        }

    }


    private void hazEscuchas() {
        cantidadSimulaciones.addActionListener( this );
    }

    private void hazGrafico() {
    	JFrame grafico = new JFrame();
    	grafico.setSize(800, 600);
        grafico.setLocationRelativeTo( null );
        grafico.setDefaultCloseOperation( EXIT_ON_CLOSE );
        grafico.setVisible(true);
        
        DefaultPieDataset Datos = new DefaultPieDataset();
		Datos.setValue("Jugador 1", puntosJugadoresJuegos[0]);
		Datos.setValue("Jugador 2", puntosJugadoresJuegos[1]);
		Datos.setValue("Jugador 3", puntosJugadoresJuegos[2]);
		Datos.setValue("Jugador 4", puntosJugadoresJuegos[3]);
		JFreeChart grafico_circular = ChartFactory.createPieChart("Grafico de juegos: ", // Nombre del grafico
				Datos, // datos
				true, // nombre de las categorias
				true, // herramientas
				false // generacion de URL
		);
		ChartPanel panel = new ChartPanel(grafico_circular);
		panel.setMouseWheelEnabled(true);
		panel.setPreferredSize(new Dimension(400, 200));
		grafico.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == cantidadSimulaciones ) {
            cantidadSimulaciones.setEnabled( false );
            timer.start();
            simulaciones = Integer.parseInt( cantidadSimulaciones.getText() );
            return;
        }

        Card [] cartas = new Card[4];
        for (int i = 0; i < 4; i++) {
            Card carta = verificarCarta();
            cards = cards.stream().filter( card -> !card.equals( carta.getCarta() ) ).toList();
            btns[i].setIcon(new ImageIcon("images/" + carta.getCarta() + ".png"));
            cartas[i] = carta;
        }

        verificarGanadorMano( cartas );

        contador++;
        if (contador == 10) {
            verificarGanadorJuego();
            contadorSimulaciones++;
            for (int i = 0; i < labels.length; i++) {
                if (puntosJugadoresJuegos[i] != 0 ) {
                    labels[i].setText("Jugador " + (i + 1) + " = " + puntosJugadoresJuegos[i] + "      ");
                }
            }
            contador = 0;
            cards = new Cards().getCards();
        }

        if ( contadorSimulaciones == simulaciones ) {
            timer.stop();
            hazGrafico();
        }

    }

    public static void main(String[] args) {
        new Juego();
    }
}
