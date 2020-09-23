package Introduccion;
/*Autor: Rogelio Samuel <@rogeliosamue621>
Fecha: 22/09/2020
Proposito: Declarar variables
*/
public class DemoDeclaracionVariables {

	public static void main(String[] args) {
		/* Declaracion de variables
		 Sintaxis: 
		 <Tipo de dato> <nombre de variable> = <Valor inicial>
		 Tambien pueden declarar multiples declaraciones en una misma linea
		 <tipo de dato> <nom_var1> , <nom_var2> , <nomb_var3> ...... <nom_varn>
		 */
		//Declaraciones de variables enteras
		int valor; int valor2 = 99; //Declarando o creando la variable valor
		int valor3,valor4,valor5; //Declare 3 variables de tipo int
		short yvalor1,yvalor2,yvalor3;
		int valor6,valor7; int num_parte = 1141,num_items = 45;
		long sim, jila = 999111444222L;
		long x1 = 23540L;
		byte x12 = 5; //Los valores validos para el byte van desde -128 a 127
		//java siempre realiza la aritmetica de enteros tipo int en 32 bits a menos que 
		//en la operacion intervenga un numero entero long
		short x;
		int a = 42325,b=40000;
		//x = a + b;
		x = (short) (a+b);
		long medidaMilimetros;
		long distanciaMedia;
		long numerosGrandes = 40020L;
		int x2 = 0347; //El subfijo 0 indica que es una constante literal en base 8
		short x3 = 0xABC; //El subfijo 0x indica que es una constante literal en base 16
		short x4 = 0x59;
		//Declaraciones de variables de tipo coma flotante o de punto flotante
		//(float/double)
		float x_valor; //Declara una variable tipo real
		float x_valor1,x_valor2; //Declaracion multiple de variables
		float x_valor3 = 99.99f; //Utilizo el subfijo f para indicar que la constante literal es de tipo float
		double prod = 2.5;
		double d; //En esta linea declaro la variable d como tipo double
		d = 5.65; //Asigna la constante literal 5.65 a la variable d
		float x5 = -1.5F;
		System.out.println("d: " +d);
		System.out.println("x5: " +x5);
		//Declaracion de Caracteres (char)
		//Utiliza el estandar Unicode tiene mas de 30 000 caracteres distintos
		char datoCar;
		char letra = 'A';
		char respuesta = 'S';
		//Existen caracteres que tienen un proposito especial SECUENCIA DE ESCAPE
		char salto = '\n'; //Representa un salto de linea
		char tabulador = '\t'; //Representa un tabulador
		char apostrofe = '\''; //Representa un apostrofe
		//Tipos de datos boolean
		boolean bisiesto;
		bisiesto = true;
		boolean encontrado,bandera;
		encontrado = true; //La variable encontrado toma el valor verdadero
		bandera = false; //La variable bandera toma el valor falso
		encontrado = bandera; 
		int xy = 0;
		encontrado = (xy>1) && (xy<10); //encontrado = falso
		xy = 9;
		boolean estaEnRango;
		estaEnRango = (xy<1) || (xy>15); //El resultado es falso
		//Conversion de tipos
		/*
		 Sintaxis:
		 (nombreTipoDato) expresion
		 */
		double xy1 = 8.5;
		System.out.println(xy1);
		int xy2 = (int) xy1;
		System.out.println(xy2);
		xy1 = 4.3;
		xy2 = (int) xy1;
		System.out.println(xy2);
		xy1 = 4.6;
		xy2 = (int) xy1;
		System.out.println(xy2);
		xy2 = 5;
		xy1 = xy2; //Conversion implicita
		System.out.println(xy1);
		//Constantes
		/*
		 1.- Literales
		 2.- Declaradas
		 */
		//Constantes literales
		double PI = 125678.00;
		long xy3 = 1245656L;
		//Constantes Reales
		/*
		 * 82,347 63 0,63, 47e-4
		 */
		float xy4 = 47e-4f;
		System.out.println(xy4);
		xy4 = 1.2E5f;
		System.out.println(xy4);
	}

}
