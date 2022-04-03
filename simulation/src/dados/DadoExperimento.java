package Unidad1;

import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class MetodoMontecarlo {
    public static Scanner leer = new Scanner(System.in);
    static DecimalFormat formato1 = new DecimalFormat("0.000");
    static DefaultPieDataset data = new DefaultPieDataset();
    public static void main(String[] args) {
        int option;
        boolean control = true;

        do {
            System.out.print("\tMenu\n"
                    + "\n1.- Moneda."
                    + "\n2.- Dado."
                    + "\n3.- Salir."
                    + "\n\nOPCION: ");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Cuantas monedas desea lanzar: ");
                    int lanzamientos = leer.nextInt();
                    moneda(lanzamientos);
                    break;
                case 2:
                    System.out.println("Cuantas monedas desea lanzar: ");
                    int lanzamientos2 = leer.nextInt();
                    dado(lanzamientos2);
                    break;
                case 3:
                    control = false;
                    break;
                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }

        }while(control);
    }

    public static void moneda(int lanzamientos) {
        int cara = 0, cruz = 0;
        System.out.println("Numero\t#Aleatorio Generado\tResultado");
        for (int i=0; i<lanzamientos; i++) {
            double random = Math.random();
            if (random <= 0.5) {
                cara++;
                System.out.println(
                        ("X" + (i + 1) + "\t") + ("#" + formato1.format(random) + "\t\t\t") + ("Cara"));
            }
            else {
                cruz++;
                System.out.println(
                        ("X" + (i + 1) + "\t") + ("#" + formato1.format(random) + "\t\t\t") + ("Cruz"));
            }
        }
        data.setValue("Cara", cara);
        data.setValue("Cruz", cruz);
        JFreeChart grafico = ChartFactory.createPieChart("Moneda", data, true, true, false);
        ChartPanel panel = new ChartPanel(grafico);
        JFrame ventana = new JFrame(" ");
        ventana.setVisible(true);
        ventana.setSize(700, 700);
        ventana.add(panel);
    }

    public static void dado(int lanzamientos) {
        int cara1 = 0, cara2 = 0, cara3 = 0;
        int cara4 = 0, cara5 = 0, cara6 = 0;
        System.out.println("Numero\t#Aleatorio Generado\tResultado");
        for (int i=0; i<lanzamientos; i++) {
            double random = Math.random();
            if (random <= 0.1667) {
                cara1++;
                System.out.println(
                        ("X" + (i + 1) + "\t") + ("#" + formato1.format(random) + "\t\t\t") + ("1"));
            }
            else if (random > 0.1667 && random <= 0.3333 ) {
                cara2++;
                System.out.println(
                        ("X" + (i + 1) + "\t") + ("#" + formato1.format(random) + "\t\t\t") + ("2"));
            }
            else if (random > 0.3333 && random <= 0.5 ) {
                cara3++;
                System.out.println(
                        ("X" + (i + 1) + "\t") + ("#" + formato1.format(random) + "\t\t\t") + ("3"));
            }
            else if (random > 0.5 && random <= 0.6666 ) {
                cara4++;
                System.out.println(
                        ("X" + (i + 1) + "\t") + ("#" + formato1.format(random) + "\t\t\t") + ("4"));
            }
            else if (random > 0.6666 && random <= 0.8333 ) {
                cara5++;
                System.out.println(
                        ("X" + (i + 1) + "\t") + ("#" + formato1.format(random) + "\t\t\t") + ("5"));
            }
            else {
                cara6++;
                System.out.println(
                        ("X" + (i + 1) + "\t") + ("#" + formato1.format(random) + "\t\t\t") + ("6"));
            }
        }
        data.setValue("1", cara1);
        data.setValue("2", cara2);
        data.setValue("3", cara3);
        data.setValue("4", cara4);
        data.setValue("5", cara5);
        data.setValue("6", cara6);

        JFreeChart grafico2 = ChartFactory.createPieChart("Dado", data, true, true, false);
        ChartPanel panel = new ChartPanel(grafico2);
        JFrame ventana = new JFrame(" ");
        ventana.setVisible(true);
        ventana.setSize(700, 700);
        ventana.add(panel);
    }

}