package arbol_busqueda;

class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public boolean vacio() {
        return this.raiz == null;
    }

    public void insertar(int valor) {
        raiz = _insertar(raiz, valor);
    }

    private Nodo _insertar(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierda = _insertar(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = _insertar(raiz.derecha, valor);
        }

        return raiz;
    }

    public Nodo buscarNodo(int valor) {
        return _buscar(raiz, valor);
    }

    private Nodo _buscar(Nodo raiz, int valor) {
        if (raiz == null || raiz.valor == valor) {
            return raiz;
        }

        if (valor < raiz.valor) {
            return _buscar(raiz.izquierda, valor);
        }

        return _buscar(raiz.derecha, valor);
    }

    public void imprimirArbol() {
        _imprimir(raiz);
    }

    private void _imprimir(Nodo raiz) {
        if (raiz != null) {
            _imprimir(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            _imprimir(raiz.derecha);
        }
    }
}