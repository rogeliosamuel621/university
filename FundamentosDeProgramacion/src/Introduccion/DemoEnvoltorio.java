package Introduccion;

/*
 * Requerimientos convertir tipos de datos primitivos (int, double, float...)
 * a estyos objetos que envuelven los tipos de datos primitivos wrappers
 * Por ejemplo Integer - int
 * 			   Long - long
 *             Float - float
 *             Double - double
 *             Short - short
 *             Byte - byte
 *             Character - char
 *             Boolean - boolean
 *             Los primero 6 heredan de una suerclase
 */

public class DemoEnvoltorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt("65"));
		System.out.println("65");
		System.out.println("65" + "10");
		System.out.println(Integer.parseInt("65") + Integer.parseInt("10"));
		System.out.println(Float.parseFloat("50"));
	}

}
