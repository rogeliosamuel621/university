package cinco_ejercicios;

import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PSerie extends JPanel {
    public static Scanner sca= new Scanner(System.in);
    static DecimalFormat formato1 = new DecimalFormat("0.00000");
    static int N, op;
    static double ram[];
    static double arr[][];
    static int Oi[][]=new int [5][5];
    static double suma;

    public PSerie(double[] aleatorios) {
        N=aleatorios.length;
        ram = aleatorios;
        startSimulation();
    }

    public static void startSimulation() {
/*
        do {
            System.out.println("Cuantos N muestras desea?");
            N=sca.nextInt();

            System.out.println("-----");

        }while(N<34 || N>100);
 */
        ram=new double [N];
        arr=new double [N][2];

        do {
            System.out.println("Cual error de probabilidad quiere?   1=0.1%   2=0.5%");
            op=sca.nextInt();

            System.out.println("-----");

        }while(op<1 || op>2);

        System.out.println ("Números Aleatorios"); //Generamos los numeros aleatorios
        for (int i=0; i<N ; i++){
            // ram[i]=Math.random();

            System.out.println((i+1)+" \t"+ ram[i]);
        }

        System.out.println ();
        System.out.println ("N "+" \t"+" \tX\t "+" \tY\t"); //Los acomodadmos en coordenadas
        for (int i=0; i<N ; i++){
            if (i == N-1) {
                System.out.println ((i+1)+" \t"+"[" + ram[i] + "," + ram[i] + "]");
                arr[i][0]=ram[i];
                arr[i][1]=ram[i];
            }else {
                System.out.println ((i+1)+" \t"+"[" + ram[i] + "," + ram[i+1] + "]");


                arr[i][0]=ram[i];
                arr[i][1]=ram[i+1];
            }
        } System.out.println ();

        System.out.println ("Coordenadas de los puntos"); // respecto a las celdas.
        for (int i=0; i<arr.length ; i++){ //calculamos los puntos respecto a las celdas solo para X
            if(arr[i][0]< 0.20) {//0
                //llamar metodo Y para calcular las posiciones del los puntos en Y
                Y(i,0);

            }else if(arr[i][0]>0.20 && arr[i][0]<0.40) {//1
                Y(i,1);

            }else if(arr[i][0]>0.40 && arr[i][0]<0.60) {//2
                Y(i,2);

            }else if(arr[i][0]>0.60 && arr[i][0]<0.80) {//3
                Y(i,3);

            }else if(arr[i][0]>0.80 && arr[i][0]<1) {//4
                Y(i,4);

            }

        } System.out.println ();
        System.out.println ("TABLA Oi"); //con las posiciones calculadas de x, y
        //obtenemos la tabla de observados
        for (int i=0; i<Oi.length ; i++) {
            for (int j=0; j<Oi.length ; j++) {
                System.out.print(Oi[i][j] + "\t\t\t");


            }
            System.out.println();
        }
        System.out.println ();
        System.out.println ("Numero Esperado"); // EL numero esperado es igual para cada celda observada
        double Ei= N/Math.pow(5,2);
        System.out.println ("E:"+Ei);
        System.out.println ();
        TablaOE(Oi,Ei);
        System.out.println ();
        double chi=chi(op);

        System.out.print("Comparamos chi cuadrado: ");

        if(suma<=chi) {//1
            System.out.println(suma+" <= "+chi+" \tLos números son independientes");

        }else if(suma > chi) {//2
            System.out.println(suma+" > "+chi+" \tLos números no son independientes");
        }


	/*  JFrame ventana = new JFrame("Prueba de serie");
		PSerie Objeto = new PSerie();
		ventana.add(Objeto);
		ventana.setSize(1000,700);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/


    }

    public static void Y (int i, int X) { //calculamos los puntos respecto a las celdas solo para Y
        int c =1;
        if(arr[i][1]< 0.20) {//0
            Oi[X][0]=Oi[X][0]+c;
            System.out.println ("\t"+"["+X + ",0]");

        }else if(arr[i][1]>0.20 && arr[i][1]<0.40) {//1
            Oi[X][1]=Oi[X][1]+c;
            System.out.println ("\t"+"["+X + ",1]");

        }else if(arr[i][1]>0.40 && arr[i][1]<0.60) {//2
            Oi[X][2]=Oi[X][2]+c;
            System.out.println ("\t"+"["+X + ",2]");

        }else if(arr[i][1]>0.60 && arr[i][1]<0.80) {//3
            Oi[X][3]=Oi[X][3]+c;
            System.out.println ("\t"+"["+X + ",3]");

        }else if(arr[i][1]>0.80 && arr[i][1]<1) {//4
            Oi[X][4]=Oi[X][4]+c
            ;
            System.out.println ("\t"+"["+X + ",4]");

        }
    }
    public static double chi(int op) {  //retorna el valor de chi con respecto al error

        if(op == 1) {//1= 33.1962
            return 33.1962;

        }else if(op== 2) {//2= 36.4150
            return 36.4150;

        }
        return 0;
    }

    public static void TablaOE(int
                                       Oi[][], double Ei) {
        double OE[][]=new double [5][5];
        System.out.println ("TABLA OE");
        System.out.println (" \t"+" 0.2\t "+" \t0.4\t"+" \t0.6\t"+" \t0.8\t"+" \t1.0\t");
        for(int i=0; i<Oi.length; i++) {
            for(int j=0; j<Oi.length; j++) {
                OE[i][j]=Math.pow((Oi[i][j]-Ei),2 )/Ei;
                System.out.print(" \t"+formato1.format(OE[i][j])+ "\t");
                suma=suma+OE[i][j];
            }
            System.out.println();
        }
        System.out.println("Suma total: "+suma);
        //Velazquez Anaya Alexsandra
    }
}
