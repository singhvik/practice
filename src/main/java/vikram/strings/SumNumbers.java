package vikram.strings;

/**
 * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters.
 * A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char)
 *  tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
 *
 *
 * sumNumbers("abc123xyz") → 123
 * sumNumbers("aa11b33") → 44
 * sumNumbers("7 11") → 18
 */
public class SumNumbers {
    public static void main(String[] args) {
        System.out.println(sumNumbers("aa11b33")); //44
        System.out.println(sumNumbers("a22bbb3")); // 25
    }

    public static int sumNumbers(String str) {
        int sum =0;
        String currentNumber = "";
        for(int index=0; index<str.length();index++){
            char currentChar = str.charAt(index);
            if(Character.isDigit(currentChar)){
                currentNumber+= currentChar;
            }else{
                if(currentNumber.length()>0){
                    sum += Integer.parseInt(currentNumber);
                    currentNumber="";
                }
            }
        }
        // number at the end case;
        if(currentNumber.length()>0) {
            sum += Integer.parseInt(currentNumber);
        }
        return sum;
    }

}
