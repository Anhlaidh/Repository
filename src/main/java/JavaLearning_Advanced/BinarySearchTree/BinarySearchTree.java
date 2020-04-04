package JavaLearning_Advanced.BinarySearchTree;

import JavaLearning_Advanced.BinarySearchTree.Util.TreePrinter;

import java.util.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 21:19
 */
public class BinarySearchTree<E> implements IBinarySearchTree<E> {
    public int size;
    private Node<E> root;
    Comparator<E> comparator;

    public Node<E> getRoot() {
        return root;
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {
        comparator = null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public void add(E element) {
        if (root == null) {//添加第一个节点
            root = new Node<>(element, null);
            size++;
            return;
        }
        //添加的不是第一个节点
        //找到父节点
        Node<E> parent = null;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;//两个数字相同时
            }
        }
        //看看插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;

    }

    @Override
    public void remove(E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }
    /*
    * 中序遍历
    * 左根右
    * 因为是二叉搜索树，所以中序遍历为有序
    * */

    @Override
    public void inOrderTraversal(Visitor<E> visitor) {
       inOrderTraversal(root,visitor);
    }

    private void inOrderTraversal(Node<E> node,Visitor<E> visitor) {
        if (visitor==null||node==null) return;
        inOrderTraversal(node.left,visitor);
        visitor.visit(node.element);
        inOrderTraversal(node.right,visitor);
    }


    /*
    * 前序遍历
    * 根左右
    * */
    @Override
    public void preOrderTraversal(Visitor<E> visitor) {
        preOrderTraversal(root,visitor);
    }
    private void preOrderTraversal(Node<E> node,Visitor<E> visitor) {
        if (visitor==null||node==null) return;
        visitor.visit(node.element);
        preOrderTraversal(node.left,visitor);
        preOrderTraversal(node.right,visitor);
    }
    /*
     * 后序遍历
     * 左右根
     * */
    @Override
    public void postOderTraversal(Visitor<E> visitor) {
        postOderTraversal(root,visitor);
    }
    private void postOderTraversal(Node<E> node,Visitor<E> visitor) {
        if (visitor==null||node==null) return;
        postOderTraversal(node.left,visitor);
        postOderTraversal(node.right,visitor);
        visitor.visit(node.element);
    }
    /*
     * 层序遍历
     *
     * */
    @Override
    public void levelOrderTraversal(Visitor visitor) {
        if (root==null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
           visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }
    }
    /*
    *
    * 计算高度
    * 递归
    * */

    public interface Visitor<E> {
        void visit(E element);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));

    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
           return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private static class Node<E> implements TreePrinter.PrintableNode {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        @Override
        public String toString() {
            if (parent==null) return element+"";
            return element + "_P(" + parent.element + ")";
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        @Override
        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return element.toString();
        }
    }


    @Override
    public boolean isComplete() {
      if (root==null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                leaf = true;
            }

        }
        return true;
    }

    //打印器
     static class BTreePrinter {

        public static <T extends Comparable<?>> void printNode(Node<T> root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List<Node<T>> newNodes = new ArrayList<Node<T>>();
            for (Node<T> node : nodes) {
                if (node != null) {
                    System.out.print(node.element);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }
}
