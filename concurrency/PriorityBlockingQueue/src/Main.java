import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> pbq= new PriorityBlockingQueue<>();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    pbq.put(71);
                    System.out.println("added");
                    Thread.sleep(1000);
                    pbq.put(922);
                    System.out.println("added");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
//                    Thread.sleep(100);
                    pbq.take();
                    System.out.println("taken");
//                    Thread.sleep(5000);
                    pbq.take();
                    System.out.println("taken");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t1.start();
        t2.start();
    }
}