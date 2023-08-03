import java.lang.Runnable;

class Runner implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Runner: "+i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Runnable runner = new Runner();
        Thread t = new Thread(runner);
        t.setPriority(Thread.MAX_PRIORITY);

        System.out.println("User thread priority:- " + t.getPriority());
        System.out.println("Main thread priority:- " + Thread.currentThread().getPriority());

        t.start();

        System.out.println("Main thread prints");
    }
}