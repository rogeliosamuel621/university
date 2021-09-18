package tarea;

import java.util.Scanner;

public class Exercise7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int superficie = 0;
		
		System.out.println("Digite la longitud de la abitacion en metros: ");
		int longitud = sc.nextInt();
		
		System.out.println("Digite la anchura de la habitacion en metros: ");
		int anchura = sc.nextInt();
		
		superficie = longitud * anchura;
		
		System.out.println("La superficie es: " + superficie + " metros cuadrados");
		
	}
}
