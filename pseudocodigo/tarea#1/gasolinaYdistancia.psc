Algoritmo sin_titulo
	// Author: Rogelio Samuel Moreno Corrales
	// Fecha: 07/10/2020
	// Input: [Total de km recorridos, precio gasolina(por litro), dinero de gasolina gastado en el viaje, tiempo que han tardado(hrs, min)]
	// Output: [Consumo de la gasolina por cada 100km(ltrs, pesos), Consumo de la gasolina (en ltrs, pesos) por km, Velocidad media (en km/h y m/s).]
	Definir kmRecorridos Como Real
	Definir precioGasolinaPorLitro Como Real
	Definir dineroGasolinaGatadoViaje Como Real
	Definir tiempoTardadohrs Como Real
	Definir tiempoTardadomin Como Real
	Definir gasolina100kmLtrs Como Real
	Definir gasolina100kmPrecio Como Real
	Definir gasolina1kmLtrs Como Real
	Definir gasolina1kmPrecio Como Real
	Definir VmediaKM Como Real
	Definir VmediaSeg Como Real
	Escribir 'Digite el total de km recorridos: '
	Leer kmRecorridos
	Escribir 'Digite el precio de la gasolina por litro: '
	Leer precioGasolinaPorLitro
	Escribir 'Digite el dinero gastado de gasolina en el viaje: '
	Leer dineroGasolinaGatadoViaje
	Escribir 'Digite el tiempo que ha tardado (horas): '
	Leer tiempoTardadohrs
	Escribir 'Digite el tiempo que ha tardado (min): '
	Leer tiempoTardadomin
	// ((litros gastados en el viaje) despues (litro por km) despues (litro cada 100 km)
	gasolina100kmLtrs <- ((dineroGasolinaGatadoViaje/precioGasolinaPorLitro)/kmRecorridos)*100
	gasolina100kmPrecio <- gasolina100kmLtrs*10
	gasolina1kmLtrs <- (dineroGasolinaGatadoViaje/precioGasolinaPorLitro)/kmRecorridos
	gasolina1kmPrecio <- gasolina100kmPrecio/100
	VmediaKM <- kmRecorridos/tiempoTardadohrs
	VmediaSeg <- (kmRecorridos*1000)/(tiempoTardadohrs*3600)
	Escribir 'Consumo de gasolina por cada 100km'
	Escribir gasolina100kmLtrs,' litros'
	Escribir gasolina100kmPrecio,' pesos'
	Escribir 'Consumo de gasolina por cada kilometro'
	Escribir gasolina1kmLtrs,' litros'
	Escribir gasolina1kmPrecio,' pesos'
	Escribir 'Velocidad media'
	Escribir VmediaKM,' km/h'
	Escribir VmediaSeg,' m/s'
FinAlgoritmo
