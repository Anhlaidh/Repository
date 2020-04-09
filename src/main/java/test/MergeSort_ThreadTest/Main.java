package test.MergeSort_ThreadTest;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-08 22:41
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = (new Random()).ints(1000000, 0, 10000).toArray();
        ForkJoinPool pool = new ForkJoinPool(8);
        Sort sort = new Sort(arr);
        ForkJoinTask<int[]> result = pool.submit(sort);

        do {
            System.out.printf("Main:Thread Count:%d\n", pool.getActiveThreadCount());
            System.out.printf("Main:Parallelism:%d\n", pool.getParallelism());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!sort.isDone());


//        int[] ints = result.get();
//        for (int anInt : ints) {
//            System.out.println(anInt+" ");
//        }

    }
}
