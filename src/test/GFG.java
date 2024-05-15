package test;

// Java Program to implement Bitap Algorithm.

import java.io.IOException;

public class GFG {
    public static void main(String[] args)
            throws IOException {

        System.out.println("Bitap Algorithm!");

        String text = "geeksforgeeks";

        String pattern = "geeks";

        // This is an object created of the class for
        // extension of functions.
        GFG g = new GFG();

        // Now here we go to findPattern functions , we two
        // arguments.
        g.findPattern(text, pattern);
    }

    public void findPattern(String t, String p) {

        // we convert the String text to Character Array for
        // easy indexing
        char[] text = t.toCharArray();

        // we convert the String pattern to Character Array
        // to access each letter in the String easily.
        char[] pattern = p.toCharArray();

        // Index shows the function bitap search if they are
        // equal at a particular index or not
        int index = bitapSearch(text, pattern);

        // If the pattern is not equal to the text of the
        // string approximately Then we tend to return -1 If
        // index is -1 Then we print there is No match
        if (index == -1) {
            System.out.println("\nNo Match\n");
        } else {
            // Else if there is a match
            // Then we print the position of the index at
            // where the pattern and the text matches.
            System.out.println("\nPattern found at index: \n" + index);
        }
    }

    private int bitapSearch(char[] text, char[] pattern) {

        // Here the len variable is taken
        // This variable accepts the pattern length as its
        // value
        int len = pattern.length;

        // This is an array of pattern_mask of all
        // character values in it.

        long[] pattern_mask = new long[Character.MAX_VALUE + 1];

        // Here the variable of being long type is
        // complemented with 1;

        long R = ~1;

        // Now if the length of the pattern is 0
        // we would return -1
        if (len == 0) {
            return -1;
        }

        // Or if the length of the pattern exceeds the
        // length of the character array Then we would
        // declare that the pattern is too long. We would
        // return -1

        if (len > 63) {
            System.out.println("Pattern too long!");
            return -1;
        }

        // Now filling the values in the pattern mask
        // We would run th eloop until the max value of
        // character Initially all the values of Character
        // are put up inside the pattern mask array And
        // initially they are complemented with zero
        for (int i = 0; i <= Character.MAX_VALUE; ++i) {
            pattern_mask[i] = ~0;
        }

        // Now len being the variable of pattern length ,
        // the loop is set till there Now the pattern being
        // the index of the pattern_mask 1L means the long
        // integer is shifted to left by i times The result
        // of that is now being complemented the result of
        // the above is now being used as an and operator We
        // and the pattern_mask and the result of it
        for (int i = 0; i < len; ++i)
            pattern_mask[pattern[i]] &= ~(1L << i);


        // Now the loop is made to run until the text length
        // Now what we do this the R array is used
        // as an Or function with pattern_mask at index of
        // text of i

        for (int i = 0; i < text.length; ++i) {


            R |= pattern_mask[i];

            // Now result of the r after the above
            // operation
            // we shift it to left side by 1 time

            R <<= 1;

            // If the 1L long integer if shifted left of the
            // len And the result is used to and the result
            // and R array
            // If that result is equal to 0
            // We return the index value
            // Index = i - len + 1

            if ((R & (1L << len)) == 0)
                return i - len + 1;
        }

        // if the index is not matched
        // then we return it as -1
        // stating no match found.

        return -1;
    }
}
