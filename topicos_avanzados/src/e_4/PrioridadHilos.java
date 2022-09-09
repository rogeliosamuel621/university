package e_4;

public class PrioridadHilos extends Thread{
    int contar;

    static boolean stop = false;
    static String actualNombre;

    PrioridadHilos(String nombre) {
        setName(nombre);
        contar = 0;
        actualNombre = nombre;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(getName() + " iniciando");

        contar++;
        if (actualNombre.compareTo(getName()) != 0) {
            actualNombre = getName();
            System.out.println("En " + actualNombre);
        }

        while (stop == false && contar < 10000000) {
            contar++;
            if (actualNombre.compareTo(getName()) != 0) {
                actualNombre = getName();
                System.out.println("En " + actualNombre);
            }
        }

        stop = true;
        System.out.println();
        System.out.println(getName() + " terminado");
    }
}
