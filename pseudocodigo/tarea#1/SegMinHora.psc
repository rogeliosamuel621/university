Algoritmo SegMinHoras
	// Autor: Rogelio Samuel <@rogeliosamuel21>
	// Fecha: 02/10/2020
	// input: tiempo en segundos
	// output: El tiempo ingresado expresado en horas, minutos y segundos
	Definir entrySeg Como Real
	Definir seg Como Real
	Definir restOfSeg Como Real
	Definir min Como Real
	Definir minEntero Como Real
	min <- 0
	Definir hora Como Real
	Definir horaEntera Como Real
	hora <- 0
	Escribir 'Digite el tiempo expresado en segundos: '
	Leer entrySeg
	hora <- entrySeg/3600
	horaEntera <- TRUNC(hora) // quitando decimales
	restOfSeg <- entrySeg MOD 3600 // los minutos que sobran de las horas
	min <- restOfSeg/60 // saco los minutos de los segundos que me sobraron de horas
	minEntero <- TRUNC(min) // Quitando decimales
	seg <- restOfSeg MOD 60 // saco los segundos de lo que saco del resto de minutos
	Escribir entrySeg,' segundos es equivalente a: '
	Escribir horaEntera,' hora(s).'
	Escribir minEntero,' minuto(s).'
	Escribir seg,' segundo(s).'
FinAlgoritmo
