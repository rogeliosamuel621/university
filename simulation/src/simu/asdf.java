package simu;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class asdf extends JFrame{

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		Random r = new Random();

		double n = 0, seleccinado = 0;
		double z = 0, intervalo, random;
		String team = "";
		ArrayList<String> equipos = new ArrayList<>();

		System.out.println("Cuantos equipos son? ");
		n = scn.nextInt();
		intervalo = 1/n; 
		random = r.nextDouble();
		for (int i = 1; i < n+1; i++) {
			z += intervalo;
			if(random <= z) {
				seleccinado = i;
			}	
		}

		for (int i = 0; i < n; i++) {
			team = "Equipo "+(i+1);
			equipos.add(team);

		}

		DefaultPieDataset Datos = new DefaultPieDataset();
		for (int i = 0; i < n; i++) {
			Datos.setValue(equipos.get(i), intervalo);
		}
		JFreeChart grafico_circular = ChartFactory.createPieChart("Tiros de dados",
				Datos,  
				true,
				true, 
				false
				);

		ChartPanel panel = new ChartPanel(grafico_circular);
		panel.setMouseWheelEnabled(true);
		panel.setPreferredSize(new Dimension(400, 200));
		JFrame ventana = new JFrame("Grafica De Aguila o Sello | Equipo 1");
		ventana.setVisible(true);
		ventana.setSize(800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(panel); // Añadimos el panel a la interfaz

		System.out.println("Equipo Ganador: "+seleccinado);

	}

}
