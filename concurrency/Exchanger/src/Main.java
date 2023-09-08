import java.util.Random;
import java.util.concurrent.Exchanger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Worker implements Runnable {
    Exchanger<Integer> exchanger;
    public Worker(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }
    int counter = 0;
    public void run() {
        counter = (int) (Math.random() * 1000);
        System.out.println(Thread.currentThread().getName() + " " + counter);
        try {
            exchanger.exchange(counter);
            System.out.println(Thread.currentThread().getName() + " " + counter);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        Thread t1 = new Thread(new Worker(exchanger));
        Thread t2 = new Thread(new Worker(exchanger));

        t1.start();
        t2.start();
    }
}