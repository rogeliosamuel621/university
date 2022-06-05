package multiples_programs;

import org.jfree.data.category.DefaultCategoryDataset;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChiSquareMethod {
    private double[] randomValues;
    private int nValue;
    private double kValue;

    public ChiSquareMethod(double[] randomValues) {
        this.nValue = randomValues.length;
        this.kValue = this.getK(nValue);
        this.randomValues = randomValues;
    }

    public void startSimulation() {
        System.out.println("I  \t\t O \t\t E \t\t (O - E) \t ((O - E)^2) / E");

        ArrayList<Double> intervals = this.getIntervals();
        double resultSummation = 0.0d;
        double matchExpectedSummation = 0.0d;
        int quantityOfRandomNumbersSummation = 0;


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

            System.out.println(_i + "\t" + o + " \t " + e + " \t " + rest + " \t\t\t " + equation);
        }

        System.out.println("Totales\t " + quantityOfRandomNumbersSummation + " \t " +  matchExpectedSummation + "\t   E= \t\t\t  " + resultSummation);

        DefaultCategoryDataset data = new DefaultCategoryDataset();

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
