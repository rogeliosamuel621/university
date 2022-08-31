package e_3;

public class HelloThreadBef extends Thread {
    private String Nombre;

    HelloThreadBef(String name)
    {
        Nombre=name;
    }

    public void run ()
    {
        for (int i=0; i < 20; i++)
        {
            System.out.println(i + " " + Nombre);
        }
        System.out.println("- " + Nombre + " Thread Finished -");
    }

    public static void main(String[] args)
    {
        new HelloThreadBef("Pepe").start();
        new HelloThreadBef("Juan").start();
        System.out.println("--- Main Thread Finished ---");
    }
}
