package tree;

public class Node<T> {
    T value;
    Node left = null;
    Node right = null;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
