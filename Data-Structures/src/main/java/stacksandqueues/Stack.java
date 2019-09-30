package stacksandqueues;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Stack<T> {
    private Node top = null;

    // Define a method called push which takes any value as an argument and
    // adds a new node with that value to the top of the stack with an O(1) Time performance.
    public void push(T value) {
        Node newTop = new Node(value, this.top);
        this.top = newTop;
    }

    // Define a method called pop that does not take any argument,
    // removes the node from the top of the stack, and returns the node’s value.
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop due to stack being empty");
        }
        T valueTop = (T) this.top.value;
        this.top = this.top.next;
        return valueTop;
    }

    // Define a method called peek that does not take an argument and
    // returns the value of the node located on top of the stack, without removing it from the stack.
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek due to stack being empty");
        }
        return (T) this.top.value;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return this.top == null;
    }

    // Return a string that shows the content of each node in the stack
    @Override
    public String toString() {
        StringJoiner stack = new StringJoiner(" -> ", "top -> ", " -> null");
        if (isEmpty()) {
            return "top -> null";
        }
        Node currentNode = this.top;
        while (currentNode != null) {
            stack.add((String)currentNode.value);
            currentNode = currentNode.next;
        }

        return stack.toString();
    }
}
