Algoritmo Monedas
	// Autor: Rogelio Samuel Moreno Corrales
	// Fecha: 08/10/2020
	Definir dinero Como Real
	Definir billetes1000 Como Real
	Definir billetes1000MOD Como Real
	Definir billetes500 Como Real
	Definir billetes500MOD Como Real
	Definir billetes200 Como Real
	Definir billetes200MOD Como Real
	Definir billetes50 Como Real
	Definir billetes50MOD Como Real
	Definir monedas10 Como Real
	Definir monedas10MOD Como Real
	Definir monedas5MOD Como Real
	Definir monedas2 Como Real
	Definir monedas2MOD Como Real
	Definir monedas1 Como Real
	Definir monedas1MOD Como Real
	Escribir 'Digite la cantidad de dinero: '
	Leer dinero
	billetes1000 <- dinero/1000
	billetes1000 <- TRUNC(billetes1000)
	billetes1000MOD <- dinero MOD 1000
	billetes500 <- billetes1000MOD/500
	billetes500 <- TRUNC(billetes500)
	billetes500MOD <- billetes1000MOD MOD 500
	billetes200 <- billetes500MOD/200
	billetes200 <- TRUNC(billetes200)
	billetes200MOD <- billetes500MOD MOD 200
	billetes100 <- billetes200MOD/100
	billetes100 <- TRUNC(billetes100)
	billetes100MOD <- billetes200MOD MOD 100
	billetes50 <- billetes100MOD/50
	billetes50 <- TRUNC(billetes50)
	billetes50MOD <- billetes100MOD MOD 50
	monedas10 <- billetes50MOD/10
	monedas10 <- TRUNC(monedas10)
	monedas10MOD <- billetes50MOD MOD 10
	monedas5 <- monedas10MOD/5
	monedas5 <- TRUNC(monedas5)
	monedas5MOD <- monedas10MOD MOD 5
	monedas2 <- monedas5MOD/2
	monedas2 <- TRUNC(monedas2)
	monedas2MOD <- monedas5MOD MOD 2
	monedas1 <- monedas2MOD/1
	Escribir dinero,' pesos es equivalente a: '
	Escribir billetes1000,' billetes de 1000'
	Escribir billetes500,' billetes de 500'
	Escribir billetes200,' billetes de 200'
	Escribir billetes100,' billetes de 100'
	Escribir billetes50,' billetes de 50'
	Escribir monedas10,' monedas de 10'
	Escribir monedas5,' monedas de 5'
	Escribir monedas2,' monedas de 2'
	Escribir monedas1,' monedas de 1'
FinAlgoritmo
