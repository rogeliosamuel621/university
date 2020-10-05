package Introduccion;

import java.io.IOException;

public class Letras {
	 public static void main(String[] args) throws IOException {

	 char primero, ultimo;
	 System.out.println("Introduzca sus Iniciales: " );
	 System.out.print("\t Primer Apellido");
	 primero= (char)(System.in.read());
	 System.out.print("\t Segundo Apellido");
	 ultimo=(char) (System.in.read());
	 System.out.println("Hola, "+primero+"."+ultimo+".!\n");
	 }
	}

