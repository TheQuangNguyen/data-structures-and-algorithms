package Data.Structures.linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    // Testing for initializing empty linked list with no nodes
    @Test
    public void testCreateEmptyLinkedList() {
        LinkedList test = new LinkedList();

        assertNull("The head of the linked list should be null initially for empty linked list",
                    test.head);
    }

    // Testing for inserting one single node to the linked list
    @Test
    public void insertOneNode() {
        LinkedList test = new LinkedList();
        test.insert(5);
        Node currentNode = test.head;

        assertEquals(5, currentNode.value);
    }

    // Testing for inserting multiple nodes to the linked list
    @Test
    public void insertMultipleNodes() {
        LinkedList test = new LinkedList();
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);
        Node currentNode = test.head;

        assertEquals(5, currentNode.value);
        currentNode = currentNode.next;
        assertEquals(7, currentNode.value);
        currentNode = currentNode.next;
        assertEquals(9, currentNode.value);
        currentNode = currentNode.next;
        assertEquals(3, currentNode.value);
        currentNode = currentNode.next;
    }

    // Testing includes when the value exists in the linked list
    @Test
    public void includesValueExist() {
        LinkedList test = new LinkedList();
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);

        assertTrue(test.includes(3));
    }

    // Testing includes when the value does not exist in the linked list
    @Test
    public void includesValueNotExist() {
        LinkedList test = new LinkedList();
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);

        assertFalse(test.includes(10));
    }

    // Testing if toString can print all the values in the linked list in one string
    // with each values separated by commas
    @Test
    public void testToStringMultipleValues() {
        LinkedList test = new LinkedList();
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);

        assertEquals("5, 7, 9, 3", test.toString());
    }

    // Test toString for when linked list only have one node
    @Test
    public void testToStringOneValue() {
        LinkedList test = new LinkedList();
        test.insert(5);

        assertEquals("5", test.toString());
    }

    // Test toString for when linked list is empty
    @Test
    public void testToStringEmptyList() {
        LinkedList test = new LinkedList();

        assertEquals("", test.toString());
    }
}