import java.lang.Thread;
class Runner1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Runner1: "+i);
        }
    }
}

class Runner2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Runner2: "+i);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Runner1();

        Thread t2 = new Runner2();

        Thread t3 = new Thread(){
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
