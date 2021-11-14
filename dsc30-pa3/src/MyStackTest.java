/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class MyStackTest {

    private MyStack empty;
    private MyStack one;
    private MyStack many;
    private MyStack full;

    private int CAP = 10; // capacity of deque
    private int SIZE = 5; // number of elements in deque

    @Before
    public void setUp() {

        empty = new MyStack(CAP);
        one = new MyStack(CAP);
        // add one element to deque "one"
        one.push(14);
        many = new MyStack(CAP);
        //fills "many" deque with SIZE amount of integers
        for (int index = 0; index < SIZE; index++) {
            many.push(index);
        }

        full = new MyStack(CAP);
        //fills "full" deque with CAP amount of integers
        for (int index2 = 0; index2 < CAP; index2++) {
            full.push(index2);
        }
    }

    @Test
    public void testCapacity() {
        assertEquals("Check capacity=10", CAP, empty.capacity());
        assertEquals("Check capacity=10", CAP, one.capacity());
        assertEquals("Check capacity=10", CAP, many.capacity());
        assertEquals("Check capacity=10", CAP, full.capacity());
    }

    @Test
    public void testSize() {
        assertEquals("Check size is 0", 0, empty.size());
        assertEquals("Check size is 1", 1, one.size());
        assertEquals("Check size is 5", SIZE, many.size());
        assertEquals("Check size is CAP (10)", CAP, full.size());
    }

    @Test
    public void testisEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(one.isEmpty());
        assertFalse(many.isEmpty());
        assertFalse(full.isEmpty());
    }

    @Test
    public void testisFull() {
        assertFalse(empty.isFull());
        assertFalse(one.isFull());
        assertFalse(many.isFull());
        assertTrue(full.isFull());
    }

    @Test
    public void testPush() {
        assertTrue(many.push(5));
        assertEquals("should be 5", 5, (int) many.peek());
        assertTrue(one.push(6));
        assertEquals("should be 6", 6, (int) one.peek());
        assertTrue(empty.push(1));
        assertEquals("should be 1", 1, (int) empty.peek());
        assertFalse(full.push(5));
    }

    @Test
    public void testPop() {
        assertEquals("Should return element 14", 14, (int) one.pop());
        assertEquals("Should be 0", 0, one.size());
        assertEquals("Should return element 4", 4, (int) many.pop());
        assertEquals("Should be SIZE-1, or 4", SIZE - 1, many.size());
        assertEquals("Should return element 0", 9, (int) full.pop());
        assertEquals("Should return element 0", 8, (int) full.pop());
    }
}

