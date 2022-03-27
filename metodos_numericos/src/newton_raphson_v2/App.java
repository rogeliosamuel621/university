package newton_raphson_v2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Double> resultados = new ArrayList<Double>();

        double puntoInicial = pedirPuntoInicial();
        double puntoFinal = pedirPuntoFinal();
        double rangoDeError = pedirRangoDeError();
        double x1 = puntoInicial;

        int i=0;

        while(x1 >= puntoInicial && x1 <= puntoFinal) {

            double x2 = obtenerUnaSolucionSinOutput(x1, rangoDeError);

            if (esRepetido(resultados, x2) && resultados.size() != 0) {
                System.out.println("REPETIDO");
                double valorAnterior = resultados.get(resultados.size() - 1);
                x1 = valorAnterior + 1;
                x2 = obtenerUnaSolucionSinOutput(x1, rangoDeError);
            }

            obtenerUnaSolucion(x1, rangoDeError);

            resultados.add(x2);
            x1 = x2 + 0.5;
            System.out.println();
            System.out.println("la solucion es: " + x2);

            // if (i == 200) break;
            i++;
        }
    }

    static private boolean esRepetido(ArrayList<Double> arr, double x) {
        boolean esRepetido = false;
        for(int i=0; i<arr.size(); i++) {

            NumberFormat formatter = new DecimalFormat("###.##");
            String resultadoFormateado = formatter.format(arr.get(i));
            String xEnString = formatter.format(x);

            /*
            System.out.println();
            System.out.println("[RESULTADO]: " + resultadoFormateado);
            System.out.println("[X]:         " + xEnString);
            System.out.println();
            */

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

        do {
            i++;
            double f1Dx = calculations.getFxDx(x1);
            x2 = calculations.newtonRaphsonMethod(x1, f1, f1Dx);
            f2 = calculations.getFx(x2);

            NumberFormat formatter = new DecimalFormat("###.##########");

            String f2Formatted = formatter.format(f2);

            System.out.println(i + " x1: " + x1 + " F(x1): " + f1 + " F'(x1): " + f1Dx + " X2: " + x2 + " F(x2): " + f2Formatted);

            x1 = x2;
            f1 = f2;

        }while(Math.abs(f2) > rangoDeError);

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
}
