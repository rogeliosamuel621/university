package servidores;

import java.util.concurrent.TimeUnit;

public class ServidoresMain {
    public static void main(String[] args) {
        Servidor servidor1 = new Servidor(20);
        Servidor servidor2 = new Servidor(40);

        servidor1.Crea60Procesos();
        Proceso[] procesos = servidor1.listaDeProcesos;

        for(int i=0; i<60; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Se genero un proceso de: " + procesos[i].peso);
                System.out.println("El mainframe 2 tiene: " + servidor2.cont);
                System.out.println("El mainframe 1 tiene: " + servidor1.cont);

                int procesosServidor1 = servidor1.cont;
                int procesosServidor2 = servidor2.cont;
                boolean servidor1TieneMas = procesosServidor1 > procesosServidor2;

                if (servidor1TieneMas) {
                    servidor2.insert(procesos[i].peso);
                    System.out.println("El proceso de" + procesos[i].peso + "MB se inserto en el mainframe 2");
                } else if(procesosServidor1 == procesosServidor2) {
                    int numeroAleatorio = servidor1.NumeroAleatorio(1);
                    if (numeroAleatorio == 1) {
                        servidor1.insert(procesos[i].peso);
                        System.out.println("El proceso de" + procesos[i].peso + "MB se inserto en el mainframe 1");
                    } else {
                        servidor2.insert(procesos[i].peso);
                        System.out.println("El proceso de" + procesos[i].peso + "MB se inserto en el mainframe 2");
                    }
                } else {
                    servidor1.insert(procesos[i].peso);
                    System.out.println("El proceso de" + procesos[i].peso + "MB se inserto en el mainframe 1");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
