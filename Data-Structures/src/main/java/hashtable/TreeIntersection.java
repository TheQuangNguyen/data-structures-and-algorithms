package hashtable;

import tree.BinaryTree;
import tree.Node;

import java.util.ArrayList;
import java.util.Map;
import java.util.Hashtable;

public class TreeIntersection {

    public static Integer[] treeIntersection(BinaryTree tree1, BinaryTree tree2) {
        Hashtable<Integer, Integer> seenValuesTable = new Hashtable<>();
        treeTraversal(tree1.root, seenValuesTable);
        treeTraversal(tree2.root, seenValuesTable);

        Map.Entry[] result = (Map.Entry[])seenValuesTable.entrySet().toArray();
        ArrayList<Integer> commonValues = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if((Integer)result[i].getValue() > 1) {
                commonValues.add((Integer)result[i].getKey());
            }
        }
        return (Integer[])commonValues.toArray();
    }

    private static void treeTraversal(Node currentNode, Hashtable<Integer, Integer> seenValuesTable) {
        if (currentNode == null) {
            return;
        }

        if (!seenValuesTable.contains((int)currentNode.value)) {
            seenValuesTable.put((Integer)currentNode.value, 1);
        } else {
            seenValuesTable.put((Integer)currentNode.value, seenValuesTable.get((Integer)currentNode.value) + 1);
        }

        treeTraversal(currentNode.left, seenValuesTable);
        treeTraversal(currentNode.right, seenValuesTable);
    }
}
