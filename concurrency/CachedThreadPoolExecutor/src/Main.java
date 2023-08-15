import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Task implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executer = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executer.execute(new Task());
        }
    }
}