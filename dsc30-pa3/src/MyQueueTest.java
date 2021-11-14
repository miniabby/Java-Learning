/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  Title: class MyQueueTest
 *  Description: JUnit test class for MyQueue class
 * @author Kechen Zhao
 */
public class MyQueueTest {

    private MyQueue empty; // deque with no elements
    private MyQueue one; // deque with one element
    private MyQueue many; // deque with several elements
    private MyQueue full; // full deque

    private int CAP = 10; // capacity of deque
    private int SIZE = 5; // number of elements in deque

    /**
     * Standard Test Fixture. An empty queue, a queue with one element, a queue
     * with several entries, and  a full queue.
     */
    @Before
    public void setUp() {

        empty = new MyQueue(CAP);
        one = new MyQueue(CAP);
        // add one element to deque "one"
        one.enqueue(14);
        many = new MyQueue(CAP);
        //fills "many" deque with SIZE amount of integers
        for (int index = 0; index < SIZE; index++) {
            many.enqueue(index);
        }

        full = new MyQueue(CAP);
        //fills "full" deque with CAP amount of integers
        for (int index2 = 0; index2 < CAP; index2++) {
            full.enqueue(index2);
        }
    }

    /** Test if each created deque has the specified capacity */
    @Test
    public void testCapacity() {
        assertEquals("Check capacity=10", CAP, empty.capacity());
        assertEquals("Check capacity=10", CAP, one.capacity());
        assertEquals("Check capacity=10", CAP, many.capacity());
        assertEquals("Check capacity=10", CAP, full.capacity());
    }

    /** Test if returns the correct size of the Deque for empty, filled, and
     * full deque
     **/
    @Test
    public void testSize() {
        assertEquals("Check size is 0", 0, empty.size());
        assertEquals("Check size is 1", 1, one.size());
        assertEquals("Check size is 5", SIZE, many.size());
        assertEquals("Check size is CAP (10)", CAP, full.size());
    }

    /** Test if returns the correct boolean value of the Deque for empty, filled, and
     * full deque
     **/
    @Test
    public void testIsEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(one.isEmpty());
        assertFalse(many.isEmpty());
        assertFalse(full.isEmpty());
    }

    /** Test if returns the correct boolean value of the Deque for empty, filled, and
     * full deque
     **/
    @Test
    public void testIsFull() {
        assertFalse(empty.isFull());
        assertFalse(one.isFull());
        assertFalse(many.isFull());
        assertTrue(full.isFull());
    }

    /** Tests if enqueue method throws a null exception when specified element is null */
    @Test (expected = NullPointerException.class)
    public void testAddBackTheowECP() {
        empty.enqueue(null);
        one.enqueue(null);
        many.enqueue(null);
        full.enqueue(null);
    }

    /** Testing removing an element from the back in an empty list */
    @Test
    public void testDequeueNull() {
        assertEquals("Should be null", null, empty.dequeue());
    }

    /** Test removing an element from the head */
    @Test
    public void testDequeue() {
        assertEquals("Should return element 14", 14, (int) one.dequeue());
        assertEquals("Should be 0", 0, one.size());
        assertEquals("Should return element 0", 0, (int) many.dequeue());
        assertEquals("Should be SIZE-1, or 4", SIZE - 1, many.size());
        assertEquals("Should return element 0", 0, (int) full.dequeue());
        assertEquals("Should return element 0", 1, (int) full.dequeue());
    }

    /** Test retrieving element from back element */
    @Test
    public void testPeek() {
        assertEquals("Should be 14", 14, (int) one.peek());
        assertEquals("Should have size 1", 1, one.size());
        assertEquals("Should be 0", 0, (int) many.peek());
        assertEquals("Should have size SIZE", SIZE, many.size());
        assertEquals("Should be 0", 0, (int) full.peek());
        assertEquals("Should have size CAP", CAP, full.size());
    }
}

