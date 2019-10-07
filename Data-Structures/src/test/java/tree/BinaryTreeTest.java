package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree<Integer> BT;
    @Before
    public void setUp() throws Exception {
        BT = new BinaryTree<>();
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
}