package Introduccion;

import java.util.Scanner;

/*
 * Autor: Rogelio Samuel <@rogeliosamuel21>
 * Proposito: Mostrar entrada de datos por la consola+}
 * Fecha: 29/09/2020
 */

public class EntradaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Cual es tu nombre?");
			String nombre;
			
			nombre = sc.nextLine();
			System.out.println("¿Cual es tu edad?");
			
			int edad;
			edad = sc.nextInt();
			
			System.out.println("Buenas tardes " + nombre + ", " + edad + " años");

			
			double variable_double;
			variable_double = sc.nextDouble();
			String cadena;
			cadena = sc.next();
	}

}
