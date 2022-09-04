import java.util.Scanner;

public class AtletaHilos extends Thread{
    Scanner dato = new Scanner(System.in);
    String nombre;

    @Override
    public void run() {
        System.out.println("Ingrese el nombre del atleta: ");
        nombre = dato.next();

        for (int i = 0; i <= 50; i++) {
            System.out.println(i + " km ");
        }

        try {
            sleep(3500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\n LLego a la meta " + nombre);
    }

    public static void main(String[] args) {
        AtletaHilos eje = new AtletaHilos();
        eje.start();

        AtletaHilos eje2 = new AtletaHilos();
        eje2.start();
    }


}
