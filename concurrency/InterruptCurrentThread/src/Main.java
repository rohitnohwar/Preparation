import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Task implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executer = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            executer.execute(new Task());
        }

        // Prevents executor from executing further tasks. The previously executed ones will keep running.
        executer.shutdown();

        try {
            if (!executer.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                executer.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}