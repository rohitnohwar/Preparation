import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Worker implements Runnable {
    public CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        downloadData();
        latch.countDown();
    }

    public void downloadData() {
        System.out.println("Downloading data");
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Worker(latch));
        }

        // Will make us qait for countdown value to go down from 5 to 0 before executing the rest of the code
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Everything completed");

        executor.shutdown();
    }
}