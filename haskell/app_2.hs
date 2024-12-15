mayorArea :: (Float, Float) -> (Float, Float) -> Float
mayorArea (ancho1, alto1) (ancho2, alto2) =
    let area1 = ancho1 * alto1
        area2 = ancho2 * alto2
    in if area1 > area2 then area1 else area2


-- Ejemplo de ejecución
-- mayorArea (5, 10) (8, 7) -> 56.0



esPeriodoExitoso :: String -> Bool
esPeriodoExitoso mes
    | mes == "noviembre" || mes == "diciembre" || mes == "enero" = True
    | otherwise = False

-- Ejemplo de ejecución
-- esPeriodoExitoso "noviembre" -> True
-- esPeriodoExitoso "marzo" -> False


clasificarEdad :: Int -> String
clasificarEdad edad
    | edad >= 0 && edad <= 11 = "Niño"
    | edad >= 12 && edad <= 18 = "Joven"
    | edad >= 19 && edad <= 50 = "Adulto"
    | edad > 50 = "Adulto Mayor"
    | otherwise = "Edad no válida"

-- Ejemplo de ejecución
-- clasificarEdad 8 -> "Niño"
-- clasificarEdad 25 -> "Adulto"
-- clasificarEdad 65 -> "Adulto Mayor"


pagaTenencia :: Int -> Int -> Bool
pagaTenencia añoActual modeloAuto = (añoActual - modeloAuto) >= 10

-- Ejemplo de ejecución
-- pagaTenencia 2024 2010 -> True
-- pagaTenencia 2024 2018 -> False


clasificarCompetencia :: Int -> String
clasificarCompetencia puntaje
    | puntaje >= 95 && puntaje <= 100 = "Sobresaliente"
    | puntaje >= 90 && puntaje <= 94  = "Altamente Competente"
    | puntaje >= 80 && puntaje <= 89  = "Competente"
    | puntaje >= 70 && puntaje <= 79  = "Suficiente"
    | puntaje < 70                    = "No Competente"
    | otherwise                       = "Puntaje no válido"

-- Ejemplo de ejecución
-- clasificarCompetencia 98 -> "Sobresaliente"
-- clasificarCompetencia 85 -> "Competente"
-- clasificarCompetencia 65 -> "No Competente"
