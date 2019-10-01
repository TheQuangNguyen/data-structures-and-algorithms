package stacksandqueues;

import java.util.NoSuchElementException;

// A class that implements a queue using two stacks
public class PseudoQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public PseudoQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    // insert value into PseudoQueue using first-in, first-out approach by only pushing in stack1
    public void enqueue(T value) {
        stack1.push(value);
    }

    // extracts a value from the PseudoQueue, using first-in, first-out approach
    //
    public T dequeue() {
        // check if both stacks are empty to determine whether PseudoQueue is empty
        // if it is, throw exception
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new NoSuchElementException("Unable to dequeue due to queue being empty");
        }
        // Check if stack2 is empty
        // If it is, pop all values from stack1 and push them into stack2.
        // This will reverse order of stack and make the order like a queue.
        // If stack2 is not empty, continue pop off values from stack2 until it is empty
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }
}
