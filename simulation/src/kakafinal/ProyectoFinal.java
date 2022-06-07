package kakafinal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProyectoFinal {

    DecimalFormat df = new DecimalFormat("0.00000");
    DecimalFormat df2 = new DecimalFormat("00");
    DecimalFormat df3 = new DecimalFormat("#.00");
    int camiones;
    int camionesIniciales;
    boolean comer = true;
    double numeroAleatorio1, numeroAleatorio2, horasExtras, salarioExtra, ocioCamion, totalTiempoEsperaCamion, operacionAlmacen, costosTotales, totalTiempoServicio;
    int salarioNormal, tiempoEntreLlegadas, tiempoServicio, ocioDelPersonal, tiempoEsperaCamion, longitudCola;
    Tiempo horaComida = new Tiempo(15, 0), horaSalida = new Tiempo(19, 30), tiempoLlegada = new Tiempo(11, 0), iniciacionServicio = new Tiempo(11, 0), terminacionServicio;
    static ArrayList<Double> sumaCostosTotalesE3 = new ArrayList<>();
    static ArrayList<Integer> sumaSalarioNormalE3 = new ArrayList<>();
    static ArrayList<Double> sumaSalarioExtraE3 = new ArrayList<>();
    static ArrayList<Double> sumaOcioCamionE3 = new ArrayList<>();
    static ArrayList<Double> sumaOperacionAlmacenE3 = new ArrayList<>();

    static ArrayList<Double> sumaCostosTotalesE4 = new ArrayList<>();
    static ArrayList<Integer> sumaSalarioNormalE4 = new ArrayList<>();
    static ArrayList<Double> sumaSalarioExtraE4 = new ArrayList<>();
    static ArrayList<Double> sumaOcioCamionE4 = new ArrayList<>();
    static ArrayList<Double> sumaOperacionAlmacenE4 = new ArrayList<>();

    static ArrayList<Double> sumaCostosTotalesE5 = new ArrayList<>();
    static ArrayList<Integer> sumaSalarioNormalE5 = new ArrayList<>();
    static ArrayList<Double> sumaSalarioExtraE5 = new ArrayList<>();
    static ArrayList<Double> sumaOcioCamionE5 = new ArrayList<>();
    static ArrayList<Double> sumaOperacionAlmacenE5 = new ArrayList<>();

    static ArrayList<Double> sumaCostosTotalesE6 = new ArrayList<>();
    static ArrayList<Integer> sumaSalarioNormalE6 = new ArrayList<>();
    static ArrayList<Double> sumaSalarioExtraE6 = new ArrayList<>();
    static ArrayList<Double> sumaOcioCamionE6 = new ArrayList<>();
    static ArrayList<Double> sumaOperacionAlmacenE6 = new ArrayList<>();

    public ProyectoFinal(int personal) {
        double p = new Random().nextDouble();
        camionesIniciales = (p <= 0.10 ? 3 : p <= 0.25 ? 2 : p <= 0.50 ? 1 : 0);
        if (p <= 0.50) {
            longitudCola = 0;
        } else if (p > 0.50 && p <= 0.75) {
            longitudCola = 1;
        } else if (p > 0.75 && p <= 0.90) {
            longitudCola = 2;
        } else {
            longitudCola = 3;
        }
        System.out.println("Camiones en espera: " + longitudCola);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Numero aleatorio|\t" + "Tiempo entre llegadas|\t" + "Tiempo de llegada|\t" + "Iniciación del servicio\t\t" + "Número aleatorio\t"
                + "Tiempo de servicio\t" + "Terminación del servicio\t" + "Ocio del personal\t" + "Tiempo de espera del camión\t" + "Longitud de la cola\t");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (true) {
            if (camionesIniciales != 0) {
                numeroAleatorio1 = 0;
                tiempoEntreLlegadas = 0;
                longitudCola = camionesIniciales;
                while (longitudCola != 0) {
                    numeroAleatorio2 = new Random().nextDouble();
                    tiempoServicio = new Metodos().tiempoServicio(numeroAleatorio2, personal);
                    if (iniciacionServicio.horas == 11 && iniciacionServicio.minutos == 0) {
                        terminacionServicio = iniciacionServicio.sumarTiempos(new Tiempo(0, tiempoServicio));
                    } else {
                        iniciacionServicio = terminacionServicio;
                        tiempoEsperaCamion = Math.abs(terminacionServicio.compareToTiempos(tiempoLlegada));
                        ocioDelPersonal = 0;
                        terminacionServicio = iniciacionServicio.sumarTiempos(new Tiempo(0, tiempoServicio));
                    }
                    longitudCola--;
                    System.out.println(df.format(numeroAleatorio1)
                            + "\t\t\t\t" + df2.format(tiempoEntreLlegadas)
                            + "\t\t\t" + tiempoLlegada
                            + "\t\t\t" + iniciacionServicio
                            + "\t\t\t" + df.format(numeroAleatorio2)
                            + "\t\t\t\t" + tiempoServicio
                            + "\t\t\t" + terminacionServicio
                            + "\t\t\t\t" + ocioDelPersonal
                            + "\t\t\t     " + tiempoEsperaCamion
                            + "\t\t\t\t" + longitudCola);
                    iniciacionServicio = terminacionServicio;
                }
                camionesIniciales = 0;
            } else {
                numeroAleatorio1 = new Random().nextDouble();
                tiempoEntreLlegadas = new Metodos().tiempoLlegada(numeroAleatorio1);
                tiempoLlegada = tiempoLlegada.sumarTiempos(new Tiempo(0, tiempoEntreLlegadas));
                numeroAleatorio2 = new Random().nextDouble();
                tiempoServicio = new Metodos().tiempoServicio(numeroAleatorio2, personal);
                totalTiempoServicio += tiempoServicio;
                if (iniciacionServicio.horas == 11 && iniciacionServicio.minutos == 0) {
                    iniciacionServicio = tiempoLlegada;
                    terminacionServicio = iniciacionServicio.sumarTiempos(new Tiempo(0, tiempoServicio));
                } else if (terminacionServicio.compareToTiempos(tiempoLlegada) > 0) {
                    iniciacionServicio = tiempoLlegada;
                    ocioDelPersonal = terminacionServicio.compareToTiempos(tiempoLlegada);
                    tiempoEsperaCamion = 0;
                } else if (terminacionServicio.compareToTiempos(tiempoLlegada) < 0) {
                    int aux = tiempoEsperaCamion;
                    iniciacionServicio = terminacionServicio;
                    tiempoEsperaCamion = Math.abs(terminacionServicio.compareToTiempos(tiempoLlegada));
                    totalTiempoEsperaCamion += tiempoEsperaCamion;
                    ocioDelPersonal = 0;
                    longitudCola = tiempoEsperaCamion < aux && longitudCola > 0 ? longitudCola - 1 : longitudCola + 1;
                } else {
                    iniciacionServicio = terminacionServicio;
                    tiempoEsperaCamion = 0;
                    ocioDelPersonal = 0;
                }
                if ((iniciacionServicio.compareToTiempos(horaComida) <= 0 || tiempoLlegada.compareToTiempos(horaComida) <= 0) && comer) {
                    if (terminacionServicio.compareToTiempos(horaComida) > 0) {
                        iniciacionServicio = horaComida.sumarTiempos(new Tiempo(0, 30));
                    } else {
                        iniciacionServicio = terminacionServicio.sumarTiempos(new Tiempo(0, 30));
                    }
                    comer = false;
                }
                terminacionServicio = iniciacionServicio.sumarTiempos(new Tiempo(0, tiempoServicio));
                horasExtras = terminacionServicio.compareToTiempos(horaSalida);
                System.out.println(df.format(numeroAleatorio1)
                        + "\t\t|\t\t" + df2.format(tiempoEntreLlegadas)
                        + "\t\t|\t" + tiempoLlegada
                        + "\t\t|\t" + iniciacionServicio
                        + "\t\t|\t" + df.format(numeroAleatorio2)
                        + "\t\t|\t\t" + tiempoServicio
                        + "\t\t|\t" + terminacionServicio
                        + "\t\t|\t\t" + ocioDelPersonal
                        + (ocioDelPersonal >= 100 ? "\t\t     " : "\t|\t\t     ") + tiempoEsperaCamion
                        + (tiempoEsperaCamion >= 100 ? "\t\t\t" : "\t\t|\t\t") + longitudCola);
                if (horasExtras <= 0) {
                    horasExtras = Math.abs(horasExtras) / 60;
                    break;
                }
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                                                                                  TABLA DE COSTOS");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nTamaño del equipo\t" + "Salario normal\t\t" + "Salario extra\t\t" + "Ocio del camión\t\t" + "Operación del almacen\t\t" + "Costos totales");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        salarioNormal = personal * 8 * 25;//25 = pago por hora
        salarioExtra = personal * horasExtras * 37.50;//37.50 = pago por hora extra
        ocioCamion = (totalTiempoEsperaCamion / 60f) * 100;
        operacionAlmacen = (totalTiempoServicio / 60) * 500;
        costosTotales = salarioNormal + salarioExtra + ocioCamion + operacionAlmacen;

        System.out.println("|" + personal + " Personas" + "\t|\t\t" + salarioNormal + "\t|\t\t" + df3.format(salarioExtra) + "\t|\t\t" + df3.format(ocioCamion) + "\t|\t\t" + df3.format(operacionAlmacen) + "\t\t|\t\t" + df3.format(costosTotales) + "|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        if (personal == 3) {
            sumaCostosTotalesE3.add(costosTotales);
            sumaOcioCamionE3.add(ocioCamion);
            sumaOperacionAlmacenE3.add(operacionAlmacen);
            sumaSalarioNormalE3.add(salarioNormal);
            sumaSalarioExtraE3.add(salarioExtra);
        } else if (personal == 4) {
            sumaCostosTotalesE4.add(costosTotales);
            sumaOcioCamionE4.add(ocioCamion);
            sumaOperacionAlmacenE4.add(operacionAlmacen);
            sumaSalarioExtraE4.add(salarioExtra);
            sumaSalarioNormalE4.add(salarioNormal);
        } else if (personal == 5) {
            sumaCostosTotalesE5.add(costosTotales);
            sumaOcioCamionE5.add(ocioCamion);
            sumaOperacionAlmacenE5.add(operacionAlmacen);
            sumaSalarioExtraE5.add(salarioExtra);
            sumaSalarioNormalE5.add(salarioNormal);
        } else if (personal == 6) {
            sumaCostosTotalesE6.add(costosTotales);
            sumaOcioCamionE6.add(ocioCamion);
            sumaOperacionAlmacenE6.add(operacionAlmacen);
            sumaSalarioExtraE6.add(salarioExtra);
            sumaSalarioNormalE6.add(salarioNormal);
        }
    }

    public static void main(String[] args) {

        int personal;
        Scanner scanner = new Scanner(System.in);
        double sumaCostos3 = 0, sumaCostos4 = 0, sumaCostos5 = 0, sumaCostos6 = 0;
        double SumaOcioCamion3 = 0, SumaOcioCamion4 = 0, SumaOcioCamion5 = 0, SumaOcioCamion6 = 0;
        double sumaOperacionAlmacen3 = 0, sumaOperacionAlmacen4 = 0, sumaOperacionAlmacen5 = 0, sumaOperacionAlmacen6 = 0;
        double sumaSalarioNormal3 = 0, sumaSalarioNormal4 = 0, sumaSalarioNormal5 = 0, sumaSalarioNormal6 = 0;
        double sumaSalarioExtra3 = 0, sumaSalarioExtra4 = 0, sumaSalarioExtra5 = 0, sumaSalarioExtra6 = 0;

        do {
            System.out.println("Sistema de colas");
            System.out.println("Selecciona una opción:");
            System.out.println("(3) personas, (4) personas, (5) personas, (6) personas, (0) para salir.");
            System.out.println("|--------------------------------------------------------------------------|");
            System.out.print("Opción:");
            personal = scanner.nextInt();
            if (personal >= 3 && personal <= 6) {
                for (int i = 0; i < 60; i++) {
                    new ProyectoFinal(personal);
                    if (personal == 3) {
                        //for (int i = 0; i < sumaCostosTotalesE3.size(); i++) {
                        sumaCostos3 += sumaCostosTotalesE3.get(i);
                        sumaSalarioNormal3 += sumaSalarioNormalE3.get(i);
                        SumaOcioCamion3 += sumaOcioCamionE3.get(i);
                        sumaSalarioExtra3 += sumaSalarioExtraE3.get(i);
                        sumaOperacionAlmacen3 += sumaOperacionAlmacenE3.get(i);
                        //}

                    } else if (personal == 4) {
                        //for (int i = 0; i < sumaCostosTotalesE4.size(); i++) {
                        sumaCostos4 += sumaCostosTotalesE4.get(i);
                        sumaSalarioNormal4 += sumaSalarioNormalE4.get(i);
                        SumaOcioCamion4 += sumaOcioCamionE4.get(i);
                        sumaSalarioExtra4 += sumaSalarioExtraE4.get(i);
                        sumaOperacionAlmacen4 += sumaOperacionAlmacenE4.get(i);
                        //}

                    } else if (personal == 5) {
                        //for (int i = 0; i < sumaCostosTotalesE5.size(); i++) {
                        sumaCostos5 += sumaCostosTotalesE5.get(i);
                        sumaSalarioNormal5 += sumaSalarioNormalE5.get(i);
                        SumaOcioCamion5 += sumaOcioCamionE5.get(i);
                        sumaSalarioExtra5 += sumaSalarioExtraE5.get(i);
                        sumaOperacionAlmacen5 += sumaOperacionAlmacenE5.get(i);
                        //}

                    } else if (personal == 6) {
                        //for (int i = 0; i < sumaCostosTotalesE6.size(); i++) {
                        sumaCostos6 += sumaCostosTotalesE6.get(i);
                        sumaSalarioNormal6 += sumaSalarioNormalE6.get(i);
                        SumaOcioCamion6 += sumaOcioCamionE6.get(i);
                        sumaSalarioExtra6 += sumaSalarioExtraE6.get(i);
                        sumaOperacionAlmacen6 += sumaOperacionAlmacenE6.get(i);
                        //}

                    }
                }
            } else {
                System.out.println("Opcion invalida");
            }
        } while (personal != 0);

        System.out.println("\n\t\t\t\t\t\t\t\t\tTABLA DE COSTOS");
        System.out.println("\nTamaño de equipo" + "\t\tSalarioNormal" + "\t\tSalarioExtra" + "\t\tOcio del camion" + "\t\tOperacion del almacen"
                + "\t\tCostos Totales");
        System.out.println("3 personas" + "\t\t  " + sumaSalarioNormal3 + "\t\t  " + sumaSalarioExtra3 + "\t\t " + SumaOcioCamion3
                + "\t\t" + sumaOperacionAlmacen3 + "\t\t\t" + sumaCostos3);
        System.out.println("4 personas" + "\t\t  " + sumaSalarioNormal4 + "\t\t  " + sumaSalarioExtra4 + "\t\t  " + SumaOcioCamion4
                + "\t\t" + sumaOperacionAlmacen4 + "\t\t\t" + sumaCostos4);
        System.out.println("5 personas" + "\t\t  " + sumaSalarioNormal5 + "\t\t  " + sumaSalarioExtra6 + "\t\t  " + SumaOcioCamion5
                + "\t\t" + sumaOperacionAlmacen5 + "\t\t\t" + sumaCostos5);
        System.out.println("6 personas" + "\t\t  " + sumaSalarioNormal6 + "\t\t  " + sumaSalarioExtra6 + "\t\t  " + SumaOcioCamion6
                + "\t\t" + sumaOperacionAlmacen6 + "\t\t\t" + sumaCostos6);
    }
}
