package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;

import static org.junit.Assert.*;

public class FizzBuzzTreeTest {

    FizzBuzzTree FBT;
    BinaryTree<Object> BT;
    @Before
    public void setUp() throws Exception {
        FBT = new FizzBuzzTree();
        BT = new BinaryTree<Object>();
    }

    // test for
    @Test
    public void testFizzBuzzForBinaryTreeWithMultipleNodesDivisibleBy3And5AndBoth() {
        BT.root = new Node(10);
        BT.root.left = new Node(3);
        BT.root.left.left = new Node(1);
        BT.root.left.right = new Node(5);
        BT.root.right = new Node(15);
        BT.root.right.right = new Node(21);
        BT.root.right.right.left = new Node(20);
        BT.root.right.right.right = new Node(26);



        FBT.FizzBuzzTree(BT);
        // make a string of all the values in the arrayList which are in preorder order
        ArrayList<Object> preorderList = BT.preOrder();
        StringJoiner string = new StringJoiner(", ");

        for(Object value: preorderList) {
            string.add(Objects.toString(value));
        }

        assertEquals("Buzz, Fizz, 1, Buzz, FizzBuzz, Fizz, Buzz, 26", string.toString());
    }
}