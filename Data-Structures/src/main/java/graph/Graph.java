package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph<T> {

    private Set<Node<T>> nodes;

    public Graph() {
        this.nodes = new HashSet<>();
    }

    // add a new node to the graph
    // takes in the value of that node and returns the add node
    public Node<T> addNode(T value) {
        Node newNode = new Node(value);
        this.nodes.add(newNode);
        return newNode;
    }

    // adds a new edge between two nodes in the graph
    // takes in two nodes to be connected by the edge
    // checks that the two nodes already in graph
    public Edge<T> addEdge(Node<T> node1, Node<T> node2) {
        if (this.nodes.contains(node1) && this.nodes.contains(node2)) {
            Edge newEdge = new Edge(node2);
            node1.addNeighbor(newEdge);
            return newEdge;
        } else {
            throw new IllegalArgumentException("input node/s are not added to graph yet");
        }

    }

    // include the ability to add weight
    public Edge<T> addEdge(Node<T> node1, Node<T> node2, int weight) {
        if (this.nodes.contains(node1) && this.nodes.contains(node2)) {
            Edge newEdge = new Edge(node2, weight);
            node1.addNeighbor(newEdge);
            return newEdge;
        } else {
            throw new IllegalArgumentException("input node/s are not added to graph yet");
        }
    }

    // return all nodes in the graph as a collection
    public Set<Node<T>> getNodes() {
        if (size() == 0) {
            return null;
        }
        return this.nodes;
    }

    // Returns a collection of nodes connected to the given node
    // takes in a given node
    // Include the weight of the connection in the returned collection in the form of list of
    public List<Edge<T>> getNeighbors(Node<T> node) {
        if (node.getNeighbors().size() == 0) {
            return null;
        }
        return node.getNeighbors();
    }

    // return the total number of nodes in the graph
    public int size() {
        return this.nodes.size();
    }
}
