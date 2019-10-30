package hashtable;

import tree.BinaryTree;
import tree.Node;

import java.util.ArrayList;

public class TreeIntersection {

    public Integer[] treeIntersection(BinaryTree tree1, BinaryTree tree2) {
        Hashtable<Integer, Integer> seenValuesTable = new Hashtable<>();
        treeTraversal(tree1.root, seenValuesTable);
        treeTraversal(tree2.root, seenValuesTable);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < seenValuesTable.hashtable.length; i++) {
            while(seenValuesTable.hashtable[i].)
        }
    }

    public void treeTraversal(Node currentNode, Hashtable<Integer, Integer> seenValuesTable) {
        if (currentNode == null) {
            return;
        }

        if (!seenValuesTable.contains((int)currentNode.value)) {
            seenValuesTable.add((Integer)currentNode.value, 1);
        }

        treeTraversal(currentNode.left, seenValuesTable);
        treeTraversal(currentNode.right, seenValuesTable);
    }
}
