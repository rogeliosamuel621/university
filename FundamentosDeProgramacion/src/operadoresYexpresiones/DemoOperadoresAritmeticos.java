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
		
		a = 5;
		b = 2;
		a += b;
		System.out.println(a);
		
		a = 5;
		b = 6;
		a -= b;
		System.out.println(a);
		
		//TABLA DE OPERACIONES EN JAVA
				/*
				 	* SIMBOLO			USO			DESCRIPCION
				 	* = 				A=B 		Asigna un valor
				 	* = 				A=B 		Multiplica  A por B y el resultado ser asignado A
				 	* /= 				A/=B 		Lo mismo que la multiplicacion solo que divide
				 	* %= 				A%=B 		Fija A al residuo o resposte de divir
				 	* -= 				A-=B   		Realiza resta y el resultado se asignara A
				 	* += 				A+=B 		Lo mismo que la resta pero en suma|
				*/
		System.out.println("suma = " + (4+5));
		System.out.println("Resta = " + (7-5));
		System.out.println("Producto = " + (4*5));
		System.out.println("Division = " + (8/5));
		System.out.println("Division = " + (8.0/5.0));
		System.out.println("Division = " + (12%5));
		
		/*
		 * PRECEDENCIA DE OPERADORES MATEMÁTICAS BÁSICOS
		 * OPERADOR           OPERACIONES             NIVERL DE PRECEDENCIA
		 * 
		 * + - (UNARIO)                                       1
		 * *,/,%                                              2
		 * + -                                                3
		 * 
		 * Ej.  6 + 2 + 3 - 4 / 2
		 * 6 + (2*3) - (4/2) = 6 + 6 - 2;
		 * 
		 * Ej. 5 * (5+(6-2) + 1);
		 *     5 * (5+4+1)
		 *     5*(10)
		 *     50
		 *     
		 * ASOCItividad
		 * r = 3;
		 * r * 4 + 5 = 17;
		 * 
		 * x = 8y = z;
		 * 
		 * 7 * 10 - 5 % 3 * 4 + 9
		 * 70 - 5 % 3 * 4 + 9
		 * 70 - 8 + 9
		 * 62
		 * 
		 *USO DE PARENTESIS
		 *Ej. (7 * (10-5) % 3) * 4 + 9
		 *    (35 % 3) * 4 + 9
		 *    2 * 4 + 9
		 *    8 + 9
		 *    17
		 */
		
		System.out.println((7 * (10-5) % 3) * 4 + 9);
		System.out.println(7*10-5%3*4+9);
		
		/*
		 * n++ || ++n0
		 * n-- || --n
		 */
		int n = 0;
		n++;
		System.out.println(n);
		n++;
		System.out.println(n);
		++n;
		System.out.println(n);
		++n;
		System.out.println(n);
		
		int m = 0;
		m = n++; //doesnt work
		m = ++n; //work
		System.out.println(m);
		
		/*
		 * OPERACIONES DE INCREMENTO Y DECREMENTO
		 * INCREMENTACION          DECEMENTACION    
		 * ++n                     --n
		 * n += 1                  n -= 1
		 * n = n + 1;              n = n - 1;
		 */
		n += 2;
		System.out.println(n);
		n -= 5;
		System.out.println(n);
		n += 1;
		
		int m1 = 2;
		System.out.println("Raiz cuadrada de m1 = " + (Math.sqrt(m1)));
		
		System.out.println("m1 * PI = " + (Math.PI * m1));
		System.out.println(Math.exp(m1));
		double n2 = 2.5;
		System.out.println(Math.ceil(n2));
		System.out.println(Math.floor(n2));
		
		
		
		
		
		
		
	}

}
