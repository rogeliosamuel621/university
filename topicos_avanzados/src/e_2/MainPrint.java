package e_2;

public class MainPrint {
    public static void main(String[] args) {
        Thread subproceso1 = new Thread( new PrintTask( "task1" ));

        PrintTask task2 = new PrintTask( "task2" );
        Thread subproceso2 = new Thread( task2);

        PrintTask task3 = new PrintTask( "task3" );
        Thread subproceso3 = new Thread( task3);

        System.out.println( "Starting Executor" );
        subproceso1.start();
        subproceso2.start();
        subproceso3.start();
        System.out.println( "Tasks started, main ends. \n" );
    }
}
