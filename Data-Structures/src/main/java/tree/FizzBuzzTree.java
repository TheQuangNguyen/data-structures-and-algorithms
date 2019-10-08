package tree;

public class FizzBuzzTree {

    // method that change values of nodes in a tree to either Fizz, Buzz, or FizzBuzz
    public static BinaryTree<Object> FizzBuzzTree(BinaryTree<Object> tree) {
        FBT(tree.root);
        return tree;
    }

    // helper method to FizzBuzzTree that recursively traverse the tree
    private static void FBT(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        if ((Integer)currentNode.value % (3*5) == 0) {
            currentNode.value = "FizzBuzz";
        } else if ((Integer)currentNode.value % 3 == 0) {
            currentNode.value = "Fizz";
        } else if ((Integer)currentNode.value % 5 == 0) {
            currentNode.value = "Buzz";
        }
        FBT(currentNode.left);
        FBT(currentNode.right);
    }
}
