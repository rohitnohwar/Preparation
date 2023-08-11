// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Worker implements Runnable{
    // 1. volatile keyword mes sure that the variable is always stored in the main memory(RAM) instead of cache memory
    // 2. Even without the volatile keyword the variable might still usually be stored in the main memory(RAM)
    // 3. Even without the volatile keyword the threads may use the same cache due to which we get the correct result.
    private volatile boolean terminated = false;
    public void run() {
        while (!terminated) {
            try {
                System.out.println("t1 inside");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTerminatedTrue() {
        this.terminated = true;
    }
}

// Two threads :- t1 and the main thread
public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();

        Thread t1 = new Thread(worker);

        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        worker.setTerminatedTrue();
        System.out.println("Algorithm has been terminated");
    }
}