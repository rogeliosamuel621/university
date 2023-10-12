package simu;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Montecarlo {

	public static char generarTipo() {
		double r = Math.random();
		char tipoCarta;

		if (r <= 0.25) {
			tipoCarta = 'O';
		} else if (r <= 0.50) {
			tipoCarta = 'C';
		} else if (r <= 0.75) {
			tipoCarta = 'E';
		} else {
			tipoCarta = 'P';
		}

		return tipoCarta;
	}

	public static int generarNumeroCarta() {
		double r = Math.random();
		int numCarta;

		if (r <= 0.1) {
			numCarta = 13;
		} else if (r <= 0.2) {
			numCarta = 2;
		} else if (r <= 0.3) {
			numCarta = 3;
		} else if (r <= 0.4) {
			numCarta = 4;
		} else if (r <= 0.5) {
			numCarta = 5;
		} else if (r <= 0.6) {
			numCarta = 6;
		} else if (r <= 0.7) {
			numCarta = 7;
		} else if (r <= 0.8) {
			numCarta = 10;
		} else if (r <= 0.9) {
			numCarta = 11;
		} else {
			numCarta = 12;
		}

		return numCarta;
	}
}