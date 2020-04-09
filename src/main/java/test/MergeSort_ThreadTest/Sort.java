package test.MergeSort_ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Sort{


    public static ThreadPoolExecutor executor;

    private static int[] copy(int[] array, int from, int to) {
        int[] result = new int[to - from];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[from + i];
        }
        return result;
    }


    public static int[] sort(int[] array) {

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);



        if (array.length<=1) return array;

        int[] left = copy(array, 0, array.length / 2);
        int[] right = copy(array, array.length / 2, array.length);
        int[] OLeft = sort(left);
        int[] ORight = sort(right);
        return merge(OLeft, ORight);


    }

    private static int[] merge(int[] left, int[] right) {


        int[] array = new int[left.length + right.length];
        int i = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (i < array.length) {
            if (left[leftIndex] < right[rightIndex]) {
                array[i] = left[leftIndex];
                leftIndex++;
                i++;
                if (leftIndex >= left.length) {
                    while (rightIndex < right.length) {
                        array[i] = right[rightIndex];
                        i++;
                        rightIndex++;
                    }
                    break;
                }

            }
            if (right[rightIndex] <= left[leftIndex]) {
                array[i] = right[rightIndex];
                rightIndex++;
                i++;
                if (rightIndex >= right.length) {
                    while (leftIndex < left.length) {
                        array[i] = left[leftIndex];
                        i++;
                        leftIndex++;
                    }
                    break;
                }
            }

        }
        return array;
    }

}
