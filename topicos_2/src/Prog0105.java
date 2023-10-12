import javax.swing.*;

public class Prog0105 {
    public static void main(String[] args) {
        JFrame miVentana = new JFrame("Programa de prueba de JLabel");
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MiPanel0105 miPanel = new MiPanel0105();
        miVentana.add(miPanel);

        miVentana.setSize(600, 400);
        miVentana.setVisible(true);
    }
}

class MiPanel0105 extends JPanel {
    public MiPanel0105() {
        Icon dibujo = new ImageIcon("imagenes/middle.gif");

        JLabel et1 = new JLabel();
        et1.setText("Etiqueta 1");
        et1.setIcon(dibujo);
        et1.setToolTipText("Etiqueta 1");
        et1.setHorizontalTextPosition(SwingConstants.CENTER);
        et1.setVerticalTextPosition(SwingConstants.BOTTOM);

        JLabel et2 = new JLabel(dibujo);
        et2.setToolTipText("Etiqueta 2");

        JLabel et3 = new JLabel("Etiqueta 3");
        et3.setToolTipText("Etiqueta 3");

        add(et1);
        add(et2);
        add(et3);


    }
}
