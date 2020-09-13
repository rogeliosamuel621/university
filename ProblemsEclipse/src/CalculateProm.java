import java.util.Scanner;

public class CalculateProm {
    private float calif1 = 0, calif2 = 0, calif3 = 0;
    private float prom = 0;

    public CalculateProm() {
        this.getCalifications();
        this.prom();
    }

    private void getCalifications() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digiste la primera calificación: ");
        calif1 = sc.nextFloat();

        System.out.println("Digiste la segunda calificación: ");
        calif2 = sc.nextFloat();

        System.out.println("Digiste la tercera calificación: ");
        calif3 = sc.nextFloat();
    }

    private void prom() {
        this.prom = (this.calif1 + this.calif2 + this.calif3) / 3;
        System.out.println("El promedio de los alumnos es: " + this.prom);
    }
}