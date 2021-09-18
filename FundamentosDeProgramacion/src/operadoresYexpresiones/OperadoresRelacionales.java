package operadoresYexpresiones;

/*
 * Proposito: Opreciones Relacionales
 * Sintaxis
 * Expresion operador_relacional expresion2
 * expresion1. expresion2 compatibles con java
 * operador relacional mostrado en la tabla de abajo
 * 5 == 4
 * a+b < c-d
 * El resultado de evaluar una expresion relacional es un tipo de dato boolean (true o false)
 * Normalmente en sentencias tipo (if), sentencias de iteracion (while, dowhile, for)
 * Sirve para comprobar una condicion
 */

public class OperadoresRelacionales {

	public static void main(String[] args) {
		/*
		 * OPERADOR 		SIGNIFICADO 		EJEMPLO
		 *   ==                 igual a         a == b
		 *   !=                no igual         a != b
		 *   >                 mayor que        a > b
		 *   <                 menor que        a < b
		 *   >=                mayor o igual    a>=b
		 *   <=                mnor o igual     a <=b
		 */ 
		/*
		 * OPERADORES L�GICOS
		 * OPERADOR 		OPERACION L�GICA 					EJEMPLO
		 * Negacio(!) 			No l�gico            			!(x>=y)
		 * O, exclusiva(^)      Operando_1 ^ operando_2         x<n ^ n>9
		 * Y, l�gica(&&)        Operando_1 && operando_2        m<n && i>j
		 * O, l�gica(||)        Operando_1 || operando_2        a = 5 || n != 10
		 * 
		 *  ----------------------------------------------------------------------
		 *  TABLA DE VERDAD DEL OPERADOR NOT (!)
		 *  ----------------------------------------------------------------------
		 *  OPERANDO(A)       NOT A
		 *  VERDADERO         FALSO
		 *  FALSO             VERDADERO
		 *  
		 *  ----------------------------------------------------------------------
		 *  TABLA DE VERDAD DEL OPERADOR OR (^)
		 *  ----------------------------------------------------------------------
		 *  OPERANDO A OPERANDO B        A^B
		 *  VERDADERO  VERDADERO         FALSO
		 *  VERDADERO  FALSO             VERDADERO
		 *  FALSO      VERDADERO         VERDADERO
		 *  FALSO      FALSO             FALSO
		 *  
		 *  ---------------------------------------------------------------------
		 *  TABLA DE VERDAD DL OPERADOR AND (&&)
		 *  ---------------------------------------------------------------------
		 *  OPERANDO A  OPERANDO B		A && B
		 *  VERDADERO	VERDADERO		VERDADERO
		 *  VERDADERO   FALSO           FALSO
		 *  FALSO       VERDADERO       FALSO
		 *  FALSO       FALSO           FALSO
		 *  
		 *  ---------------------------------------------------------------------
		 *  TABLA DE VERDAD DEL OPERADOR AND (||)
		 *  ---------------------------------------------------------------------
		 *  OPERANDOA   OPERADON B     A || B
		 *  VERDADERO	VERDADERO		VERDADERO
		 *  VERDADERO   FALSO           VERDADERO
		 *  FALSO       VERDADERO       VERDADERO
		 *  FALSO       FALSO           FALSO
		 */
		
		
	/*	
		boolean c;
		c = 3<7;
		System.out.println(c);
		c = 7<3;
		System.out.println(c);
		int a;
		a = 3 + 5;
		double x = 5.75, b = 1, d = 1;
		boolean b1 = b*b >= 5.0 * a * a;
		System.out.println(x <= 5.75);
		char inicial = 'S';
		System.out.println(inicial != 'S');
		
		byte nota = 10;
		if(nota == 9)
			System.out.println("Regular");
			*/
		
		int edad;
		char esMexicano;
		edad = 5;
		esMexicano = 'n';
		
		boolean puedeTenerINE;
		puedeTenerINE = edad>=18 && esMexicano == 's';
		System.out.println(puedeTenerINE);

		int x1 = 5;
		boolean resultadoDeLaCondicion;
		resultadoDeLaCondicion = !(x1 == 5);
		System.out.println(resultadoDeLaCondicion);
		if(edad >= 18 || esMexicano == 's') 
			System.out.println("Ya puedes tramitar INE");
		 else 
			System.out.println("No puedes tener INE");
		
		int a = 6;
		String nombre;
		nombre = "Marinero";
		resultadoDeLaCondicion = a > 5 && nombre == "Marinero";
		System.out.println(resultadoDeLaCondicion);
		resultadoDeLaCondicion = (a > 5)  || (nombre == "Mari Sol");
		System.out.println(resultadoDeLaCondicion);
		double ventas = 0;
		short horas = 0;
		int prima = 0;
		
		if(ventas > 50000 || horas<100) {
			prima = 100000;
		}
		if(!(ventas <2500)) {
			prima = 12500;
		}
		int x = 5;
		int b = 18;
		if (x<5 ^ b<19)
			System.out.println("Par de valores no validos");
		else 
			System.out.println("Par de valores validos");
	}

}
