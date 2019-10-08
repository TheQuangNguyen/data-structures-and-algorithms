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

    // test for one single node that is only divisible by 3
    @Test
    public void testFizzBuzzWithOneNodeDivisibleBy3() {
        BT.root = new Node(12);

        FBT.FizzBuzzTree(BT);
        ArrayList<Object> preorderList = BT.preOrder();
        StringJoiner string = new StringJoiner(", ");

        for(Object value: preorderList) {
            string.add(Objects.toString(value));
        }

        assertEquals("Fizz", string.toString());
    }

    // test for one single node that is only divisible by 5
    @Test
    public void testFizzBuzzWithOneNodeDivisibleBy5() {
        BT.root = new Node(35);

        FBT.FizzBuzzTree(BT);
        ArrayList<Object> preorderList = BT.preOrder();
        StringJoiner string = new StringJoiner(", ");

        for(Object value: preorderList) {
            string.add(Objects.toString(value));
        }

        assertEquals("Buzz", string.toString());
    }

    // test for one single node that is divisible by 3 and 5
    @Test
    public void testFizzBuzzWithOneNodeDivisibleBy3And5() {
        BT.root = new Node(30);

        FBT.FizzBuzzTree(BT);
        ArrayList<Object> preorderList = BT.preOrder();
        StringJoiner string = new StringJoiner(", ");

        for(Object value: preorderList) {
            string.add(Objects.toString(value));
        }

        assertEquals("FizzBuzz", string.toString());
    }

    // test for Binary Tree with multiple nodes that are combination of divisible by 3, 5, and both.
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

    // test fizzbuzz with empty tree. Return should be empty list
    @Test
    public void testFizzBuzzEmptyTree() {
        FBT.FizzBuzzTree(BT);
        // make a string of all the values in the arrayList which are in preorder order
        ArrayList<Object> preorderList = BT.preOrder();
        StringJoiner string = new StringJoiner(", ");

        for(Object value: preorderList) {
            string.add(Objects.toString(value));
        }

        assertEquals("", string.toString());
    }
}