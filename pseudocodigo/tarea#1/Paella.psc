Algoritmo Paella
	Definir comensales Como Entero
	Definir precioArroz Como Real
	Definir precioCamarones Como Real
	Definir cantidadArroz Como Real
	Definir cantidadCamarones Como Real
	Definir costoCamarones Como Real
	Definir costoarroz Como Real
	Definir preciototal Como Real
	Escribir 'Digite el numero de comensales: '
	Leer comensales
	Escribir 'Digite el precio del arroz: '
	Leer precioArroz
	Escribir 'igite el precio de los camarones: '
	Leer precioCamarones
	cantidadArroz <- comensales*0.5/4
	cantidadCamarones <- comensales*0.25/4
	precioArroz <- cantidadArroz*precioArroz
	precioCamarones <- cantidadCamarones*precioCamarones
	preciototal <- precioArroz+precioCamarones
	Escribir 'Cantidad de los ingredientes necesarios: '
	Escribir cantidadArroz
	Escribir cantidadCamarones
	Escribir 'Precio de los ingredientes: '
	Escribir precioArroz
	Escribir precioCamarones
	Escribir 'Precio total: '
	Escribir preciototal
FinAlgoritmo
