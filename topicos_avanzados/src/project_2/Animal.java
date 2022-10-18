package project_2;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Animal extends Thread {
    private String nombre;
    private int limite;
    JLabel label;

    public Animal (String nombre, int limite, JLabel label){
        this.nombre = nombre;
        this.limite= limite;
        this.label = label;
    }

    public void run(){

        for (int i = 0; i < limite; i++) {
            this.avanza(i);
        }

        this.mostrarMensajeDeMeta();
    }

    /**
     * Metodo que hace que el animal avance el numero de pixeles que se le indique
     * @param nuevaPosision
     */
    private void avanza(int nuevaPosision) {
        try{
            // System.out.println(nombre + " AVANZA");
            label.setLocation(nuevaPosision,0);
            Thread.sleep(20);
        }catch(InterruptedException err){
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, err);
        }
    }

    private void mostrarMensajeDeMeta() {
        JOptionPane.showMessageDialog(null,nombre + " HA LLEGADO A LA META");
        // System.out.println(nombre + " HA LLEGADO A LA META");
    }
}
