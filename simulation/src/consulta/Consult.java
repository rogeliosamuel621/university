package consulta;

import java.util.ArrayList;
import java.util.Scanner;

public class Consult {

    static String licenciasVendidas;
    static int devolucionLicencia = 25;
    static int repeticiones;
    static int costoLicencia = 75;
    static int nLicenciasD;
    static int nLicencias;
    static int ingxVta;
    static int ingxDev;
    static int utilidad;
    static int costo;
    static int media;
    static int c1 = 0;
    static int c2 = 0;
    static int c3 = 0;
    static int c4 = 0;
    static int c5 = 0;
    static int c6 = 0;
    static double moneda;
    static double valorAleatorio;

    static ArrayList<Integer> utilidades = new ArrayList<>(); // se declara arraylist para guardar valores de la utilidad
    static ArrayList<Double> desvEstandar = new ArrayList<>(); // se declara arraylist para guardar valores de la desviación estándar

    // Método para sumar todas las utilidades
    public static int sumaUtilidades(ArrayList<Integer> numeros) {
        int sum = 0;
        for (int i = 0; i < numeros.size(); i++) {
            sum += numeros.get(i);
        }
        return sum;
    }

    // Método para sumar valores en el proceso de la desviación estándar
    public static int sumaDesvEstandar(ArrayList<Double> numeros) {
        int sum = 0;
        for (int i = 0; i < numeros.size(); i++) {
            sum += numeros.get(i);
        }
        return sum;
    }

    // Método para calcular la desviación estándar
    public static int calculaDesv(ArrayList<Integer> numeros, int media) {
        int sum = 0;
        for (int i = 0; i < numeros.size(); i++) {
            desvEstandar.add(Math.pow(sum = numeros.get(i) - media, 2));
        }
        return sum;
    }

    public static void main(String[] args) {
        //DefaultPieDataset dataset = new DefaultPieDataset(); // se declara objeto para usar la grafica de pastel
        Scanner leer = new Scanner(System.in); // se declara objeto para el escáner

        System.out.println("¿Cuántas veces desea realizar la simulación?");
        repeticiones = leer.nextInt();

        System.out.println("¿Cuántas licencias desea comprar? (100,150,200,250,300)");
        nLicencias = leer.nextInt();

        // Se imprimen las cabeceras de la tabla
        System.out.println("     N\t     N.alegen\t       Licencias vendidas    Licencias devueltas        Costo      IngxVta      IngxDev    Utilidad");
        System.out.println(" ");

        costo = (costoLicencia * nLicencias); // se calcula el costo
        for (int i = 0; i < repeticiones; i++) {
            valorAleatorio = Math.random(); // genera num aleatorio del 0 al 1
            if (valorAleatorio > 0.00 && valorAleatorio <= 0.30) {
                c1++; // se incrementa el dato para mostrar en la gráfica de pastel
                licenciasVendidas = "100";
                nLicenciasD = (nLicencias - Integer.parseInt(licenciasVendidas)); // se calcula el número de licencias devueltas al restar el n de licencias menos las vendidas
                ingxVta = (Integer.parseInt(licenciasVendidas) * 100); // se calcula el ingreso por venta
                ingxDev = (nLicenciasD * 25); // se calcula el ingreso por devolución
                //dataset.setValue(licenciasVendidas, c1);
            } else if (valorAleatorio > 0.30 && valorAleatorio <= 0.50 && nLicencias >= 150) { // se valida que el n de licencias sea mayor o igual que 150
                c2++;
                licenciasVendidas = "150";
                nLicenciasD = (nLicencias - Integer.parseInt(licenciasVendidas));
                ingxVta = (Integer.parseInt(licenciasVendidas) * 100);
                ingxDev = (nLicenciasD * 25);
                //dataset.setValue(licenciasVendidas, c2);
            } else if (valorAleatorio > 0.50 && valorAleatorio <= 0.80 && nLicencias >= 200) {
                c3++;
                licenciasVendidas = "200";
                nLicenciasD = (nLicencias - Integer.parseInt(licenciasVendidas));
                ingxVta = (Integer.parseInt(licenciasVendidas) * 100);
                ingxDev = (nLicenciasD * 25);
                //dataset.setValue(licenciasVendidas, c3);
            } else if (valorAleatorio > 0.80 && valorAleatorio <= 0.95 && nLicencias >= 250) {
                c4++;
                licenciasVendidas = "250";
                nLicenciasD = (nLicencias - Integer.parseInt(licenciasVendidas));
                ingxVta = (Integer.parseInt(licenciasVendidas) * 100);
                ingxDev = (nLicenciasD * 25);
                //dataset.setValue(licenciasVendidas, c4);
            } else if (valorAleatorio > 0.95 && valorAleatorio <= 1.0 && nLicencias >= 300) {
                c5++;
                licenciasVendidas = "300";
                nLicenciasD = (nLicencias - Integer.parseInt(licenciasVendidas));
                ingxVta = (Integer.parseInt(licenciasVendidas) * 100);
                ingxDev = (nLicenciasD * 25);
                //dataset.setValue(licenciasVendidas, c5);
            } else {
                c1++;
                licenciasVendidas = Integer.toString(nLicencias);
                nLicenciasD = (nLicencias - Integer.parseInt(licenciasVendidas));
                ingxVta = (Integer.parseInt(licenciasVendidas) * 100);
                ingxDev = (nLicenciasD * 25);
                //dataset.setValue(licenciasVendidas, c1);
            }
            utilidades.add(utilidad = (ingxVta + ingxDev) - (costo)); // se calcula la utilidad y se agrega en un arreglo
            // se imprimen los valores de la tabla
            System.out.println(String.format("     %d       %s            %s                        %s                 %s       %s         %s            %s", i, Double.toString(valorAleatorio).substring(0, 8), licenciasVendidas, nLicenciasD, costo, ingxVta, ingxDev, utilidad));
        }
        System.out.println("");

        media = (sumaUtilidades(utilidades) / utilidades.size()); // se calcula la media
        System.out.println("La media es: " + media);

        calculaDesv(utilidades, media); // se calcula la desviación eestándar
        System.out.println("La desviación estándar es: " + sumaDesvEstandar(desvEstandar));

        /*JFreeChart chart = ChartFactory.createPieChart(
                "Licencias",
                dataset,
                true,
                true, false);
        ChartPanel panel = new ChartPanel(chart);

        //Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.add(panel);*/

    }

}

