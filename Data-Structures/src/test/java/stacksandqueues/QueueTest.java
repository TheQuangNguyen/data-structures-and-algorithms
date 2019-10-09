package stacksandqueues;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueueTest {

    Queue<String> queue;
    @Before
    public void setUp() throws Exception {
        queue = new Queue<>();
    }

    // test if we can instantiate an empty queue
    @Test
    public void testCreateEmptyQueue() {
        assertEquals("front -> null", queue.toString());
    }

    // test if we can add one item onto the queue
    @Test
    public void testEnqueueOneItemOntoQueue() {
        queue.enqueue("one");
        assertEquals("front -> one -> null", queue.toString());
    }

    // test if we can enqueue multiple items onto the queue
    @Test
    public void testEnqueueMultipleItemsOntoQueue() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.enqueue("five");
        assertEquals("front -> one -> two -> three -> four -> five -> null", queue.toString());
    }

    // test dequeue when there is only one item in queue
    @Test
    public void testDequeueWhenQueueHasOneItem() {
        queue.enqueue("one");
        assertEquals("front -> one -> null", queue.toString());
        queue.dequeue();
        assertEquals("front -> null", queue.toString());
    }

    // test if we can dequeue the the first item added to the queue
    @Test
    public void testDequeueOneItemOffFilledQueue() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.enqueue("five");
        String value = queue.dequeue();
        assertEquals("one", value);
        assertEquals("front -> two -> three -> four -> five -> null", queue.toString());
    }

    // test if we can dequeue all items on the queue until it is empty
    @Test
    public void testDequeueMultipleItemsUntilQueueEmpty() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.enqueue("five");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals("front -> null", queue.toString());
    }

    // test if exception is thrown when we dequeue from empty queue
    @Test(expected = NoSuchElementException.class)
    public void testDequeueWhenQueueEmpty() {
        queue.dequeue();
    }

    // test if we can see the value at the front of the queue without modifying the queue
    @Test
    public void testPeekAtOldestItemInQueue() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.enqueue("five");
        String value = queue.peek();

        assertEquals("one", value);
        assertEquals("front -> one -> two -> three -> four -> five -> null", queue.toString());
    }

    // test if there is exception when we peek on an empty stack
    @Test(expected = NoSuchElementException.class)
    public void testPeekOnEmptyStack() {
        queue.peek();
    }

    // test if we can check if the stack is empty
    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());
    }
}