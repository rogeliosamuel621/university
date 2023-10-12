package Cartas;

import javax.swing.*;

public class Start
{
    public static void main(String[] args){
        int number;
        while(true){
            try {
                number = Integer.parseInt(JOptionPane.showInputDialog("How many games do you want to play?"));
                if(number > 0 && number <1000)
                    break;
                JOptionPane.showMessageDialog(null, "Enter a number between 0 - 1000");
            }
            catch (NumberFormatException error){
                JOptionPane.showMessageDialog(null, "Please enter a valid number!");
            }
        }

        JFrame window = new JFrame("Cards");
        window.setSize(1000, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(new Panel(number));
        window.setResizable(false);
        window.setVisible(true);
    }

}
