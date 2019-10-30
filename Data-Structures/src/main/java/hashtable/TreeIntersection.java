package hashtable;

import tree.BinaryTree;
import tree.Node;

public class TreeIntersection {

    public Integer[] treeIntersection(BinaryTree tree1, BinaryTree tree2) {
        Hashtable<Integer, Integer> seenValuesTable = new Hashtable<>();

    }

    public Hashtable<Integer, Integer> treeTraversal(Node currentNode, Hashtable<Integer, Integer> seenValuesTable) {
        if (currentNode == null) {
            return seenValuesTable;
        }

        if (!seenValuesTable.contains((int)currentNode.value)) {
            seenValuesTable.add((Integer)currentNode.value, 1);
        }
    }
}
