/**
 * DSC 30 PA 02 - Part 2
 * A class of three debugging problems.
 */
public class Debug {

    /**
     * Only calculate square of numbers that are larger than the threshold.
     * @param nums an array of integers
     * @param threshold threshold
     * @return the array with only larger numbers squared
     */
    public static int[] squareLargeNums(int[] nums, int threshold) {

        int[] arr = new int[nums.length];
        int i = 0;

        while (i < arr.length) {
            if (nums[i] > threshold) {
                arr[i] = nums[i] * nums[i];
                i++;
            } else {
                arr[i] = nums[i];
                i++;
            }
        }
        return arr;

    }
    
    /**
     * Count occurrences of a pattern in a string.
     * @param str string
     * @param pat pattern
     * @return number of occurrences
     */
    public static int countPatterns(String str, String pat) {
        int strLen = str.length();
        int patLen = pat.length();
        int count = 0;
        int i = 0;

        while (i <= strLen - patLen) {

            if (str.substring(i, i + patLen).equals(pat)) {
                count++;
            }
            i++;
        }
        return count;
    }
    
    /**
     * Find the location of the target integer in a sorted 2D matrix.
     * @param matrix2D a sorted 2D matrix
     * @param target target integer
     * @return an array of size 2 that is the location of an integer in a sorted
     * 2D matrix. If the element is not there, return [-1, -1].
     */
    public static int[] searchBroken(int[][] matrix2D, int target) {
        int[] emptyArr = new int[]{-1, -1};
        if (matrix2D == null || matrix2D.length == 0 || matrix2D[0].length == 0) {
            return emptyArr;
        }

        int col = matrix2D[0].length - 1;
        int row = 0;

        while (col >= 0 && row < matrix2D.length) {
            if (target == matrix2D[row][col]) {
                int[] correctArr = new int[]{row, col};
                return correctArr;
            } else if (target < matrix2D[row][col]) {
                col -= 1;
            } else if (target > matrix2D[row][col]) {
                row += 1;
            }
        }

        return emptyArr;
    }


}
