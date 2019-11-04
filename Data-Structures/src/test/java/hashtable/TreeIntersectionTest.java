package hashtable;

import org.junit.Before;
import org.junit.Test;
import tree.BinaryTree;
import static hashtable.TreeIntersection.*;
import static org.junit.Assert.*;

public class TreeIntersectionTest {

    BinaryTree tree1;
    BinaryTree tree2;

    @Before
    public void setUp() throws Exception {
        tree1 = new BinaryTree();
        tree2 = new BinaryTree();
    }

    @Test
    public void testTreeIntersectionForNormalCaseOfTwoTreesHavingDuplicateValues() {
        tree1.root.value = 150;             //                          150
        tree1.root.left.value = 100;        //                  100             250
        tree1.root.right.value = 250;       //              75      160     200     350
        tree1.root.left.left.value = 75;    //                  125     175     300     500
        tree1.root.left.right.value = 160;
        tree1.root.left.right.left.value = 125;
        tree1.root.left.right.right.value = 175;
        tree1.root.right.left.value = 200;
        tree1.root.right.right.value = 350;
        tree1.root.right.right.left.value = 300;
        tree1.root.right.right.right.value = 500;

        tree1.root.value = 42;              //                          42
        tree1.root.left.value = 100;        //                  100             600
        tree1.root.right.value = 600;       //              15      160     200     350
        tree1.root.left.left.value = 15;    //                  125     175     4       500
        tree1.root.left.right.value = 160;
        tree1.root.left.right.left.value = 125;
        tree1.root.left.right.right.value = 175;
        tree1.root.right.left.value = 200;
        tree1.root.right.right.value = 350;
        tree1.root.right.right.left.value = 4;
        tree1.root.right.right.right.value = 500;

        Integer[] result = treeIntersection(tree1, tree2);
        assertArrayEquals(new Integer[]{150,100,75,160,125,175,250,200,}, result);
    }
}