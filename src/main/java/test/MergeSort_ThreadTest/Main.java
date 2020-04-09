package test.MergeSort_ThreadTest;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-08 22:41
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 3, 2, 7, 4, 5, 8
        };
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
        } while (result.isDone());



        for (int i : arr) {
            System.out.print(i+" ");
        }

    }
}
