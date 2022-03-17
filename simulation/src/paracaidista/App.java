package paracaidista;

import java.util.Scanner;

public class App{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        float masa = obtenerMasa();
        float resistencia = obtenerResistencia();

        Simulation simulation = new Simulation(masa, resistencia);
        simulation.generarSimulacion();
        simulation.mostrarGrafica();
    }

    static private float obtenerMasa() {
        float masa = 0;
        do {
            System.out.println("Inserte el peso del paracaidista");
            masa = sc.nextFloat();

            if(masa < 1) System.out.println("Inserte un valor valido");

        } while(masa < 1);

        return masa;
    }

    static private float obtenerResistencia() {
        float resistencia = 0;
        do {
            System.out.println("Inserte el coeficiente de resistencia");
            resistencia = sc.nextFloat();

            if(resistencia < 1) System.out.println("Inserte un valor valido");

        } while(resistencia < 1);

        return resistencia;
    }


}