package puzzle;
import java.util.*;

class Nodo implements Comparable<Nodo> {
    int[][] estado;
    int g; // costo desde el inicio hasta este nodo
    int h; // heurística estimada hasta el estado final
    Nodo padre; // nodo padre para reconstruir el camino

    public Nodo(int[][] estado, int g, Nodo padre) {
        this.estado = estado;
        this.g = g;
        this.h = calcularHeuristica(estado);
        this.padre = padre;
    }

    // Implementar la comparación para la cola de prioridad
    @Override
    public int compareTo(Nodo otro) {
        return (this.g + this.h) - (otro.g + otro.h);
    }

    // Función heurística: Distancia Manhattan
    private int calcularHeuristica(int[][] estado) {
        int heuristica = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int valor = estado[i][j];
                if (valor != 0) {
                    int objetivoX = (valor - 1) / 3;
                    int objetivoY = (valor - 1) % 3;
                    heuristica += Math.abs(i - objetivoX) + Math.abs(j - objetivoY);
                }
            }
        }
        return heuristica;
    }

    // Generar posibles movimientos (hijos) del estado actual
    public List<Nodo> generarHijos() {
        List<Nodo> hijos = new ArrayList<>();
        int[] posicionVacia = encontrarVacio();
        int fila = posicionVacia[0];
        int col = posicionVacia[1];
        int[][] direcciones = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] direccion : direcciones) {
            int nuevaFila = fila + direccion[0];
            int nuevaCol = col + direccion[1];

            if (nuevaFila >= 0 && nuevaFila < 3 && nuevaCol >= 0 && nuevaCol < 3) {
                int[][] nuevoEstado = copiarMatriz(this.estado);
                nuevoEstado[fila][col] = nuevoEstado[nuevaFila][nuevaCol];
                nuevoEstado[nuevaFila][nuevaCol] = 0;
                hijos.add(new Nodo(nuevoEstado, this.g + 1, this));
            }
        }

        return hijos;
    }

    // Encontrar la posición del espacio vacío (0)
    private int[] encontrarVacio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (estado[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Crear una copia de la matriz
    private int[][] copiarMatriz(int[][] matriz) {
        int[][] copia = new int[3][3];
        for (int i = 0; i < 3; i++) {
            copia[i] = matriz[i].clone();
        }
        return copia;
    }

    // Verificar si este nodo es el estado final
    public boolean esObjetivo() {
        int[][] objetivo = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        return Arrays.deepEquals(this.estado, objetivo);
    }

    // Mostrar el estado del tablero
    public void imprimirEstado() {
        for (int[] fila : estado) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

public class Puzzle8 {
    public static void main(String[] args) {
        // Estado inicial
        int[][] estadoInicial = {
                {1, 2, 3},
                {4, 0, 5},
                {7, 8, 6}
        };

        // Aplicar el algoritmo A*
        Nodo solucion = aEstrella(estadoInicial);

        // Imprimir el camino de solución
        if (solucion != null) {
            List<Nodo> camino = new ArrayList<>();
            Nodo actual = solucion;
            while (actual != null) {
                camino.add(actual);
                actual = actual.padre;
            }
            Collections.reverse(camino);
            for (Nodo nodo : camino) {
                nodo.imprimirEstado();
            }
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    // Implementación del algoritmo A*
    public static Nodo aEstrella(int[][] estadoInicial) {
        PriorityQueue<Nodo> frontera = new PriorityQueue<>();
        Set<String> visitados = new HashSet<>();

        Nodo nodoInicial = new Nodo(estadoInicial, 0, null);
        frontera.add(nodoInicial);
        visitados.add(Arrays.deepToString(nodoInicial.estado));

        while (!frontera.isEmpty()) {
            Nodo actual = frontera.poll();

            if (actual.esObjetivo()) {
                return actual;
            }

            for (Nodo hijo : actual.generarHijos()) {
                String estadoHijo = Arrays.deepToString(hijo.estado);
                if (!visitados.contains(estadoHijo)) {
                    frontera.add(hijo);
                    visitados.add(estadoHijo);
                }
            }
        }

        return null; // No se encontró solución
    }
}
