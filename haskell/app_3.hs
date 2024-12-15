-- Definir una función que nos diga qué meses corresponden  a cada estación
-- ejemplo: Primavera == Marzo, Abril, Mayo
est :: String -> String
est estacion
  | estacion == "Primavera" = "Marzo, Abril, Mayo"
  | estacion == "Verano" = "Junio, Julio, Agosto"
  | estacion == "Otoño" = "Septiembre, Octubre, Noviembre"
  | estacion == "Invierno" = "Diciembre, Enero, Febrero"
  | otherwise = "Estación no válida"

--Definir la función mcd, tal que (mcd a b) es el máximo común divisor de a y b calculado mediante el algoritmo de Euclides. Por ejemplo, mcd 30 45 == 15
mcd :: Integer -> Integer -> Integer
mcd a b
  | b == 0 = a
  | otherwise = mcd b (mod a b)

-- Calcula el factorial de un numero usando: a) guardas y b) Patrones
fact :: Integer ->  Integer
fact n
  | n == 0 = 1
  | n > 0 = n * fact (n - 1)

-- Decir hacia donde miras si giras 90 grados
girar90 :: String -> String
girar90 posInicial
  | posInicial == "Norte" = "Este"
  | posInicial == "Este" = "Sur"
  | posInicial == "Sur" = "Oeste"
  | posInicial == "Oeste" = "Norte"
  | otherwise = "Dirección no válida"

-- Decir que color sigue en el semaforo a partir del color actual
semaforo :: String -> String
semaforo color
  | color == "Rojo" = "Verde"
  | color == "Amarillo" = "Rojo"
  | color == "Verde" = "Amarillo"
  | otherwise = "Color no válido"

-- Dice si el parametro b es multiplo del parametro a
multiploDe :: Integer -> Integer -> Bool 
multiploDe a b = mod b a == 0

-- Retorna las raíces de una funcion en base a sus coeficientes
-- raices :: Float ->    Float -> Float -> (Float, Float)
-- ???

-- Funcion que reciba un numero y retorne cero
cero :: Integer -> Integer
cero n = 1

-- Recibe la edad de una persona y le dice si puede votar
votar :: Int -> Bool
votar edad = edad >= 18

-- Dice si se presenta examen, estan excentos solo los 100 
excenta :: (Eq a, Num a) => a -> [Char]
excenta calificacion
  | calificacion == 100 = "Excento"
  | otherwise = "Presenta examen"

-- DE AQUI EN ADELANTE DEFINE LAS FIRMAS PARA LAS FUNCIONES

-- Recibe un número y nos dice si esta en el rango 0-9
rango :: Int -> Bool
rango n = n >= 0 && n <= 9

-- recibe un número y nos regresa en una tupla el  previo y siguiente a dicho número
prevSiguiente :: Int -> (Int, Int)
prevSiguiente n = (n - 1, n + 1)

-- Definir una funcion que recibe dos valores booleanos y simula el resultado del AND LOGICO
andLogico :: Bool -> Bool -> Bool
andLogico a b = a && b

-- Recibe un numero y nos retorna su valor absoluto
absoluto :: Int -> Int
absoluto n
  | n < 0 = -n
  | otherwise = n

-- Recibe un numero y nos dice que signo tiene
{- Para enviar parámetros negativos es necesario enviarlos entre parentesis para que Haskell entienda que se trata de un numero, porque si no lo hacemos asi, al detectar el guion asume que se trata de un string. Ejemplo

signo -8 Nos envia mensaje de error de tipos, por el guion al inicio del numero
signo (-8) Nos arrojara la respuesta que hayamos programado
signo 8 Nos arrojara la respuesta que hayamos programado, porque identifica el digito como un numero
-}
signo :: Int -> String
signo n
  | n < 0 = "Negativo"
  | n == 0 = "Cero"
  | otherwise = "Positivo"


-- DE MOMENTO ES TODO, MUCHACHOS
-- SI TIENEN DUDAS LOS ESTARE ATENDIENDO
-- QUE TENGAN UNA HERMOSA TARDE...





