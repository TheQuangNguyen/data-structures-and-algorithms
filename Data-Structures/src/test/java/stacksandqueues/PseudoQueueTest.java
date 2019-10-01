package stacksandqueues;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PseudoQueueTest {

    PseudoQueue<String> pseudoQueue;
    @Before
    public void setUp() throws Exception {
        pseudoQueue = new PseudoQueue<>();
    }

    // Test enqueue a value and if dequeue return the same value
    @Test
    public void testEnqueueOnceDequeueOnce() {
        pseudoQueue.enqueue("ten");
        assertEquals("ten", pseudoQueue.dequeue());
    }

    // test enqueue multiple values and if dequeue return the same order that the items were put into the queue
    @Test
    public void testEnqueueMultipleDequeueMultiple() {
        pseudoQueue.enqueue("three");
        pseudoQueue.enqueue("two");
        pseudoQueue.enqueue("one");
        assertEquals("three", pseudoQueue.dequeue());
        assertEquals("two", pseudoQueue.dequeue());
        assertEquals("one", pseudoQueue.dequeue());
    }

    // test enqueue multiple values, dequeue once, enqueue multiple values, then dequeue all the remaining values
    @Test
    public void testEnqueueAndDequeueRepeatedly() {
        pseudoQueue.enqueue("one");
        pseudoQueue.enqueue("two");
        pseudoQueue.enqueue("three");
        assertEquals("one", pseudoQueue.dequeue());
        pseudoQueue.enqueue("four");
        pseudoQueue.enqueue("five");
        pseudoQueue.enqueue("six");
        assertEquals("two", pseudoQueue.dequeue());
        assertEquals("three", pseudoQueue.dequeue());
        assertEquals("four", pseudoQueue.dequeue());
        assertEquals("five", pseudoQueue.dequeue());
        assertEquals("six", pseudoQueue.dequeue());
    }

    // test enqueue multiple values, dequeue all values, then enqueue multiple values again and dequeue all of it once more
    @Test
    public void testEnqueueAndDequeueAllRepeatedly() {
        pseudoQueue.enqueue("one");
        pseudoQueue.enqueue("two");
        pseudoQueue.enqueue("three");
        assertEquals("one", pseudoQueue.dequeue());
        assertEquals("two", pseudoQueue.dequeue());
        assertEquals("three", pseudoQueue.dequeue());
        pseudoQueue.enqueue("four");
        pseudoQueue.enqueue("five");
        pseudoQueue.enqueue("six");
        assertEquals("four", pseudoQueue.dequeue());
        assertEquals("five", pseudoQueue.dequeue());
        assertEquals("six", pseudoQueue.dequeue());
    }

    // test for exception for dequeue when queue is empty
    @Test(expected = NoSuchElementException.class)
    public void testDequeueEmptyPseudoQueue() {
        pseudoQueue.dequeue();
    }



}