import java.lang.Runnable;

class Runner1 implements Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Daemon thread is executing");
        }
    }
}

class Runner2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("User thread finished it's execution");
    }
}

public class Main {
    public static void main(String[] args) {
        Runnable runner1 = new Runner1();
        Thread t1 = new Thread(runner1);
        t1.setDaemon(true);

        Runnable runner2 = new Runner2();
        Thread t2 = new Thread(runner2);

        t1.start();
        t2.start();
    }
}