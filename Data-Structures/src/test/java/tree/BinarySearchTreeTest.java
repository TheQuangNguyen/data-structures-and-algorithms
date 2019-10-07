package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.StringJoiner;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer> BST;
    @Before
    public void setUp() throws Exception {
        BST = new BinarySearchTree<>();
    }

    // Test if we can successfully instantiate an empty BST
    @Test
    public void testCreateEmptyBST() {
        assertNull(BST.root);
    }

    // Test if we can successfully instantiate a BST with a single root node
    @Test
    public void testAddBSTWithSingleNode() {
        BST.add(10);
        assertEquals(10, BST.root.value);
    }

    // Test if we can add left and right child to single root node
    @Test
    public void testAddBSTWithLeftAndRightChild() {
        BST.add(10);
        BST.add(5);
        BST.add(15);

        assertEquals(10, BST.root.value);
        assertEquals(15, BST.root.right.value);
        assertEquals(5, BST.root.left.value);
    }

    // test if we can continue to expand on the tree with more child nodes
    @Test
    public void testAddBSTWithMoreChildNodes() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(20);
        BST.add(13);
        BST.add(8);
        BST.add(0);

        assertEquals(10, BST.root.value);
        assertEquals(15, BST.root.right.value);
        assertEquals(5, BST.root.left.value);
        assertEquals(20, BST.root.right.right.value);
        assertEquals(13, BST.root.right.left.value);
        assertEquals(8, BST.root.left.right.value);
        assertEquals(0, BST.root.left.left.value);
    }

    // test if we can search for a given value if it is in a BST
    @Test
    public void testContainsBSTWithMultipleNodes() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(20);
        BST.add(13);
        BST.add(8);
        BST.add(0);

        assertTrue(BST.contains(13));
        assertTrue(BST.contains(10));
        assertTrue(BST.contains(8));
    }

    // test contains if the values are not in the BST
    @Test
    public void testContainsValueNotInBST() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(20);
        BST.add(13);
        BST.add(8);
        BST.add(0);

        assertFalse(BST.contains(11));
        assertFalse(BST.contains(17));
        assertFalse(BST.contains(-3));
    }

    // Test contains for an empty tree
    @Test
    public void testContainsEmptyBST() {
        assertFalse(BST.contains(10));
    }

    // Test for preOrder Traversal for balanced tree
    @Test
    public void testPreOrderTraversalBalancedBST() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(20);
        BST.add(13);
        BST.add(8);
        BST.add(0);

        // make a string of all the values in the arrayList which are in preorder order
        ArrayList<Integer> preorderList = BST.preOrder();
        StringJoiner string = new StringJoiner(", ");

        for(int value: preorderList) {
            string.add(Integer.toString(value));
        }

        assertEquals("10, 5, 0, 8, 15, 13, 20", string.toString());
    }

    // Test for inOrder Traversal for balanced tree
    @Test
    public void testInOrderTraversalBalancedBST() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(20);
        BST.add(13);
        BST.add(8);
        BST.add(0);

        // make a string of all the values in the arrayList which are in preorder order
        ArrayList<Integer> inOrderList = BST.inOrder();
        StringJoiner string = new StringJoiner(", ");

        for(int value: inOrderList) {
            string.add(Integer.toString(value));
        }

        assertEquals("0, 5, 8, 10, 13, 15, 20", string.toString());
    }

    // Test for postOrder Traversal for balanced tree
    @Test
    public void testPostOrderTraversalBalancedBST() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(20);
        BST.add(13);
        BST.add(8);
        BST.add(0);

        // make a string of all the values in the arrayList which are in preorder order
        ArrayList<Integer> postOrderList = BST.postOrder();
        StringJoiner string = new StringJoiner(", ");

        for(int value: postOrderList) {
            string.add(Integer.toString(value));
        }

        assertEquals("0, 8, 5, 13, 20, 15, 10", string.toString());
    }

    // test preOrder traversal for none balanced tree
    @Test
    public void testPreOrderTraversalNonBalancedBST() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(0);
        BST.add(20);
        BST.add(-5);
        BST.add(3);
        BST.add(1);
        BST.add(4);
        BST.add(18);
        BST.add(30);
        BST.add(40);
        BST.add(50);

        // make a string of all the values in the arrayList which are in preorder order
        ArrayList<Integer> preorderList = BST.preOrder();
        StringJoiner string = new StringJoiner(", ");

        for(int value: preorderList) {
            string.add(Integer.toString(value));
        }

        assertEquals("10, 5, 0, -5, 3, 1, 4, 15, 20, 18, 30, 40, 50", string.toString());
    }

    // test inOrder traversal for none balanced tree
    @Test
    public void testInOrderTraversalNonBalancedBST() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(0);
        BST.add(20);
        BST.add(-5);
        BST.add(3);
        BST.add(1);
        BST.add(4);
        BST.add(18);
        BST.add(30);
        BST.add(40);
        BST.add(50);

        // make a string of all the values in the arrayList which are in preorder order
        ArrayList<Integer> inOrderList = BST.inOrder();
        StringJoiner string = new StringJoiner(", ");

        for(int value: inOrderList) {
            string.add(Integer.toString(value));
        }

        assertEquals("-5, 0, 1, 3, 4, 5, 10, 15, 18, 20, 30, 40, 50", string.toString());
    }

    // test postOrder traversal for none balanced tree
    @Test
    public void testPostOrderTraversalNonBalancedBST() {
        BST.add(10);
        BST.add(5);
        BST.add(15);
        BST.add(0);
        BST.add(20);
        BST.add(-5);
        BST.add(3);
        BST.add(1);
        BST.add(4);
        BST.add(18);
        BST.add(30);
        BST.add(40);
        BST.add(50);

        // make a string of all the values in the arrayList which are in preorder order
        ArrayList<Integer> postOrderList = BST.postOrder();
        StringJoiner string = new StringJoiner(", ");

        for(int value: postOrderList) {
            string.add(Integer.toString(value));
        }

        assertEquals("-5, 1, 4, 3, 0, 5, 18, 50, 40, 30, 20, 15, 10", string.toString());
    }
}