package operadoresYexpresiones;

/*
 * Expresion: Es un elemento de un programa que toma un valor 
 * en algunos casos, puede realizar una operacion. tambien puede ser una
 * constante a una variable simple, a un valor a una variable
 * combinado con operadores.
 * 
 *  Ej. a = b + c
 *  
 *   SINTAXIS:
 *   variable = expresion
 *   variable: identificador válido de java, declarado como una variable
 *   expresion: constante, otra variable con un valor previamente asignada o una fórmula
 *              evaluada de tipo de variable
 */

public class DemoOperadoresAritmeticos {

	public static void main(String[] args) {
		// OPERADOR DE ASIGNACION
		int codigo = 22;
		int coordX = 525;
		int coordY = 725;
		
		byte a, b, c;
		a = b = c = 45;
		a = (b = (c = 45));
		
		//TABLA DE OPREADORES EN JAVA
		/*
		 * SIMBOLO  USO    DESCRIPCION
		 * 
		 *    =     a=b    Asigna el valor de b para a
		 *    *=    a*=b   Multiplica a * b y asigna el resultado en la variable a
		 *    /=    a/=b   Divide a / b y asigna el resultado a la variable a
		 *    %=    a%=b   Fija al residuo de a/b
		 *    
		 */
		
		a = 3;
		b = 8;
		a *= b;
		System.out.println("Valor de a = " + a);
		
		a = 10;
		b = 5;
		a /= b;
		System.out.println("Valorde a = "+ a);
		
		a = 10;
		b = 3;
		a %= b;
		System.out.println("El valor de a = " + a);
		float a1 = 10, a2 = 3;
		a1 %= a2;
		System.out.println("El valor de a = " + a1);
		
	}

}
