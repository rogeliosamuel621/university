import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prog0106 {
    public static void main(String[] args) {
        JFrame miVentana = new JFrame("Programa 0106 - prueba de jbutton");
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MiPanel0106 miPanel = new MiPanel0106();
        miVentana.add(miPanel);

        miVentana.setSize(600, 400);
        miVentana.setVisible(true);
    }
}

class MiPanel0106 extends JPanel {
    private JButton btnDesabilita;
    private JButton btnEnMedio;
    private JButton btnHabilita;

    public MiPanel0106() {
        MiOyente0106 miOyente = new MiOyente0106();

        Icon flechaIzquierda = new ImageIcon("imagenes/left.gif");
        Icon flechaDerecha = new ImageIcon("imagenes/right.gif");

        btnDesabilita = new JButton();
        btnDesabilita.setText("Desabilita boton del medio");
        btnDesabilita.setIcon(flechaDerecha);
        btnDesabilita.setMnemonic('D');
        btnDesabilita.setToolTipText("Desabilitar");
        btnDesabilita.setHorizontalTextPosition(SwingConstants.LEFT);
        btnDesabilita.setActionCommand("desabilitar");
        btnDesabilita.addActionListener(miOyente);

        btnEnMedio = new JButton("En medio");
        btnEnMedio.setMnemonic('E');
        btnEnMedio.setToolTipText("");

        btnHabilita = new JButton("Habilitar boton en medio");
        btnHabilita.setMnemonic('H');
        btnHabilita.setToolTipText("Habilita");
        btnHabilita.setEnabled(false);
        btnHabilita.addActionListener(miOyente);

        add(btnDesabilita);
        add(btnEnMedio);
        add(btnHabilita);
    }

    class MiOyente0106 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cual = e.getActionCommand();

            if (cual.equals("desabilitar")) {
                btnDesabilita.setEnabled(false);
                btnEnMedio.setEnabled(false);
                btnHabilita.setEnabled(true);
            } else {
                btnDesabilita.setEnabled(true);
                btnEnMedio.setEnabled(true);
                btnHabilita.setEnabled(false);
            }
        }
    }
}
