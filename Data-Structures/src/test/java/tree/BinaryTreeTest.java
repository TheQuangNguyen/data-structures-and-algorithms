package tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree<Integer> BT;
    // I got how to test for console message here https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private ByteArrayOutputStream consoleMessage = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        BT = new BinaryTree<>();
        System.setOut(new PrintStream(consoleMessage));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // test if we can instantiate an empty binary tree
    @Test
    public void testCreateEmptyTree() {
        assertNull(BT.root);
    }

    // test if we can add a single node to BT
    @Test
    public void testAddSingleNodeToBT() {
        BT.add(10);
        assertEquals(10, BT.root.value);
    }

    // test preOrder traversal on binary tree with multiple nodes
    @Test
    public void testPreOrderTraversalOnBTWithMultipleNodes() {
        BT.add(1);
        BT.add(2);
        BT.add(3);
        BT.add(4);
        BT.add(5);
        BT.add(6);

        ArrayList<Integer> preorder = BT.preOrder();
        for (int value :preorder) {
            System.out.println(value);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////

    // test breadth-first for empty tree
    @Test
    public void testBreadthFirstEmptyTree() {
        BT.breadthFirstPrint();
        assertEquals("", consoleMessage.toString());
    }

    // test breadth-first for binary tree with single node
    @Test
    public void testBreadthFirstSingleNode() {
        BT.root = new Node(10);
        BT.breadthFirstPrint();
        assertEquals("10", consoleMessage.toString());
    }

    // test breadth-first for binary tree with three nodes
    @Test
    public void testBreadthFirstThreeNodes2Levels() {
        BT.root = new Node(10);
        BT.root.left = new Node(20);
        BT.root.right = new Node(50);
        BT.breadthFirstPrint();
        assertEquals("10\n20\n50", consoleMessage.toString());
    }

    // test breadth-first for binary tree with multiple levels and nodes
    @Test
    public void testBreadthFirstMultipleLevelsAndNodes() {
        BT.root = new Node(1);
        BT.root.left = new Node(2);
        BT.root.right = new Node(3);
        BT.root.left.right = new Node(4);
        BT.root.left.right.left = new Node(7);
        BT.root.left.right.right = new Node(8);
        BT.root.right.left = new Node(5);
        BT.root.right.right = new Node(6);
        BT.root.right.left.right = new Node(9);
        BT.root.right.left.right.right = new Node(10);
        BT.breadthFirstPrint();

        assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n10", consoleMessage.toString());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    // test find max for tree that has one node
    @Test
    public void testFindMaxOneNodeTree() {
        BT.root = new Node(10);
        int max = BT.findMaximumValue();

        assertEquals(10, max);
    }

    // test find max for tree that has two nodes
    @Test
    public void testFindMaxTwoNodesTree() {
        BT.root = new Node(5);
        BT.root.right = new Node(1);
        int max = BT.findMaximumValue();

        assertEquals(5, max);
    }

    // test find max for tree that has three nodes
    @Test
    public void testFindMaxThreeNodesTree() {
        BT.root = new Node(5);
        BT.root.right = new Node(1);
        BT.root.left = new Node(10);
        int max = BT.findMaximumValue();

        assertEquals(10, max);
    }

    // test find max for tree that has multiple nodes
    @Test
    public void testFindMaxMultipleNodes() {
        BT.root = new Node(6);
        BT.root.left = new Node(1);
        BT.root.right = new Node(10);
        BT.root.left.right = new Node(4);
        BT.root.left.right.left = new Node(15);
        BT.root.left.right.right = new Node(0);
        BT.root.right.left = new Node(3);
        BT.root.right.right = new Node(24);
        BT.root.right.left.right = new Node(15);
        BT.root.right.left.right.right = new Node(24);

        int max = BT.findMaximumValue();

        assertEquals(24, max);
    }
}