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

    // Testing for removing a node in the middle of the list
    @Test
    public void testRemoveMiddleOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.remove(30);

        Node currentNode = test.head;

        assertEquals(40, currentNode.next.next.value);
    }

    // Testing for removing a node at the beginning of the list
    @Test
    public void testRemoveBeginningOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.remove(10);

        Node currentNode = test.head;

        assertEquals(20, currentNode.value);
    }

    // Testing for removing a node at the end of the list
    @Test
    public void testRemoveEndOfList() {
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        test.remove(50);

        Node currentNode = test.head;

        // The thing after 40 should be null;
        assertNull(currentNode.next.next.next.next);
    }

    // Testing for removing a node when there are duplicates in the list
    @Test
    public void testRemoveDuplicatesInList() {
        test.insert(50);
        test.insert(40);
        test.insert(20);
        test.insert(20);
        test.insert(10);
        test.remove(20);

        Node currentNode = test.head;

        assertEquals(40, currentNode.next.next.value);
        assertEquals(20, currentNode.next.value);
    }

    // Testing for removing a node when it does not exist in the list
    @Test
    public void testRemoveNotExistInList() {
        test.insert(50);
        test.insert(40);
        test.insert(20);
        test.insert(20);
        test.insert(10);

        assertFalse(test.remove(60));
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    // Testing for a normal case when there are multiple nodes and we remove one around the middle
    // from the end of the list
    @Test
    public void testGetKthNodeFromEndOfListMultipleNodes() {
        test.insert(60);
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        int result = test.getKthNodeFromTheEnd(2);

        assertEquals(40, result);
    }

    // Testing for when the k value is greater than the length of the list. Return a null pointer exception
    @Test(expected = NullPointerException.class)
    public void testGetKthNodeFromEndOfListKGreaterThanLength() {
        test.insert(60);
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        int result = test.getKthNodeFromTheEnd(10);
    }

    // Testing for when the k value is negative number. This is outside of acceptable range for the
    // parameter so return illegal argument exception
    @Test(expected = IllegalArgumentException.class)
    public void testGetKthNodeFromEndOfListNegative() {
        test.insert(60);
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        int result = test.getKthNodeFromTheEnd(-2);
    }

    // Testing for when the list is empty. Should return null pointer exception since there is no node in the list and head points
    // to null
    @Test(expected = NullPointerException.class)
    public void testGetKthNodeFromEndOfListEmpty() {

        int result = test.getKthNodeFromTheEnd(0);
    }

    // Testing for when k is equal to the list length. This means that k is outside of the list range so
    // return an null pointer exception
    @Test(expected = NullPointerException.class)
    public void testGetKthNodeFromEndOfListKEqualLength() {
        test.insert(60);
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        int result = test.getKthNodeFromTheEnd(6);
    }

    // Testing for when k is 0. It should returns the element at the end of list
    @Test
    public void testGetKthNodeFromEndOfListKZero() {
        test.insert(60);
        test.insert(50);
        test.insert(40);
        test.insert(30);
        test.insert(20);
        test.insert(10);
        int result = test.getKthNodeFromTheEnd(0);

        assertEquals(60, result);
    }

    // Testing for when the list is of size 1. Should return the only value in the list
    @Test
    public void testGetKthNodeFromEndOfListSizeOfOne() {
        test.insert(60);
        int result = test.getKthNodeFromTheEnd(0);

        assertEquals(60, result);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    // Testing for normal case where both linked list is the same size to see if they can be zipped properly
    @Test
    public void testMergeListsSameLengthForBoth() {
        LinkedList<Integer> test2 = new LinkedList<>();

        // First Linked List: head -> 1 -> 2 -> 3 -> null
        test.insert(3);
        test.insert(2);
        test.insert(1);

        // Second Linked List: head -> 11 -> 12 -> 13 -> null
        test2.insert(13);
        test2.insert(12);
        test2.insert(11);

        // merge list should be head -> 1 -> 11 -> 2 -> 12 -> 3 -> 13 -> null
        Node mergedList = test.mergeLists(test, test2);

        // Testing for values of every nodes to see if it match the expected
        assertEquals(1, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(11, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(2, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(12, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(3, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(13, mergedList.value);
    }

    // Testing when first linked list is one node less than the other
    @Test
    public void testMergeListsFirstListIsLongerByOne() {
        LinkedList<Integer> test2 = new LinkedList<>();

        // First Linked List: head -> 1 -> 2 -> 3 -> 4 -> null
        test.insert(4);
        test.insert(3);
        test.insert(2);
        test.insert(1);

        // Second Linked List: head -> 11 -> 12 -> 13 -> null
        test2.insert(13);
        test2.insert(12);
        test2.insert(11);

        // merge list should be head -> 1 -> 11 -> 2 -> 12 -> 3 -> 13 -> 4 -> null
        Node mergedList = test.mergeLists(test, test2);

        // Testing for values of every nodes to see if it match the expected
        assertEquals(1, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(11, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(2, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(12, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(3, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(13, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(4, mergedList.value);
    }

    // Testing when the second linked list is one node less than the other
    @Test
    public void testMergeListsSecondListIsLongerByOne() {
        LinkedList<Integer> test2 = new LinkedList<>();

        // First Linked List: head -> 1 -> 2 -> 3 -> null
        test.insert(3);
        test.insert(2);
        test.insert(1);

        // Second Linked List: head -> 11 -> 12 -> 13 -> 14 -> null
        test2.insert(14);
        test2.insert(13);
        test2.insert(12);
        test2.insert(11);

        // merge list should be head -> 1 -> 11 -> 2 -> 12 -> 3 -> 13 -> 14 -> null
        Node mergedList = test.mergeLists(test, test2);

        // Testing for values of every nodes to see if it match the expected
        assertEquals(1, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(11, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(2, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(12, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(3, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(13, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(14, mergedList.value);
    }

    // Testing when first linked list is three nodes more than the other
    @Test
    public void testMergeListsFirstListIsLongerByThree() {
        LinkedList<Integer> test2 = new LinkedList<>();

        // First Linked List: head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        test.insert(5);
        test.insert(4);
        test.insert(3);
        test.insert(2);
        test.insert(1);

        // Second Linked List: head -> 11 -> 12 -> null
        test2.insert(12);
        test2.insert(11);

        // merge list should be head -> 1 -> 11 -> 2 -> 12 -> 3 -> 4 -> 5 -> null
        Node mergedList = test.mergeLists(test, test2);

        // Testing for values of every nodes to see if it match the expected
        assertEquals(1, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(11, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(2, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(12, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(3, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(4, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(5, mergedList.value);
    }

    // Testing when second linked list is three nodes less than the other
    @Test
    public void testMergeListsSecondListIsLongerByThree() {
        LinkedList<Integer> test2 = new LinkedList<>();

        // First Linked List: head -> 1 -> 2 -> null
        test.insert(2);
        test.insert(1);

        // Second Linked List: head -> 11 -> 12 -> 13 -> 14 -> 15 -> null
        test2.insert(15);
        test2.insert(14);
        test2.insert(13);
        test2.insert(12);
        test2.insert(11);

        // merge list should be head -> 1 -> 11 -> 2 -> 12 -> 13 -> 14 -> 15 -> null
        Node mergedList = test.mergeLists(test, test2);

        // Testing for values of every nodes to see if it match the expected
        assertEquals(1, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(11, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(2, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(12, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(13, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(14, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(15, mergedList.value);
    }

    // Testing when both linked lists is empty
    @Test
    public void testMergeListsBothListsEmpty() {
        LinkedList<Integer> test2 = new LinkedList<>();

        Node mergedList = test.mergeLists(test, test2);

        assertNull(mergedList);
    }

    // Testing when both linked lists have size of 1
    @Test
    public void testMergeListsBothListSizeOne() {
        LinkedList<Integer> test2 = new LinkedList<>();

        test.insert(1);
        test2.insert(11);

        Node mergedList = test.mergeLists(test, test2);

        assertEquals(1, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(11, mergedList.value);
    }

    // Testing when both linked list have different data types
    @Test
    public void testMergeListsDifferentDataTypes() {
        LinkedList<String> test2 = new LinkedList<>();

        test.insert(3);
        test.insert(2);
        test.insert(1);

        test2.insert("three");
        test2.insert("two");
        test2.insert("one");

        // merge list should be: head -> 1 -> one -> 2 -> two -> 3 -> three -> null
        Node mergedList = test.mergeLists(test, test2);

        // Testing for values of every nodes to see if it match the expected
        assertEquals(1, mergedList.value);
        mergedList = mergedList.next;
        assertEquals("one", mergedList.value);
        mergedList = mergedList.next;
        assertEquals(2, mergedList.value);
        mergedList = mergedList.next;
        assertEquals("two", mergedList.value);
        mergedList = mergedList.next;
        assertEquals(3, mergedList.value);
        mergedList = mergedList.next;
        assertEquals("three", mergedList.value);
    }

    // Test if one linked list is empty and the other one has 2 nodes in it. Should just return
    // a list that is equivalent to the linked list that is not empty.
    @Test
    public void testMergeListOneEmptyOtherOneNot() {
        LinkedList<String> test2 = new LinkedList<>();

        test.insert(3);
        test.insert(2);
        test.insert(1);

        // merge list should be: head -> 1 -> 2 -> 3 -> null
        Node mergedList = test.mergeLists(test, test2);

        assertEquals(1, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(2, mergedList.value);
        mergedList = mergedList.next;
        assertEquals(3, mergedList.value);
        mergedList = mergedList.next;
    }
}