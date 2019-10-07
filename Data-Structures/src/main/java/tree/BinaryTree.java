package tree;

import stacksandqueues.Queue;
import stacksandqueues.Stack;

import java.util.ArrayList;

public class BinaryTree<T> {
    Node root;

    public BinaryTree(T value) {
        this.root = new Node(value);
    }

    public BinaryTree() {
        this.root = null;
    }

    // pre-order traversal which adds the value of the node in an array before doing down left and right children
    public ArrayList<T> preOrder() {
        ArrayList<T> values = new ArrayList<>();
        return preOrder(this.root, values);
    }

    // helper method for pre-order traversal
    private ArrayList<T> preOrder(Node currentNode, ArrayList<T> values) {
        if (currentNode == null) {
            return values;
        }
        values.add((T)currentNode.value);
        values = preOrder(currentNode.left, values);
        values = preOrder(currentNode.right, values);
        return values;
    }

    // in-order traversal which adds the value of the node in an array after going all the way down the left children
    public ArrayList<T> inOrder() {
        ArrayList<T> values = new ArrayList<>();
        return inOrder(this.root, values);
    }

    // helper method for in-order traversal
    private ArrayList<T> inOrder(Node currentNode, ArrayList<T> values) {
        if (currentNode == null) {
            return values;
        }
        values = inOrder(currentNode.left, values);
        values.add((T)currentNode.value);
        values = inOrder(currentNode.right, values);
        return values;
    }

    // post-order traversal which adds the value of the node in an array after going down both the left and right children
    public ArrayList<T> postOrder() {
        ArrayList<T> values = new ArrayList<>();
        return postOrder(this.root, values);
    }

    // helper method for post-order traversal
    private ArrayList<T> postOrder(Node currentNode, ArrayList<T> values) {
        if (currentNode == null) {
            return values;
        }
        values = postOrder(currentNode.left, values);
        values = postOrder(currentNode.right, values);
        values.add((T)currentNode.value);
        return values;
    }

    // add new value to binary tree by randomly choose to traverse down the tree either going
    // right or left and insert the node whenever there is an empty spot.
    public void add(T value) {
        this.root = add(this.root, value);
    }

    // helper method for adding new value to binary tree using recursion
    private Node add(Node currentNode, T value) {
        if (currentNode == null) {
            currentNode = new Node(value);
            return currentNode;
        }
        double randomNum = Math.random();
        if (randomNum >= 0.5) {
            currentNode.right = add(currentNode.right, value);
        } else {
            currentNode.left = add(currentNode.left, value);
        }
        return currentNode;
    }

//    @Override
//    public String toString() {
//        StringBuilder tree = new StringBuilder();
//        Queue<T> queue = new Queue<>();
//
//    }
//
//    private String helperToString(Queue queue, StringBuilder tree) {
//        Node currentNode = queue.dequeueNode();
//        queue.enqueue(currentNode.left);
//        queue.enqueue(currentNode.right);
//    }
}
