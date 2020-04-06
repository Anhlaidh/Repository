package test;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/5 0005 22:14
 */
public class test1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        while ((a = b) != 0) {
            System.out.println(a);
            b--;
        }
    }
}
