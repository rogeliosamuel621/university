package Introduccion;

/*
 * Fecha: 17/09/2020
 * Autor: Rogelio Samuel <@rogeliosamuel21>
 * Proposito: Sacar el promedio de 3 calificaciones
 */

import java.util.Scanner;

public class CalcularPromedio {

	public static void main(String[] args) {
		float calif1 = 0, calif2 = 0, calif3 = 0;
		float prom = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite calificacion 1: ");
		calif1 = sc.nextFloat();
		
		System.out.println("Digite calificacion 2: ");
		calif2 = sc.nextFloat();
		
		System.out.println("Digite calificacion 3: ");
		calif3 = sc.nextFloat();
		
		prom = (calif1 + calif2 + calif3) / 3;
		
		System.out.println("El promedio es: " + prom);
		
		sc.close();

	}

}
