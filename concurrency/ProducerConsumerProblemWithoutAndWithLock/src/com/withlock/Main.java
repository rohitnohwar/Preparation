package com.withlock;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProducerConsumer {
    private static int queueSize = 10;
    private static Semaphore full = new Semaphore(0);
    private static Semaphore empty = new Semaphore(queueSize);

    private static int in = 0;
    private static int out = 0;

    private static Random random = new Random();

    private static Lock lock = new ReentrantLock();
    private static int[] arr = new int[queueSize];

    public static void produce() throws InterruptedException {
        while (true) {
            empty.acquire();
            lock.lock();

            System.out.println("Producer");
            System.out.println(" ");

            arr[in] = random.nextInt(1000) + 1;
            in = (in + 1) % queueSize;

            lock.unlock();
            full.release();

            Thread.sleep(random.nextInt(1000) + 500);
        }
    }

    public static void consume() throws InterruptedException {
        while (true) {
            full.acquire();
            lock.lock();

            System.out.println("Consumer");
            System.out.println(" ");

            arr[out] = random.nextInt(1000) + 1;
            in = (out + 1) % queueSize;

            lock.unlock();
            empty.release();

            Thread.sleep(random.nextInt(1000) + 500);
        }
    }
}

public class Main {
    public static void main (String args[]) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    ProducerConsumer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    ProducerConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t1.start();
        t2.start();
    }
}
