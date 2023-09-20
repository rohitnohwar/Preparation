import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Worker extends RecursiveAction {
    int num;
    public Worker(int num) {
        this.num = num;
    }
    public void compute() {
        if (num > 100) {
            System.out.println("Splitting task");
            RecursiveAction action1 = new Worker(num / 2);
            RecursiveAction action2 = new Worker(num / 2);

            // Alternative 1
            action1.fork();
            action2.fork();

            action1.join();
            action2.join();

            // Alternative 2
//            invokeAll(action1, action2);


        }
        else {
            for (int i = 1; i < num; i++) System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        RecursiveAction action = new Worker(1000);
        action.fork();
        action.join();
    }
}