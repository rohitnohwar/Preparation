import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

enum Database {
    INSTANCE;

    static int readerCount = 0;
    static Lock readerCountLock = new ReentrantLock(true);

    static Lock dbLock = new ReentrantLock(true);

    static Random random = new Random();

    public static void read() {
        readerCountLock.lock();
        readerCount += 1;
        if (readerCount == 1) dbLock.lock();
        readerCountLock.unlock();

        System.out.println("Reading");

        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        readerCountLock.lock();
        readerCount -= 1;
        if (readerCount == 0) dbLock.unlock();
        readerCountLock.unlock();
    }

    public static  void write() {
        dbLock.lock();

        System.out.println("Writing");

        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        dbLock.unlock();
    }
}

class Reader implements Runnable {
    public void run() {
        while (true) Database.INSTANCE.read();
    }

}

class Writer implements Runnable {
    public void run() {
        while (true) Database.INSTANCE.write();
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        int n = 3;

        Reader[] readers = new Reader[n];
        Writer[] writers = new Writer[n];

        for (int i = 0; i < n; i++) {
            readers[i] = new Reader();
            writers[i] = new Writer();

            executor.execute(readers[i]);
            executor.execute(writers[i]);
        }

    }
}