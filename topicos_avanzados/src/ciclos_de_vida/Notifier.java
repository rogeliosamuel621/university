package ciclos_de_vida;

/**
 * Una clase que invocará a los metodos notify
 */
public class Notifier implements Runnable {

    // declaracion
    private Message msg;

    // constructor
    public Notifier(Message msg) {
        this.msg = msg;
    }

    /**
     * Lo que se ejecutará en el hilo
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                // Momento en el que se aplica el metodo de notify
                msg.setMsg(name+" Notifier work done");
                msg.notify();
                // msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
