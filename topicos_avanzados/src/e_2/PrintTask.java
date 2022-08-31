package e_2;

import java.util.Random;

public class PrintTask implements Runnable {
    private final int sleepTime; // random sleep time for thread
    private final String taskName; // name of task
    private final static Random generator = new Random();

    public PrintTask(String taskName) {
        this.taskName = taskName;
        sleepTime = generator.nextInt( 5000 ); // milliseconds
    }

    public void run() {
        try { // put thread to sleep for sleepTime amount of time 24
            System.out.printf("%s going to sleep for %d milliseconds. \n", taskName, sleepTime);
            Thread.sleep(sleepTime);
            System.out.printf("½s Continua Ejecucion \n", taskName);
        } // end try
        catch ( InterruptedException exception ){
            System.out.printf( "½s %s\n", taskName, "terminated prematurely due " + "to interrumption");
        } // end catch
    }
}
