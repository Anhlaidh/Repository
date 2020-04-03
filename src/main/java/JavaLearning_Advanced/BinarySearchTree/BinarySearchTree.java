package JavaLearning_Advanced.BinarySearchTree;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 21:19
 */
public class BinarySearchTree<E extends Comparable> implements IBinarySearchTree<E>{
    public int size;
    private Node<E> root;

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
            root = new Node(element, null);
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

        }

    }

    @Override
    public void remove(E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    private int compare(E e1, E e2) {
        return e1.compareTo(e2);
    }


    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
