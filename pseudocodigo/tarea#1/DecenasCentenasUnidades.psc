Algoritmo DecenasCentenasUnidades
	// Autor: Rogelio Samuel <@rogeliosamuel>
	// Fecha: 04/10/2020
	// Input: Numero entero de 3 cifras
	// Output: centenas, decenas y unidades de un número entero de tres cifras.
	Definir num Como Entero
	Definir decenas Como Real
	Definir MODdecenas Como Real
	Definir centenas Como Real
	Definir MODCentenas Como Real
	Definir RestOfCentena Como Real
	Definir RestOfDecena Como Real
	Escribir 'Un numero entero de 3 cifras: '
	Leer num
	centenas <- num/100
	MODCentenas <- num MOD 100
	// Centena como entero y no como real
	RestOfCentena <- MODCentenas*0.1*0.1
	centenas <- centenas-RestOfCentena
	Si MODCentenas>0 Entonces
		decenas <- MODCentenas/10
		MODdecenas <- MODCentenas MOD 10
		// decena como entero y no como real
		RestOfDecena <- MODdecenas*0.1
		decenas <- decenas-RestOfDecena
		Escribir 'El numero ',num
		Escribir 'Tiene ',centenas,' centenas.'
		Escribir 'Tiene ',decenas,' decenas.'
		Escribir 'Tiene ',MODdecenas,' unidades.'
	SiNo
		Escribir 'El numero ',num
		Escribir 'Tiene ',centenas,' centenas'
	FinSi
FinAlgoritmo
