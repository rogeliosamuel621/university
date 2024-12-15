-- module Main where

-- main :: IO ()

-- Realiza las siguientes funciones en Haskell, ejecútalas y anota el resultado de cada ejecución.

-- 1.       Dadas las dimensiones ancho y alto de dos terrenos rectangulares, definir el área del terreno mayor.
-- Función que calcula el área de un terreno
area :: Int -> Int -> Int
area w h = w * h

-- Función para determinar el área mayor usando guardas
terrenoMayor :: Int -> Int -> Int -> Int -> Int
terrenoMayor w1 h1 w2 h2
  | area1 > area2 = area1
  | otherwise = area2
  where
    area1 = area w1 h1
    area2 = area w2 h2

-- Patrones de comparación
terrenoMayorPat :: Int -> Int -> Int -> Int -> Int
terrenoMayorPat w1 h1 w2 h2 = max (area w1 h1) (area w2 h2)


-- 2.       En el estado de Sinaloa el periodo de siembra de hortalizas es entre los meses de noviembre a enero, fuera de esos periodos la siembra no es exitosa. Definir una función en Haskell que determine si la siembra tendrá éxito teniendo como entrada el mes. El resultado debe ser un valor booleano.
-- Función para determinar si la siembra tendrá éxito
siembraExitosa :: Int -> Bool
siembraExitosa mes
  | mes >= 11 || mes <= 1 = True
  | otherwise = False

-- Usando patrones para los meses exitosos
siembraExitosaPat :: Int -> Bool
siembraExitosaPat 11 = True
siembraExitosaPat 12 = True
siembraExitosaPat 1 = True
siembraExitosaPat _ = False


-- 3.       Hacer una función que retorne si una persona es niño (de 0 a 11 años), joven (de 12 a 18 años), adulto (de 19 a 50) y adulto mayor (de 50 o más años).
-- Función para determinar la categoría de edad
categoriaEdad :: Int -> String
categoriaEdad edad
  | edad >= 0 && edad <= 11 = "Niño"
  | edad >= 12 && edad <= 18 = "Joven"
  | edad >= 19 && edad <= 50 = "Adulto"
  | edad > 50 = "Adulto Mayor"
  | otherwise = "Edad inválida"

-- Usando patrones para determinar la categoría
categoriaEdadPat :: Int -> String
categoriaEdadPat edad
  | edad >= 0 && edad <= 11 = "Niño"
  | edad >= 12 && edad <= 18 = "Joven"
  | edad >= 19 && edad <= 50 = "Adulto"
  | edad > 50 = "Adulto Mayor"
  | otherwise = "Edad inválida"

-- 4.       Los autos pagan tenencia se son modelo de diez años atrás al año actual. Hacer una función que dado el año actual y el modelo del auto indique si ese auto pagará tenencia o no.
-- Función para verificar si el auto paga tenencia
pagaTenencia :: Int -> Int -> Bool
pagaTenencia añoActual modelo
  | añoActual - modelo >= 10 = True
  | otherwise = False

-- Usando patrones, aunque en este caso no es común, se aplica para dos casos
pagaTenenciaPat :: Int -> Int -> Bool
pagaTenenciaPat añoActual modelo
  | añoActual - modelo >= 10 = True
  | otherwise = False

-- 5.       En el nuevo modelo de competencias los alumnos son calificados como “Sobresalientes“ si obtienen calificación de 95 a 100, “Altamente Competentes” si su calificación es entre 90 y 94, “Competente” si su calificación es 80 a89, “Suficiente” si obtiene entre 70 y 79, en caso que su calificación sea menor a 70 será “No Competente”. Hacer una función en Haskell que reciba el puntaje y retorne como salida la leyenda de competencia correspondiente.
-- Función para determinar la competencia según la calificación
competencia :: Int -> String
competencia calificacion
  | calificacion >= 95 && calificacion <= 100 = "Sobresaliente"
  | calificacion >= 90 && calificacion <= 94 = "Altamente Competente"
  | calificacion >= 80 && calificacion <= 89 = "Competente"
  | calificacion >= 70 && calificacion <= 79 = "Suficiente"
  | calificacion < 70 = "No Competente"
  | otherwise = "Calificación inválida"

-- Usando patrones para determinar la competencia
competenciaPat :: Int -> String
competenciaPat calificacion
  | calificacion >= 95 && calificacion <= 100 = "Sobresaliente"
  | calificacion >= 90 && calificacion <= 94 = "Altamente Competente"
  | calificacion >= 80 && calificacion <= 89 = "Competente"
  | calificacion >= 70 && calificacion <= 79 = "Suficiente"
  | calificacion < 70 = "No Competente"
  | otherwise = "Calificación inválida"

