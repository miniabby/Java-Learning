/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *  Title: class DequeTest
 *  Description: JUnit test class for Deque class
 */
public class DequeTest {

    private Deque empty; // deque with no elements
    private Deque one; // deque with one element
    private Deque many; // deque with several elements
    private Deque full; // full deque
    private Deque DequeA;
    private Deque DequeB;
    private Deque DequeC;

    private int CAP = 10; // capacity of deque
    private int SIZE = 5; // number of elements in deque

    private int CAPTY = 6; // capacity of deque

    /**
     * Standard Test Fixture. An empty deque, a deque with one element, a deque
     * with several entries, and  a full deque.
     */
    @Before
    public void setUp() {

        empty = new Deque(CAP);
        one = new Deque(CAP);
        // add one element to deque "one"
        one.addBack(14);
        many = new Deque(CAP);
        //fills "many" deque with SIZE amount of integers
        for (int index = 0; index < SIZE; index++) {
            many.addBack(index);
        }

        full = new Deque(CAP);
        //fills "full" deque with CAP amount of integers
        for (int index2 = 0; index2 < CAP; index2++) {
            full.addBack(index2);
        }

        DequeA = new Deque(CAPTY);
        DequeA.addBack(12);
        DequeA.addBack(22);
        DequeA.addBack(32);
        DequeB = new Deque();
        DequeB.addFront(11);
        DequeB.addFront(21);
        DequeC = new Deque();

    }

    /** Test if each created deque has the specified capacity */
    @Test
    public void testCapacity() {
        assertEquals("Check capacity=10", CAP, empty.capacity());
        assertEquals("Check capacity=10", CAP, one.capacity());
        assertEquals("Check capacity=10", CAP, many.capacity());
        assertEquals("Check capacity=10", CAP, full.capacity());

        assertEquals("Check capacity=5", CAPTY, DequeA.capacity());
        assertEquals("Check capacity=5", 5, DequeB.capacity());
        assertEquals("Check capacity=5", 5, DequeC.capacity());
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

        assertEquals("Check size is 3", 3, DequeA.size());
        assertEquals("Check size is 2", 2, DequeB.size());
        assertEquals("Check size is 0", 0, DequeC.size());
    }

    /** Tests adding an element to the front of the deque for empty, filled,
     * and full deque
     **/
    @Test
    public void testAddFront() {
        assertTrue(empty.addFront(10));
        assertEquals("Size must be 1", 1, empty.size());
        assertEquals("Element must equal 10", 10, (int) empty.removeFront());

        assertTrue(one.addFront(10));
        assertEquals("Size must be 2", 2, one.size());
        assertEquals("Element must equal 10", 10, (int) one.removeFront());

        assertTrue(many.addFront(10));
        assertEquals("Size must be 6", SIZE + 1, many.size());
        assertEquals("Element must equal 10", 10, (int) many.removeFront());

        assertFalse(full.addFront(10));

        assertTrue(DequeA.addFront(10));
        assertEquals("Size must be 4", 4, DequeA.size());
        assertEquals("Element must equal 10", 10, (int) DequeA.removeFront());
        assertTrue(DequeA.addFront(10));
        assertTrue(DequeA.addFront(9));
        assertTrue(DequeA.addFront(9));
    }


    /** Test add front method stops inserting elements when array is full */
    @Test
    public void testAddFrontFull() {
        for (int index = 0; index < CAP - SIZE; index++) {
            assertTrue(many.addFront(10));
        }
        assertFalse(many.addFront(1));

    }

    /** Tests if addFront method throws a null exception when specified element is null */
    @Test
    public void testAddFrontNullException() {

        try {
            empty.addFront(null);
            fail("Error: Did not throw exception.");
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    /** Tests if addFront method throws a null exception when specified element is null */
    @Test (expected = NullPointerException.class)
    public void testAddFrontTheowECP() {
        DequeA.addFront(null);
    }

    /** Test add back method */
    @Test
    public void testAddBack() {
        assertTrue(empty.addBack(10));
        assertEquals("Size must be 1", 1, empty.size());
        assertEquals("Element must equal 10", 10, (int) empty.removeBack());

        assertTrue(one.addBack(10));
        assertEquals("Size must be 2", 2, one.size());
        assertEquals("Element must equal 10", 10, (int) one.removeBack());

        assertTrue(many.addBack(10));
        assertEquals("Size must be 6", SIZE + 1, many.size());
        assertEquals("Element must equal 10", 10, (int) many.removeBack());

        assertFalse(full.addBack(10));

        assertTrue(DequeB.addBack(7));
        assertEquals("Size must be 3", 3, DequeB.size());
        assertTrue(DequeC.addBack(7));
        assertEquals("Size must be 1", 1, DequeC.size());
        assertEquals("Element must equal 7", 7, (int) DequeC.removeBack());
    }

    /** Test add back stops inserting elements when array is full */
    @Test
    public void testAddBackFull() {
        for (int index = 0; index < CAP - SIZE; index++) {
            assertTrue(many.addBack(10));
        }
        assertFalse(many.addBack(10));

        assertTrue(DequeA.addBack(4));
        assertTrue(DequeA.addBack(3));
        assertTrue(DequeA.addBack(10));
    }


    /** Tests if addBack method throws a null exception when specified element is null */
    @Test
    public void testAddBackNullException() {
        try {
            empty.addBack(null);
            fail("Error: Did not throw exception.");
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    @Test (expected = NullPointerException.class)
    public void testAddBackTheowECP() {
        DequeB.addBack(null);
        DequeC.addBack(null);
        DequeA.addBack(null);
    }

    /** Testing removing an element from the front in an empty list */
    @Test
    public void testRemoveFrontEmpty() {
        assertEquals("Should be null", null, empty.removeFront());
        assertEquals("Should be null", null, DequeC.removeFront());
    }

    /** Test removing an element from the front */
    @Test
    public void testRemoveFront() {
        assertEquals("Should return element 14", 14, (int) one.removeFront());
        assertEquals("Should be 0", 0, one.size());
        assertEquals("Should return element 0", 0, (int) many.removeFront());
        assertEquals("Should be SIZE-1, or 4", SIZE - 1, many.size());

        assertEquals("Should be 12", 12, (int) DequeA.removeFront());
        assertEquals("Should be 21", 21, (int) DequeB.removeFront());
        assertEquals("Should be null", null, DequeC.removeFront());
    }


    /** Testing removing an element from the back in an empty list */
    @Test
    public void testRemoveBackEmpty() {
        assertEquals("Should be null", null, empty.removeBack());
        assertEquals("Should be null", null, DequeC.removeBack());
    }

    /** Test removing an element from the back */
    @Test
    public void testRemoveBack() {
        assertEquals("Should return element 14", 14, (int) one.removeBack());
        assertEquals("Should be 0", 0, one.size());
        assertEquals("Should return element 4", 4, (int) many.removeBack());
        assertEquals("Should be SIZE-1, or 4", SIZE - 1, many.size());

        assertEquals("Should be 32", 32, (int) DequeA.removeBack());
        assertEquals("Should be 11", 11, (int) DequeB.removeBack());
        assertEquals("Should be null", null, DequeC.removeBack());
    }

    /** Test retrieving element from front element */
    @Test
    public void testPeekFront() {
        assertEquals("Should be 14", 14, (int) one.peekFront());
        assertEquals("Should have size 1", 1, one.size());
        assertEquals("Should be 0", 0, (int) many.peekFront());
        assertEquals("Should have size SIZE", SIZE, many.size());
        assertEquals("Should be 0", 0, (int) full.peekFront());
        assertEquals("Should have size CAP", CAP, full.size());

        assertEquals("Should be 12", 12, (int) DequeA.peekFront());
        assertEquals("Should be 21", 21, (int) DequeB.peekFront());
        assertEquals("Should be null", null, DequeC.peekFront());
    }

    /** Test empty list will return null from a call to peek front */
    @Test
    public void testPeekFrontEmpty() {
        assertEquals("Should be null", null, empty.peekFront());
        assertEquals("Should be null", null, DequeC.peekFront());
    }

    /** Test retrieving element from back element */
    @Test
    public void testPeekBack() {
        assertEquals("Should be 14", 14, (int) one.peekBack());
        assertEquals("Should have size 1", 1, one.size());
        assertEquals("Should be 4", 4, (int) many.peekBack());
        assertEquals("Should have size SIZE", SIZE, many.size());
        assertEquals("Should be 9", 9, (int) full.peekBack());
        assertEquals("Should have size CAP", CAP, full.size());
        assertEquals("Should be 32", 32, (int) DequeA.peekBack());
        assertEquals("Should be 11", 11, (int) DequeB.peekBack());
        assertEquals("Should be null", null, DequeC.peekBack());
    }

    /** Test empty list will return null from a call to peek back */
    @Test
    public void testPeekBackEmpty() {
        assertEquals("Should be null", null, empty.peekBack());
        assertEquals("Should be null", null, DequeC.peekBack());
    }

    @Test
    public void testSimpleDequeTwo() {
        Deque q =  new Deque();

        assertTrue(q.addFront(2));
        assertEquals(1, q.size());
        assertFalse(q.isFull());
        assertEquals(new Integer(2), q.peekFront());

        assertTrue(q.addFront(1));
    }

}
