package test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

/**
 * @Description: boolean
 * @author: Anhlaidh
 * @date: 2020/1/20 0020 16:55
 */
public class test {
    public static void main(String[] args) {
//        char a = 'a';
//        boolean[] used = new boolean[128];
//        String s = "abcabcbb";
//        System.out.println(s.charAt(3));
//
//        System.out.println(used[a]);
//        used[a]=true;
//        System.out.println(used[a]);
//        System.out.println((byte)a);
//        String s = "abcabcbb";
//        int i=65;
//        for (; i < 91; i++) {
//            System.out.print("\'"+(char)i+"\',");
//        }
//        i=2;
//        for (; i <= 9; i++) {
//            System.out.print("\'"+i+"\',");
//        }
//    }
//        Arrays.sort();
//        Integer a = 103;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println("a".compareTo("b"));
        Random random = new Random();
        int[] arr = random.ints(10, 0, 100).toArray();
//        int[] arr = {1, 3, 2, 5, 6, 9, 7, 8, 4};
        int q = arr.length;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
