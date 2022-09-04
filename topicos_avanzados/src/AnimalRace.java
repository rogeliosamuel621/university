import java.util.Scanner;

public class AnimalRace implements Runnable {
    Scanner dato = new Scanner(System.in);
    String nombre;

    @Override
    public void run() {
        System.out.println("Ingrese el nombre del animal: ");
        nombre = dato.next();

        for (int i = 0; i <= 50; i++) {
            System.out.println(nombre + " " + i + " km ");
        }

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\n LLego a la meta " + nombre);
    }

    public static void main(String[] args) {
        AnimalRace animal1 = new AnimalRace();
        Thread subproceso1 = new Thread(animal1);
        subproceso1.start();

        AnimalRace animal2 = new AnimalRace();
        Thread subproceso2 = new Thread(animal2);
        subproceso2.start();

        AnimalRace animal3 = new AnimalRace();
        Thread subproceso3 = new Thread(animal3);
        subproceso3.start();
    }

}
