package tarea2;

import java.util.Scanner;

public class Promedio {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite la calificacion 1");
		float calificacion1 = sc.nextFloat();
		System.out.println("Digite la calificacion 2");
		float calificacion2 = sc.nextFloat();
		System.out.println("Digite la calificacion 3");
		float calificacion3 = sc.nextFloat();
		
		float promedio = (calificacion1 + calificacion2 + calificacion3) / 3;
		
		System.out.println("El promedio es: " + promedio);
	}
}
