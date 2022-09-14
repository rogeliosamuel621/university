package project_1;

import java.util.Random;

public class CarWasherRunnable implements Runnable{
    private Client client;
    private long initialTime;

    public CarWasherRunnable(Client client, long initialTime) {
        this.client = client;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        this.starWashingTheCarRecord();

        for (int i = 0; i< this.client.getCars().length; i++) {
            this.washTheCarRecord(i);
        }
        this.endWashingCarRecord();
    }

    private void wait (int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private int getServicePrice() {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;

        return randomInt;
    }

    /**
     * Registra el tiempo en el que se empieza a lavar un acrro
     */
    private void starWashingTheCarRecord() {
        System.out.println("El lavador de carros " + Thread. currentThread().getName()
                + "COMIENZA A LAVAR EL CARRO DEL cliente " +
                this.client.getName()
                + " EN EL TIEMPO: "
                + (System. currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }

    /**
     * se lava el carro en x tiempo mostrando sus estadísticas
     * @param i id del carro que se está lavando
     */
    private void washTheCarRecord(int i) {
        this.wait((client.getCars())[i]);
        int price = this.getServicePrice();
        System.out.println("Lavando el carro " + (i + 1) + " del " + this.client.getName() + "-›Tiempo: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg" + " Precio del servicio: $" + price);
        this.client.upgradeAmountToPay(price);
    }

    /**
     * Muestra el fin del lavado de los carros de un cliente
     */
    private void endWashingCarRecord() {
        System.out.println("El lavador de carros " + Thread.currentThread().getName() +
                " HA TERMINADO DE LAVAR LOS CARROS DEL CLIENTE "
                + this.client.getName()+
                " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this. initialTime) / 1000 + "seg"
                + " Con un precio total de: $" + this.client.getAmountToPay());
    }
}
