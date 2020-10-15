package tarea;

import java.util.Scanner;

public class Exercise10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite un numero del mes (1 al 12)");
		byte month = sc.nextByte();
		
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("31 dias");
			return;
		}
		
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("30 dias");
			return;
		}
		
		if(month == 2) {
			System.out.println("29 dias");
			return;
		}
		
		//Default case
		System.out.println("Debe de digitar un numero entre 1 y 12");
	}
}
