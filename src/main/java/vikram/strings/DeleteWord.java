package vikram.strings;

/**
 * Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive).
 * You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
 *
 *
 * withoutString("Hello there", "llo") → "He there"
 * withoutString("Hello there", "e") → "Hllo thr"
 * withoutString("Hello there", "x") → "Hello there"
 */
public class DeleteWord {
    public static void main(String[] args) {
        System.out.println("Hello there, llo : " +withoutString("Hello there","llo"));
    }

    public static String withoutString(String base, String remove) {
        String lowerCaseBase = base.toLowerCase();
        String lowerCaseRemove = remove.toLowerCase();
        int match = lowerCaseBase.indexOf(lowerCaseRemove);
        if(match ==-1){
            return base;
        }
        if(match==0){
            return withoutString(base.substring(match+remove.length()),remove);
        }
        String updatedBase = base.substring(0,match);
        if(match+remove.length()<=base.length()){
            updatedBase += base.substring(match+remove.length());
        }
        return withoutString(updatedBase,remove);

    }

}
