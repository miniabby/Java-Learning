/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 *  Title: class SortsTest
 *  Description: JUnit test class for Sorts class
 */
public class SortsTester {

    private ArrayList list;
    private ArrayList list0;
    private ArrayList list1;
    private ArrayList list2;
    private Sorts sorts = new Sorts();

    /**
     * Standard Test Fixture.
     */
    @Before
    public void setup() {
        list = new ArrayList<>();
        list.add(2);
        list.add(9);
        list.add(0);
        list.add(12);
        list.add(4);
        list.add(79);
        list.add(3);

        list0 = new ArrayList<>();
        list0.add(0);
        list0.add(2);
        list0.add(3);
        list0.add(4);
        list0.add(9);
        list0.add(12);
        list0.add(79);

        list1 = new ArrayList<>();
        list1.add(2);
        list1.add(0);
        list1.add(4);
        list1.add(9);
        list1.add(12);
        list1.add(79);
        list1.add(3);

        list2 = new ArrayList<>();
        list2.add(2);
        list2.add(9);
        list2.add(0);
        list2.add(4);
        list2.add(12);
        list2.add(79);
        list2.add(3);

    }

    /**
     * Test cases for InsertionSort()
     */
    @Test
    public void testInsertionSort0() {
        sorts.InsertionSort(list, 0, list.size() - 1);
        assertEquals(list0, list);
    }

    @Test
    public void testInsertionSort1() {
        sorts.InsertionSort(list, 1, list.size() - 2);
        assertEquals(list1, list);
    }

    @Test
    public void testInsertionSort2() {
        sorts.InsertionSort(list, 2, list.size() - 3);
        assertEquals(list2, list);
    }

    @Test
    public void testInsertionSort3() {
        sorts.InsertionSort(list, 3, list.size() - 3);
        assertEquals(list2, list);
    }

    /**
     * Test cases for QuickSort()
     */
    @Test
    public void testQuickSort0() {
        sorts.QuickSort(list, 0, list.size() - 1);
        assertEquals(list0, list);
    }

    @Test
    public void testQuickSort1() {
        sorts.QuickSort(list, 1, list.size() - 2);
        assertEquals(list1, list);
    }

    @Test
    public void testQuickSort2() {
        sorts.QuickSort(list, 2, list.size() - 3);
        assertEquals(list2, list);
    }

    @Test
    public void testQuickSort3() {
        sorts.QuickSort(list, 3, list.size() - 3);
        assertEquals(list2, list);
    }

    /**
     * Test cases for Modified_QuickSort()
     */
    @Test
    public void testModifiedQuickSort0() {
        sorts.Modified_QuickSort(list, 0, list.size() - 1, 1);
        assertEquals(list0, list);
    }

    @Test
    public void testModifiedQuickSort1() {
        sorts.Modified_QuickSort(list, 1, list.size() - 2, 2);
        assertEquals(list1, list);
    }

    @Test
    public void testModifiedQuickSort2() {
        sorts.Modified_QuickSort(list, 2, list.size() - 3, 3);
        assertEquals(list2, list);
    }

    @Test
    public void testModifiedQuickSort3() {
        sorts.Modified_QuickSort(list, 3, list.size() - 3, 4);
        assertEquals(list2, list);
    }

    /**
     * Test cases for TimSort()
     */
    @Test
    public void testTimSort0() {
        sorts.TimSort(list, 0, list.size() - 1, 4);
        assertEquals(list0, list);
    }

    @Test
    public void testTimSort1() {
        sorts.TimSort(list, 1, list.size() - 2, 3);
        assertEquals(list1, list);
    }

    @Test
    public void testTimSort2() {
        sorts.TimSort(list, 2, list.size() - 3, 4);
        assertEquals(list2, list);
    }

    @Test
    public void testTimSort3() {
        sorts.TimSort(list, 3, list.size() - 3, 9);
        assertEquals(list2, list);
    }

}

