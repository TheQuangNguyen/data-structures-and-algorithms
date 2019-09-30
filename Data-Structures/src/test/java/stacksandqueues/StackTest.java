package stacksandqueues;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class StackTest {

    Stack<String> stack;
    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
    }

    // test if we can instantiate an empty stack
    @Test
    public void testCreateEmptyStack() {
        assertEquals("top -> null", stack.toString());
    }

    // test if we can push one item onto the stack
    @Test
    public void testPushOneItemOntoStack() {
        stack.push("one");
        assertEquals("top -> one -> null", stack.toString());
    }

    // test if we can push multiple items onto the stack
    @Test
    public void testPushMultipleItemsOntoStack() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        assertEquals("top -> five -> four -> three -> two -> one -> null", stack.toString());
    }

    // test if we can pop off the most recently added item on the stack
    @Test
    public void testPopOneItemOffFilledStack() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        stack.pop();
        assertEquals("top -> four -> three -> two -> one -> null", stack.toString());
    }

    // test if we can pop off all items on the stack until it is empty
    @Test
    public void testPopMultipleItemsUntilStackEmpty() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals("top -> null", stack.toString());
    }

    // test if exception is thrown when we pop from empty stack
    @Test(expected = NoSuchElementException.class)
    public void testPopWhenStackEmpty() {
        stack.pop();
    }

    // test if we can see the value at the top of the stack without modifying the stack
    @Test
    public void testPeekAtMostRecentItemAddedOnStack() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        String value = stack.peek();

        assertEquals("five", value);
        assertEquals("top -> five -> four -> three -> two -> one -> null", stack.toString());
    }

    // test if there is exception when we peek on an empty stack
    @Test(expected = NoSuchElementException.class)
    public void testPeekOnEmptyStack() {
        stack.peek();
    }

    // test if we can check if the stack is empty
    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
    }
}