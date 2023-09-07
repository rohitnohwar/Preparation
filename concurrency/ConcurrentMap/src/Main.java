import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.PriorityBlockingQueue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Locks on segments instead of the whole map
        ConcurrentMap<Integer, Integer> map= new ConcurrentHashMap<>();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    map.put(71, 23);
                    System.out.println("added");
                    Thread.sleep(1000);
                    map.put(922, 23);
                    System.out.println("added");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                //                    Thread.sleep(10);
                map.remove(71);
                System.out.println("taken");
//                    Thread.sleep(5000);
                map.remove(922);
                System.out.println("taken");
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(map);
    }
}