// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static int counter1 = 0;
    public static int counter2 = 0;
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void increment1() {
        synchronized (lock1) {
            counter1++;
        }
    }

    public static void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    increment1();
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    increment2();
                }
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("counter1:- "+counter1);
        System.out.println("counter2:- "+counter2);
    }
}