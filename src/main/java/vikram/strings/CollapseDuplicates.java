package vikram.strings;

/**
 * Collapse dups: https://codingbat.com/prob/p256268
 * collapseDuplicates("a") → "a"
 * collapseDuplicates("aa") → "a"
 * collapseDuplicates("abc") → "abc"
 */
public class CollapseDuplicates {
    public static void main(String[] args) {
        System.out.println(collapseDuplicates("abbbcaaaccc"));
    }

    public static String collapseDuplicates(String a) {
        String result = "";
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) != a.charAt(i + 1)) {
                result += a.charAt(i);
            }
        }
        if (a.length() > 0) {
            result += a.charAt(a.length() - 1);
        }
        return result;

    }

}
