package baraja_v3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Tablero extends JPanel {

    int posicion = 0;
    Thread hilo;
    private int numero;
    private String tipoCarta;
    private String cartaFinal;
    private int contadornumeros[] = new int[10];
    private int nCartas = 40;
    private int[] victorias = new int[4];
    JLabel[] arregloImagenes = new JLabel[nCartas];
    JLabel lblJugador1, lblJugador2, lblJugador3, lblJugador4;
    JLabel imagen;
    double valor;
    int pganadasj1 = 0;
    int pganadasj2 = 0;
    int pganadasj3 = 0;
    int pganadasj4 = 0;
    int pj1 = 0;
    int pj2 = 0;
    int pj3 = 0;
    int pj4 = 0;
    int empate = 0;
    String currentPath = "";

    public String[] nombreCarta = {"O", "C", "E", "B"}; // oro, copas, espadas y bastos
    ArrayList<String> cartas = new ArrayList<String>();
    Random aleatorio = new Random();

    public Tablero() {
        try {
            this.currentPath = new java.io.File(".").getCanonicalPath() + "/src/baraja_v2/";
        } catch (Exception e) {
            System.out.println("Error in constructor");
            e.printStackTrace();
        }
        generaDiseño();
    }

    public void generaDiseño() {
        setLayout(null);
        // Se coloca la imagen de fondo
        imagen = new JLabel(new ImageIcon(this.currentPath + "imagenes/Mj.jpg"));
        imagen.setBounds(0, 0, 900, 999);

        // añadir los componentes que tendra la mesa
        lblJugador1 = new JLabel("Jugador 1");
        lblJugador1.setForeground(Color.BLACK);
        lblJugador1.setBounds(400, 70, 70, 20);
        imagen.add(lblJugador1);

        lblJugador2 = new JLabel("Jugador 2");
        lblJugador2.setBounds(400, 270, 70, 20);
        lblJugador2.setForeground(Color.BLACK);
        imagen.add(lblJugador2);

        lblJugador3 = new JLabel("Jugador 3");
        lblJugador3.setBounds(400, 480, 70, 20);
        lblJugador3.setForeground(Color.BLACK);
        imagen.add(lblJugador3);

        lblJugador4 = new JLabel("Jugador 4");
        lblJugador4.setForeground(Color.BLACK);
        lblJugador4.setBounds(400, 670, 70, 20);
        imagen.add(lblJugador4);

        reversoCartas();
    }

    // genera la gráfica de pastel en base a los resultados usando JFreeChart
    public void generaGrafica() {
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Jugador 1", pganadasj1);
        data.setValue("Jugador 2", pganadasj2);
        data.setValue("Jugador 3", pganadasj3);
        data.setValue("Jugador 4", pganadasj4);
        data.setValue("Empate", empate);

        JFreeChart chart = ChartFactory.createPieChart("", data, true, true, false);
        ChartFrame frame = new ChartFrame("Resultados", chart);
        frame.pack();
        frame.setVisible(true);
    }

    // método el cual genera todas las cartas y las juega
    public void crearBaraja(int numJugadas) {
        while (numJugadas > 0) { // repite el ciclo hasta que las jugadas se acaban
            for (int i = 0; i < nCartas; i++) { // repite el ciclo 40 veces
                generaCarta(); // método para generar cartas
                cartaFinal = String.valueOf(generaTipoCarta(valor) + crearCarta(valor)); // une el tipo de carta con su valor
                while (cartas.contains(cartaFinal)) {
                    generaCarta(); // método para generar cartas
                    cartaFinal = String.valueOf(generaTipoCarta(valor) + crearCarta(valor));
                }
                cartas.add(cartaFinal); // agrega las cartas al arreglo
            }

            juegaCartas(); // reparte cartas, las muestra y las quita
            reversoCartas();

            while (!cartas.isEmpty()) {
                cartas.remove(0);
            }
            numJugadas--; // decrementa el número de jugadas
        }
    }

    // método que muestra las cartas en pantalla
    public void juegaCartas() {
        for (int i = 0; i < nCartas; i += 4) {
            // obtiene el tipo de carta generado
            String carta1 = cartas.get(i).substring(0, 1);
            String carta2 = cartas.get(i + 1).substring(0, 1);
            String carta3 = cartas.get(i + 2).substring(0, 1);
            String carta4 = cartas.get(i + 3).substring(0, 1);

            // obtiene el valor de la carta generada
            int valor1 = Integer.parseInt(cartas.get(i).substring(1));
            int valor2 = Integer.parseInt(cartas.get(i + 1).substring(1));
            int valor3 = Integer.parseInt(cartas.get(i + 2).substring(1));
            int valor4 = Integer.parseInt(cartas.get(i + 3).substring(1));

            // imprime las imágenes de las cartas
            imprimeCarta(i);
            imprimeCarta(i + 1);
            imprimeCarta(i + 2);
            imprimeCarta(i + 3);

            // imprime el tipo de carta en pantalla
            System.out.println("Carta 1: " + carta1);
            System.out.println("Carta 2: " + carta2);
            System.out.println("Carta 3: " + carta3);
            System.out.println("Carta 4: " + carta4);

            // imprime el valor de la carta en pantalla
            System.out.println("Valor1: " + valor1);
            System.out.println("Valor2: " + valor2);
            System.out.println("Valor3: " + valor3);
            System.out.println("Valor4: " + valor4);
            System.out.println("");

            // realiza la sumatoria de los puntos
            // Palo y valor 1
            if (carta1.equals(nombreCarta[3])) {
                pj1 += (valor1 + 15);
            }
            if (carta1.equals(nombreCarta[2])) {
                pj1 += (valor1 + 30);
            }
            if (carta1.equals(nombreCarta[1])) {
                pj1 += (valor1 + 45);
            }
            if (carta1.equals(nombreCarta[0])) {
                pj1 += (valor1 + 60);
            }

            // Palo y valor 2
            if (carta2.equals(nombreCarta[3])) {
                pj2 += (valor2 + 15);
            }
            if (carta2.equals(nombreCarta[2])) {
                pj2 += (valor2 + 30);
            }
            if (carta2.equals(nombreCarta[1])) {
                pj2 += (valor2 + 45);
            }
            if (carta2.equals(nombreCarta[0])) {
                pj2 += (valor2 + 60);
            }

            // Palo y valor 3
            if (carta3.equals(nombreCarta[3])) {
                pj3 += (valor3 + 15);
            }
            if (carta3.equals(nombreCarta[2])) {
                pj3 += (valor3 + 30);
            }
            if (carta3.equals(nombreCarta[1])) {
                pj3 += (valor3 + 45);
            }
            if (carta3.equals(nombreCarta[0])) {
                pj3 += (valor3 + 60);
            }

            // Palo y valor 4
            if (carta4.equals(nombreCarta[3])) {
                pj4 += (valor4 + 15);
            }
            if (carta4.equals(nombreCarta[2])) {
                pj4 += (valor4 + 30);
            }
            if (carta4.equals(nombreCarta[1])) {
                pj4 += (valor4 + 45);
            }
            if (carta4.equals(nombreCarta[0])) {
                pj4 += (valor4 + 60);
            }

            // asigna la victoria de la ronda
            if (pj1 > pj2 && pj1 > pj3 && pj1 > pj4) {
                victorias[0]++;

            } else {
                if (pj2 > pj1 && pj2 > pj3 && pj2 > pj4) {
                    victorias[1]++;
                } else {
                    if (pj3 > pj1 && pj3 > pj2 && pj3 > pj4) {
                        victorias[2]++;
                    } else {
                        if (pj4 > pj1 && pj4 > pj2 && pj4 > pj3) {
                            victorias[3]++;
                        } else {
                        }
                    }
                }
            }

            pj1 = 0;
            pj2 = 0;
            pj3 = 0;
            pj4 = 0;
        }

        // muestra el ganador
        if (victorias[0] > victorias[1] && victorias[0] > victorias[2]
                && victorias[0] > victorias[3]) {
            JOptionPane.showMessageDialog(null, "El ganador es el jugador: 1", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            pganadasj1++;
        } else {
            if (victorias[1] > victorias[0] && victorias[1] > victorias[2]
                    && victorias[1] > victorias[3]) {
                JOptionPane.showMessageDialog(null, "El ganador es el jugador: 2", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                pganadasj2++;
            } else {
                if (victorias[2] > victorias[0] && victorias[2] > victorias[1]
                        && victorias[2] > victorias[3]) {
                    JOptionPane.showMessageDialog(null, "El ganador es el jugador: 3", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                    pganadasj3++;
                } else {
                    if (victorias[3] > victorias[0] && victorias[3] > victorias[1]
                            && victorias[3] > victorias[2]) {
                        JOptionPane.showMessageDialog(null, "El ganador es el jugador: 4", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                        pganadasj4++;
                    } else {
                        // si hubo un empate, muestra el resultado
                        if (victorias[0] == victorias[1] || victorias[0] == victorias[2]
                                || victorias[0] == victorias[3] || victorias[1] == victorias[2]
                                || victorias[1] == victorias[3] || victorias[2] == victorias[3]) {
                            JOptionPane.showMessageDialog(null, "Empate.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                            empate++;
                        }
                    }
                }
            }
        }

        // imprime el número de victorias de cada jugador
        System.out.println("\n" + victorias[0] + " " + victorias[1] + " " + victorias[2] + " "
                + victorias[3] + "\n");
        victorias[0] = 0;
        victorias[1] = 0;
        victorias[2] = 0;
        victorias[3] = 0;
    }

    // método el cual genera la carta en curso
    public void generaCarta() {
        valor = aleatorio.nextDouble(); // genera un número aleatorio para generar la carta
        generaTipoCarta(valor); // asigna el tipo de carta (oro, copas, espadas, bastos)
        crearCarta(valor); //asigna el número de la carta y la crea
    }

    // se crea la carta en base a la tabla de números proporcionada
    public int crearCarta(double nAleatorio) {
        if (nAleatorio <= 0.10) {
            contadornumeros[0]++;
            numero = 2;
        } else if (nAleatorio >= 0.11 && nAleatorio <= 0.20) {
            contadornumeros[1]++;
            numero = 3;
        } else if (nAleatorio >= 0.21 && nAleatorio <= 0.30) {
            contadornumeros[2]++;
            numero = 4;
        } else if (nAleatorio >= 0.31 && nAleatorio <= 0.40) {
            contadornumeros[3]++;
            numero = 5;
        } else if (nAleatorio >= 0.41 && nAleatorio <= 0.50) {
            contadornumeros[4]++;
            numero = 6;
        } else if (nAleatorio >= 0.51 && nAleatorio <= 0.60) {
            contadornumeros[5]++;
            numero = 7;
        } else if (nAleatorio >= 0.61 && nAleatorio <= 0.70) {
            contadornumeros[6]++;
            numero = 10;
        } else if (nAleatorio >= 0.71 && nAleatorio <= 0.80) {
            contadornumeros[7]++;
            numero = 11;
        } else if (nAleatorio >= 0.81 && nAleatorio <= 0.90) {
            contadornumeros[8]++;
            numero = 12;
        } else if (nAleatorio >= 0.91) {
            contadornumeros[9]++;
            numero = 13;
        }
        return numero;
    }

//en este metodo creamos el tipo de carta.
    private String generaTipoCarta(double numAleatorio) {
        if (numAleatorio >= 0.00 && numAleatorio <= 0.25) { // oro
            tipoCarta = nombreCarta[0];
        } else if (numAleatorio >= 0.25 && numAleatorio <= 0.50) { // copas
            tipoCarta = nombreCarta[1];
        } else if (numAleatorio >= 0.50 && numAleatorio <= 0.75) { // espadas
            tipoCarta = nombreCarta[2];
        } else if (numAleatorio >= 0.75 && numAleatorio <= 1.0) { // bastos
            tipoCarta = nombreCarta[3];
        }
        return tipoCarta;
    }

    // muestra el reverso de las cartas en fila, usando coordenadas en X y Y
    public void reversoCartas() {
        int X1 = 150, Y1 = 100, X2 = 150, Y2 = 300, X3 = 150, Y3 = 500, X4 = 150, Y4 = 700;

        for (int i = 0; i < nCartas; i++) {

            if (posicion > 3) { // reinicia el contador de la fila a 0
                posicion = 0;
            }

            if (posicion == 0) {
                X1 += 45;
                arregloImagenes[i] = new JLabel(new ImageIcon(this.currentPath + "imagenes/back.jpg"));
                arregloImagenes[i].setBounds(X1, Y1, 100, 150);
                imagen.add(arregloImagenes[i]);
            }

            if (posicion == 1) {
                X2 += 45;
                arregloImagenes[i] = new JLabel(new ImageIcon(this.currentPath + "imagenes/back.jpg"));
                arregloImagenes[i].setBounds(X2, Y2, 100, 150);

                imagen.add(arregloImagenes[i]);
            }
            if (posicion == 2) {
                X3 += 45;
                arregloImagenes[i] = new JLabel(new ImageIcon(this.currentPath + "imagenes/back.jpg"));
                arregloImagenes[i].setBounds(X3, Y3, 100, 150);
                imagen.add(arregloImagenes[i]);
            }
            if (posicion == 3) {
                X4 += 45;
                arregloImagenes[i] = new JLabel(new ImageIcon(this.currentPath + "imagenes/back.jpg"));
                arregloImagenes[i].setBounds(X4, Y4, 100, 150);
                imagen.add(arregloImagenes[i]);
            }
            posicion++;
        }
    }

    // método que sirve para imprimir las imágenes en pantalla y las retira
    public void imprimeCarta(int i) {
        System.out.println(this.currentPath + "imagenes/" + cartas.get(i) + ".jpg");
        try {
            // especifica la ubicación y nombre de la carta
            arregloImagenes[i].setIcon(new ImageIcon(this.currentPath + "imagenes/" + cartas.get(i) + ".jpg"));
            imagen.update(getGraphics());
            hilo.sleep(300); // tiempo de espera en milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try { // quita la imagen de la interfaz
            imagen.remove(arregloImagenes[i]);
            imagen.update(getGraphics());
            hilo.sleep(300); // tiempo de espera en milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
