/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

/**
 * Doubly-Linked List Implementation Testing
 *
 * @author Kechen Zhao
 * @since 2020/02/04
 */
public class DoublyLinkedListTest {

    private DoublyLinkedList emptyInt;
    private DoublyLinkedList emptyStr;
    private DoublyLinkedList oneInt;
    private DoublyLinkedList oneStr;
    private DoublyLinkedList manyInt;
    private DoublyLinkedList manyStr;

    private DoublyLinkedList otherListInt;
    private DoublyLinkedList otherListStr;

    /**
     * Create new doubly linked list with different size
     * and type
     */
    @Before
    public void setup() {
        emptyInt = new DoublyLinkedList<Integer>();
        emptyStr = new DoublyLinkedList<String>();
        oneInt = new DoublyLinkedList<Integer>();
        oneInt.add(1);
        oneStr = new DoublyLinkedList<String>();
        oneStr.add("one");
        manyInt = new DoublyLinkedList<Integer>();
        manyInt.add(1);
        manyInt.add(2);
        manyInt.add(3);
        manyStr = new DoublyLinkedList<Integer>();
        manyStr.add("one");
        manyStr.add("two");
        manyStr.add("three");

        otherListInt = new DoublyLinkedList<Integer>();
        otherListInt.add(7);
        otherListInt.add(8);
        otherListInt.add(9);

        otherListStr = new DoublyLinkedList<String>();
        otherListStr.add("seven");
        otherListStr.add("eight");
        otherListStr.add("nine");

        otherListInt = new DoublyLinkedList<Integer>();
        otherListInt.add(7);
        otherListInt.add(8);
        otherListInt.add(9);


    }


    /**
     * Test cases for toString()
     */
    @Test
    public void testToString() {
        assertEquals("[(head) -> (tail)]", emptyInt.toString());
        assertEquals("[(head) -> (tail)]", emptyStr.toString());
        assertEquals("[(head) -> 1 -> (tail)]", oneInt.toString());
        assertEquals("[(head) -> one -> (tail)]", oneStr.toString());
        assertEquals("[(head) -> 1 -> 2 -> 3 -> (tail)]", manyInt.toString());
        assertEquals("[(head) -> one -> two -> three -> (tail)]", manyStr.toString());
    }

    /**
     * Test cases for get()
     */
    @Test
    public void textGet() {
        assertEquals(1, oneInt.get(0));
        assertEquals(3, manyInt.get(2));
        assertEquals(2, manyInt.get(1));
        assertEquals(1, manyInt.get(0));
    }

    /**
     * Test cases for get() that throw exception
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void textGetIOB() {
        emptyInt.get(0);
        oneInt.get(1);
        oneInt.get(-1);
        manyInt.get(3);
    }

    /**
     * Test cases for add(index)
     */
    @Test
    public void testAdd() {
        assertTrue(emptyInt.add(1));
        assertEquals(1, emptyInt.get(0));
        assertTrue(emptyStr.add("one"));
        assertEquals("one", emptyStr.get(0));
        assertTrue(oneInt.add(2));
        assertEquals(2, oneInt.get(1));
        assertEquals(1, oneInt.get(0));
        assertTrue(oneStr.add("two"));
        assertEquals("two", oneStr.get(1));
        assertEquals("one", oneStr.get(0));
        assertTrue(manyInt.add(4));
        assertEquals(4, manyInt.get(3));
        assertTrue(manyStr.add("four"));
        assertEquals("four", manyStr.get(3));
    }

    /**
     * Test cases for add() that throw exception
     */
    @Test (expected = NullPointerException.class)
    public void testAddTheowNPC() {
        emptyInt.add(null);
        emptyStr.add(null);
        oneInt.add(null);
        oneStr.add(null);
        manyInt.add(null);
        manyStr.add(null);
    }

    /**
     * Test cases for addIndex(index, element)
     */
    @Test
    public void testAddIndex() {
        emptyInt.add(0, 0);
        assertEquals(0, emptyInt.get(0));
        emptyStr.add(0, "one");
        assertEquals("one", emptyStr.get(0));
        oneInt.add(1, 2);
        assertEquals(2, oneInt.get(1));
        assertEquals(1, oneInt.get(0));
        oneStr.add(1, "two");
        assertEquals("two", oneStr.get(1));
        assertEquals("one", oneStr.get(0));
        manyInt.add(1, 22);
        assertEquals(1, manyInt.get(0));
        assertEquals(22, manyInt.get(1));
        assertEquals(2, manyInt.get(2));
        assertEquals(3, manyInt.get(3));
        manyInt.add(0, 10);
        assertEquals(10, manyInt.get(0));
        manyInt.add(5, 100);
        assertEquals(100, manyInt.get(5));
    }

    /**
     * Test cases for addIndex(index, element) that throw exception
     */
    @Test (expected = NullPointerException.class)
    public void testAddIndexNPE() {
        emptyInt.add(1, null);
        emptyStr.add(1, null);
        manyStr.add(1, null);
    }

    /**
     * Test cases for addIndex(index, element) that throw exception
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddIndexIOB() {
        emptyInt.add(1, 10);
        oneStr.add(2, "ten");
        manyStr.add(4, "ten");
    }

    /**
     * Test cases for clear()
     */
    @Test
    public void testClear() {
        oneStr.clear();
        assertEquals(0, oneStr.size());
        manyInt.clear();
        assertEquals(0, manyInt.size());
        manyStr.clear();
        assertEquals(0, manyStr.size());
    }

    /**
     * Test cases for contains()
     */
    @Test
    public void testContains() {
        assertTrue(oneInt.contains(1));
        assertFalse(emptyInt.contains(1));
        assertTrue(oneStr.contains("one"));
        assertFalse(emptyInt.contains("none"));
        assertTrue(manyInt.contains(2));
        assertTrue(manyInt.contains(3));
        assertTrue(manyStr.contains("three"));
        assertFalse(manyStr.contains("Hello"));
    }


    /**
     * Test cases for isEmpty()
     */
    @Test
    public void testisEmpty() {
        assertTrue(emptyStr.isEmpty());
        assertTrue(emptyInt.isEmpty());
        assertFalse(oneInt.isEmpty());
        assertFalse(manyStr.isEmpty());
    }

    /**
     * Test cases for remove()
     */
    @Test
    public void testRemove() {
        assertEquals(1, oneInt.remove(0));
        assertEquals(0, oneInt.size());
        assertEquals("one", oneStr.remove(0));
        assertEquals(0, oneStr.size());
        assertEquals(1, manyInt.remove(0));
        assertEquals(2, manyInt.size());
        assertEquals(2, manyInt.get(0));
        assertEquals(3, manyInt.get(1));
        assertEquals(3, manyInt.remove(1));
        assertEquals(1, manyInt.size());
        assertEquals("two", manyStr.remove(1));
        assertEquals(2, manyStr.size());
    }

    /**
     * Test cases for remove() that throw exception
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveIOP() {
        emptyStr.remove(0);
        oneStr.remove(1);
        manyStr.remove(3);
    }

    /**
     * Test cases for set()
     */
    @Test
    public void testSet() {
        assertEquals(1, oneInt.set(0, 10));
        assertEquals(10, oneInt.get(0));
        assertEquals(1, oneInt.size());
        assertEquals("one", oneStr.set(0, "Hello"));
        assertEquals("Hello", oneStr.get(0));
        assertEquals(2, manyInt.set(1, 20));
        assertEquals(3, manyInt.size());
        assertEquals(20, manyInt.get(1));
    }

    /**
     * Test cases for set() that throw exception
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetIOB() {
        emptyInt.set(0, 10);
        oneInt.set(1, 10);
        manyInt.set(3, 10);
    }

    /**
     * Test cases for set() that throw exception
     */
    @Test (expected = NullPointerException.class)
    public void testSetNPE() {
        oneInt.set(0, null);
        manyInt.set(2, null);
        manyInt.set(2, null);
    }

    /**
     * Test cases for size()
     */
    @Test
    public void testSize() {
        assertEquals(0, emptyStr.size());
        assertEquals(1, oneStr.size());
        assertEquals(3, manyStr.size());
    }


    /**
     * Test cases for splice()
     */
    @Test
    public void testSplice1() {
        manyInt.splice(0, otherListInt);
        assertEquals("[(head) -> 7 -> 8 -> 9 -> 1 -> 2 -> 3 -> (tail)]", manyInt.toString());
    }
    @Test
    public void testSplice2() {
        manyInt.splice(1, otherListInt);
        assertEquals("[(head) -> 1 -> 7 -> 8 -> 9 -> 2 -> 3 -> (tail)]", manyInt.toString());
    }
    @Test
    public void testSplice3() {
        manyInt.splice(2, otherListInt);
        assertEquals("[(head) -> 1 -> 2 -> 7 -> 8 -> 9 -> 3 -> (tail)]", manyInt.toString());
    }
    @Test
    public void testSplice4() {
        manyInt.splice(3, otherListInt);
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 7 -> 8 -> 9 -> (tail)]", manyInt.toString());
    }
    @Test
    public void testSplice5() {
        emptyInt.splice(0, otherListInt);
        assertEquals("[(head) -> 7 -> 8 -> 9 -> (tail)]", emptyInt.toString());
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSpliceIOB() {
        emptyInt.splice(1, otherListInt);
        manyInt.splice(-1, otherListInt);
        manyInt.splice(4, otherListInt);
    }

    /**
     * Test cases for match()
     */
    @Test
    public void testMatch() {
        DoublyLinkedList sequence = new DoublyLinkedList();
        sequence.add("A");
        sequence.add("B");
        sequence.add("C");
        sequence.add("A");
        sequence.add("B");
        sequence.add("A");
        sequence.add("A");
        DoublyLinkedList subsequence = new DoublyLinkedList();
        subsequence.add("A");
        subsequence.add("B");
        assertEquals("[]", Arrays.toString(sequence.match(subsequence)));
    }
}

