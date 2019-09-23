package doublyLinkedList;

import doublyLinkedList.DoublyLinkedList;
import doublyLinkedList.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    // Testing for initializing empty linked list with no nodes
    @Test
    public void testCreateEmptyDoublyLinkedList() {
        DoublyLinkedList test = new DoublyLinkedList();

        assertNull("The head of the linked list should be null initially for empty linked list",
            test.head);
        assertNull("The tail of the linked list should be null initially for empty linked list", test.tail);
    }

    // Testing for inserting one single node to the linked list
    @Test
    public void insertOneNode() {
        DoublyLinkedList test = new DoublyLinkedList();
        test.insert(5);

        assertEquals("Head of linked list should have value of 5",5, test.head.value);
        assertEquals("Tail of linked list should have value of 5",5, test.tail.value);
    }

    // Testing for inserting multiple nodes to the linked list
    @Test
    public void insertMultipleNodes() {
        DoublyLinkedList test = new DoublyLinkedList();
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);
        Node currentNode = test.head;

        assertEquals(3, currentNode.value);
        currentNode = currentNode.next;
        assertEquals(9, currentNode.value);
        currentNode = currentNode.next;
        assertEquals(7, currentNode.value);
        currentNode = currentNode.next;
        assertEquals(5, currentNode.value);
        currentNode = currentNode.next;
        assertEquals("Test if head is 3 for beginning of linked list", 3, test.head.value);
        assertEquals("Test if tail is 5 for end of linked list", 5, test.tail.value);
    }

    // Testing includes when the value exists in the linked list
    @Test
    public void includesValueExist() {
        DoublyLinkedList test = new DoublyLinkedList();
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);

        assertTrue(test.includes(3));
    }

    // Testing includes when the value does not exist in the linked list
    @Test
    public void includesValueNotExist() {
        DoublyLinkedList test = new DoublyLinkedList();
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);

        assertFalse(test.includes(10));
    }

    // Testing if toString can print all the values in the linked list in one string
    // with each values separated by commas from back of list to front
    @Test
    public void testToStringMultipleValues() {
        DoublyLinkedList test = new DoublyLinkedList();
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);

        assertEquals("5, 7, 9, 3", test.toString());
    }

    // Test toString for when linked list only have one node
    @Test
    public void testToStringOneValue() {
        DoublyLinkedList test = new DoublyLinkedList();
        test.insert(5);

        assertEquals("5", test.toString());
    }

    // Test toString for when linked list is empty
    @Test
    public void testToStringEmptyList() {
        DoublyLinkedList test = new DoublyLinkedList();

        assertEquals("", test.toString());
    }
}