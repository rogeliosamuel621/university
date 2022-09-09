package e_5;

public class PrioridadHilos extends Thread
{
    int contar;
    String nombre;

    static boolean stop=false;
    static String actualNombre;

    PrioridadHilos(String nombre)
    {
        this.nombre=nombre;
        contar=0;
        actualNombre = nombre;
    }

    public void run()
    {
        System.out.println(nombre+" Iniciando... ");
        while (stop == false && contar < 10000000)
        {
            contar++;
            if (actualNombre.compareTo(nombre) != 0)
            {
                actualNombre = nombre;
                System.out.println("En: " + actualNombre);
            }
        }

        stop = true;

        System.out.println("\n" + nombre + " terminado.");

    }

}

