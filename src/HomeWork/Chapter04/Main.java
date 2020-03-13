package HomeWork.Chapter04;

import HomeWork.sort.SortImpl;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/13 0013 18:47
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {5,2,3,1};//
        SortImpl sort = new SortImpl();
        sort.MergeSort(array);
        for (int a:array) System.out.println(a);
    }
}
