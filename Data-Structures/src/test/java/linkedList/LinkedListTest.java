package linkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList<Integer> test;
    @Before
    public void setUp() throws Exception {
        test = new LinkedList<>();
    }

    // Testing for initializing empty linked list with no nodes
    @Test
    public void testCreateEmptyLinkedList() {
        assertNull("The head of the linked list should be null initially for empty linked list",
                    test.head);
    }

    // Testing for inserting one single node to the linked list
    @Test
    public void insertOneNode() {
        test.insert(5);
        Node currentNode = test.head;

        assertEquals(5, currentNode.value);
    }

    // Testing for inserting multiple nodes to the linked list
    @Test
    public void insertMultipleNodes() {
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
    }

    // Testing includes when the value exists in the linked list
    @Test
    public void includesValueExist() {
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);

        assertTrue(test.includes(3));
    }

    // Testing includes when the value does not exist in the linked list
    @Test
    public void includesValueNotExist() {
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
        test.insert(5);
        test.insert(7);
        test.insert(9);
        test.insert(3);

        assertEquals("3, 9, 7, 5", test.toString());
    }

    // Test toString for when linked list only have one node
    @Test
    public void testToStringOneValue() {
        test.insert(5);

        assertEquals("5", test.toString());
    }

    // Test toString for when linked list is empty
    @Test
    public void testToStringEmptyList() {
        assertEquals("", test.toString());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Testing append to the end of the list when the list already have multiple nodes
    @Test
    public void testAppendMultipleNodesExist() {
        test.insert(10);
        test.insert(5);
        test.insert(20);
        test.insert(30);
        test.append(100);

        Node currentNode = test.head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        assertEquals(100, currentNode.value);
    }

    // Testing append to the end of the list when the list have only one node
    @Test
    public void testAppendOneNodeExist() {
        test.insert(10);
        test.append(100);

        Node currentNode = test.head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        assertEquals(100, currentNode.value);
    }

    // Testing append to the end of the list when the list is empty
    @Test
    public void testAppendEmptyList() {
        test.append(100);

        Node currentNode = test.head;
        assertEquals(100, currentNode.value);
    }

    // Testing insert before in the middle of the list when there are multiple nodes
    @Test
    public void testInsertBeforeMiddleOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.insertBefore(30, 25);

        Node currentNode = test.head;
        assertEquals("Testing for the third thing on the list after insertBefore which should be 25",
                    25,
                    currentNode.next.next.value);
    }

    // Testing insert before in the beginning of the list when there are multiple nodes
    @Test
    public void testInsertBeforeBeginningOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.insertBefore(10, 5);

        Node currentNode = test.head;
        assertEquals("Testing for the first thing on the list after insertBefore which should be 5",
            5,
            currentNode.value);
    }

    // Testing insert before in the end of the list when there are multiple nodes
    @Test
    public void testInsertBeforeEndOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.insertBefore(50, 45);

        Node currentNode = test.head;
        assertEquals("Testing for the second to last thing on the list after insertBefore which should be 45",
            45,
            currentNode.next.next.next.next.value);
    }

    // Testing insert before when list is empty/ value does not exist
    @Test
    public void testInsertBeforeEmptyList() {
        Node currentNode = test.head;
        assertFalse("Testing for if the value of 10 does not exist in the list, should return false",
                    test.insertBefore(10, 5));
    }

    // Testing for if there are duplicates value in the linked list
    @Test
    public void testInsertBeforeDuplicates() {
        test.insert(50);
        test.insert(50);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.insertBefore(50, 45);

        Node currentNode = test.head;
        assertEquals("Testing for insertion of 45 to appear before the first 50",
            45,
            currentNode.next.next.next.value);
    }

    // Testing insert after in the middle of the list when there are multiple nodes
    @Test
    public void testInsertAfterMiddleOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.insertAfter(30, 35);

        Node currentNode = test.head;
        assertEquals("Testing for the fourth thing on the list after insertAfter which should be 35",
            35,
            currentNode.next.next.next.value);
    }

    // Testing insert before in the beginning of the list when there are multiple nodes
    @Test
    public void testInsertAfterBeginningOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.insertAfter(10, 15);

        Node currentNode = test.head;
        assertEquals("Testing for the second thing on the list after insertBefore which should be 15",
            15,
            currentNode.next.value);
    }

    // Testing insert before in the end of the list when there are multiple nodes
    @Test
    public void testInsertAfterEndOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.insertAfter(50, 55);

        Node currentNode = test.head;
        assertEquals("Testing for the last thing on the list after insertAfter which should be 55",
            55,
            currentNode.next.next.next.next.next.value);
    }

    // Testing for if there are duplicates value in the linked list
    @Test
    public void testInsertAfterDuplicates() {
        test.insert(50);
        test.insert(50);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.insertAfter(50, 45);

        Node currentNode = test.head;
        assertEquals("Testing for insertion of 45 to appear after the first 50 and before the second 50",
            45,
            currentNode.next.next.next.next.value);
    }

    // Testing insert before when list is empty/value does not exist
    @Test
    public void testInsertAfterEmptyList() {
        Node currentNode = test.head;
        assertFalse("Testing for if the value of 10 does not exist in the list, should return false",
            test.insertAfter(10, 5));
    }
}