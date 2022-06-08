package cinco_ejercicios;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Huecos {
    static ArrayList<Double> randomNumbers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat formato1 = new DecimalFormat("0.0000");
    static DecimalFormat formato2 = new DecimalFormat("0.00");

    public Huecos(ArrayList<Double> randomNumbersProp) {
        randomNumbers = randomNumbersProp;
        startSimulation();
    }

    public static void startSimulation() {
        // TODO Auto-generated method stub
        // System.out.println("Inserta la cantidad de numeros: ");
        // int number = sc.nextInt();
        // randomNumberGenerator(number);
        System.out.println("Inserte la probabilidad de errror");
        int probability = sc.nextInt();
        startHuecos(probability);
    }

    static void randomNumberGenerator (int numbers) {
        for (int i=0; i < numbers; i++) {
            double randomNumber = Math.random();
            randomNumbers.add(randomNumber);
        }
    }

    static void startHuecos (int probability) {
        System.out.println("Inserte el valor de a: ");
        double a = sc.nextDouble();
        System.out.println("Inserte el valor de b: ");
        double b = sc.nextDouble();
        double o = b - a;
        int e = 3;
        int contI = 0;
        int contE = 0;
        int i = 3;
        int ant = 7;
        int antE = 0;
        int cont = 0;
        double pi = 0;
        double ei = 0;
        ArrayList<Integer> contador = new ArrayList<>();
        ArrayList<Integer> contador0 = new ArrayList<>();
        List<Integer> acomodo;
        acomodo = new ArrayList<Integer>();
        System.out.println("n\tUi\t€\ti");
        for (int n=0; n <= randomNumbers.size(); n++) {
            antE = e;

            if (cont == randomNumbers.size()) {
                cont = n-1;;
            }
            if (randomNumbers.get(cont) > a && randomNumbers.get(cont) < b) {
                e = 1;
                i = 0;
                contI++;
            }
            else {
                e = 0;
                i = 1;
                contE++;
            }

            if (n == randomNumbers.size()) {
                i = 3;
            }

            if (n == randomNumbers.size()) {
                contE = contE - 1;
            }

            if (i == ant && n > 0) {
                System.out.println(((n) + "\t") + (formato1.format(randomNumbers.get(n-1)) + "\t")
                        + (antE + "\t"));
            }
            else if (i != ant && n > 0 ) {
                if (contI > contE) {
                    System.out.println(((n) + "\t") + (formato1.format(randomNumbers.get(n-1)) + "\t")
                            + (antE + "\t") + 0);
                    contador0.add(1);
                    contI = 0;
                }
                else if (contE > contI){
                    System.out.println(((n) + "\t") + (formato1.format(randomNumbers.get(n-1)) + "\t")
                            + (antE + "\t") + contE);
                    contador.add(contE);
                    acomodo.add(contE);
                    contE = 0;
                }
                else if (contE == contI && ant == 1) {
                    System.out.println(((n) + "\t") + (formato1.format(randomNumbers.get(n-1)) + "\t")
                            + (antE + "\t") + 1);
                    contador.add(contE);
                    acomodo.add(contE);
                    contE = 0;
                }
                else if (contE == contI && ant == 0){
                    System.out.println(((n) + "\t") + (formato1.format(randomNumbers.get(n-1)) + "\t")
                            + (antE + "\t") + 0);
                    contador0.add(1);
                    contI = 0;
                }
            }
            ant = i;
            cont++;
        }

        Set<Integer> hashSet = new HashSet<Integer>(acomodo);
        acomodo.clear();
        acomodo.addAll(hashSet);
        System.out.println();
        int contTable = getTable(acomodo);
        Collections.sort(contador);
        int occurrences = 0;
        double eiTotal = 0;
        System.out.println();
        int newCont = 0;
        System.out.println();
        System.out.println("i\tPi\tOi\tEi\tOi-Ei\t\tXo2");
        double piTotal = 0;
        int occurrencesTotal = 0;
        int occurrencesFinal = 0;
        int oiaux = 0;
        int oiaux2 = 0;
        int oiaux3 = 0;
        double fallos5 [] = {3.8415,5.9915,7.8147,9.4877,11.0705,12.5916,14.0671,15.5073,16.9190,18.3070};
        double fallos10[] = {2.7055,4.6052,6.2514,7.7794,9.2363,10.6446,12.0170,13.3616,14.6837,15.9872};


        for (int t=0; t <= contTable; t++) {
            if (t == 0) {
                oiaux = contador0.size();
            }
            else if (t > 0 && t < contTable) {
                oiaux = Collections.frequency(contador, t);
            }
            else {
                newCont = t;
                while (newCont <= getLastElement(contador)) {
                    oiaux = Collections.frequency(contador, newCont);
                    oiaux2 = oiaux2 + oiaux;
                    newCont ++;
                }
                oiaux2 = oiaux2 - oiaux;
            }

            oiaux3 = oiaux3 + oiaux;
            oiaux3 = oiaux3 + oiaux2;
        }

        double rest = 0;
        double chi = 0;
        double sumaChi = 0;
        for (int k=0; k <= contTable; k++) {

            if (k == 0) {
                pi = o;
                occurrences = contador0.size();
                ei = oiaux3 * o;
                rest = occurrences - ei;
                chi = Math.pow(rest, 2) / ei;
                System.out.println(((k) + "\t") + (formato1.format(pi)) + "\t"
                        + (contador0.size() + "\t") + (formato1.format(ei) + "\t")
                        + (formato1.format(rest) + "\t\t" + formato1.format(chi)));
            }
            else if (k > 0 && k < contTable) {
                occurrences = Collections.frequency(contador, k);
                pi = Math.pow((1 - o),k) * o ;
                ei = oiaux3 * (Math.pow((1 - o),k) * o);
                rest = occurrences - ei;
                chi = Math.pow(rest, 2) / ei;
                System.out.println(((k) + "\t") + (formato1.format(pi)) + "\t"
                        + (occurrences + "\t") + (formato1.format(ei) + "\t") +
                        (formato1.format(rest) + "\t\t" + formato1.format(chi)));
            }
            else {
                newCont = k;
                while (newCont <= getLastElement(contador)) {
                    occurrences = Collections.frequency(contador, newCont);
                    occurrencesFinal = occurrencesFinal + occurrences;

                    newCont ++;
                }

                pi = Math.pow((1 - o),k);
                ei = oiaux3 * (Math.pow((1 - o),k));
                rest = occurrencesFinal - ei;
                chi = Math.pow(rest, 2) / ei;
                System.out.println(((k) + "\t") + (formato1.format(pi)) + "\t"
                        + (occurrencesFinal + "\t") + (formato1.format(ei) + "\t")
                        + (formato1.format(rest)+ "\t\t"+ formato1.format(chi)));
                occurrencesFinal = occurrencesFinal - occurrences;
            }
            piTotal = piTotal + pi;

            occurrencesTotal = occurrencesTotal + occurrences;
            occurrencesTotal = occurrencesTotal + occurrencesFinal;
            eiTotal = eiTotal + ei;
            sumaChi = sumaChi + chi;

        }
        System.out.println(("Sumas" + "\t") + (piTotal) + "\t"
                + (occurrencesTotal + "\t") + formato2.format(eiTotal) + "\t\t\t" + formato1.format(sumaChi) );
        String validation = "";
        System.out.println();
        for (int s=0; s < 10; s++ ) {
            if (contTable == (s+1) && probability == 5) {
                validation = getValidation(sumaChi, fallos5[s]);
                System.out.println(validation);
            }
            else if (contTable == (s+1) && probability == 10) {
                validation = getValidation(sumaChi, fallos10[s]);
                System.out.println(validation);
            }
        }
    }

    static int getTable (List<Integer> acomodo) {
        int contTable = 0;
        for (int j=0; j < acomodo.size(); j++) {
            if (acomodo.get(j) == (j+1)) {
                contTable++;
            }
            else {
                contTable++;
                return contTable;
            }
        }
        return contTable;
    }

    public static <E> E getLastElement(ArrayList<E> list)
    {
        int lastIdx = list.size() - 1;
        E lastElement = list.get(lastIdx);
        return lastElement;
    }

    static String getValidation (double chi, double D) {
        String validation = "";
        if (chi <= D) {
            validation = "Los numeros estan uniformemente distribuidos";
            return validation;
        }
        else {
            validation = "Los numeros no estan uniformemente distribuidos";
            return validation;
        }
    }
}
