import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
enum DownloadService {
    INSTANCE;

    private static final Semaphore semaphore = new Semaphore(3);

    public void download() throws InterruptedException {
        semaphore.acquire();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Downloading for:- " + Thread.currentThread().getName());

        semaphore.release();
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        DownloadService.INSTANCE.download();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
}