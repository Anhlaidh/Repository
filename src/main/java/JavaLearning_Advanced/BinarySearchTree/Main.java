package JavaLearning_Advanced.BinarySearchTree;

import JavaLearning_Advanced.BinarySearchTree.Util.TreePrinter;

import java.util.Comparator;
import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 23:34
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
//        Integer[] arr = new Integer[]{4, 5, 3, 6, 2, 5, 1};
//        Integer[] arr = new Integer[]{7, 4, 9, 2, 5};
        Integer[] arr = new Integer[]{7, 4, 9, 2, 5, 8, 11, 1, 3, 10, 12};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer integer : arr) {
            bst.add(integer);

        }
        TreePrinter.print(bst.getRoot());
        System.out.println(bst.isComplete());


        System.out.println("height:" + bst.height());
        bst.remove(4);
        TreePrinter.print(bst.getRoot());
    }
}
