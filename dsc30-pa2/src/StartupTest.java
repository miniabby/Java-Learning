import static org.junit.Assert.*;
import org.junit.Test;

public class StartupTest {

    @Test
    public void testsameDigit() {
        int num1 = 10;
        int num2 = 20;
        assertFalse(Startup.sameDigit(num1, num2));
        int num3 = 0;
        int num4 = 20;
        assertFalse(Startup.sameDigit(num3, num4));
        int num5 = 256;
        int num6 = 20;
        assertTrue(Startup.sameDigit(num5, num6));
    }

    @Test
    public void testsameUpper() {
        String str1 = "Abigail";
        assertEquals(Startup.someUpper(str1), "abigAIL");
        String str2 = " ";
        assertEquals(Startup.someUpper(str2), " ");
        String str3 = "a";
        assertEquals(Startup.someUpper(str3), "A");
        String str4 = "ABI";
        assertEquals(Startup.someUpper(str4), "aBI");

    }

    @Test
    public void testtwoElement() {
        int[] array1 = {1, 3, 2, 4, 4, 6};
        int[] output1 = {2, 4};
        assertArrayEquals(Startup.twoElements(array1), output1);
        int[] array2 = {};
        int[] output2 = {};
        assertArrayEquals(Startup.twoElements(array2), output2);
        int[] array3 = {1, 2, 3};
        int[] output3 = {1, 3};
        assertArrayEquals(Startup.twoElements(array3), output3);
        int[] array4 = {2};
        int[] output4 = {};
        assertArrayEquals(Startup.twoElements(array4), output4);
    }

    @Test
    public void testsecondMax() {
        int[] list1 = {-3, -4, -2, -2};
        assertEquals(Startup.secondMax(list1), -2);
        int[] list2 = {-3, -4, -1, 0};
        assertEquals(Startup.secondMax(list2), -1);
        int[] list3 = {};
        int largertNum = Integer.MAX_VALUE;
        assertEquals(Startup.secondMax(list3), largertNum);
        int[] list4 = {1};
        assertEquals(Startup.secondMax(list4), largertNum);
    }

    @Test
    public void testlatestTime() {
        String time1 = "2?:5?";
        assertEquals(Startup.latestTime(time1), "23:59");
        String time2 = "?9:?8";
        assertEquals(Startup.latestTime(time2), "19:58");
        String time3 = "??:1?";
        assertEquals(Startup.latestTime(time3), "23:19");
        String time4 = "??:??";
        assertEquals(Startup.latestTime(time4), "23:59");
        String time5 = "?2:??";
        assertEquals(Startup.latestTime(time5), "22:59");
    }
}


