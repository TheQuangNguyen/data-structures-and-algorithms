package tree;

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
}
