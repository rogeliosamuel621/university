package newton_raphson;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Newton_Raphson {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Double> resultados = new ArrayList<Double>();

        // Muestra el problema
        System.out.println("Instituto Tecnológico de Culiacan");
        System.out.println("Ing. en sistemas computacionales \n");
        System.out.println("Kevin Fernando López Nájera");
        System.out.println("Método de Newton Raphson. Raíces de una Ecuación.");
        System.out.println("De 10:00 a 11:00 horas.\n");
        System.out.println("Este programa ejecuta el proceso de cálculo de Raíces de una ecuación utilizando el método de Newton Raphson.");
        System.out.println("Cuál es la pregunta del Problema:");
        String textoProblema = leer.nextLine();

        // x1
        System.out.println("Digite x1: ");
        double x1 = leer.nextDouble();
        double puntoInicial = x1;

        // limite
        System.out.println("Digite el limite");
        double limite = leer.nextDouble();

        // rango de error
        System.out.println("Digite el rango de error");
        double error = leer.nextDouble();

        // tc
        System.out.println("Digite el total de casos");
        double tc = leer.nextInt();

        // Reporte
        System.out.println("Instituto Tecnológico de Culiacán");
        System.out.println("Ingeniería en sistemas conputacionales");
        System.out.println();
        System.out.println("Kevin Fernando López Nájera");
        System.out.println("Método de Newton Raphson. Raíces de una Ecuación");
        System.out.println("De 10:00 a 11:00 horas.");
        System.out.println();
        System.out.println("[PREGUNTA]: " + textoProblema);

        int cont = 1;
        while(x1 >= puntoInicial && x1 <= limite) {
            double x2 = solucionA(x1, error);

            boolean valida = false;
            for(int i=0; i<resultados.size(); i++) {
                NumberFormat f = new DecimalFormat("###.##");
                String resultado2 = f.format(resultados.get(i));
                String xEnString = f.format(x2);
                if (resultado2.equals(xEnString)) valida = true;
            }

            if (valida && resultados.size() != 0) {
                double prev = resultados.get(resultados.size() - 1);
                x1 = prev + 1;
                x2 = solucionA(x1, error);
            }

            double f1 = x1 * (Math.cos(x1 * x1)) - 4;
            double f2 = 0.0;
            double x2_2;
            int cont2 = 0;
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("N   X1                            F(X1)                         F'(X1)                          X2                           F(X2)");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            do {
                cont2++;
                double f1Dx = Math.cos(x1 * x1) - ((2 * (x1 * x1)) * Math.sin(x1 * x1));
                x2_2 = x1 - (f1 / f1Dx);
                f2 = x2_2 * (Math.cos(x2_2 * x2_2)) - 4;

                NumberFormat formatter = new DecimalFormat("###.##########");

                String f2Formatted = formatter.format(f2);


                System.out.println(cont2+"   "+x1+"            "+f1+"            "+f1Dx+"            "+x2_2+"            "+f2Formatted);

                x1 = x2_2;
                f1 = f2;

            }while(Math.abs(f2) > error);

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

            resultados.add(x2);
            boolean esLimite = (Double.compare(x2, -5d) >= 0 && Double.compare(x2, -4d) <= 0);
            if (esLimite) x1 = 4.00000000000001;else { x1 = x2 + 0.5; }
            System.out.println("La Raíz de la Ecuación: " + x2);
            System.out.println();

            // si es igual a total de casos se para
            if (cont == tc) break;
            cont++;
        }
    }

    static private double solucionA(double x1, double error) {
        double f1 = x1 * (Math.cos(x1 * x1)) - 4;
        double f2 = 0.0, x2;
        do {
            double f1Dx = Math.cos(x1 * x1) - ((2 * (x1 * x1)) * Math.sin(x1 * x1));
            x2 = x1 - (f1 / f1Dx);
            f2 = x2 * (Math.cos(x2 * x2)) - 4;
            x1 = x2;
            f1 = f2;
        }while(Math.abs(f2) > error);
        return x2;
    }
}
