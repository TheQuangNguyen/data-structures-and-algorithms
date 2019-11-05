package stacksandqueues;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Queue<T> {
    private Node front = null;
    private Node back = null;

    // Define a method called enqueue which takes any value as an argument
    // and adds a new node with that value to the back of the queue with an O(1) Time performance.
    public void enqueue(T value) {
        Node oldBack = this.back;
        this.back = new Node(value);
        // if before enqueue it is empty, then both front and back should point to same node
        // otherwise the old back points to the new back
        if (isEmpty()) {
            this.front = this.back;
        } else {
            oldBack.next = this.back;
        }
    }

    // enqueue a node instead of a value


    // Define a method called dequeue that does not take any argument,
    // removes the node from the front of the queue, and returns the node’s value.
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue due to queue being empty");
        }
        T value = (T) this.front.value;
        this.front = this.front.next;
        // if there was one element before dequeue, then front and back should be null
        if (isEmpty()) {
            this.back = null;
        }
        return value;
    }

    public Node dequeueNode() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue due to queue being empty");
        }
        Node dequeueNode = this.front;
        this.front = this.front.next;
        // if there was one element before dequeue, then front and back should be null
        if (isEmpty()) {
            this.back = null;
        }
        return dequeueNode;
    }

    //  Define a method called peek that does not take an argument and
    //  returns the value of the node located in the front of the queue, without removing it from the queue.
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek due to queue being empty");
        }
        return (T) this.front.value;
    }

    // checks if queue is empty
    public boolean isEmpty() {
        return this.front == null;
    }

    // return a string that show the content of the queue
    @Override
    public String toString() {
        StringJoiner queue = new StringJoiner(" -> ", "front -> ", " -> null");
        if (isEmpty()) {
            return "front -> null";
        }

        Node currentNode = this.front;
        while (currentNode != null) {
            queue.add((String)currentNode.value);
            currentNode = currentNode.next;
        }
        return queue.toString();
    }
}
