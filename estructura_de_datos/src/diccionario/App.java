package diccionario;

import java.util.Scanner;

public class App {
    static Dictionary dictionary = new Dictionary();

    public static void main(String[] args) {
        int res;
        do {
            res = showMenu();
            switch (res) {
                case 1:
                    addRecord();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("debe seleccionar una opcion valida");
                    break;
            }
        }while (res != 3);
    }




    private static int showMenu() {
        Scanner _sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Agregar una palabra");
        System.out.println("2. Buscar una palabra");
        System.out.println("3. Salir");
        System.out.println();
        System.out.println("Escoga una opcion?");
        return _sc.nextInt();
    }

    private static void addRecord() {
        Record recordToInsert = getRecordInformation();
        dictionary.insert(recordToInsert);
    }

    private static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite la palabra");
        String word = sc.next();

        Record record = dictionary.getByword(word);

        if (record == null) {
            System.out.println("El registro no existe");
            System.out.println("Desea agregarlo?");
            String res = sc.next().toLowerCase();

            if (res.equals("si")) {
                addRecord();
            }
            return;
        }

        dictionary.showRecord(record);
    }

    private static Record getRecordInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite la palabra");
        String word = sc.next();
        System.out.println("Digite la definicion");
        String definition = sc.next();

        return new Record(word, definition);
    }

}
