import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prog0111 {
    public static void main(String[] args) {
        JFrame window = new JFrame("prog0111 - test jtextarea");
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);

        MyPanel0111 panel = new MyPanel0111();
        window.add(panel);

        window.setSize(800, 600);
        window.setVisible(true);
    }
}

class MyPanel0111 extends JPanel {
    Listener0111 listener = new Listener0111();
    private JTextArea taSource;
    private JButton btnCopy;
    private JTextArea taFate;

    MyPanel0111() {
        taSource = new JTextArea(5, 10);
        taSource.setLineWrap(true);
        taSource.setWrapStyleWord(true);

        btnCopy = new JButton("copy >>");
        btnCopy.addActionListener(listener);

        taFate = new JTextArea(5, 10);
        taFate.setEditable(false);
        taFate.setLineWrap(true);
        taFate.setWrapStyleWord(true);

        add(new JScrollPane(taSource));
        add(btnCopy);
        add(new JScrollPane(taFate));
    }

    class Listener0111 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            taFate.append(taSource.getText() + "\n");
        }
    }
}


