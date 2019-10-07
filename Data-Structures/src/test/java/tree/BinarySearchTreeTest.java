package tree;

import org.junit.Before;
import org.junit.Test;

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

}