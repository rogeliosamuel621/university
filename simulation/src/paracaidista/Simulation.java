package paracaidista;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Simulation {
    private double masa = 0.0;
    private double resistencia = 0.0;
    private double[] resultados = new double[2000];
    private int numeroDeResultados = 0;

    private final double gravedad = 9.8;
    private DefaultCategoryDataset data = new DefaultCategoryDataset();

    public Simulation(double masa, double resistencia) {
        this.masa = masa;
        this.resistencia = resistencia;
    }

    public void generarSimulacion() {
        for(int i=0; i<2000; i++) {
            this.numeroDeResultados++;
            double resultadoActual = obtenerVelocidad(i);
            this.resultados[i] = resultadoActual;

            boolean esElPrimerResultado = i == 0;

            if (esElPrimerResultado) this.mostrarInicioDeTabla();
            this.mostrarResultado(resultadoActual, i);

            if (esElPrimerResultado) continue;

            boolean elResultadoEsConstante = Double.compare(this.resultados[i-1], this.resultados[i]) == 0;
            if (elResultadoEsConstante) break;
        }
    }

    public void mostrarGrafica() {
        this.guardarInformacionParaLaGrafica(this.numeroDeResultados, this.resultados);
        JFreeChart grafica = this.generarGrafica(this.data);

        ChartPanel panel = new ChartPanel(grafica);

        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(400,200);

        ventana.add(panel);
    }

    private double obtenerVelocidad(int time) {
        return ((this.gravedad*this.masa)/this.resistencia)*(1-Math.pow(Math.E, (-(resistencia/masa)*(time))));
    }

    private void guardarInformacionParaLaGrafica(int numeroDeResultados, double[] resultados) {
        for(int i=0; i<numeroDeResultados; i++){
            this.data.setValue(resultados[i], "Paracaidista", String.valueOf(i+1));
        }
    }

    private JFreeChart generarGrafica(DefaultCategoryDataset informacion) {
        JFreeChart grafica = ChartFactory.createLineChart("Paracaidista", "Distancia", "Velocidad", informacion);
        return grafica;
    }

    private void mostrarResultado(double resultado, int tiempo) {
        System.out.println("             " + (tiempo) +"              |      "+ resultado
                +"\n-----------------------------|-----------------------------");
    }

    private void mostrarInicioDeTabla() {
        System.out.println("-----------------------------|-----------------------------"
                +"\n|            t               |           v                |"
                +"\n-----------------------------|-----------------------------");
    }
}
