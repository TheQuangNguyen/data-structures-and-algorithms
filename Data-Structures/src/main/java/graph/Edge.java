package graph;

public class Edge<T> {
    private int weight;
    private Node<T> node;

    public Edge(Node node) {
        this.node = node;
        this.weight = 0;
    }

    public Edge(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Node<T> getNode() {
        return node;
    }
}
