package Introduccion;

/*
 * Ambito de las variables locales
 */

public class DemoVariablesLocales {

	public static void main(String[] args) {
		
		sumar();
	}
	
	static void sumar() {
		int a, b, c;
		a = (int)(Math.random()*999);
		b = (int)(Math.random()*999);
		c = (int)(Math.random()*999);
		int numero = a + b + c;
		
		System.out.println(a + ", " + b + ", " + c);
		System.out.println("Suma de los tres numeros aleatorios es igual a: " + numero);
	}
	
	static void resta() {
		double a, b;
	}

}
