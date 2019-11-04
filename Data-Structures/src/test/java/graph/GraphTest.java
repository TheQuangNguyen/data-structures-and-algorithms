package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

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
        assertFalse(edgeList2.contains(edge));
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

}