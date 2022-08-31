public class E_1 implements Runnable {
    public static void main(String[] args) {
        E_1 m1 = new E_1();
        Thread t1 = new Thread(m1);
        t1.start();

        System.out.println("Finish main");
    }

    public void run() {
        System.out.println("thread is running... ");

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
