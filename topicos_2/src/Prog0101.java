import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prog0101 {
    public static void main(String[] args) {
        JFrame myWindow = new JFrame("Ejemplo de fuente y oyente de ventana");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel myPanel = new MyPanel();
        myWindow.add(myPanel);

        myWindow.setSize(600, 400);
        myWindow.setVisible(true);
    }
}

class MyPanel extends JPanel {
    public MyPanel() {
        MyListener myListener = new MyListener();
        JButton buttonOk = new JButton("Ok");
        add(buttonOk);
        buttonOk.addActionListener(myListener);

    }

    class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Pulsaste el boton :D");
        }
    }
}