package test;

import java.util.Arrays;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/30 0030 14:20
 */
public class sort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 6, 9, 7, 8, 4};
        int[] ints = quickSort(arr);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    private static int[] quickSort(int[] arr) {
        if (arr.length<=1) return arr;
        int left = 0;
        int right = arr.length-1;
        int mid = arr[0];
        while (left != right) {
            while (true) {
                if (right == left) break;
                else if (arr[right] < mid) {
                    arr[left] = arr[right];
                    break;
                } else right--;
            }
            while (true) {
                if (left == right) break;
                else if (arr[left] >= mid) {
                    arr[right] = arr[left];
                    break;
                } else left++;
            }
        }
        int[] leftArr = Arrays.copyOfRange(arr, 0, left);
        int[] rightArr = Arrays.copyOfRange(arr, right+1, arr.length);
        int[] l = quickSort(leftArr);
        int[] r = quickSort(rightArr);
        arr[right] = mid;
        System.arraycopy(l, 0, arr, 0, l.length);
        System.arraycopy(r, 0, arr, right+1, r.length);

        return arr;
    }


}