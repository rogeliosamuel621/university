package tarea;

import java.util.Scanner;

public class Exercise10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite un numero del mes (1 al 12)");
		byte month = sc.nextByte();
		
		
		switch (month) {
		case 1:
			System.out.println("31 dias");
			break;
		case 2:
			System.out.println("29 dias");
			break;
		case 3:
			System.out.println("31 dias");
			break;
		case 4:
			System.out.println("30 dias");
			break;
		case 5:
			System.out.println("31 dias");
			break;
		case 6:
			System.out.println("30 dias");
			break;
		case 7:
			System.out.println("31 dias");
			break;
		case 8:
			System.out.println("31 dias");
			break;
		case 9:
			System.out.println("30 dias");
			break;
		case 10:
			System.out.println("31 dias");
			break;
		case 11:
			System.out.println("30 dias");
			break;
		case 12:
			System.out.println("31 dias");
			break;
		default:
			System.out.println("Debe de ser un numero entre el 1 y el 12");
			System.out.println("Reinice el programa...");
			break;
		}
	}
}
