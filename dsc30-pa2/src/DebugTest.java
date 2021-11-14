/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class will contain all the test case for Debug.java
 * @author Kechen Zhao
 * @since 2020/01/21
 */
public class DebugTest {

    // test case for squareLargeNums(int[] nums, int threshold)
    @Test
    public void testsquareLargeNums() {
        int[] intArray1 = {3, 1, 5};
        int[] squareInt1 = {3, 1, 25};
        assertArrayEquals(Debug.squareLargeNums(intArray1, 4), squareInt1);
        int[] intArray2 = {0, 0};
        int[] squareInt2 = {0, 0};
        assertArrayEquals(Debug.squareLargeNums(intArray2, 0), squareInt2);
    }

    // test case for countPatterns(String str, String pat)
    @Test
    public void testcountPattern() {
        String str1 = "SeananananSean";
        String pat1 = "nan";
        assertEquals(Debug.countPatterns(str1, pat1), 3);
        String str2 = "madeLINE";
        String pat2 = "E";
        assertEquals(Debug.countPatterns(str2, pat2), 1);
        String str3 = "YUXUANYUXUAN";
        String pat3 = "AN";
        assertEquals(Debug.countPatterns(str3, pat3), 2);
        String str4 = "NABI";
        String pat4 = "";
        assertEquals(Debug.countPatterns(str4, pat4), 5);
        String str5 = "12121";
        String pat5 = "3";
        assertEquals(Debug.countPatterns(str5, pat5), 0);
    }

    // test case for searchBroken(int[][] matrix2D, int target)
    @Test
    public void testsearchBroken() {
        int[][] input = new int[][] {
                new int[] {1, 3, 5, 5},
                new int[] {2, 3, 6, 7},
                new int[] {5, 7, 11, 13},
                new int[] {6, 7, 12, 15}};
        int[] output1 = {1, 0};
        assertArrayEquals(Debug.searchBroken(input, 2), output1);
        int[] output2 = {0, 3};
        assertArrayEquals(Debug.searchBroken(input, 5), output2);
        int[] output3 = {-1, -1};
        assertArrayEquals(Debug.searchBroken(input, 8), output3);
        assertArrayEquals(Debug.searchBroken(new int[0][0], 15), output3);
    }
}

