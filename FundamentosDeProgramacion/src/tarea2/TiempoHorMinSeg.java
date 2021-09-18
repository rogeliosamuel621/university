package tarea2;

import java.util.Scanner;

public class TiempoHorMinSeg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite la velocidad(segundos): ");
		int velocidad = sc.nextInt();
		
		System.out.println("Digite la distancia:(metros) ");
		int distancia = sc.nextInt();
		
		int tiempo = distancia / velocidad;
		
		double horas = Math.floor(tiempo / 3600);
		double horasMOD = tiempo % 3600;
		double minutos = Math.floor(horasMOD / 60);
		double segundos = horasMOD % 60;
		
		System.out.println("El tiempo en Horas es: " + horas);
		System.out.println("El tiempo en minutos es: " + minutos);
		System.out.println("El tiempo en segundos es: " + segundos);
	}
}
