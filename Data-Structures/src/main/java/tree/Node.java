package tree;

public class Node<T> {
    public T value;
    public Node left = null;
    public Node right = null;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
