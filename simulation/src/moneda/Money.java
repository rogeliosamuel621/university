package moneda;

import java.util.Scanner;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Money {
    static Scanner sc = new Scanner(System.in);
    static DefaultPieDataset data = new DefaultPieDataset();
    public static void main(String[] args) {
        moneda();
    }
    public static void moneda() {
        int cara = 0, cruz = 0, aux, tiradas;
        int datos[] = new int[1000000];
        final String x = "Cara";
        final String y = "Cruz";
        System.out.println("Cuantas veces desea tirar la moneda");
        tiradas = sc.nextInt();
        System.out.println("Numero\t#Aleatorio Generado\tResultado");
        for (int i = 0; i < tiradas; i++) {
            aux = (int) (1 + Math.random() * 2);
            switch (aux) {
                case 1: {
                    System.out.println(
                            ("X" + (i + 1) + "\t") + ("#" + 1 + "\t\t\t") + ("Cara"));
                    cara++;
                    datos[i] = 1;
                    data.setValue(x, datos[i]);
                    break;
                }
                case 2: {
                    System.out.println(
                            ("X" + (i + 1) + "\t") + ("#" + 2 + "\t\t\t") + ("Cruz"));
                    cruz++;
                    datos[i] = 2;
                    data.setValue(y, datos[i]);
                    break;
                }
            }
        }
        JFreeChart grafico = ChartFactory.createPieChart("Moneda", data, true, true, false);
        ChartPanel panel = new ChartPanel(grafico);
        JFrame ventana = new JFrame(" ");
        ventana.setVisible(true);
        ventana.setSize(700, 700);
        ventana.add(panel);
    }
}