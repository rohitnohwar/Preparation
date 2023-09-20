import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Worker extends RecursiveTask<Integer> {
    int num;
    public Worker(int num) {
        this.num = num;
    }
    public Integer compute() {
        if (num > 100) {
            System.out.println("Splitting task");
            RecursiveTask action1 = new Worker(num / 2);
            RecursiveTask action2 = new Worker(num / 2);

            int subSolution = 0;
            action1.fork();
            action2.fork();

            subSolution += (int) action1.join();
            subSolution += (int) action2.join();

            return subSolution;
        }
        else {
            return num;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        RecursiveTask action = new Worker(1000);
        System.out.println(pool.invoke(action));
    }
}