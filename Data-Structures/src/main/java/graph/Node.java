package graph;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    private T value;
    private List<Edge<T>> neighbors;

    public Node(T value) {
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    public T getValue() {
        return value;
    }

    public List<Edge<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Edge<T> neighbor) {
        this.neighbors.add(neighbor);
    }
}
