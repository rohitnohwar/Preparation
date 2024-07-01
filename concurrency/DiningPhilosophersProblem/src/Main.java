import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fork {
    String name;
    Lock lock;
    public Fork(String name) {
        this.name = name;
        lock = new ReentrantLock();
    }

    public void pick() {
        lock.lock();
    }

    public void release() {
        lock.unlock();
    }
}

class Philosopher implements Runnable {
    String name;
    Random random;
    public Philosopher(String name, Random random) {
        this.name = name;
        this.random = random;
    }
    Fork[] fork = new Fork[2];

    public void think() {
        System.out.println(name + " is thinking");
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void eat() {
        System.out.println(name + " is eating");
        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            fork[0].pick();
            System.out.println(name + " picked up " + fork[0].name);
            fork[1].pick();
            System.out.println(name + " picked up " + fork[1].name);

            eat();

            fork[0].release();
            System.out.println(name + " released " + fork[0].name);
            fork[1].release();
            System.out.println(name + " released " + fork[1].name);

            think();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 5;
        Random random = new Random();

        Philosopher[] philosophers = new Philosopher[n];
        Fork[] forks = new Fork[n];

        for (int i = 0; i < n; i++) {
            forks[i] = new Fork("Fork" + i);
        }

        for (int i = 0; i < n; i++) {
            philosophers[i] = new Philosopher("Philosopher" + i, random);
            if (i == n - 1) {
                philosophers[i].fork[0] = forks[(i + 1) % n];
                philosophers[i].fork[1] = forks[i];
            }
            else {
                philosophers[i].fork[0] = forks[i];
                philosophers[i].fork[1] = forks[(i + 1) % n];
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < n; i++) {
            executor.execute(philosophers[i]);
        }
    }
}