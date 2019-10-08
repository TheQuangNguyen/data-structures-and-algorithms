package tree;

public class FizzBuzzTree {
    public static BinaryTree<Object> FizzBuzzTree(BinaryTree<Object> tree) {
        FBT(tree.root);
        return tree;
    }

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
