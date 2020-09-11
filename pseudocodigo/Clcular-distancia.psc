Algoritmo CalculaDistancia
	// Autor: Rogelio Samuel <@rogeliosamuel21>
	// Fecha: 11/09/2020
	// Proposito: Calcular la distancia de un movial, conociendo la velocidad (m/s) y el tiempo recorrido
	// v = D/T
	Definir Velocidad Como Entero
	Definir Tiempo Como Entero
	Definir Distancia Como Entero
	Escribir 'Digite la velocidad (m/s): '
	Leer Velocidad
	Escribir 'Digite el tiempo (s): '
	Leer Tiempo
	Distancia <- Velocidad*Tiempo
	Escribir 'Distancia es: ',Distancia
FinAlgoritmo
