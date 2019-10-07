package tree;

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
    public ArrayList<T> preOrder(Node currentNode, ArrayList<T> values) {
        if (currentNode == null) {
            return values;
        } else {
            values.add((T)currentNode.value);
        }
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
    public ArrayList<T> inOrder(Node currentNode, ArrayList<T> values) {
        values = preOrder(currentNode.left, values);
        if (currentNode == null) {
            return values;
        } else {
            values.add((T)currentNode.value);
        }
        values = preOrder(currentNode.right, values);
        return values;
    }

    // post-order traversal which adds the value of the node in an array after going down both the left and right children
    public ArrayList<T> postOrder() {
        ArrayList<T> values = new ArrayList<>();
        return postOrder(this.root, values);
    }

    // helper method for post-order traversal
    public ArrayList<T> postOrder(Node currentNode, ArrayList<T> values) {
        values = preOrder(currentNode.left, values);
        values = preOrder(currentNode.right, values);
        if (currentNode == null) {
            return values;
        } else {
            values.add((T)currentNode.value);
            return values;
        }
    }
}
