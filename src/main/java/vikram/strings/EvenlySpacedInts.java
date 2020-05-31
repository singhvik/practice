package vikram.strings;

import java.util.Arrays;

/**
 * Given three ints, a b c, one of them is small, one is medium and one is large.
 * Return true if the three values are evenly spaced, so the difference between small and medium is the same as the difference between medium and large.
 * <p>
 * <p>
 * evenlySpaced(2, 4, 6) → true
 * evenlySpaced(4, 6, 2) → true
 * evenlySpaced(4, 6, 3) → false
 * <p>
 * https://codingbat.com/prob/p198700
 */
public class EvenlySpacedInts {

    public static void main(String[] args) {
        System.out.println(evenlySpaced(4, 6, 2));
        System.out.println(evenlySpaced(4, 6, 3));
    }
    public static boolean evenlySpaced(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        if (arr[1] - arr[0] == arr[2] - arr[1]) {
            return true;
        }
        return false;
    }

}
