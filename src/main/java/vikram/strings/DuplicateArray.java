package vikram.strings;

import java.util.Arrays;
/**
 * Remove duplicates from a sorted array.
 */
public class DuplicateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 3, 5, 6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return a;
        }
        int i = 0, j = 0;
        while (i < a.length - 1) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
            i++;
        }
        // last element is always a valid case.
        a[j++] = a[i];
        int[] result = new int[j];
        for (i = 0; i < j; i++) {
            result[i] = a[i];
        }
        return result;
    }

}
