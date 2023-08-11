// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final Lock lock = new ReentrantLock();
    private static int counter = 0;

    private static void increment() {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            Main.counter++;
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                Main.increment();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                Main.increment();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("counter:- "+counter);
    }
}