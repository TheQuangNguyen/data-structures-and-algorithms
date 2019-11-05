package graph;

import stacksandqueues.Queue;

import java.util.*;

public class Graph<T> {

    private Set<Node<T>> nodes;

    public Graph() {
        this.nodes = new HashSet<>();
    }

    // add a new node to the graph
    // takes in the value of that node and returns the add node
    public Node<T> addNode(T value) {
        Node<T> newNode = new Node<>(value);
        this.nodes.add(newNode);
        return newNode;
    }

    // adds a new edge between two nodes in the graph
    // takes in two nodes to be connected by the edge
    // checks that the two nodes already in graph
    public Edge<T> addEdge(Node<T> node1, Node<T> node2) {
        if (this.nodes.contains(node1) && this.nodes.contains(node2)) {
            Edge<T> newEdge = new Edge<T>(node2);
            node1.addNeighbor(newEdge);
            return newEdge;
        } else {
            throw new IllegalArgumentException("input node/s are not added to graph yet");
        }

    }

    // include the ability to add weight
    public Edge<T> addEdge(Node<T> node1, Node<T> node2, int weight) {
        if (this.nodes.contains(node1) && this.nodes.contains(node2)) {
            Edge<T> newEdge = new Edge<T>(node2, weight);
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

    // accept a starting node and perform a breadth-first traversal on the graph
    // return a collection of the nodes in the order they were visited
    public String breadthFirstTraversal(Node start) {
        HashSet<Node<T>> visited = new HashSet<>();
        Queue<Node<T>> toVisit = new Queue<>();
        LinkedList<Node<T>> ans = new LinkedList<>();
        // StringJoiner is for testing
        StringJoiner result = new StringJoiner(", ");

        visited.add(start);
        ans.add(start);
        toVisit.enqueue(start);
        result.add(start.getValue().toString());
        while (!toVisit.isEmpty()) {
            Node<T> current = toVisit.peek();
            for (Edge<T> neighbor: current.getNeighbors()) {
                Node neighborNode = neighbor.getNode();
                if (!visited.contains(neighborNode)) {
                    toVisit.enqueue(neighborNode);
                    ans.add(neighborNode);
                    visited.add(neighborNode);
                    // for testing
                    result.add(neighborNode.getValue().toString());
                    continue;
                }
            }
            toVisit.dequeue();
        }
//        return ans;

        // For testing purpose, return a string that shows the nodes in order that they were visited
        return result.toString();
    }
}
