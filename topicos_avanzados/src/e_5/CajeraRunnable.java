package e_5;

import java.util.Random;

public class CajeraRunnable implements Runnable{
    private Cliente cliente;
    private long initialTime;
    public CajeraRunnable(Cliente cliente, long initialTime) {
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        System.out.println("La cajera " + Thread. currentThread().getName()
                        + "COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " +
                        this.cliente.getNombre()
                        + " EN EL TIEMPO: "
                        + (System. currentTimeMillis() - this.initialTime) / 1000 + "seg");

        for (int i = 0; i< this.cliente.getCarroCompra().length; i++) {
            // Se procesa el pedido en X segundos

            this.esperarXsegundos((cliente.getCarroCompra())[i]);
            int price = this.getPrice();
            System.out.println("Procesado el producto " + (i + 1) + " del " + this.cliente.getNombre() + "-›Tiempo: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg" + " Price: $" + price);
            this.cliente.UpgradeTotalPrice(price);

        }

            System.out.println("La cajera " + Thread.currentThread().getName() +
            " HA TERMINADO DE PROCESAR "
                    + this.cliente.getNombre()+
                    " EN EL TIEMPO: "
                    + (System.currentTimeMillis() - this. initialTime) / 1000 + "seg"
            + " Con un precio total de: $" + this.cliente.totalPrice);
    }

    private void esperarXsegundos (int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private int getPrice() {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;

        return randomInt;
    }
}
