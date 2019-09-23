package linkedList;

public class LinkedList {
    public Node head = null;

    // Constructor for linked list that initialize it as an empty list
    public LinkedList() {
    }

    // Define a method called insert which takes any value as an argument
    // and adds a new node with that value to the head of the list with an O(1) Time performance.
    public void insert(int value) {
        Node oldNode = head;
        head = new Node(value);
        head.next = oldNode;
    }

    // Define a method called includes which takes any value as an argument
    // and returns a boolean result depending on whether that value exists as a Node’s value somewhere within the list.
    public boolean includes(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // Define a method called toString which takes in no arguments
    // and returns a string representing all the values in the Linked List.
    @Override
    public String toString() {
        Node currentNode = head;
        StringBuilder result = new StringBuilder();
        if (head != null) {
            result.append(head.value);
            currentNode = currentNode.next;
        }
        while (currentNode != null) {
            result.append(String.format(", %s", currentNode.value));
            currentNode = currentNode.next;
        }

        return result.toString();
    }



}
