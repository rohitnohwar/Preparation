// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class WaitAndNotify {
    public void process1() {
        synchronized (this) {
            System.out.println("In process1 before wait()");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("In process1 after wait");
        }
    }

    public void process2() {
        synchronized (this) {
            try {
                Thread.sleep(1000);
                System.out.println("In process2 before notify()");
                // Code after notify() executes before notify()
                notify();
                System.out.println("Still in process2. This will execute before notify()");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        Thread t1 = new Thread() {
            public void run() {
                waitAndNotify.process1();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                waitAndNotify.process2();
            }
        };

        t1.start();
        t2.start();
    }
}