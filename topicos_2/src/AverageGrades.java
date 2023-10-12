import java.util.Scanner;

public class AverageGrades {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el número de alumnos: ");
            int numAlumnos = scanner.nextInt();

            double[] calificaciones = new double[numAlumnos];
            double sumaCalificaciones = 0;

            for (int i = 0; i < numAlumnos; i++) {
                System.out.print("Ingrese la calificación del alumno " + (i + 1) + ": ");
                calificaciones[i] = scanner.nextDouble();
                sumaCalificaciones += calificaciones[i];
            }

            double promedio = sumaCalificaciones / numAlumnos;

            int mayoresIgualesPromedio = 0;
            int menoresPromedio = 0;

            for (int i = 0; i < numAlumnos; i++) {
                if (calificaciones[i] >= promedio) {
                    mayoresIgualesPromedio++;
                } else {
                    menoresPromedio++;
                }
            }

            System.out.println("El promedio del grupo es: " + promedio);
            System.out.println("Alumnos con calificación mayor o igual al promedio: " + mayoresIgualesPromedio);
            System.out.println("Alumnos con calificación menor al promedio: " + menoresPromedio);

            scanner.close();
        }

}
