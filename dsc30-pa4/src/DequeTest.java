/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for Deque class implementation
 *
 * @author Kechen Zhao
 * @since 2020/02/04
 */
public class DequeTest {

    private Deque emptyInt;
    private Deque oneInt;
    private Deque manyInt;

    /**
     * Standard Test Fixture. An empty deque, a deque with one element, a deque
     * with several entries.
     */
    @Before
    public void setup() {
        emptyInt = new Deque();
        oneInt = new Deque();
        oneInt.addBack(1);
        manyInt = new Deque();
        manyInt.addBack(1);
        manyInt.addBack(2);
        manyInt.addBack(3);
    }

    /**
     * Test cases for size()
     */
    @Test
    public void testSize() {
        assertEquals("Check size is 0", 0, emptyInt.size());
        assertEquals("Check size is 1", 1, oneInt.size());
        assertEquals("Check size is 3", 3, manyInt.size());
    }

    /**
     * Test cases for isEmpty()
     */
    @Test
    public void testisEmpty() {
        assertTrue(emptyInt.isEmpty());
        assertFalse(oneInt.isEmpty());
        assertFalse(manyInt.isEmpty());
    }

    @Test (expected = NullPointerException.class)
    public void testAddFrontTheowECP() {
        emptyInt.addFront(null);
        oneInt.addFront(null);
        manyInt.addFront(null);
    }

    /**
     * Test cases for addFront and removeFront
     */
    @Test
    public void testAddFrontandRemoveFront() {
        assertTrue(emptyInt.addFront(10));
        assertEquals("Size must be 1", 1, emptyInt.size());
        assertEquals("Element must equal 10", 10, (int) emptyInt.removeFront());

        assertTrue(oneInt.addFront(10));
        assertEquals("Size must be 2", 2, oneInt.size());
        assertEquals("Element must equal 10", 10, (int) oneInt.removeFront());

        assertTrue(manyInt.addFront(10));
        assertEquals("Size must be 4", 4, manyInt.size());
        assertEquals("Element must equal 10", 10, (int) manyInt.removeFront());
    }

    /** Test addBack method */
    @Test
    public void testAddBackandRemoveBack() {
        assertTrue(emptyInt.addBack(10));
        assertEquals("Size must be 1", 1, emptyInt.size());
        assertEquals("Element must equal 10", 10, (int) emptyInt.removeBack());

        assertTrue(oneInt.addBack(10));
        assertEquals("Size must be 2", 2, oneInt.size());
        assertEquals("Element must equal 10", 10, (int) oneInt.removeBack());

        assertTrue(manyInt.addBack(10));
        assertEquals("Size must be 4", 4, manyInt.size());
        assertEquals("Element must equal 10", 10, (int) manyInt.removeBack());
    }

    /** Testing removing an element from the front in an empty list */
    @Test
    public void testRemoveFrontEmpty() {
        assertEquals("Should be null", null, emptyInt.removeFront());
    }

    /** Test removing an element from the front */
    @Test
    public void testRemoveFront() {
        assertEquals("Should return element 1", 1, (int) oneInt.removeFront());
        assertEquals("Should be 0", 0, oneInt.size());
        assertEquals("Should return element 1", 1, (int) manyInt.removeFront());
        assertEquals("Should be 2", 2, manyInt.size());
    }

    /** Testing removing an element from the back in an empty list */
    @Test
    public void testRemoveBackEmpty() {
        assertEquals("Should be null", null, emptyInt.removeBack());
    }

    /** Test removing an element from the back */
    @Test
    public void testRemoveBack() {
        assertEquals("Should return element 1", 1, (int) oneInt.removeBack());
        assertEquals("Should be 0", 0, oneInt.size());
        assertEquals("Should return element 3", 3, (int) manyInt.removeBack());
        assertEquals("Should be 2", 2, manyInt.size());
    }

    /** Test retrieving element from front element */
    @Test
    public void testPeekFront() {
        assertEquals("Should be 1", 1, (int) oneInt.peekFront());
        assertEquals("Should have size 1", 1, oneInt.size());
        assertEquals("Should be 1", 1, (int) manyInt.peekFront());
        assertEquals("Should have size 3", 3, manyInt.size());
    }

    /** Test empty list will return null from a call to peek front */
    @Test
    public void testPeekFrontEmpty() {
        assertEquals("Should be null", null, emptyInt.peekFront());
    }

    /** Test retrieving element from back element */
    @Test
    public void testPeekBack() {
        assertEquals("Should be 1", 1, (int) oneInt.peekBack());
        assertEquals("Should have size 1", 1, oneInt.size());
        assertEquals("Should be 3", 3, (int) manyInt.peekBack());
        assertEquals("Should have size 3", 3, manyInt.size());
    }

    /** Test empty list will return null from a call to peek back */
    @Test
    public void testPeekBackEmpty() {
        assertEquals("Should be null", null, emptyInt.peekBack());
    }
}

