package baraja_v2;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Tablero extends javax.swing.JFrame {

    Baraja baraja;
    int posicion = 0;
    Thread hilo;
    private int numero;
    private String Tipodecarta;
    private String aux;
    private int contadornumeros[] = new int[10];
    private int numerodecartas = 40;
    private int turnosganados[] = new int[4];
    ArrayList<String> CartaAgg = new ArrayList<String>();
    Random rnd = new Random();
    double valor;
    public String nombreCartas[] = {"O", "C", "E", "B"};
    JLabel jlImagenes[] = new JLabel[numerodecartas];
    JLabel ImagenMesa;
    JButton Grafica;
    String currentPath = "";

    int pj1 = 0, pj2 = 0, pj3 = 0, pj4 = 0;
    // contadores
    int pganadasj1 = 0, pganadasj2 = 0, pganadasj3 = 0, pganadasj4 = 0, empate = 0;

    public Tablero() {
        try {
            this.currentPath = new java.io.File(".").getCanonicalPath() + "/scr/baraja_v2/";
        } catch (Exception e) {
            System.out.println("Error in constructor");
            e.printStackTrace();
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicia = new javax.swing.JButton();
        txtNumJuegos = new javax.swing.JTextField();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador3 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblJugador4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tablero");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Número de juegos:");

        btnInicia.setText("Iniciar juego");
        btnInicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciaActionPerformed(evt);
            }
        });

        txtNumJuegos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblJugador1.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador1.setText("Jugador 1");

        lblJugador3.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador3.setText("Jugador 3");

        lblJugador2.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador2.setText("Jugador 2");

        lblJugador4.setForeground(new java.awt.Color(0, 0, 0));
        lblJugador4.setText("Jugador 4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnInicia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtNumJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(520, 520, 520)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblJugador3)
                                                        .addComponent(lblJugador1))))
                                .addContainerGap(559, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(lblJugador4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblJugador2)
                                .addGap(183, 183, 183))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(lblJugador1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(189, 189, 189)
                                                .addComponent(lblJugador4))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(203, 203, 203)
                                                .addComponent(lblJugador2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addComponent(lblJugador3)
                                .addGap(144, 144, 144)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNumJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnInicia)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciaActionPerformed
        System.out.println(txtNumJuegos.getText());
        crearBaraja(Integer.parseInt(txtNumJuegos.getText()));
        repaint();

    }//GEN-LAST:event_btnIniciaActionPerformed

    /*public void actionPerformed(ActionEvent Evt) {
        if (Evt.getSource() == Grafica) {
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Jugador 1", pganadasj1);
            data.setValue("Jugador 2", pganadasj2);
            data.setValue("Jugador 3", pganadasj3);
            data.setValue("Jugador 4", pganadasj4);
            data.setValue("Empate", empate);

            // Creando el Grafico
            JFreeChart chart = ChartFactory.createPieChart("", data, true, true, false);
            // Mostrar Grafico
            ChartFrame frame = new ChartFrame("CARTAS", chart);
            frame.pack();
            frame.setVisible(true);
        }
    }*/

    public void crearBaraja(int numJugadas) {
        while (numJugadas > 0) {
            for (int i = 0; i < numerodecartas; i++) {
                crear();
                // aux= String.valueOf(crearCarta(valor))+crearPalo(valor);
                aux = String.valueOf(CrearTipo(valor) + crearCarta(valor));
                while (CartaAgg.contains(aux)) {
                    crear();
                    // aux= String.valueOf(crearCarta(valor))+crearPalo(valor);
                    aux = String.valueOf(CrearTipo(valor) + crearCarta(valor));
                }
                CartaAgg.add(aux);
            }

            jugar();
            espacioCartas();

            while (!CartaAgg.isEmpty()) {
                CartaAgg.remove(0);
            }
            numJugadas--;
        }
    }

    public void jugar() {
        for (int i = 0; i < numerodecartas; i += 4) {
            String carta1 = CartaAgg.get(i).substring(0, 1);
            String carta2 = CartaAgg.get(i + 1).substring(0, 1);
            String carta3 = CartaAgg.get(i + 2).substring(0, 1);
            String carta4 = CartaAgg.get(i + 3).substring(0, 1);

            int valor1 = Integer.parseInt(CartaAgg.get(i).substring(1));
            int valor2 = Integer.parseInt(CartaAgg.get(i + 1).substring(1));
            int valor3 = Integer.parseInt(CartaAgg.get(i + 2).substring(1));
            int valor4 = Integer.parseInt(CartaAgg.get(i + 3).substring(1));

            dibujarCarta(i);
            dibujarCarta(i + 1);
            dibujarCarta(i + 2);
            dibujarCarta(i + 3);

            System.out.println("Carta 1: " + carta1);
            System.out.println("Carta 2: " + carta2);
            System.out.println("Carta 3: " + carta3);
            System.out.println("Carta 4: " + carta4);

            System.out.println("Valor1: " + valor1);
            System.out.println("Valor2: " + valor2);
            System.out.println("Valor3: " + valor3);
            System.out.println("Valor4: " + valor4);

            // Palo y valor 1
            if (carta1.equals(nombreCartas[3])) {
                pj1 += (valor1 + 15);
            }
            if (carta1.equals(nombreCartas[2])) {
                pj1 += (valor1 + 30);
            }
            if (carta1.equals(nombreCartas[1])) {
                pj1 += (valor1 + 45);
            }
            if (carta1.equals(nombreCartas[0])) {
                pj1 += (valor1 + 60);
            }

            // Palo y valor 2
            if (carta2.equals(nombreCartas[3])) {
                pj2 += (valor2 + 15);
            }
            if (carta2.equals(nombreCartas[2])) {
                pj2 += (valor2 + 30);
            }
            if (carta2.equals(nombreCartas[1])) {
                pj2 += (valor2 + 45);
            }
            if (carta2.equals(nombreCartas[0])) {
                pj2 += (valor2 + 60);
            }

            // Palo y valor 3
            if (carta3.equals(nombreCartas[3])) {
                pj3 += (valor3 + 15);
            }
            if (carta3.equals(nombreCartas[2])) {
                pj3 += (valor3 + 30);
            }
            if (carta3.equals(nombreCartas[1])) {
                pj3 += (valor3 + 45);
            }
            if (carta3.equals(nombreCartas[0])) {
                pj3 += (valor3 + 60);
            }

            // Palo y valor 4
            if (carta4.equals(nombreCartas[3])) {
                pj4 += (valor4 + 15);
            }
            if (carta4.equals(nombreCartas[2])) {
                pj4 += (valor4 + 30);
            }
            if (carta4.equals(nombreCartas[1])) {
                pj4 += (valor4 + 45);
            }
            if (carta4.equals(nombreCartas[0])) {
                pj4 += (valor4 + 60);
            }

            System.out.println(pj1 + " " + pj2 + " " + pj3 + " " + pj4);
            // Comprueba el ganados de cada partida.
            if (pj1 > pj2 && pj1 > pj3 && pj1 > pj4) {
                turnosganados[0]++;

            } else {
                if (pj2 > pj1 && pj2 > pj3 && pj2 > pj4) {
                    turnosganados[1]++;
                } else {
                    if (pj3 > pj1 && pj3 > pj2 && pj3 > pj4) {
                        turnosganados[2]++;
                    } else {
                        if (pj4 > pj1 && pj4 > pj2 && pj4 > pj3) {
                            turnosganados[3]++;
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

        // Comparaci�n entre las partidas de los jugadores, para saber cual de ellos
        // gano m�s partidas
        // Se selecciona al ganador de todas las partidas.
        if (turnosganados[0] > turnosganados[1] && turnosganados[0] > turnosganados[2]
                && turnosganados[0] > turnosganados[3]) {
            JOptionPane.showMessageDialog(null, "El ganador es el jugador: 1", "Aviso del programa", JOptionPane.INFORMATION_MESSAGE);//esto era
            pganadasj1++;
        } else {
            if (turnosganados[1] > turnosganados[0] && turnosganados[1] > turnosganados[2]
                    && turnosganados[1] > turnosganados[3]) {
                JOptionPane.showMessageDialog(null, "El ganador es el jugador: 2", "Aviso del programa", JOptionPane.INFORMATION_MESSAGE);
                pganadasj2++;
            } else {
                if (turnosganados[2] > turnosganados[0] && turnosganados[2] > turnosganados[1]
                        && turnosganados[2] > turnosganados[3]) {
                    JOptionPane.showMessageDialog(null, "El ganador es el jugador: 3", "Aviso del programa", JOptionPane.INFORMATION_MESSAGE);
                    pganadasj3++;
                } else {
                    if (turnosganados[3] > turnosganados[0] && turnosganados[3] > turnosganados[1]
                            && turnosganados[3] > turnosganados[2]) {
                        JOptionPane.showMessageDialog(null, "El ganador es el jugador: 4", "Aviso del programa", JOptionPane.INFORMATION_MESSAGE);
                        pganadasj4++;
                    } else {
                        if (turnosganados[0] == turnosganados[1] || turnosganados[0] == turnosganados[2]
                                || turnosganados[0] == turnosganados[3] || turnosganados[1] == turnosganados[2]
                                || turnosganados[1] == turnosganados[3] || turnosganados[2] == turnosganados[3]) {
                            JOptionPane.showMessageDialog(null, "Hubo un empate", "Aviso del programa", JOptionPane.INFORMATION_MESSAGE);
                            empate++;
                        }
                    }
                }
            }
        }
        for (int k = 0; k < numerodecartas; k++) {
            if (pganadasj1 > pganadasj2 && pganadasj1 > pganadasj3 && pganadasj1 > pganadasj4) {
                //JOptionPane.showMessageDialog(null, "Gan� el jugador 1 en la ronda " + (k + 1));
                return;
            } else {
                if (pganadasj2 > pganadasj1 && pganadasj2 > pganadasj3 && pganadasj2 > pganadasj4) {
                    //JOptionPane.showMessageDialog(null, "Gan� el jugador 2 en la ronda " + (k + 1));
                    return;
                } else {
                    if (pganadasj3 > pganadasj1 && pganadasj3 > pganadasj2 && pganadasj3 > pganadasj4) {
                        //JOptionPane.showMessageDialog(null, "Gan� el jugador 3 en la ronda " + (k + 1));
                        return;
                    } else {
                        if (pganadasj4 > pganadasj1 && pganadasj4 > pganadasj2 && pganadasj4 > pganadasj3) {
                            //JOptionPane.showMessageDialog(null, "Gan� el jugador 4 en la ronda " + (k + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("\n" + turnosganados[0] + " " + turnosganados[1] + " " + turnosganados[2] + " "
                + turnosganados[3] + "\n");
        turnosganados[0] = 0;
        turnosganados[1] = 0;
        turnosganados[2] = 0;
        turnosganados[3] = 0;
    }

    public void crear() {
        valor = rnd.nextDouble();
        CrearTipo(valor);
        crearCarta(valor);
    }

    // en este metodo creamos el numero de la carta.valor es el numero random
    // generado.
    public int crearCarta(double random) {
        if (random <= 0.10) {
            contadornumeros[0]++;
            numero = 2;
        }

        if (random >= 0.11 && random <= 0.20) {
            contadornumeros[1]++;
            numero = 3;
        }
        if (random >= 0.21 && random <= 0.30) {
            contadornumeros[2]++;
            numero = 4;
        }
        if (random >= 0.31 && random <= 0.40) {
            contadornumeros[3]++;
            numero = 5;
        }
        if (random >= 0.41 && random <= 0.50) {
            contadornumeros[4]++;
            numero = 6;
        }
        if (random >= 0.51 && random <= 0.60) {
            contadornumeros[5]++;
            numero = 7;
        }
        if (random >= 0.61 && random <= 0.70) {
            contadornumeros[6]++;
            numero = 10;
        }
        if (random >= 0.71 && random <= 0.80) {
            contadornumeros[7]++;
            numero = 11;
        }
        if (random >= 0.81 && random <= 0.90) {
            contadornumeros[8]++;
            numero = 12;
        }
        if (random >= 0.91) {
            contadornumeros[9]++;
            numero = 13;
        }
        return numero;
    }

    //en este metodo creamos el tipo de carta.
    private String CrearTipo(double random) {
        if (random <= 0.25) {
            // contadorpalo[0]++;
            Tipodecarta = nombreCartas[0];
        }
        if (random >= 0.251 && random <= 0.5) {
            // contadorpalo[1]++;
            Tipodecarta = nombreCartas[1];
        }
        if (random >= 0.51 && random <= 0.75) {
            // contadorpalo[2]++;
            Tipodecarta = nombreCartas[2];

        }
        if (random >= 0.751) {
            // contadorpalo[3]++;
            Tipodecarta = nombreCartas[3];
        }
        return Tipodecarta;
    }

    public void espacioCartas() {
        // Colocaci�n de las cartas
        int X1 = 400, Y1 = 90, X2 = 710, Y2 = 300, X3 = 390, Y3 = 515, X4 = 120, Y4 = 300;

        for (int i = 0; i < numerodecartas; i++) {

            if (posicion > 3) {
                posicion = 0;
            }

            if (posicion == 0) {
                X1 += 45;
                jlImagenes[i] = new JLabel(new ImageIcon(getClass().getResource("imagenes/back.jpg")));
                jlImagenes[i].setBounds(X1, Y1, 100, 150);

                ImagenMesa.add(jlImagenes[i]);
            }

            if (posicion == 1) {
                X2 += 45;
                jlImagenes[i] = new JLabel(new ImageIcon(getClass().getResource("imagenes/back.jpg")));
                jlImagenes[i].setBounds(X2, Y2, 100, 150);

                ImagenMesa.add(jlImagenes[i]);
            }
            if (posicion == 2) {
                X3 += 45;
                jlImagenes[i] = new JLabel(new ImageIcon(getClass().getResource("imagenes/back.jpg")));
                jlImagenes[i].setBounds(X3, Y3, 100, 150);
                ImagenMesa.add(jlImagenes[i]);
            }
            if (posicion == 3) {
                X4 += 45;
                jlImagenes[i] = new JLabel(new ImageIcon(getClass().getResource("imagenes/back.jpg")));
                jlImagenes[i].setBounds(X4, Y4, 100, 150);
                ImagenMesa.add(jlImagenes[i]);
            }
            posicion++;
        }
    }

    public void dibujarCarta(int i) {
        try {
            jlImagenes[i].setIcon(new ImageIcon(this.currentPath + "imagenes/" + CartaAgg.get(i) + ".jpg"));
            ImagenMesa.update(getGraphics());
            hilo.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            ImagenMesa.remove(jlImagenes[i]); // remueve la imagen de la carta que ya fue volteada.
            ImagenMesa.update(getGraphics());
            hilo.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblJugador4;
    private javax.swing.JTextField txtNumJuegos;
    // End of variables declaration//GEN-END:variables
}
