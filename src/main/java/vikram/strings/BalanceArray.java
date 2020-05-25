package vikram.strings;

import java.util.Arrays;

/**
 * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to
 * the sum of the numbers on the other side.
 * https://codingbat.com/prob/p158767
 * canBalance([1, 1, 1, 2, 1]) → true
 * canBalance([2, 1, 1, 2, 1]) → false
 * canBalance([10, 10]) → true
 */
public class BalanceArray {
    public static void main(String[] args) {

        int arr[] = new int[]{1, 1, 1, 2, 1};
        System.out.println("Array  "+ Arrays.toString(arr) + "  - " + canBalance(arr) );

        int arr2[] = new int[]{1, 2, 3, 1, 0, 2, 3};
        System.out.println("Array  "+ Arrays.toString(arr2) + "  - " + canBalance(arr) );
    }

    public static boolean canBalance(int[] nums) {
        int sumFirstHalf = 0;
        int sumOtherHalf = 0;
        if (nums.length > 1) {
            sumFirstHalf = nums[0];
            sumOtherHalf = nums[nums.length - 1];
        }
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (sumFirstHalf == sumOtherHalf && i == j - 1) {
                return true;
            } else if (sumFirstHalf < sumOtherHalf) {
                i++;
                sumFirstHalf += nums[i];
            } else {
                j--;
                sumOtherHalf += nums[j];
            }

        }
        return false;
    }

}
