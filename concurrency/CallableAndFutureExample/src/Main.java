// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Worker implements Callable<Integer>{

    int counter = 0;
    private int i;

    public void setI(int i) {
        this.i = i;
    }

    public Integer call() {
//        if(i%2==1) {
//            try {
//                Thread.currentThread().sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return i;
    }
}


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Worker worker = new Worker();

        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Future<Integer> future = executorService.submit(worker);
            list.add(future);
//            System.out.println(future.get()); // Getting will make the execution serial
        }
    }
}