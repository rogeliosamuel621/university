package cinco_ejercicios;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ChiSquareMethod extends JFrame {
    Scanner sc = new Scanner(System.in);
    private double[] randomValues;
    private int nValue;
    private double kValue;
    JPanel panel;

    public ChiSquareMethod(double[] randomValues) {
        this.nValue = randomValues.length;
        this.kValue = this.getK(nValue);
        this.randomValues = randomValues;
        startSimulation();
    }

    public void startSimulation() {

        System.out.println("Digite el porcentaje de fallo: (1: 5%, 2: 10%)");
        int opt = sc.nextInt();

        double percentage5 [] = {3.8415,5.9915,7.8147,9.4877,11.0705,12.5916,14.0671,15.5073,16.9190,18.3070};
        double percentage10[] = {2.7055,4.6052,6.2514,7.7794,9.2363,10.6446,12.0170,13.3616,14.6837,15.9872};

        System.out.println("I  \t\t O \t\t E \t\t (O - E) \t ((O - E)^2) / E");

        ArrayList<Double> intervals = this.getIntervals();
        double resultSummation = 0.0d;
        double matchExpectedSummation = 0.0d;
        int quantityOfRandomNumbersSummation = 0;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < intervals.size(); i++) {
            double currentInterval = intervals.get(i);
            int[] indexesForLimits = this.getLimitsIndexes(i, intervals.size() - 1);
            double lowerLimit = i == 0 ? 0 : intervals.get(indexesForLimits[0]);
            double upperLimit = intervals.get(i == 0 ? 0 : indexesForLimits[1]);
            int quantityOfRandomNumber = this.getRandomNumbersInLimits(lowerLimit, upperLimit);



            double matchExpected = this.getMatchExpected();
            double rest0AndE = quantityOfRandomNumber - matchExpected;
            double finalEquation = (rest0AndE * rest0AndE) / matchExpected;

            resultSummation = resultSummation + finalEquation;
            matchExpectedSummation = matchExpectedSummation + matchExpected;
            quantityOfRandomNumbersSummation = quantityOfRandomNumbersSummation + quantityOfRandomNumber;

            String _i = new DecimalFormat("0.00").format(currentInterval);
            String o = new DecimalFormat("0.0").format(quantityOfRandomNumber);
            String e = new DecimalFormat("0.00").format(matchExpected);
            String rest = new DecimalFormat("0.00").format(rest0AndE);
            String equation = new DecimalFormat("0.000").format(finalEquation);

            dataset.setValue(quantityOfRandomNumber,_i , "10");

            System.out.println(_i + "\t" + o + " \t " + e + " \t " + rest + " \t\t\t " + equation);
        }

        System.out.println("Totales\t " + quantityOfRandomNumbersSummation + " \t " +  matchExpectedSummation + "\t   E= \t\t\t  " + resultSummation);

        double value = 0.0d;
        if (opt == 1) {
            value = percentage5[intervals.size() - 2];
        } else {
            value = percentage10[intervals.size() - 2];
        }

        if (resultSummation <= value) {
            System.out.println("Los numeros están uniformemente distribuidos");
        } else  {
            System.out.println("Los numeros no están uniformemente distribuidos");
        }

        panel = new JPanel();
        getContentPane().add(panel);

        JFreeChart chart = ChartFactory.createBarChart("Chi-cuadrado", "Intervalos", "Cantidad", dataset);
        chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);

        setTitle("Como Hacer Graficos con Java");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private double getK(int N) {
        return Math.sqrt(N);
    }

    private double getMatchExpected() {
        return this.nValue / this.kValue;
    }

    private ArrayList<Double> getIntervals() {
        ArrayList<Double> intervals = new ArrayList<>();

        double intervalValue = 1 / this.kValue;
        double summation = 0.0d;

        while (true) {
            summation = summation + intervalValue;
            intervals.add(summation);

            if (summation >= 1.0d) break;
        }

        return intervals;
    }

    private int getRandomNumbersInLimits(double lowerLimit, double upperLimit) {
        int count = 0;

        for (int i = 0; i < this.randomValues.length; i++) {
            double currentValue = this.randomValues[i];

            if (currentValue > lowerLimit && currentValue <= upperLimit) count++;
        }

        return count;
    }

    private int[] getLimitsIndexes(int index, int lengthLimit) {
        int[] limitIndexes = new int[2];

        int lowerLimit = index - 1;
        int upperLimit = index;

        if (upperLimit > lengthLimit) {
            upperLimit -= 1;
        }

        limitIndexes[0] = lowerLimit;
        limitIndexes[1] = upperLimit;

        return limitIndexes;
    }
}
