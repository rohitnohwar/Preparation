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
        ExecutorService executors = Executors.newFixedThreadPool(10);

        List<Future<Integer>> list = new ArrayList<>();

        Worker worker = new Worker();

        for (int i = 0; i < 100000; i++) {
            worker.setI(i);
            Future<Integer> future = executors.submit(worker);
            list.add(future);

//            System.out.println(future.get());       // If we use .get(), the loop will pause here till we get the future value, thus executing sequentially
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get());
        }
    }
}