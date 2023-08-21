import java.util.concurrent.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Worker implements Runnable {
    public CyclicBarrier cyclicBarrier;

    public Worker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        downloadData();
        try {
             // Used for threads to make them wait for each other
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("done "+Thread.currentThread().getName());
    }

    public void downloadData() {
        System.out.println("Downloading data");
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("completed");
            }
        });
        for (int i = 0; i < 5; i++) {
            executor.execute(new Worker(cyclicBarrier));
        }

//        executor.shutdown();
    }
}