	package tarea;
	
	import java.util.Scanner;
	
	public class Exercie11 {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Digite un numero");
			float num1 = sc.nextFloat();
			
			System.out.println("Digite un segundo numero");
			float num2 = sc.nextFloat();
			
			float bigger = (num1 > num2) ? num1 : num2;
			
			System.out.println("El numero mas grander es: " + bigger);
		}
	
	}
