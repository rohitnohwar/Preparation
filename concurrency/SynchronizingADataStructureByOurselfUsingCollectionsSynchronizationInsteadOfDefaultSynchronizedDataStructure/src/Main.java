import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    public static void add(int i) {
        list.add(i);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    add(i);
                }
            }
        };


        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    add(i);
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Size of list:- " + list.size());
    }
}