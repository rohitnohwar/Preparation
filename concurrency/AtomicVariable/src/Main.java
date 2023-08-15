import java.util.concurrent.atomic.AtomicInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static AtomicInteger counter = new AtomicInteger(0);

    private static void increment() {
        counter.getAndIncrement();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    increment();
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

        System.out.println(counter);
    }
}