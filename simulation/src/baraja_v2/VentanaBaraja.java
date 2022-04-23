package baraja_v2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaBaraja extends JFrame implements ActionListener {

    JTextField txt;
    JButton jugar;
    Baraja baraja;

    /*public VentanaBaraja()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
                //Nombre de la ventana
		setTitle("Juego de cartas");
		setSize(1370,770); //Tamaño del panel
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel pregunta =new JLabel("¿Cuantas veces deseas jugar? ");
		pregunta.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(pregunta);

		txt = new JTextField(10);
		panel.add(txt);
                
                //Boton para inicializar el juego
		jugar = new JButton("Jugar");
		jugar.setFont(new Font("Arial",Font.PLAIN,15));
		jugar.addActionListener(this);
		panel.add(jugar);
		add(panel,BorderLayout.NORTH);

		baraja = new Baraja();
		baraja.setBackground(Color.white);
		add(baraja);

		setVisible(true);
	}*/
    
    public void actionPerformed(ActionEvent e) {
        //Lanza un mensaje en caso de que el dato introducido no sea un numero entero.
        if (e.getSource() == jugar) {
            try {

                baraja.crearBaraja(Integer.parseInt(txt.getText()));
                baraja.repaint();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "El valor que introdujo no es un numero", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}
