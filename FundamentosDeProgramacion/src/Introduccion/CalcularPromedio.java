package Introduccion;

import java.util.Scanner;

public class CalcularPromedio {

	public static void main(String[] args) {
		float calif1 = 0, calif2 = 0, calif3 = 0;
		float prom = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite calificacion 1: ");
		calif1 = entrada.nextFloat();
		
		System.out.println("Digite calificacion 2: ");
		calif2 = entrada.nextFloat();
		
		System.out.println("Digite calificacion 3: ");
		calif3 = entrada.nextFloat();
		
		prom = (calif1 + calif2 + calif3) / 3;
		
		System.out.println("El promedio es: " + prom);
		
		entrada.close();

	}

}
