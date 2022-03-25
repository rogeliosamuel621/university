package metodo_congruencia;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class MainMC
{
    static int a=0;
    static int x=0;
    static int c=0;
    static int m=0;
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        int option;
        boolean control = true;

        do {
            System.out.print("\tMenu\n"
                    + "\n1.- Introducir variables."
                    + "\n2.- Metodos."
                    + "\n3.- Salir."
                    + "\n\nOPCION: ");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Introduzca el valor de a:");
                    a=a();
                    x=x();
                    c=c();
                    m=M();
                    break;
                case 2:
                    System.out.println("primera parte: ");
                    prim_pte();
                    break;
                case 3:
                    control = false;
                    break;
                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }

        }while(control);
    }


    public static int a() {
        int a = leer.nextInt();

        if (!((a%3 == 0) || (a%5 == 0))) return a;

        while ((a%3 == 0) || (a%5 == 0)) {
            System.out.println("El valor de a debe ser un número entero impar, que no deberá ser divisible por 3 ó 5");
            System.out.println("Introduzca un nuevo valor:");
            a=leer.nextInt();
        }

        return a;
    }

    public static int x()
    {
        int x = 0;
        int option;
        boolean control = true;

        do {
            System.out.println("Introducir variable x.");
            System.out.print("\tMenu\n"
                    + "\n1.- Por teclado."
                    + "\n2.- Aleatorio."
                    + "\n\nOPCION: ");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Introducir variable x:");
                    x=xtec(x);
                    control = false;
                    break;
                case 2:
                    x=xal(x);
                    System.out.println("numero aleatorio: " + x);
                    control = false;
                    break;
                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }
        }while(control);
        return x;
    }

    public static int xtec(int x)
    {
        return x = leer.nextInt();
    }

    public static int xal(int x)
    {
        return x = (int) (Math.random()*(100+1));
    }
    public static int c()
    {
        System.out.println("Introduzca el valor de c:");
        int c = leer.nextInt();
        return c%200;
    }

    public static int M()
    {
        int m = 0;
        int option;
        boolean control = true;

        do {
            System.out.println("Introducir variable M.");
            System.out.print("\tMenu\n"
                    + "\n1.- Aleatorio."
                    + "\n2.- Numero primo."
                    + "\n3.- Salir."
                    + "\n\nOPCION: ");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    m=Mal(m);
                    System.out.println("numero aleatorio "+ Mal(m));
                    control = false;
                    break;
                case 2:
                    m=Mprim(m);
                    String str = "El numero primo mas grande posible es:" + m;
                    System.out.println( str );
                    control = false;
                    break;

                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }

        }while(control);
        return m;
    }

    public static int Mal (int m)
    {
        return m =  (int) (Math.random()*(100+1));
    }

    public static int Mprim (int m)
    {
        int numPrimo;
        double limit;

        do {
            System.out.println("digite el numero primo: ");
            numPrimo = leer.nextInt();
            limit = Math.pow(10.0, 15);

            if (numPrimo > limit) System.out.println("Número primo no válido, repita");
        } while (numPrimo > limit);

        return numPrimo;
    }

    public static void prim_pte()
    {
        int rep [] = new int[1000];
        boolean repetido = false;
        boolean last = false;
        int cont=0, prim_pte=0, seg_pte=0;


        while (repetido == false)
        {
            if (x == 0) x = 1;
            rep[cont]=x;
            cont++;
            prim_pte=a*x+c;
            seg_pte=prim_pte%m;
            System.out.println("n    x    ax + c    (ax + c)/m    xn+1");
            System.out.println(cont+"    "+x+"    " +prim_pte+ "    "+seg_pte+"    "+seg_pte);
            x=seg_pte;

            for (int i=0;i<rep.length;i++)
            {
                if(rep[i]==x)
                {
                    prim_pte=a*x+c;
                    seg_pte=prim_pte%m;
                    System.out.println("n    x    ax + c    (ax + c)/m    xn+1");
                    System.out.println((cont + 1) + "    "+x+"    " +prim_pte+ "    "+seg_pte+"    "+seg_pte);
                    repetido=true;
                }
            }
        }
    }

}
