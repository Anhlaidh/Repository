package test.MergeSort_ThreadTest;

import java.util.concurrent.RecursiveTask;

public class Sort extends RecursiveTask<int[]> {
    private int[] array;
    private static int[] copy(int[] array, int from, int to) {
        int[] result = new int[to - from];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[from + i];
        }
        return result;
    }

    public Sort(int[] array) {
        this.array = array;
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

    @Override
    protected int[] compute() {
        if (array.length<=1) return array;
        int[] left = copy(array, 0, array.length / 2);
        int[] right = copy(array, array.length / 2, array.length);
        Sort sortL = new Sort(left);
        Sort sortR = new Sort(right);
        invokeAll(sortL, sortR);
        int[] OLeft = sortL.join();
        int[] ORight = sortR.join();

        return merge(OLeft, ORight);

    }
}
