package diccionario;

public class App {
    public static void main(String[] args) {
        Record record1 = new Record("primera", "funciona");
        Record record2 = new Record("segunda", "por");
        Record record3 = new Record("tercera", "favor");

        Dictionary dictionary = new Dictionary();

        dictionary.insert(record1);
        dictionary.insert(record2);
        dictionary.insert(record3);

        dictionary.showDictionary();

    }

}
