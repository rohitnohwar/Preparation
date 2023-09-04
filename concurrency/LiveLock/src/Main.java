import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    final static ReentrantLock lock1 = new ReentrantLock();
    final static ReentrantLock lock2 = new ReentrantLock();

    public static void process1() throws InterruptedException {
        while (true) {
            lock1.tryLock(50, TimeUnit.MILLISECONDS);
            System.out.println("process1 acquired lock1");

            if (lock2.tryLock()) {
                System.out.println("process1 acquired lock2");
            }
            else {
                // We will always end up in this loop as lock 2 is never released by process2
                Thread.sleep(3000);
                continue;
            }

            break;
        }

        lock1.unlock();
        lock2.unlock();
        System.out.println("process1 released lock1 and lock2");
    }

    public static void process2() throws InterruptedException {
        while (true) {
            lock2.tryLock(50, TimeUnit.MILLISECONDS);
            System.out.println("process2 acquired lock2");

            if (lock1.tryLock()) {
                System.out.println("process2 acquired lock1");
            }
            else {
                // We will always end up in this loop as lock 1 is never released by process1
                Thread.sleep(3000);
                continue;
            }

            break;
        }

        lock1.unlock();
        lock2.unlock();
        System.out.println("process2 released lock2 and lock1");
    }

    //To avoid livelocks we can acquire locks in the same order
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                try {
                    process1();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    process2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}