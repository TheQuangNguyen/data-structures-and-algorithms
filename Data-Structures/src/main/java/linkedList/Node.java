package linkedList;

public class Node<T> {
    public T value;
    public Node next = null;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }
}
