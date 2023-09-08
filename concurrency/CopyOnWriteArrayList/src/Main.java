import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) list.add(i);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 10000; i++) list.set(i, i + 99999);
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 10000; i++) System.out.println(list.get(i));
            }
        };

        t1.start();
        t2.start();
        t3.start();

    }
}