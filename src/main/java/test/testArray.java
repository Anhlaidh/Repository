package test;

import java.util.ArrayList;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/7 0007 14:52
 */
public class testArray {
    public static void main(String[] args) {
//        int[][] array = new int[3][3];
//        int p = 0;
//        for (int i = 0; i < array.length;i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                array[i][j] = p;
//                p++;
//                System.out.print(array[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println(Find(2,array));
//        System.out.println(replaceSpace(new StringBuffer("   ")));
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(printListFromTailToHead(node));

    }
    public static boolean Find(int target, int [][] array) {
        int x= array[0].length-1;
        int y = array.length-1;
        while(true){
            if (target > array[x][y]) {
                x = (x+array[0].length)/2;
            }
            if (target > array[x][y]) {
                y = (y + array.length) / 2;
                continue;
            }

            if (target < array[x][y]) {
                x =x/ 2;
            }
            if (target < array[x][y]) {
                y = y / 2;
                continue;
            }
            if (target == array[x][y]) {
                return true;
            }

        }
    }
    public static String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' '){
                str.deleteCharAt(i);
                str.insert(i,"%20");
            }
        }
        return str.toString();
    }
    public static class ListNode {
       int val;
       ListNode next = null;
       ListNode(int val) {
           this.val = val;
       }
   }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<>(arrayList.size());
        if (listNode==null) return result;
        do {
            arrayList.add(listNode.val);

        } while ((listNode=listNode.next) != null);

        for (int i = arrayList.size()-1; i>=0; i--) {
            result.add(arrayList.get(i));
        }
        return result;



    }
}
