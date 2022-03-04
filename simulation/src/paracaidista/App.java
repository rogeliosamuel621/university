package paracaidista;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        double masa, resistencia, gravedad = 9.8;
        double resultado;
        final String p = "Paracaidista";
        //Introduccion de datos

        //arrglo que guarda los las velocidades en las distintas posiciones.
        double datos[] = new double[10];

        //objeto que guarda los datos para posteriormente ser insertados en la grafica
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        //Peso
        do{
            System.out.println("Inserte el peso del paracaidista");
            masa = Keyboard.nextFloat();
            if(masa < 1){
                System.out.println("Inserte un valor valido");
            }
        }while(masa < 1);

        //Resistencia
        do{
            System.out.println("Inserte la coeficiencia de la resistencia del aire");
            resistencia = Keyboard.nextFloat();
            if(masa < 1){
                System.out.println("Inserte un valor valido");
            }
        }while(resistencia < 1);
        System.out.println("-----------------------------|-----------------------------"
                +"\n|            t               |           v                |"
                +"\n-----------------------------|-----------------------------");
        //calculo de velocidad
        for(int i=0; i<10; i++){
            resultado = ((gravedad*masa)/resistencia)*(1-Math.pow(2.7, (-(resistencia/masa)*(i+1))));
            datos[i]=resultado;
            if((i+1)==10){
                System.out.println("             " + (i+1) +"              |      "+ resultado
                        +"\n-----------------------------|-----------------------------");
            }
            else{
                System.out.println("             " + (i+1) +"               |      "+ resultado
                        +"\n-----------------------------|-----------------------------");
            }

        }

        //se guardan los faros en la dataset
        for(int i=0; i<10; i++){
            data.setValue(datos[i], p, String.valueOf(i+1));
        }


        JFreeChart grafico = ChartFactory.createLineChart("Paracaidista", "Distancia", "Velocidad", data);

        ChartPanel panel = new ChartPanel(grafico);

        JFrame ventana = new JFrame(" ");
        ventana.setVisible(true);
        ventana.setSize(400,200);

        ventana.add(panel);

    }
}