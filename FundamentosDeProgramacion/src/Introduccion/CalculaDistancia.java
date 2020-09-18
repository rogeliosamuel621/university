package Introduccion;

import java.util.Scanner;

public class CalculaDistancia {

	public static void main(String[] args) {
		
		int velocity = 0, time = 0, distance = 0;

		Scanner sc = new Scanner(System.in);
			
		System.out.println("Digite la velocidad: ");
		velocity = sc.nextInt();
		
		System.out.println("Digite el tiempo: ");
		time = sc.nextInt();
		
		distance = velocity * time;
		
		System.out.println("La distancia es: " + distance);
		
		sc.close();
	}

}
