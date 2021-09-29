package servidores;

import queue_example.Node;

public class Servidor
{
    Proceso primero;
    Proceso ultimo;
    int capacidad;
    int cont;

    public Servidor(int capacidad) {
        this.capacidad = capacidad;
    }

    public int NumeroAleatorio(int tope)
    {
        return (int)((Math.random() * tope) + 1);
    }

    public void insert(int value) {
        Proceso node = new Proceso(value);

        if (this.estaLleno()) {
            System.out.println("El servidor esta lleno");
            return;
        }

        if (this.estaVacio()) {
            this.primero = node;
            this.ultimo = node;
            this.cont++;
            return;
        }

        this.ultimo.prev = node;
        this.ultimo = node;
        this.cont++;
    }

    private boolean estaLleno() {
        return this.capacidad == this.cont;
    }

    private boolean estaVacio() {
        return this.cont == 0;
    }
}
