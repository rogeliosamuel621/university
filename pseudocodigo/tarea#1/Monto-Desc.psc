Algoritmo PrecioConDescuento
	// Autor: Rogelio Samuel <@rogeliosamuel21>
	// Fecha: 04/10/2020
	// Input: [Porcentaje del descuento, precio total sin descuento]
	// outpu: monto de una compra con descuento
	Definir total Como Real
	Definir descuento Como Real
	Definir porcentaje Como Real
	Definir precioResultante Como Real
	Escribir 'Digite el monto total sin el descuento: '
	Leer total
	Escribir 'Digite el descuento: '
	Leer descuento
	descuento <- descuento*0.1*0.1
	porcentaje <- total*descuento
	precioResultante <- total-porcentaje
	Escribir descuento
	Escribir porcentaje
	Escribir 'El precio con descuento aplicado es: ',precioResultante
FinAlgoritmo
