package test.MergeSort_ThreadTest;

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
        arr = Sort.sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }

    }
}
