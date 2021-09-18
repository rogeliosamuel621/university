package tarea2;

import java.util.Scanner;

public class CalcularDistancia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite la velocidad");
		int velocidad = sc.nextInt();
		
		System.out.println("Digite el tiempo");
		int tiempo = sc.nextInt();
		
		int distanciaRecorrida = velocidad * tiempo;
		
		System.out.println("La distancia recorrida en metros  es: " + distanciaRecorrida);
	}

}
