package newton_raphson_v2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Double> resultados = new ArrayList<Double>();

        String problem = showCoverPage();
        double puntoInicial = pedirPuntoInicial();
        double puntoFinal = pedirPuntoFinal();
        double rangoDeError = pedirRangoDeError();
        int totalDeCasos = pedirTotalDeCasos();
        double x1 = puntoInicial;

        System.out.println();
        System.out.println();
        showResultPage(problem);

        int i = 1;

        while(x1 >= puntoInicial && x1 <= puntoFinal) {

            double x2 = obtenerUnaSolucionSinOutput(x1, rangoDeError);

            if (esRepetido(resultados, x2) && resultados.size() != 0) {
                double valorAnterior = resultados.get(resultados.size() - 1);
                x1 = valorAnterior + 1;
                x2 = obtenerUnaSolucionSinOutput(x1, rangoDeError);
            }

            obtenerUnaSolucion(x1, rangoDeError);

            resultados.add(x2);

            boolean estaEnElLimiteDeNegativos = (Double.compare(x2, -5d) >= 0 && Double.compare(x2, -4d) <= 0);

            x1 = estaEnElLimiteDeNegativos ? 4.000000000000001 : x2 + 0.5;
            System.out.println("La Raíz (" + i + ") de la Ecuación: " + x2);
            System.out.println();

            if (i == totalDeCasos) break;
            i++;
        }
    }

    static private boolean esRepetido(ArrayList<Double> arr, double x) {
        boolean esRepetido = false;
        for(int i=0; i<arr.size(); i++) {

            NumberFormat formatter = new DecimalFormat("###.##");
            String resultadoFormateado = formatter.format(arr.get(i));
            String xEnString = formatter.format(x);

            if (resultadoFormateado.equals(xEnString)) {
                esRepetido = true;
            }
        }

        return esRepetido;
    }

    static private double obtenerUnaSolucion(double x1, double rangoDeError) {
        Calculations calculations = new Calculations();

        double f1 = calculations.getFx(x1);
        double f2 = 0.0;
        double x2;

        int i = 0;

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("N   X1                           F(X1)                        F'(X1)                         X2                          F(X2)");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        do {
            i++;
            double f1Dx = calculations.getFxDx(x1);
            x2 = calculations.newtonRaphsonMethod(x1, f1, f1Dx);
            f2 = calculations.getFx(x2);

            NumberFormat formatter = new DecimalFormat("###.##########");

            String f2Formatted = formatter.format(f2);


            System.out.println(i+"   "+x1+"            "+f1+"            "+f1Dx+"            "+x2+"            "+f2Formatted);

            x1 = x2;
            f1 = f2;

        }while(Math.abs(f2) > rangoDeError);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");


        return x2;
    }

    static private double obtenerUnaSolucionSinOutput(double x1, double rangoDeError) {
        Calculations calculations = new Calculations();

        double f1 = calculations.getFx(x1);
        double f2 = 0.0;
        double x2;

        int i = 0;

        do {
            i++;
            double f1Dx = calculations.getFxDx(x1);
            x2 = calculations.newtonRaphsonMethod(x1, f1, f1Dx);
            f2 = calculations.getFx(x2);

            x1 = x2;
            f1 = f2;

        }while(Math.abs(f2) > rangoDeError);

        return x2;
    }

    static private double pedirPuntoInicial() {
        System.out.println("Digite el punto de inicio: ");
        return sc.nextDouble();
    }

    static private double pedirPuntoFinal(){
        System.out.println("Digite el punto final");
        return sc.nextDouble();
    }

    static private double pedirRangoDeError() {
        System.out.println("Digite el rango de error");
        return sc.nextDouble();
    }

    static private int pedirTotalDeCasos() {
        System.out.println("Digite el total de casos");
        return sc.nextInt();
    }

    static private String showCoverPage() {
        System.out.println("Instituto Tecnológico de Culiacan");
        System.out.println("Ing. en sistemas computacionales \n");
        System.out.println("Meza Valenzuela Alan");
        System.out.println("Moreno Corrales Rogelio Samuel");
        System.out.println("Método de Newton Raphson. Raíces de una Ecuación.");
        System.out.println("De 12:00 a 13:00 horas.\n");

        System.out.println("Este programa ejecuta el proceso de cálculo de Raíces de una ecuación utilizando el método de Newton Raphson.");

        System.out.println("Cuál es la pregunta del Problema:");
        return sc.nextLine();
    }

    static private void showResultPage(String problema) {
        System.out.println("Instituto Tecnológico de Culiacán");
        System.out.println("Ingeniería en sistemas conputacionales");
        System.out.println();
        System.out.println("Meza Valenzuela Alan");
        System.out.println("Moreno Corrales Rogelio Samuel");
        System.out.println("Método de Newton Raphson. Raíces de una Ecuación");
        System.out.println("De 10:00 a 11:00 horas.");
        System.out.println();
        System.out.println("[PREGUNTA]: " + problema);
    }
}
