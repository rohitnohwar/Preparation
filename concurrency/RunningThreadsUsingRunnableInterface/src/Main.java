import java.lang.Runnable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Runner1: "+i);
        }
    }
}

class Runner2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Runner2: "+i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Runnable runner1 = new Runner1();
        Thread t1 = new Thread(runner1);

        Runnable runner2 = new Runner2();
        Thread t2 = new Thread(runner2);

        Thread t3 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("Runner3: "+i);
                }
            }
        };

        Runnable t4 = new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("Runner3: "+i);
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}