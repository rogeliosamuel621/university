package hashtable;

public class Main {
    public static void main(String[] args) {
        CustomHashTable customHashTable = new CustomHashTable();
        System.out.println("Esta vacía? " + (customHashTable.isEmpty() ? "Si" : "No"));

        System.out.println();
        System.out.println("Tamaño de la tabla de hash: " + customHashTable.size());

        System.out.println();
        System.out.println("Agregando un registro");
        customHashTable.add(1, "Uno");

        System.out.println();
        System.out.println("Obtener por key");
        System.out.println("Value: " + customHashTable.getByKey((1)));
    }
}
