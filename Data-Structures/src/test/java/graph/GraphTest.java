package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import static org.junit.Assert.*;

public class GraphTest {

    Graph<String> graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph<>();
    }

    // test that we can one node to the graph class
    // also test that we can return a set of all nodes in the graph to check if the node we just added is there or not
    @Test
    public void testAddOneNode() {
        Node<String> newNode = graph.addNode("test");
        Set<Node<String>> allNodes = graph.getNodes();

        assertTrue(allNodes.contains(newNode));
    }

    // test that we can add multiple nodes in the graph
    @Test
    public void testAddMultipleNodes() {
        Node<String> node1 = graph.addNode("first node");
        Node<String> node2 = graph.addNode("second node");
        Node<String> node3 = graph.addNode("third node");
        Node<String> node4 = graph.addNode("fourth node");
        Node<String> node5 = graph.addNode("fifth node");
        Set<Node<String>> allNodes = graph.getNodes();

        assertTrue(allNodes.contains(node1));
        assertTrue(allNodes.contains(node2));
        assertTrue(allNodes.contains(node3));
        assertTrue(allNodes.contains(node4));
        assertTrue(allNodes.contains(node5));
    }

    // test that we can add a unidirectional edge that points one node to another but not vice versa
    // also test get neighbors to see if it can return a list of connections for a node
    @Test
    public void testAddOneEdge() {
        Node<String> node1 = graph.addNode("first node");
        Node<String> node2 = graph.addNode("second node");
        Edge edge = graph.addEdge(node1, node2);

        List<Edge<String>> edgeList1 = graph.getNeighbors(node1);
        List<Edge<String>> edgeList2 = graph.getNeighbors(node2);

        // node1 points to node2 but node2 does not point to node1
        assertTrue(edgeList1.contains(edge));
        assertNull(edgeList2);
        assertEquals(node2, edge.getNode());
    }

    // test that we can add multiple edges for multiple nodes
    @Test
    public void testAddMultipleEdgesAndNodes() {
        Node<String> node1 = graph.addNode("first node");
        Node<String> node2 = graph.addNode("second node");
        Node<String> node3 = graph.addNode("third node");
        Node<String> node4 = graph.addNode("fourth node");
        Node<String> node5 = graph.addNode("fifth node");

        // create a bi-directional connection between node1 and node2
        // node1 points to node2, node3, and node4 and have node2 points to it
        // node 2 points to only node 1 and have node 1 points to it
        // node 3 points to none and have node1 and node4 points to it
        // node 4 points to node3 and have node1 points to it
        // node 5 points to none and have no nodes points to it (island)
        Edge edge1_2 = graph.addEdge(node1, node2);
        Edge edge2_1 = graph.addEdge(node2, node1);
        Edge edge4_3 = graph.addEdge(node4, node3);
        Edge edge1_4 = graph.addEdge(node1, node4);
        Edge edge1_3 = graph.addEdge(node1, node3);

        // getting list of neighbors of each node
        List<Edge<String>> edgeList1 = graph.getNeighbors(node1);
        List<Edge<String>> edgeList2 = graph.getNeighbors(node2);
        List<Edge<String>> edgeList3 = graph.getNeighbors(node3);
        List<Edge<String>> edgeList4 = graph.getNeighbors(node4);
        List<Edge<String>> edgeList5 = graph.getNeighbors(node5);

        // neighbors of node1
        assertTrue(edgeList1.contains(edge1_2));
        assertTrue(edgeList1.contains(edge1_3));
        assertTrue(edgeList1.contains(edge1_4));

        // neighbors of node2
        assertTrue(edgeList2.contains(edge2_1));

        // neighbors of node3
        assertNull(edgeList3);

        // neighbors of node4
        assertTrue(edgeList4.contains(edge4_3));

        // neighbors of node5
        assertNull(edgeList5);
    }

    // test that we can add weights to the edge connection
    @Test
    public void testAddEdgeWithWeights() {
        Node<String> node1 = graph.addNode("first node");
        Node<String> node2 = graph.addNode("second node");
        Edge edge1_2 = graph.addEdge(node1, node2, 10);
        Edge edge2_1 = graph.addEdge(node2, node1, 5);

        List<Edge<String>> edgeList1 = graph.getNeighbors(node1);
        List<Edge<String>> edgeList2 = graph.getNeighbors(node2);

        // node1 points to node2 with weights of 10 and node2 points to node1 with weights of 5
        assertTrue(edgeList1.contains(edge1_2));
        assertTrue(edgeList2.contains(edge2_1));
        assertEquals(node2, edge1_2.getNode());
        assertEquals(node1, edge2_1.getNode());
        assertEquals(10, edge1_2.getWeight());
        assertEquals(5, edge2_1.getWeight());
    }

    // test adding a single node and an edge that points to itself
    @Test
    public void testAddOneNodeAndOneEdge() {
        Node<String> node1 = graph.addNode("first node");
        Edge edge = graph.addEdge(node1, node1);

        List<Edge<String>> edgeList = graph.getNeighbors(node1);

        assertTrue(edgeList.contains(edge));
        assertEquals(node1, edge.getNode());
    }

    // test we can get the right amount of nodes in the graph
    @Test
    public void testSizeForMultipleNodes() {
        Node<String> node1 = graph.addNode("first node");
        Node<String> node2 = graph.addNode("second node");
        Node<String> node3 = graph.addNode("third node");
        Node<String> node4 = graph.addNode("fourth node");
        Node<String> node5 = graph.addNode("fifth node");

        assertEquals(5, graph.size());
    }

    // test that for empty graph, we return zero for size
    @Test
    public void testSizeForEmptyGraph() {
        assertEquals(0, graph.size());
    }

    // test that an empty graph return null for getting a collection of nodes
    @Test
    public void testGetNodesForEmptyGraph() {
        assertNull(graph.getNodes());
    }

    // test that a node that has no edges in its list should return null for getNeighbors
    @Test
    public void testGetNeighborsEmptyList() {
        Node<String> test = graph.addNode("test");
        assertNull(graph.getNeighbors(test));
    }

    // test that an exception will occur if an edge is made between node/s that are not in the graph
    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeBetweenNodesThatHaveNotAddedToGraph() {
        Node<String> node1 = new Node("first node, not in graph");
        Node<String> node2 = new Node("second node, not in graph");
        Node<String> node3 = graph.addNode("third node. This one is in the graph");

        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node1);
    }

    ///////////////////////////////////// Breadth First Traversal Test //////////////////////////////////////////////////

    // Test for normal case like the example in the challenge description
    @Test
    public void testBreadthFirstNormalCaseWhereMostNodesAreConnectedBiDirectionalToEachOther() {
        Node pandora = graph.addNode("Pandora");
        Node arendelle = graph.addNode("Arendelle");
        Node metroville = graph.addNode("Metroville");
        Node monstropolis = graph.addNode("Monstropolis");
        Node narnia = graph.addNode("Narnia");
        Node naboo = graph.addNode("Naboo");

        graph.addEdge(pandora, arendelle);
        graph.addEdge(arendelle, pandora);
        graph.addEdge(arendelle, metroville);
        graph.addEdge(arendelle, monstropolis);
        graph.addEdge(metroville, arendelle);
        graph.addEdge(metroville, narnia);
        graph.addEdge(metroville, naboo);
        graph.addEdge(metroville, monstropolis);
        graph.addEdge(monstropolis, arendelle);
        graph.addEdge(monstropolis, metroville);
        graph.addEdge(monstropolis, naboo);
        graph.addEdge(naboo, narnia);
        graph.addEdge(naboo, metroville);
        graph.addEdge(naboo, monstropolis);
        graph.addEdge(narnia, metroville);
        graph.addEdge(narnia, naboo);

        String result = graph.breadthFirstTraversal(naboo);
        assertEquals("Naboo, Narnia, Metroville, Monstropolis, Arendelle, Pandora", result);
    }

    // test for like the last case but narnia is not connect to anyone
    @Test
    public void testBreadthFirstWhereThereIsIsland() {
        Node pandora = graph.addNode("Pandora");
        Node arendelle = graph.addNode("Arendelle");
        Node metroville = graph.addNode("Metroville");
        Node monstropolis = graph.addNode("Monstropolis");
        Node narnia = graph.addNode("Narnia");
        Node naboo = graph.addNode("Naboo");

        graph.addEdge(pandora, arendelle);
        graph.addEdge(arendelle, pandora);
        graph.addEdge(arendelle, metroville);
        graph.addEdge(arendelle, monstropolis);
        graph.addEdge(metroville, arendelle);
        graph.addEdge(metroville, naboo);
        graph.addEdge(metroville, monstropolis);
        graph.addEdge(monstropolis, arendelle);
        graph.addEdge(monstropolis, metroville);
        graph.addEdge(monstropolis, naboo);
        graph.addEdge(naboo, metroville);
        graph.addEdge(naboo, monstropolis);

        String result = graph.breadthFirstTraversal(naboo);
        assertEquals("Naboo, Metroville, Monstropolis, Arendelle, Pandora", result);
    }

    // test for when edge between pandora nd arendelle is uni-directional meaning pandora only points to arendelle but arendelle does not point to pandora
    @Test
    public void testBreadthFirstUniDirectionalEdge() {
        Node pandora = graph.addNode("Pandora");
        Node arendelle = graph.addNode("Arendelle");
        Node metroville = graph.addNode("Metroville");
        Node monstropolis = graph.addNode("Monstropolis");
        Node narnia = graph.addNode("Narnia");
        Node naboo = graph.addNode("Naboo");

        graph.addEdge(pandora, arendelle);
        graph.addEdge(arendelle, metroville);
        graph.addEdge(arendelle, monstropolis);
        graph.addEdge(metroville, arendelle);
        graph.addEdge(metroville, narnia);
        graph.addEdge(metroville, naboo);
        graph.addEdge(metroville, monstropolis);
        graph.addEdge(monstropolis, arendelle);
        graph.addEdge(monstropolis, metroville);
        graph.addEdge(monstropolis, naboo);
        graph.addEdge(naboo, narnia);
        graph.addEdge(naboo, metroville);
        graph.addEdge(naboo, monstropolis);
        graph.addEdge(narnia, metroville);
        graph.addEdge(narnia, naboo);

        String result = graph.breadthFirstTraversal(naboo);
        assertEquals("Naboo, Narnia, Metroville, Monstropolis, Arendelle", result);
    }

    ///////////////////////////////////// Depth First Traversal Test //////////////////////////////////////////////////

    // test for normal case where nodes are connected to each other in various ways
    @Test
    public void testDepthFirstTraversalNormalCase() {
        Node<String> A = graph.addNode("A");
        Node<String> B = graph.addNode("B");
        Node<String> C = graph.addNode("C");
        Node<String> D = graph.addNode("D");
        Node<String> E = graph.addNode("E");
        Node<String> F = graph.addNode("F");
        Node<String> G = graph.addNode("G");
        Node<String> H = graph.addNode("H");

        graph.addEdge(A, B);
        graph.addEdge(A, D);
        graph.addEdge(B, A);
        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(C, B);
        graph.addEdge(C, G);
        graph.addEdge(D, A);
        graph.addEdge(D, B);
        graph.addEdge(D, E);
        graph.addEdge(D, F);
        graph.addEdge(D, H);
        graph.addEdge(E, D);
        graph.addEdge(F, D);
        graph.addEdge(F, H);
        graph.addEdge(H, D);
        graph.addEdge(H, F);

        List<Node<String>> result = graph.depthFirstTraversal(A);
        StringJoiner actual = new StringJoiner(", ");
        for(Node<String> node : result) {
            actual.add(node.getValue());
        }

        assertEquals("A, D, H, F, E, B, C, G", actual.toString());
    }

    // test when there is an island. H would be the island
    @Test
    public void testDepthFirstTraversalWhenThereIsAnIslandNode() {
        Node<String> A = graph.addNode("A");
        Node<String> B = graph.addNode("B");
        Node<String> C = graph.addNode("C");
        Node<String> D = graph.addNode("D");
        Node<String> E = graph.addNode("E");
        Node<String> F = graph.addNode("F");
        Node<String> G = graph.addNode("G");
        Node<String> H = graph.addNode("H");

        graph.addEdge(A, B);
        graph.addEdge(A, D);
        graph.addEdge(B, A);
        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(C, B);
        graph.addEdge(C, G);
        graph.addEdge(D, A);
        graph.addEdge(D, B);
        graph.addEdge(D, E);
        graph.addEdge(D, F);
        graph.addEdge(E, D);
        graph.addEdge(F, D);

        List<Node<String>> result = graph.depthFirstTraversal(A);
        StringJoiner actual = new StringJoiner(", ");
        for(Node<String> node : result) {
            actual.add(node.getValue());
        }

        assertEquals("A, D, F, E, B, C, G", actual.toString());
    }

    // test when E is connected to H instead of D
    @Test
    public void testDepthFirstTraversalForTwoPathsThatAreEqualDepth() {
        Node<String> A = graph.addNode("A");
        Node<String> B = graph.addNode("B");
        Node<String> C = graph.addNode("C");
        Node<String> D = graph.addNode("D");
        Node<String> E = graph.addNode("E");
        Node<String> F = graph.addNode("F");
        Node<String> G = graph.addNode("G");
        Node<String> H = graph.addNode("H");

        graph.addEdge(A, B);
        graph.addEdge(A, D);
        graph.addEdge(B, A);
        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(C, B);
        graph.addEdge(C, G);
        graph.addEdge(D, A);
        graph.addEdge(D, B);
        graph.addEdge(D, F);
        graph.addEdge(D, H);
        graph.addEdge(E, H);
        graph.addEdge(F, D);
        graph.addEdge(F, H);
        graph.addEdge(H, D);
        graph.addEdge(H, F);
        graph.addEdge(H, E);

        List<Node<String>> result = graph.depthFirstTraversal(A);
        StringJoiner actual = new StringJoiner(", ");
        for(Node<String> node : result) {
            actual.add(node.getValue());
        }

        assertEquals("A, D, H, E, F, B, C, G", actual.toString());
    }

    // Test when the graph is secretly a linked list
    @Test
    public void testDepthFirstTraversalForGraphThatIsLinkedList() {
        Node<String> A = graph.addNode("A");
        Node<String> B = graph.addNode("B");
        Node<String> C = graph.addNode("C");
        Node<String> D = graph.addNode("D");
        Node<String> E = graph.addNode("E");
        Node<String> F = graph.addNode("F");
        Node<String> G = graph.addNode("G");
        Node<String> H = graph.addNode("H");

        graph.addEdge(A, B);
        graph.addEdge(B, C);
        graph.addEdge(C, D);
        graph.addEdge(D, E);
        graph.addEdge(E, F);
        graph.addEdge(F, G);
        graph.addEdge(G, H);

        List<Node<String>> result = graph.depthFirstTraversal(A);
        StringJoiner actual = new StringJoiner(", ");
        for(Node<String> node : result) {
            actual.add(node.getValue());
        }

        assertEquals("A, B, C, D, E, F, G, H", actual.toString());
    }

    // Test when every letters are connect to A and nothing else
    @Test
    public void testDepthFirstTraversalForGraphOfSingleLevel() {
        Node<String> A = graph.addNode("A");
        Node<String> B = graph.addNode("B");
        Node<String> C = graph.addNode("C");
        Node<String> D = graph.addNode("D");
        Node<String> E = graph.addNode("E");

        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(A, D);
        graph.addEdge(A, E);

        List<Node<String>> result = graph.depthFirstTraversal(A);
        StringJoiner actual = new StringJoiner(", ");
        for(Node<String> node : result) {
            actual.add(node.getValue());
        }

        assertEquals("A, E, D, C, B", actual.toString());
    }
}