package tarea2;

import java.util.Scanner;

/*
 *  el n�mero de respuestas correctas, incorrectas y en blanco
 *  
 *  puntaje final
 *  
 *  respuesta correcta tendr� 4 puntos, respuesta incorrecta tendr� -1 
 *  y respuestas en blanco tendr� un valor de 0.
 */

public class Puntaje {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite el numero de respestas correctas");
		int respuestasCorrectas = sc.nextInt() * 4;
		
		System.out.println("Digite el numero de respuestas incorrectas");
		int respestasIncorrectas = sc.nextInt();
		
		System.out.println("Digite el numero de respuestas en blanco");
		int respuestasEnBlanco = sc.nextInt();
		
		
		int puntaje = respuestasCorrectas - respestasIncorrectas;
		
		System.out.println("El puntaje final es: " + puntaje);
	}
}
