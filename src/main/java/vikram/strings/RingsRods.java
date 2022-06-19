package vikram.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsRods {
    //Map<Character, Set<Character>> ringMap = new HashMap<>() ;
    public int countPoints(String rings) {
        int count =0;
        Map<Character, Set<Character>> ringMap = new HashMap<>() ;
        for (int ring = 0,  rod=1; ring < rings.length() -1; ring+=2,rod+=2) {
            Character currentRod = rings.charAt(rod);
            Character currentRing = rings.charAt(ring);
            Set<Character> currentRingSet = ringMap.getOrDefault(currentRod,new HashSet<>());
            boolean newRingColourAdded = currentRingSet.add(currentRing);
            ringMap.put(currentRod, currentRingSet);
            if(newRingColourAdded && currentRingSet.size()==3){
                count++;
            }
        }
        return count;
    }
}
