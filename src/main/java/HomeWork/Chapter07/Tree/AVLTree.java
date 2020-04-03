package HomeWork.Chapter07.Tree;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 15:49
 */
public class AVLTree {
    private class Node implements Comparable<Node>{
        private String key;
        private int value;
        private Node left;
        private Node right;
        private int height;

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }


}
