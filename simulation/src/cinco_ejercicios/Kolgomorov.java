package cinco_ejercicios;

import javax.swing.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Collections;

public class Kolgomorov extends JFrame {
    static ArrayList<Double> randomNumbers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat formato1 = new DecimalFormat("0.0000");
    static DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

    public Kolgomorov(ArrayList<Double> randomNumbersProp) {
        randomNumbers = randomNumbersProp;
        startSimulation();
    }

    public static void startSimulation() {
        // TODO Auto-generated method stub
        //System.out.println("Inserta la cantidad de numeros: ");
        //int number = sc.nextInt();
        //randomNumberGenerator(number);
        System.out.println("Inserte la probabilidad de errror");
        int probability = sc.nextInt();
        startSimulation(randomNumbers, probability);
    }

    static void randomNumberGenerator (int numbers) {
        for (int i=0; i < numbers; i++) {
            double randomNumber = Math.random();
            randomNumbers.add(randomNumber);
        }
    }

    static void startSimulation (ArrayList<Double> randomNumbers, int probability) {
        Collections.sort(randomNumbers);
        double fn = 0;
        double Di = 0;
        double D5 [] = {0.22743,0.22425,0.22119,0.21826,0.21544,0.21273,
                0.21012,0.20760,0.20517,0.20283,0.20056,0.19837,0.19625,
                0.19420,0.19221,0.19028,0.18841};
        double D10 [] = {0.21472,0.20185,0.19910,0.19646,0.19392,0.19148,
                0.18913,0.18687,0.18468,0.18257,0.18051,0.17856,0.17665,
                0.17481,0.17301,0.17128,0.16959};
        ArrayList<Double> saveDi = new ArrayList<>();
        double higherDi = 0;
        double d = 0;
        String validation = "";
        System.out.println("i\tUi\ti/N\tDi");
        for(int i = 0; i < randomNumbers.size(); i++) {
            fn = (double) (i+1) / randomNumbers.size();
            Di = Math.abs(randomNumbers.get(i) - fn);
            saveDi.add(Di);
            higherDi = Collections.max(saveDi);
            System.out.println(((i+1) + "\t") + (formato1.format(randomNumbers.get(i)) + "\t")
                    + (formato1.format(fn) + "\t") + (formato1.format(Di)));
            String graphic = (i+1) + "";
            line_chart_dataset.addValue(randomNumbers.get(i), "Ui", graphic);
            line_chart_dataset.addValue(fn, "i/N", graphic);
        }
        int arrayPosition = randomNumbers.size() - 34;
        System.out.println();
        if (probability == 5) {
            if (randomNumbers.size() < 50) {
                validation = getValidation(higherDi,D5[arrayPosition]);
                System.out.println("Di: " + formato1.format(higherDi)
                        + " <= " + "D: " + D5[arrayPosition]);
                System.out.println(validation);
            }
            else {
                d = calculatedD(5,randomNumbers.size());
                validation = getValidation(higherDi,d);
                System.out.println("Di: " + formato1.format(higherDi)
                        + " <= " + "D: " + d);
                System.out.println(validation);
            }
        }
        else {
            if (randomNumbers.size() < 50) {
                validation = getValidation(higherDi,D10[arrayPosition]);
                System.out.println("Di: " + formato1.format(higherDi)
                        + " <= " + "D: " + D10[arrayPosition]);
                System.out.println(validation);
            }
            else {
                d = calculatedD(10,randomNumbers.size());
                validation = getValidation(higherDi,d);
                System.out.println("Di: " + formato1.format(higherDi)
                        + " <= " + "D: " + d);
                System.out.println(validation);
            }

        }
        JFreeChart chart=ChartFactory.createLineChart("Grafica",
                "Numeros","Rango",line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);
        ChartPanel panel = new ChartPanel(chart);
        JFrame ventana = new JFrame(" ");
        ventana.setVisible(true);
        ventana.setSize(1920, 600);
        ventana.add(panel);
    }

    static String getValidation (double higherDi, double D) {
        String validation = "";
        if (higherDi <= D) {
            validation = "Los numeros estan uniformemente distribuidos";
            return validation;
        }
        else {
            validation = "Los numeros no estan uniformemente distribuidos";
            return validation;
        }
    }

    static double calculatedD (int probability, int n) {
        double d = 0;
        if (probability == 5) {
            d = (double) 1.36 / (Math.sqrt(n));
        }
        else {
            d = (double) 1.22 / (Math.sqrt(n));
        }
        return d;
    }
}
