import java.lang.Runnable;

class Runner1 implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                System.out.println("Daemon thread is printing");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Runnable runner1 = new Runner1();
        Thread t1 = new Thread(runner1);

        t1.setPriority(Thread.MAX_PRIORITY);

        System.out.println();

        Thread.currentThread().getPriority();
    }
}