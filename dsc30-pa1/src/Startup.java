/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */
import java.util.Arrays;
// this import statement is used for print the output when it's an array
import java.util.Collection;
import java.util.HashMap;
/**
 * This class contains all the methods that are required in PA1
 * as well as the statements which print the output
 *
 * @author Kechen Zhao
 * @since 13/1/2020
 */
public class Startup {
    /**
     * This method contains all the print statements
     * which help me visualize the output of each method in PA1
     * @param /the parameter is the method with its corresponding parameters
     */
    public static void main(String[] args) {
        //#1
        System.out.println("Method1");
        System.out.println(passed("C", 1.9f));
        System.out.println(passed("F", 1.3f));
        //#2
        System.out.println("Method2");
        System.out.println(sameDigit(27, 57));
        System.out.println(sameDigit(37, 3));
        //#3
        System.out.println("Method3");
        System.out.println(someUpper("datascience"));
        System.out.println(someUpper("Data"));
        //#4
        System.out.println("Method4");
        int[] elems1 = {2, 2, 3, 3, 4, 4, 5, 5};
        //int[] output1 = {3, 4};
        System.out.println(Arrays.toString(twoElements(elems1)));
        //#5
        System.out.println("Method5");
        int[] elem1 = {1, 2, 3, 6, 5, 4};
        //#6
        System.out.println("Method6");
        int[] a1 = {1, 9, 3, 6};
        System.out.println(secondMax(a1));
        int[] a2 = {1, 2, 3, 3};
        //#7
        System.out.println("Method7");
        int[][] ratings1 = {{1, 3, 2, 2}, {2, 3, 4, 3}, {9, 9, 10, 10}};
        System.out.println(averageRating(ratings1, 0));
        //#8
        System.out.println("Method8");
        System.out.println(patternHalf(6));
        System.out.println(patternHalf(5));
        //#9
        System.out.println("Method9");
        int[] n1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(evensOnly(n1)));
        //#10
        System.out.println("Method10");
        System.out.println(noDots("Recursion is cool."));
        System.out.println(noDots("M.A.R.I.N.A"));
        //#11
        System.out.println("Method11");
        int[] a11 = {1, 3, 3, 3, 2, 1};
        System.out.println(secondFreqInt(a11));
        int[] a12 = {6, 9, 3, 2, 9, 6, 6, 9};
        System.out.println(secondFreqInt(a12));
        //#12
        System.out.println("Method12");
        System.out.println(latestTime("1?:50"));
        System.out.println(latestTime("?3:54"));
        //#13
        System.out.println("Method13");
        int[] arr1 = {10, 2, -8, 3};
        System.out.println(Arrays.toString(multiplyByGroup(arr1, 2)));
        //#14
        System.out.println("Method14");
        System.out.println(recursiveReverseUpToN("Nabi", 3));
        System.out.println(recursiveReverseUpToN("klmnasd", 4));
    }

    //#1
    /**
     * This method takes a string and a float as parameters
     * and returns true when the letterGrade is equal to A, B,
     * or C  and grade is greater or equal to 2.5.
     * @param /The parameters are a string which represent the letter grade
     * and a float which represent the numerical grade
     *  @return /the return type of this method is boolean value
     */
    public static boolean passed(String letterGrade, float grade) {
        /* Declare constants and magic numbers */
        float passGrade = 2.5f;
        // the condition for this method to return true is
        // when the letterGrade is equal to A, B, or C and grade is greater or equal to 2.5
        if (grade >= passGrade && (letterGrade.equals("A")
                | letterGrade.equals("B") | letterGrade.equals("C"))) {
            return true;
        }
        return false;
    }

    //#2
    /**
     * This method takes two non-negative integers and returns true
     * if the two numbers have the same first digit otherwise false.
     * @param /two non-negative integers
     * @return /the return type of this method is boolean value
     */
    public static boolean sameDigit(int num1, int num2) {
        // convert two integer to string
        // and select two first character to compare
        String str1 = Integer.toString(num1);
        char cha1 = str1.charAt(0);
        String str2 = Integer.toString(num2);
        char cha2 = str2.charAt(0);
        if (cha1 == cha2) {
            return true;
        }
        return false;
    }

    //#3
    /**
     * This method takes in a string and returns a new string
     * where the last 3 characters are now in upper case.
     * If the string has less than 3 characters,
     * uppercases the whole string.
     * If the string has 3 or more characters
     * and the first letter as an upper case,
     * make the first letter lower case.
     * @param /the parameter is a string
     * @return /the return type of this method is string
     */
    public static String someUpper(String str) {
        /* Declare constants and magic numbers */
        int strLength = 3;
        // select the first character to check whether it's uppercase
        char char1 = str.charAt(0);
        int leng = str.length();
        // if the string length is less than 3
        // uppercase the entire string
        if (str.length() < strLength) {
            return str.toUpperCase();
        }
        // if the string length is 3 and
        // the first character is upprecase
        // make the first char lowercase and the remaining uppercase
        if (str.length() == strLength && (Character.isUpperCase(char1))) {
            char1 = Character.toLowerCase(char1);
            String substr = str.substring(1, strLength);
            substr = substr.toUpperCase();
            return char1 + substr;
        }
        // if the string length is greater than 3
        // and the first character is upprecase
        // make the first char lowercase and the last 3 uppercase
        if (str.length() > strLength && (Character.isUpperCase(char1))) {
            char1 = Character.toLowerCase(char1);
            String substr = str.substring(leng - strLength, leng);
            substr = substr.toUpperCase();
            String middle = str.substring(1, leng - strLength);
            return char1 + middle + substr;
        }
        // if a string is none of the above cases
        // just upper the last 3 characters
        String begin = str.substring(0, leng - strLength);
        String end = str.substring(leng - strLength, leng);
        end = end.toUpperCase();
        return begin + end;
    }

    //#4
    /**
     * This method takes in an array of even length
     * and returns a new array length 2
     * containing the middle two elements from the original array.
     * It should not modify the original array.
     * @param /the parameter is an integer array
     * @return /the return type of this method is integer array
     */
    public static int[] twoElements(int[] elems) {
        /* Declare constants and magic numbers */
        int evenLength = 2;
        int[] output = new int[2];
        int leng = elems.length;
        // if the string length is smaller than 2
        // return the empty string
        if (leng < evenLength) {
            int[] oddOutput = new int[0];
            return oddOutput;
        }
        // if the string length is larger than 2
        // and is odd,
        // return an array contains the first and last element
        // in the input string
        if (leng > evenLength && leng % evenLength != 0) {
            output[0] = elems[0];
            output[1] = elems[leng - 1];
            return output;
        }
        // the only remaining case is
        // the length of string is larger than 2 and is even
        // in this case
        // return the middle two element in the string
        // locate the element with index
        int index1 = leng / evenLength - 1;
        int index2 = leng / evenLength;
        output[0] = elems[index1];
        output[1] = elems[index2];
        return output;
    }

    //#5
    /**
     * This method takes in an integer array
     * and returns true if the array somewhere
     * contains three continuously decreasing numbers.
     * @param /the parameter is an integer array
     * @return /the return type of this method is a boolean
     */
    public static boolean decreasingOrder(int[] elems) {
        int leng = elems.length;
        //use for loop to iterate through the whole array
        for (int j = 0; j < leng - 1; j++) {
            // the if statement can check whether
            // there exists three continuously decreasing numbers
            if (elems[j] - elems[j + 1] == 1 && elems[j + 1] - elems[j + 2] == 1) {
                return true;
            }
        }
        return false;
    }

    //#6
    /**
     * This method takes an array of integers
     * and returns the second largest element in this array.
     * @param /the parameter is an integer array
     * @return /the return type of this method is an integer
     */
    public static int secondMax(int[] a) {
        /* Declare constants and magic numbers */
        int strBasecase = 1;
        int leng = a.length;
        // first initialize the first maximum value
        // and the second maximum value as the first integer
        int max1Value = a[0];
        int max2Value = a[0];
        if (leng > strBasecase) {
            // create a for loop to find the
            // largest and the second largest number in array
            for (int i = 1; i < leng; i++) {
                // if there is an integer that is great than the
                // current maximum value,
                // assign this value to max1Value
                // and let max2Value equals to the previous maximum value
                if (a[i] >= max1Value) {
                    max2Value = max1Value;
                    max1Value = a[i];
                } else if (a[i] >= max2Value) {
                    max2Value = a[i];
                }
            }
            return max2Value;
        }
        return Integer.MAX_VALUE;
    }

    //#7
    /**
     * This method takes in a 2-D array that represents
     * users‘ ratings for each movie, and
     * the index for a movie.
     * It returns the average rating for a movie at the given index.
     * @param /the parameters are a 2D integer array and an integer
     * @return /the return type of this method is a float
     */
    public static float averageRating(int[][] ratings, int movieIndex) {
        // initialize the average rating and the sum of rating
        double avgRating = 0.0;
        double sum = 0.0;
        int leng = ratings.length;
        // use for loop to sum up all the ratings
        // at index movieIndex
        for (int i = 0; i < leng; i++) {
            sum += ratings[i][movieIndex];
        }
        avgRating = sum / leng;
        return (float) (Math.round(avgRating * 1000d) / 1000d);
    }

    //#8
    /**
     * This method takes in a positive integer and
     * returns a string that represents half of a diamond, made of '*' (stars).
     * @param /parameter is an integer
     * @return /the return type of this method is a string
     */
    public static String patternHalf(int n) {
        /* Declare constants and magic numbers */
        int empty = 0;
        if (n <= empty) {
            System.out.println(" ");
        } else {
            // first print the top half of stars
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println(" ");
            }
            // then print the lower half
            for (int i = n - 1; i >= 1; i--) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        // return the blank line at the end
        return " ";
    }

    //#9.
    /**
     * for this problem, I tried three different methods
     * to return the even numbers in an array
     * none of them is working, but
     * I choose to present my work to gain some partial credit
     */

    /**
     * for my first approach, I tried to split
     * the array by using the same method in mergesort
     * I successfully write this function
     * but I don't know how to implement it
     * into the function evensOnly
     * @param /parameter is an integer array
     */
    public static void splitList(int[] a) {
        int n = a.length;
        int middle = n / 2;
        int[] left = new int[middle];
        int[] right = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = a[i];
        }
        for (int i = middle; i < n; i++) {
            right[i - middle] = a[i];
        }
        splitList(left);
        splitList(right);
    }

    /**
     * for my second approach, I tried to write
     * this function without using recursion
     * I successfully select the even numbers
     * but the output is not what I expected
     * @param /parameter is an integer array
     */
    public static int[] evensOnly(int[] n) {
        int leng = n.length;
        int[] output = new int[0];
        if (leng > 0) {
            for (int i = 0; i < leng; i++) {
                // during each iteration
                // a new int array will be created to store the elememts
                // except the first one
                // the first element will be checked whether
                // even or odd
                // if it's even
                // the element will be printed
                for (int j = 0; j < leng; j++) {
                    int[] newList = new int[leng - i];
                    System.arraycopy(n, i, newList, 0, leng - i);
                    if ((newList[0] % 2) == 0) {
                        System.out.println(newList[0]);
                    }
                    break;
                }
            }
        }
        return output;
    }

    /**
     * for my third approach, I write a new function
     * which use recursion to select even numbers and print them
     * but I don't know how to implement it into evensOnly function
     * @param /parameters are an integer array and two integer values
     */
    public static void checkEvens(int[] n, int start, int end) {
        start = 0;
        end = n.length;
        int[] recursion = new int[end];
        System.arraycopy(n, start, recursion, 0, end);
        if (start == end) {
            return;
        } else {
            // if the first number in the array is even
            // print the number and recursively call this function
            // to check the next element
            if (n[0] % 2 == 0) {
                System.out.println(n[0]);
                checkEvens(recursion, start + 1, end);
            } else {
                checkEvens(recursion, start + 1, end);
            }
        }
    }

    //#10
    /**
     * This method takes in a string and
     * returns a new string where all the dots ('.') have been removed.
     * @param /parameter is a string
     * @return /the return type of this method is a string
     */
    public static String noDots(String str) {
        // use for loop to find the dots
        // then add two strings together
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(".")) {
                return str.substring(0, i) + noDots(str.substring(i + 1));
            }
        }
        return str;
    }

    //#11...need improve
    /**
     * This method takes an array of integers and
     * returns the second most frequent value in this array.
     * @param /parameter is an integer array
     * @return /the return type of this method is a integer
     */
    public static int secondFreqInt(int[] a) {
        // create a hash map which has the same function as Python dictionary
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        // use for loop to count the frequency of each element in array
        for (int i = 0; i < a.length; i++) {
            if (count.containsKey(a[i])) {
                int curFreq = count.get(a[i]);
                count.remove(a[i]);
                count.put(a[i], curFreq + 1);
            } else {
                count.put(a[i], 1);
            }
        }
        Collection<Integer> freq = count.values();
        // create an array that contains all the frequencies
        int[] frequency = freq.stream().mapToInt(i -> i).toArray();
        Collection<Integer> numbers = count.keySet();
        // create an array that contains all the elements
        int[] number = numbers.stream().mapToInt(i -> i).toArray();
        // use the same method of find second max number
        // to find the second frequent number
        int leng = frequency.length;
        int max1Value = a[0];
        int max2Value = a[0];
        if (leng > 1) {
            for (int i = 1; i < leng; i++) {
                if (frequency[i] >= max1Value) {
                    max2Value = max1Value;
                    max1Value = frequency[i];
                } else if (frequency[i] >= max2Value) {
                    max2Value = frequency[i];
                }
            }
        }
        return max2Value;
    }

    //#12
    /**
     * This method takes in a string in the format of XX:XX representing the time.
     * It will return the latest time possible in 24 hour format
     * @param /parameter is a string
     * @return /the return type of this method is a string
     */
    public static String latestTime(String time) {
        // the basic logic of this method is to select the four digit of time
        // separately, then store the integer and string values of these digits
        // brute force all possible cases
        // then return the final output
        int cha1Value = 0, cha2Value = 0, cha3Value = 0, cha4Value = 0;
        String cha1 = time.substring(0, 1);
        if (!cha1.equals("?")) {
            cha1Value = Integer.parseInt(cha1);
        }
        String cha2 = time.substring(1, 2);
        if (!cha2.equals("?")) {
            cha2Value = Integer.parseInt(cha2);
        }
        String cha3 = time.substring(3, 4);
        if (!cha3.equals("?")) {
            cha3Value = Integer.parseInt(cha3);
        }
        String cha4 = time.substring(4, 5);
        if (!cha4.equals("?")) {
            cha4Value = Integer.parseInt(cha4);
        }
        String newTime = "";
        if (cha1.equals("?") && cha2Value <= 4) {
            cha1 = "2";
        }
        if (cha1.equals("?") && cha2Value > 4) {
            cha1 = "1";
        }
        if (cha1.equals("1") && cha2.equals("?")) {
            cha2 = "9";
        }
        if (cha1.equals("2") && cha2.equals("?")) {
            cha2 = "3";
        }
        if (cha3.equals("?")) {
            cha3 = "5";
        }
        if (cha4.equals("?")) {
            cha4 = "9";
        }
        if (cha1.equals("?") && cha2.equals("?")) {
            cha1 = "2";
            cha2 = "3";
        }
        newTime = cha1 + cha2 + ":" + cha3 + cha4;
        return newTime;
    }

    //#13
    /**
     * This method splits arr into subgroups of (equal) size groupSize,
     * and multiply the contents of each subgroup.
     * It returns the individual product in a new list
     * @param /parameters are an integer array and a integer
     * @return /the return type of this method is an integer array
     */
    public static int[] multiplyByGroup(int[] arr, int groupSize) {
        int leng = arr.length;
        int[] product = new int[0];
        // if the array cannot be separated into #groupSize groups
        // return the empty array
        if (leng % groupSize != 0) {
            return product;
        } else {
            int subList = leng / groupSize;
            product = new int[subList];
            for (int i = 0; i < subList; i++) {
                product[i] = 1;
                // use for loop to iteratively multiply the element within the group
                for (int j = i * groupSize; j < groupSize + i * groupSize; j++) {
                    product[i] = product[i] * arr[j];
                }
            }
        }
        return product;
    }

    //#14
    /**
     * This method recursively reverses the given string s by part for n times.
     * @param /parameter is a string
     * @return /the return type of this method is a string
     */
    // first write a helper method to recursively reverse the entire string
    public static String reverseString(String string) {
        if (!string.isEmpty()) {
            return reverseString(string.substring(1)) + string.charAt(0);
        }
        return string;
    }

    public static String recursiveReverseUpToN(String s, int n) {
        String output = "";
        // by using the for loop
        // reverse part of the string in each loop
        for (int i = 1; i <= n; i++) {
            String reverse = s.substring(0, i);
            String currentEnd = s.substring(i);
            output = reverseString(reverse);
            s = output + currentEnd;
        }
        return s;
    }
}

