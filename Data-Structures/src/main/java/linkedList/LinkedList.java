package linkedList;

public class LinkedList<T> {
    public Node head = null;

    // Constructor for linked list that initialize it as an empty list
    public LinkedList() {
    }

    // Define a method called insert which takes any value as an argument
    // and adds a new node with that value to the head of the list with an O(1) Time performance.
    public void insert(T value) {
        Node oldNode = head;
        head = new Node(value);
        head.next = oldNode;
    }

    // Define a method called includes which takes any value as an argument
    // and returns a boolean result depending on whether that value exists as a Node’s value somewhere within the list.
    public boolean includes(T value) {
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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // adds a new node with the given value to the end of the list
    public void append(T value) {
        Node currentNode = head;

        if (head == null) {
            Node newNode = new Node(value);
            head = newNode;
            return;
        }
        // Get to the last node of the list
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        Node newNode = new Node(value);
        currentNode.next = newNode;
    }

    // add a new node with the given newValue immediately before the first value node.
    // Return true or false depends on if we found the value or not
    public boolean insertBefore(T value, T newVal) {
        Node currentNode = head;

        // if the value is the first thing on the list, make new node the head and point it to the previous head
        if (currentNode == null) {
            return false;
        } else if (currentNode.value == value) {
            Node newNode = new Node(newVal, head);
            head = newNode;
            return true;
        }

        while (currentNode.next.value != value && currentNode.next != null) {
            currentNode = currentNode.next;
        }

        // if next value is null, that means we search the entire list and did not find the value
        if (currentNode.next == null) {
            return false;
        } else {
            Node newNode = new Node(newVal, currentNode.next);
            currentNode.next = newNode;
            return true;
        }
    }

    // add a new node with the given newValue immediately after the first value node
    // Return true or false depends on if we found the value or not
    public boolean insertAfter(T value, T newVal) {
        Node currentNode = head;

        if (currentNode == null) {
            return false;
        }

        while (currentNode.value != value && currentNode != null) {
            currentNode = currentNode.next;
        }

        // if next value is null, that means we search the entire list and did not find the value
        if (currentNode == null) {
            return false;
        } else {
            Node newNode = new Node(newVal, currentNode.next);
            currentNode.next = newNode;
            return true;
        }
    }

    // remove the first node with the given value
    // return true or false depends on if the value exist or not in the list
    public boolean remove(T value) {
        Node currentNode = head;

        if (currentNode == null) {
            return false;
        } else if (currentNode.value == value) {
            head = currentNode.next;
            return true;
        }

        while (currentNode.next != null && currentNode.next.value != value) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            return false;
        } else {
            currentNode.next = currentNode.next.next;
            return true;
        }
    }

}
