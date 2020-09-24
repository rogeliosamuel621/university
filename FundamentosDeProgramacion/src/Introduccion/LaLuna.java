package Introduccion;

/*
 * Proposito: Ejemplo de declaracion de variable en el punto de ejecucion
 */

public class LaLuna {
	public static void main(String[] args) {
		final int  LUNA = 238857;
		System.out.println("Distancia a la luna " + LUNA + " millas");
		double lunaKilo;
		lunaKilo = LUNA * 1.609;
		System.out.println("En kilometros es: " + lunaKilo + " kilometros");
	}
}
