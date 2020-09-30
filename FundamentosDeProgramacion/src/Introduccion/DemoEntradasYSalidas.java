package Introduccion;

import java.util.Scanner;

/*
 * En java las entradas y salidas se escribe en flujos (streams)
 * Esto se puede dar por medio del teclado (entrada) por medio de la pantall (salida)
 * Las clases utilizadas:
 * 	  System.in	    entrada de teclado
 * 	  System.out 	para salida por pantalla
 */

public class DemoEntradasYSalidas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Esto es una cadena");
		
		/*
		 * print() Transfiere una cadena al buffer de la pantalla 
		 * println() Transfiere una adena al buffer de la pantall y el caracter de fin de linea
		 * flush() El buffer con las cadenas almacenadas se imprimen en pantalla
		 */
		
		System.out.print("Un viaje submarino" + " a los confines" + " del mundo");
		System.out.println("Fin");
		
		int x = 500;
		System.out.print(x);
		
		double r = 2.0;
		double area = Math.PI * r * r;
		System.out.println("Radio: " + r + '+' + " Area = " + area );
		System.out.println("\n Error - Pulsar una tecla para continuar \n");
		System.out.println("Esa sal de sale \n" +
							"a la sala \n" +
							"de mi casa");
		
		int num = 12;
		int num2 = 12345;
		System.out.print(num2);
		System.out.print(num);
		System.out.printf("%d\n", num2);
		System.out.printf("%5d\n", num);
		System.out.printf("");
		int contador = 99;
		System.out.printf("El valor es %d. \n", contador);
		
		/*
		 * La clase Scanner
		 */
		
		Scanner entrada = new Scanner(System.in);
		//Primero creo el objeto Scanner con el constructor new System.in
		
		System.out.print("Introduzca una cantidad: ");
		int cantidad;
		cantidad = entrada.nextInt();
		
		System.out.print("Introduzca precio: ");
		double precio = entrada.nextDouble();
		
		System.out.printf("Cantidad a pagar es %f$.\n ", cantidad * precio);
		
		System.out.println("¿Cual es tu nombre? ");
		String nombre;
		//nombre = entrada.next(); //string sin espacios 
		entrada.next();
		nombre = entrada.nextLine(); //string completo
		System.out.println("Mucho gusto " + nombre);

	}

}
