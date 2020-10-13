package tarea;

import java.util.Scanner;

public class Exercise8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite un numero con punto decimal");
		float num1 = sc.nextFloat();
		
		System.out.println("Digite otro numero con punto decimal");
		float num2 = sc.nextFloat();
		
		float result = num1 + num2;
		
		System.out.println("La suma de los dos numeros es: " + result);
		
	}
	
}
