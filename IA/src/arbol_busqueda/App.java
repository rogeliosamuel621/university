package arbol_busqueda;

public class App {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        System.out.println("Antes de ingresar datos: ");
        System.out.println("");
        System.out.println("¿El árbol está vacío? " + arbol.vacio());

        System.out.println("");
        System.out.println("Se ingresan datos");
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("¿El árbol está vacío? " + arbol.vacio());

        System.out.println("");
        System.out.println("Impresión del árbol:");
        arbol.imprimirArbol();

        System.out.println("");
        System.out.println("");
        System.out.print("Buscar nodo:");
        int valorBuscado = 40;
        Nodo nodoBuscado = arbol.buscarNodo(valorBuscado);
        if (nodoBuscado != null) {
            System.out.print("\nNodo con valor " + valorBuscado + " encontrado.");
        } else {
            System.out.print("\nNodo con valor " + valorBuscado + " no encontrado.");
        }
    }
}
