package tree;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable> {
    Node root;

    public BinarySearchTree(T value) {
        this.root = new Node(value);
    }

    public BinarySearchTree() {
        this.root = null;
    }

    // add a new node with the input value in the correct place in the binary search tree
    public void add(T value) {
        if (contains(value)) {
            return;
        } else {
            this.root = add(this.root, value);
        }
    }

    // helper method for add to traverse the binary tree with recursion
    private Node add(Node currentNode, T value) {
        if (currentNode == null) {
            currentNode = new Node(value);
            return currentNode;
        }
        if (value.compareTo(currentNode.value) > 0) {
            currentNode.right = add(currentNode.right, value);
        } else if (value.compareTo(currentNode.value) < 0) {
            currentNode.left = add(currentNode.left, value);
        }
        return currentNode;
    }

    // check if a given value is already in the BST or not
    public boolean contains(T value) {
        return contains(this.root, value);
    }

    // helper method for contains to traverse the binary tree with recursion
    public boolean contains(Node currentNode, T value) {
        if (currentNode == null) {
            return false;
        }
        if (value.compareTo(currentNode.value) == 0) {
            return true;
        } else if (value.compareTo(currentNode.value) > 0) {
            return contains(currentNode.right, value);
        } else {
            return contains(currentNode.left, value);
        }
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
}
