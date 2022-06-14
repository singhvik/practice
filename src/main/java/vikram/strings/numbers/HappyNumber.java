package vikram.strings.numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */
public class HappyNumber {
    private Set<Integer> history= new HashSet<>();
    public boolean isHappy(int n) {

            System.out.println("n is " + n);
            if (n == 1) {
                // success case
                return true;
            }
            int sos = sumOfSqurdDigits(n);
            System.out.println("Sum of squares is " + sos);
             if(detectLoop(n)){
                 // failure case
                 return false;
             }
            return isHappy(sos);
    }
    public boolean detectLoop(int n) {
        return !history.add(n);
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        happyNumber.sumOfSqurdDigits(1);
    }

    public int sumOfSqurdDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n /= 10;
        }
        System.out.println("sum is ->" + sum);
        return sum;
    }
}
