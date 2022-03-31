package agujas_experimento;
import java.util.Scanner;

public class AgujasB
{
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        double Distancia= 0.025;
        double x1;
        double x2;
        double a;
        double b;
        double Exitos=0;
        double total=0;
        double z;

        System.out.println("Aguja de Buffon");
        System.out.println("¿Cuántas agujas deseas lanzar? ");
        total=leer.nextDouble();

        for (int i=0; i < total; i++)
        {
            a= -1 + Math.random() * 2;
            b= -1 + Math.random() * 2;
            x1 = Math.random();
            x2 = x1 + ( (a * Distancia)/ (Math.pow((Math.pow(a, 2) + Math.pow(b, 2)) , 0.5)) );
            z=0;
            for (int j=0; j < 1 + (1/Distancia); j++ )
            {
                if(x1 < z && z < x2)
                {
                    Exitos++;
                }
                if (x1 > z && z> x2)
                {
                    Exitos++;
                }
                z = z + Distancia;
            }
        }
        System.out.println("asiertos: "+Exitos);

        double piEstimado = (2*total)/ Exitos;

        System.out.println();
        System.out.println("Valor aproximado de pi: "+piEstimado);
    }
}