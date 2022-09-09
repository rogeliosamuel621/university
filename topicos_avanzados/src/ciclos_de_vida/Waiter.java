package ciclos_de_vida;

/**
 * Clase que esperará a otros hilos para invocar el metodo notify para terminar los procesos
 */
public class Waiter implements Runnable{

    // delcaracion
    private Message msg;

    // constructor
    public Waiter(Message m){
        this.msg=m;
    }

    /**
     * Lo que se ejecutará en el hilo
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try{
                // se registra el tiempo en el que se aplica el metodo wait
                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                msg.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            // Codigo que será ejecutado al momento de ser aplicado el metodo notify
            System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+" processed: "+msg.getMsg());
        }
    }

}
