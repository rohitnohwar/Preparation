import java.util.concurrent.locks.ReentrantLock;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    final static ReentrantLock lock1 = new ReentrantLock();
    final static ReentrantLock lock2 = new ReentrantLock();

    public static void process1() {
        lock1.lock();
        System.out.println("process1 acquired lock1");

        // Won't reach this part of the code as lock2 is acquired by process2
        lock2.lock();
        System.out.println("process1 acquired lock2");

        lock1.unlock();
        lock2.unlock();
    }

    public static void process2() {
        lock2.lock();
        System.out.println("process2 acquired lock2");

        // Won't reach this part of the code as lock1 is acquired by process1
        lock1.lock();
        System.out.println("process2 acquired lock1");

        lock2.unlock();
        lock1.unlock();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                process1();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                process2();
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