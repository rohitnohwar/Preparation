package com.withoutlock;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProducerConsumer {

    static int count = 0;
    static int in = 0;
    static int out = 0;
    static int queueSize = 10;
    static Random random = new Random();

    static int[] queue = new int[queueSize];

    public static void produce() throws InterruptedException {
        while (true) {
            while (count == queueSize) {
                Thread.sleep(1000);
            }

            System.out.println("Before Producer. in=" + in + ", count=" + count);

            queue[in] = random.nextInt(300) + 300;
            in = (in + 1) % 10;
            count++;

            System.out.println("After Producer. in=" + in + ", count=" + count);
            System.out.println(" ");

            try {
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void consume() throws InterruptedException {
        while (true) {
            while (count == 0) {
                Thread.sleep(1000);
            }

            System.out.println("Before Consumer. out=" + out + ", count=" + count);

            queue[out] = 0;
            out = (out + 1) % 10;
            count--;

            System.out.println("After Consumer. out=" + out + ", count=" + count);
            System.out.println(" ");

            try {
                Thread.sleep(random.nextInt(800) + 400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
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