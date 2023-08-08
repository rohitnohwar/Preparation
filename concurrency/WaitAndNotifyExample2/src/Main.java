class Waiter extends Thread
{
    public void run() {
        synchronized (this) {
            System.out.println("In Waiter before wait()");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("In Waiter after wait");
        }
    }
}
class Notifier extends Thread {
    public Waiter waiter;
    Notifier(Waiter waiter) {
        this.waiter = waiter;
    }
    public void run() {
        synchronized (this.waiter) {
            try {
                Thread.sleep(1000);
                System.out.println("In Notifier before notify()");
                // Code after notify() executes before notify()
                this.waiter.notify();
                System.out.println("Still in Notifier. This will execute before notify()");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Waiter waiter = new Waiter();
        Thread notifier = new Notifier(waiter);

        waiter.start();
        Thread.sleep(1000);
        notifier.start();
    }
}