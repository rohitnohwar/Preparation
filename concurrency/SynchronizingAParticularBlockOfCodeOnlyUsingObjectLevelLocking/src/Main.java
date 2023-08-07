// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Execute execute = new Execute();

        Thread t1 = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    execute.increment();
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    execute.increment();
                }
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(execute.counter);
    }
}

class Execute {
    public int counter = 0;

    public synchronized void increment() {
        counter++;
    }
}