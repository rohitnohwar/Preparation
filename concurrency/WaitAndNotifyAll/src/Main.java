class Waiter1 extends Thread
{
    public void run() {
        synchronized (this) {
            System.out.println("In Waiter1 before wait()");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("In Waiter1 after wait");
        }
    }
}

class Waiter2 extends Thread
{
    public Waiter1 waiter1;
    Waiter2(Waiter1 waiter1) {
        this.waiter1 = waiter1;
    }

    public void run() {
        synchronized (this.waiter1) {
            System.out.println("In Waiter2 before wait()");
            try {
                this.waiter1.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("In Waiter2 after this.waiter1.wait()");
        }
    }
}

class Waiter3 extends Thread
{
    public Waiter1 waiter1;
    Waiter3(Waiter1 waiter1) {
        this.waiter1 = waiter1;
    }

    public void run() {
        synchronized (this.waiter1) {
            System.out.println("In Waiter3 before wait()");
            try {
                this.waiter1.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("In Waiter3 after this.waiter1.wait()");
        }
    }
}

class Notifier extends Thread {
    public Waiter1 waiter1;
    Notifier(Waiter1 waiter1) {
        this.waiter1 = waiter1;
    }
    public void run() {
        synchronized (this.waiter1) {
            try {
                Thread.sleep(1000);
                System.out.println("In Notifier before notifyAll");
                // Code after notify() executes before notifyAll()
                this.waiter1.notifyAll();
                System.out.println("Still in Notifier. This will execute before notifyAll()");
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
        Waiter1 waiter1 = new Waiter1();
        Waiter2 waiter2 = new Waiter2(waiter1);
        Waiter3 waiter3 = new Waiter3(waiter1);
        Notifier notifier = new Notifier(waiter1);

        waiter1.start();
        waiter2.start();
        waiter3.start();
        Thread.sleep(1000);
        notifier.start();
    }
}