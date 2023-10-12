import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prog0110 {
    public static void main(String[] args) {
        JFrame miVentana = new JFrame("Prog 0110 - prueba de jtextfield y jpassword");
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MiPanel0110 mipanel = new MiPanel0110();
        miVentana.add(mipanel);

        miVentana.setSize(500, 300);
        miVentana.setVisible(true);
    }
}

class MiPanel0110 extends JPanel {
    private JTextField txtPrimero;
    private JTextField txtSegundo;
    private JTextField txtTercero;
    private JPasswordField pswContrasena;

    public MiPanel0110() {
        MiOyente0110 miOyente = new MiOyente0110();
        txtPrimero = new JTextField("Hola a todos");
        txtPrimero.addActionListener(miOyente);

        txtSegundo = new JTextField(10);
        txtSegundo.addActionListener(miOyente);

        txtTercero = new JTextField("Campos de texto de sólo lectura", 15);
        txtTercero.setEditable(false);
        txtTercero.addActionListener(miOyente);

        pswContrasena = new JPasswordField(10);
        pswContrasena.addActionListener(miOyente);

        add(new JLabel("Primer campo de texto: "));
        add(txtPrimero);
        add(new JLabel("Segundo campo de texto: "));
        add(txtSegundo);
        add(new JLabel("Tercerop campo de texto: "));
        add(txtTercero);

        add(new JLabel("Proporciona tu contraseña: "));
        add(pswContrasena);

    }

    class MiOyente0110 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField cual = (JTextField) e.getSource();

            if (cual == pswContrasena) {
                JOptionPane.showMessageDialog(null, "Error: la contraseña no es: " + new String(pswContrasena.getPassword()));
            } else {
                JOptionPane.showMessageDialog(null, cual.getText());
            }
        }
    }

}

