/*
 * NAME: Kechen Zhao
 * PID: A16139826
 */
/**
 * This class contains a method which simulates a 369-Game.
 *
 * @author Kechen Zhao
 * @since 13/1/2020
 */
public class ThreeSixNine {
    /* Declare constants and magic numbers */
    private static final int CLAP = -1;
    /**
     * This method simulates a 369-Game, where n represents the maximum number to count.
     * A player starts counting numbers from 1, then the next player counts 2 and so on.
     * When encountering a number that is a multiple of 3, or contains 3, 6 or 9,
     * the player should clap hands instead of saying the number.
     * In this method, the place where the player need to clap hands
     * is represented by -1.
     * @param /the parameter of this method is an integer,
     * which represents the maximum number to count.
     * @return /the return type of this method is an integer array
     */
    public static int[] the369Game(int n) {
        int[] output = new int[n];
        // create a new integer array with dimension n
        for (int i = 0; i < n; i++) {
            // by using for loop, filling all the positions in array 'output'
            // with either the number or -1
            if ((i + 1) % 3 == 0) {
                output[i] = CLAP;
                // if the number is a multiple of 3
                // then this position should represented by -1
                // where -1 means the players clap their hands
            } else {
                output[i] = i + 1;
                // if the number is not a multiple of 3
                // then this position should represented by the number they say
            }
            // now consider another case, if the number is not a multiple of 3
            // (which is not represented by -1)
            // then convert this integer into string
            // loop through all the index position
            // to check whether this integer contains
            // the multiple of 3 (3, 6 or 9)
            if (output[i] != -1) {
                String intStr = Integer.toString(output[i]);
                int leng = intStr.length();
                for (int j = 0; j < leng; j++) {
                    int strInt = Integer.parseInt(intStr.substring(j, j + 1));
                    if (strInt != 0 && strInt % 3 == 0) {
                        output[i] = CLAP;
                    }
                }
            }
        }
        return output;
    }

    /* for test purpose */
    public static void main(String[] args) {
        int n = 40;
        int[] output;
        output = the369Game(n);

        System.out.println(java.util.Arrays.toString(output));
        // Should print [1, 2, -1, 4, 5, -1, 7, 8, -1, 10, 11, -1,
        // -1, 14, -1, -1, 17, -1, -1, 20, -1, 22, -1, -1, 25, -1,
        // -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40]

        int n1 = 0;
        int[] output1;
        output1 = the369Game(n1);
        System.out.println(java.util.Arrays.toString(output1));
    }
}

