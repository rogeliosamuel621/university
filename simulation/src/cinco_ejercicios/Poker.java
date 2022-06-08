package cinco_ejercicios;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Poker {
    static int muestra = 0, si;
    static double error = 0;
    static Scanner sc = new Scanner (System.in);
    static double[] global;

    public Poker(double[] randomNumbersProp) {
        global = randomNumbersProp;
        muestra = randomNumbersProp.length;
        try {
            startSimulation();
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    public static void startSimulation() throws ParseException {
        // System.out.println("Introduce el total de muestras que quieres: ");
        // muestra = sc.nextInt();
        probabilidadError();
        ri = new double [muestra];
        pepe = new String [muestra];
        tabla();
    }

    static double numero = 0;
    static DecimalFormat formato1 = new DecimalFormat("0.00000");
    static DecimalFormat formato2 = new DecimalFormat("0.0000");
    static String riString, evento, FEaux;
    static int pa = 0,contpa = 0, contquin = 0, contpok = 0, contfull = 0, contterc = 0, cont2par = 0, cont1par = 0;
    static double [] ri; static int [] FO = new int [7];
    static String [] pepe; static String [] event = new String [7];
    static String [] PE = new String [7]; static String [] FEfalse = new String [7];
    static String [] FEtrue = new String [7]; static double [] FEi = new double [7];
    static double FE = 0, sum = 0;
    static String Sumatoria = " ";

    public static void chikis () {
        double [] x = new double [muestra];
        for (int i = 0; i<ri.length;i++) {
            // numero = (double)(Math.random());
            // x[i]=numero;
            formato1.format(global[i]);
            ri[i] = global[i];
        }
    }

    public static void probabilidadError () {
        System.out.println("Introduzca la probabilidad de error");
        System.out.println("5% o 10%:");
        error = sc.nextDouble();
        if (error != 5 && error !=10) {
            do {
                System.out.println("Error, introduzca una de las probabilidades que se le indica.");
                System.out.println();
                System.out.println("5% o 10%:");
                error = sc.nextDouble();
            } while (error == 5 && error ==10);

        }
    }

    public static String evento (String number) {

        if (number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(4) && number.charAt(2)==number.charAt(5) && number.charAt(2)==number.charAt(6)) {
            evento = "quintilla";
            contquin++;
        }
        else if (number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(4) && number.charAt(2)==number.charAt(5) && number.charAt(2)!=number.charAt(6)
                || number.charAt(2)!=number.charAt(3) && number.charAt(2)==number.charAt(4) && number.charAt(2)==number.charAt(5) && number.charAt(2)==number.charAt(6)
                || number.charAt(2)==number.charAt(3) && number.charAt(2)!=number.charAt(4) && number.charAt(2)==number.charAt(5)&& number.charAt(2)==number.charAt(6)
                || number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(4) && number.charAt(2)!=number.charAt(5)&& number.charAt(2)==number.charAt(6)
                || number.charAt(3)!=number.charAt(2) && number.charAt(3)==number.charAt(4) && number.charAt(3)==number.charAt(5)&& number.charAt(3)==number.charAt(6)) {
            evento = "poker";
            contpok++;
        }
        else if (number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(4) && number.charAt(5)==number.charAt(6)
                || number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(5) && number.charAt(4)==number.charAt(6)
                || number.charAt(2)==number.charAt(4) && number.charAt(2)==number.charAt(5) && number.charAt(3)==number.charAt(6)
                || number.charAt(2)==number.charAt(3) && number.charAt(4)==number.charAt(5) && number.charAt(4)==number.charAt(6)
                || number.charAt(2)==number.charAt(4) && number.charAt(3)==number.charAt(5) && number.charAt(3)==number.charAt(6)
                || number.charAt(2)==number.charAt(5) && number.charAt(3)==number.charAt(4) && number.charAt(3)==number.charAt(6)
                || number.charAt(3)==number.charAt(5) && number.charAt(2)==number.charAt(4) && number.charAt(2)==number.charAt(6)
                || number.charAt(2)==number.charAt(4) && number.charAt(3)==number.charAt(5) && number.charAt(3)==number.charAt(6)
                || number.charAt(4)==number.charAt(5) && number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(6)) {
            evento = "full";
            contfull++;
        }
        else if (number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(4) && number.charAt(5)!=number.charAt(6)
                || number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(5) && number.charAt(4)!=number.charAt(6)
                || number.charAt(2)==number.charAt(5) && number.charAt(2)==number.charAt(6) && number.charAt(3)!=number.charAt(4)
                || number.charAt(2)==number.charAt(4) && number.charAt(2)==number.charAt(5) && number.charAt(3)!=number.charAt(6)
                || number.charAt(3)==number.charAt(4) && number.charAt(3)==number.charAt(5) && number.charAt(2)!=number.charAt(6)
                || number.charAt(2)==number.charAt(3) && number.charAt(2)==number.charAt(6) && number.charAt(3)!=number.charAt(5)
                || number.charAt(4)==number.charAt(5) && number.charAt(4)==number.charAt(6) && number.charAt(2)!=number.charAt(3)
                || number.charAt(5)==number.charAt(6) && number.charAt(5)==number.charAt(2) && number.charAt(3)!=number.charAt(4)
                || number.charAt(5)==number.charAt(6) && number.charAt(5)==number.charAt(3) && number.charAt(2)!=number.charAt(4)){
            evento = "tercia";
            contterc++;
        }
        else if (number.charAt(2)==number.charAt(4) && number.charAt(3)==number.charAt(5)
                || number.charAt(2)==number.charAt(5) && number.charAt(3)==number.charAt(4)
                || number.charAt(2)==number.charAt(4) && number.charAt(3)==number.charAt(6)
                || number.charAt(2)==number.charAt(3) && number.charAt(4)==number.charAt(5)
                || number.charAt(2)==number.charAt(3) && number.charAt(3)==number.charAt(6)
                || number.charAt(2)==number.charAt(3) && number.charAt(5)==number.charAt(6)
                || number.charAt(2)==number.charAt(5) && number.charAt(3)==number.charAt(6)
                || number.charAt(2)==number.charAt(4) && number.charAt(5)==number.charAt(6)
                || number.charAt(2)==number.charAt(5) && number.charAt(4)==number.charAt(6)
                || number.charAt(2)==number.charAt(6) && number.charAt(4)==number.charAt(5)
                || number.charAt(2)==number.charAt(6) && number.charAt(3)==number.charAt(4)
                || number.charAt(2)==number.charAt(6) && number.charAt(3)==number.charAt(5)
                || number.charAt(3)==number.charAt(4) && number.charAt(5)==number.charAt(6)
                || number.charAt(3)==number.charAt(5) && number.charAt(4)==number.charAt(6)
                || number.charAt(3)==number.charAt(6) && number.charAt(4)==number.charAt(5)){
            evento = "2 pares";
            cont2par++;
        }
        else if (number.charAt(2)==number.charAt(3)
                || number.charAt(2)==number.charAt(4)
                || number.charAt(2)==number.charAt(5)
                || number.charAt(2)==number.charAt(6)
                || number.charAt(3)==number.charAt(4)
                || number.charAt(3)==number.charAt(5)
                || number.charAt(3)==number.charAt(6)
                || number.charAt(4)==number.charAt(5)
                || number.charAt(4)==number.charAt(6)
                || number.charAt(5)==number.charAt(6)) {
            evento = "1 par";
            cont1par++;
        }
        else if (number.charAt(2)!=number.charAt(3) && number.charAt(2)!=number.charAt(4) && number.charAt(2)!=number.charAt(5) && number.charAt(2)!=number.charAt(6)
                && number.charAt(3)!=number.charAt(2) && number.charAt(3)!=number.charAt(4) && number.charAt(3)!=number.charAt(5)&& number.charAt(3)!=number.charAt(6)
                && number.charAt(4)!=number.charAt(2) && number.charAt(4)!=number.charAt(3) && number.charAt(4)!=number.charAt(5) && number.charAt(4)!=number.charAt(6)
                && number.charAt(5)!=number.charAt(2) && number.charAt(5)!=number.charAt(3) && number.charAt(5)!=number.charAt(4) &&number.charAt(5)!=number.charAt(6)
                && number.charAt(6)!=number.charAt(2) && number.charAt(6)!=number.charAt(3) && number.charAt(6)!=number.charAt(4) &&number.charAt(6)!=number.charAt(5)) {
            evento = "pachuca";
            contpa++;
        }
        return evento;
    }



    public static void event () {
        String [] s = new String [7];
        for (int i = 0; i<event.length;i++) {
            s[0]="Pachuca  ";
            s[1]="Un par   ";
            s[2]="Tercia   ";
            s[3]="2 Pares  ";
            s[4]="Full     ";
            s[5]="Poker    ";
            s[6]="Quintilla";

            event[i] = s[i];
        }
    }

    public static void FO () {
        int [] c = new int [7];
        for (int i = 0; i<event.length;i++) {
            c[0]=contpa;
            c[1]=cont1par;
            c[2]=contterc;
            c[3]=cont2par;
            c[4]=contfull;
            c[5]=contpok;
            c[6]=contquin;

            FO[i] = c[i];
        }
    }

    public static void PE () {
        String [] p = new String [7];
        for (int i = 0; i<event.length;i++) {
            p[0]="0.3024";
            p[1]="0.5040";
            p[2]="0.0720";
            p[3]="0.1080";
            p[4]="0.0090";
            p[5]="0.0045";
            p[6]="0.0001";

            PE[i] = p[i];
        }
    }

    public static String FEfalse () {
        double [] p = new double [7];
        for (int i = 0; i<event.length;i++) {
            p[0]=0.3024*muestra;
            p[1]=0.5040*muestra;
            p[2]=0.0720*muestra;
            p[3]=0.1080*muestra;
            p[4]=0.0090*muestra;
            p[5]=0.0045*muestra;
            p[6]=0.0001*muestra;

            FEfalse[i] = formato2.format(p[i]);
            FEaux = FEfalse[i];

            FE = Double.parseDouble(FEaux);
            double cuadrado = Math.pow((FE-FO[i]), 2);
            FEtrue[i] = formato2.format(cuadrado/p[i]);
            FEi[i] = cuadrado/p[i];
            Sumatoria = formato2.format(FEi[0] + FEi[1] + FEi[2] + FEi[3] + FEi[4] + FEi[5] + FEi[6]) ;
            sum = FEi[0] + FEi[1] + FEi[2] + FEi[3] + FEi[4] + FEi[5] + FEi[6];
        }


        return FEaux;
    }

    public static void independientes () {
        if (error==5) {

            if (sum <= 12.5916) {
                System.out.println(formato2.format(sum) + " <= 12.5916");
                System.out.println("Los numeros son idependientes");
            }
            else {
                System.out.println(formato2.format(sum) + " <= 12.5916");
                System.out.println("Los numeros son dependientes");
            }
        }
        if (error==10) {

            if (sum <= 10.6446) {
                System.out.println(formato2.format(sum) + " <= 10.6446");
                System.out.println("Los numeros son idependientes");
            }
            else {
                System.out.println(formato2.format(sum) + " <= 10.6446");
                System.out.println("Los numeros son dependientes");
            }
        }
    }

    public static void tabla () {
        chikis();
        event();
        PE();

        int n= 01;

        System.out.println(" n " + "     ri     " + "evento");
        for (int i=0;i<ri.length;i++) {
            pepe [i] = formato1.format(ri[i]);
            System.out.println(n + "   " + formato1.format(ri[i])+ "   "+(evento = evento(pepe[i])));
            n++;
            FO();
            FEfalse();
        }

        System.out.println();
        System.out.println("Evento       FO     PE       FE        FEi");
        for (int i=0;i<event.length;i++) {
            System.out.println(event[i]+ "    " + FO[i]+ "   " + PE[i] + "   " + FEfalse[i] + "    " + FEtrue[i]);
        }
        System.out.println();
        System.out.println("Sumatoria FEi " + Sumatoria);
        System.out.println();
        independientes();
    }
}
