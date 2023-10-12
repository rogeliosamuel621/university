import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Prog0107 {
    public static void main(String[] args) {
        JFrame miVentana = new JFrame("Prog0107 - prueba de JCheckBox");
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MiPanel0107 mipanel = new MiPanel0107();
        miVentana.add(mipanel);

        miVentana.pack();
        miVentana.setVisible(true);
    }
}

class MiPanel0107 extends JPanel {
    private JCheckBox chkbarbilla;
    private JCheckBox chklentes;
    private JCheckBox chkpelo;
    private JCheckBox chkdientes;
    private JLabel dibujo;

    public MiPanel0107() {
        MiOyente0107 miOyente = new MiOyente0107();
        dibujo = new JLabel();

        chkbarbilla = new JCheckBox();
        chkbarbilla.setText("barbilla");
        chkbarbilla.setMnemonic('B');
        chkbarbilla.setToolTipText("Seleccionar barbilla");
        chkbarbilla.setSelected(true);

        chklentes = new JCheckBox("Lentes");
        chklentes.setMnemonic('L');
        chklentes.setToolTipText("Seleccionar lentes");
        chklentes.setSelected(true);

        chkpelo = new JCheckBox("Pelo", true);
        chkpelo.setMnemonic('P');
        chkpelo.setToolTipText("Seleccionar pelo");

        chkdientes = new JCheckBox("Dientes", true);
        chkdientes.setMnemonic('D');
        chkdientes.setToolTipText("Seleccionar dientes");

        mostrarFigura("blpd");

        JPanel panelOpciones = new JPanel();
        Border borde = BorderFactory.createTitledBorder("Seleccione un atributo");
        panelOpciones.setBorder(borde);

        panelOpciones.add(chkbarbilla);
        panelOpciones.add(chkdientes);
        panelOpciones.add(chklentes);
        panelOpciones.add(chkpelo);

        add(panelOpciones);
        add(dibujo);
    }

    private void mostrarFigura(String opciones) {
        Icon persona = new ImageIcon("imagenes/geek-" + opciones + ".gif");
        dibujo.setIcon(persona);
    }

    class MiOyente0107 implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println("Actioned");
            String opciones = "";
            if (chklentes.isSelected())
                opciones += 'l';
            else
                opciones += '-';
            if (chkbarbilla.isSelected())
                opciones += 'b';
            else
                opciones += '-';
            if (chkdientes.isSelected())
                opciones += 'd';
            else
                opciones += '-';
            if (chkpelo.isSelected())
                opciones += 'p';
            else
                opciones += '-';
        }
    }

}

