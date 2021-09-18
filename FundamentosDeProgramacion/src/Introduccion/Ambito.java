package Introduccion;

public class Ambito {
	int q;
	void marcas() {
		int a; //variable de marcas
		a = 124;
		q = 1;
		{
			int b; //variable local al bloque
			a = 457;
			q = 2;
			{
				int c; //variable local al bloque
				b = 457; //aquí sí funciona
			}
		}
		{
			int c; //variable local al bloque
			/* b = 457; no funciona */
		}
	}
}
