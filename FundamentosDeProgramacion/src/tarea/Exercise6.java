package tarea;

import java.util.Scanner;

public class Exercise6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite un numero entero");
		int x = sc.nextInt();
		
		System.out.println("Digite otro numero entero");
		int y = sc.nextInt();
		
		System.out.println("La operacion x/y: " + (x/y));
		System.out.println("La operaciosn x%y: " + (x%y)); 
		
	}

}
