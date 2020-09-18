Algoritmo CalcularPromedio
	// Autor: Rogelio Samuel <@rogeliosamuel21>
	// Fecha: 11/09/2020
	// Proposito: Calcular promedio de un estudiante de 3 calificaciones
	// Entrada: Calificacion 1, calificacion 2, calificacion 3
	// Salida: Promedio
	Definir Calificacion1,Calificacion2,Calificacion3 Como Real
	Definir Promedio Como Real
	Escribir 'Digite la calificacion 1:'
	Leer Calificacion1
	Escribir 'Digite la calificacion 2:'
	Leer Calificacion2
	Escribir 'Digite la calificacion 3:'
	Leer Calificacion3
	Promedio <- (Calificacion1+Calificacion2+Calificacion3)/3
	Escribir 'El promedio es: ',Promedio
FinAlgoritmo
