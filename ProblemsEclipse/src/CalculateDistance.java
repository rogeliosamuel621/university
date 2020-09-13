import java.util.Scanner;

public class CalculateDistance {

    private float velocity = 0;
    private float time = 0;
    private float distance = 0;

    public CalculateDistance() {
        this.getData();
        this.showDistance();
    }
    private void getData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite velocidad: ");
        velocity = sc.nextFloat();

        System.out.println("Digite tiempo: ");
        time = sc.nextFloat();
    }

    private void showDistance() {
        this.distance = this.time * this.velocity;

        System.out.println("La distancia es: " + this.distance);
    }
}
