package test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Description: boolean
 * @author: Anhlaidh
 * @date: 2020/1/20 0020 16:55
 */
public class test {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        char[] str = reader.nextLine().toCharArray();
        int[] a = new int[str.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(str[i] + "");
        }
        str = reader.nextLine().toCharArray();
        int[] b = new int[str.length];

        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(str[i] + "");
        }

        boolean carryFlag = false;
        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        for (int i = 0; i < b.length; i++) {
            if (carryFlag) a[aIndex - i] = a[aIndex - i] + b[bIndex - i] + 1;
            a[aIndex - i] = a[aIndex - i] + b[bIndex - i];
            if (a[aIndex - i] >= 10) {
                a[aIndex - i] = a[aIndex] % 10;
                carryFlag = true;
            }
        }
        if (carryFlag) {
            a[a.length - b.length - 1]++;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }


    }
}

