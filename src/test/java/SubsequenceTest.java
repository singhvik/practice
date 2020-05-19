
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static vikram.strings.Subsequence.binarySearch;
public class SubsequenceTest {

    @Test
    public void testBinarySearch() {
        Random random = new Random();
        int listSize = 23;
        var list = Stream.generate(() -> random.nextInt(1000000)).limit(listSize).sorted().collect(Collectors.toList());
        System.out.println(list);
        // lower number then min in the list
        assertEquals(list.get(0) ,binarySearch(-11111, 0, list.size() - 1, list));
        // first in list
        assertEquals(list.get(0),binarySearch(-11111, 0, list.size() - 1, list));
        // last in list
        assertEquals(list.get(list.size() - 1),binarySearch(list.get(list.size() - 1), 0, list.size() - 1, list));
        // mid
        int mid = (listSize+1)/2;
        assertEquals(list.get(mid),binarySearch(list.get(mid), 0, list.size() - 1, list));
        assertEquals(list.get(mid-1),binarySearch(list.get(mid-1), 0, list.size() - 1, list));
        assertEquals(list.get(mid+1),binarySearch(list.get(mid+1), 0, list.size() - 1, list));
        // random
        assertEquals(list.get(17),binarySearch(list.get(17), 0, list.size() - 1, list));
        // random
        assertEquals(list.get(5),binarySearch(list.get(5), 0, list.size() - 1, list));
        // greater than max
        assertEquals(-1,binarySearch(11111, 0, list.size() - 1, list));
    }

    @Test
    public void testBinarySearchEvenSizedList() {
        Random random = new Random();
        int listSize = 24;
        var list = Stream.generate(() -> random.nextInt(1000)).limit(24).sorted().collect(Collectors.toList());
        System.out.println(list);
        // lower number then min in the list
        assertEquals(list.get(0) ,binarySearch(-11111, 0, list.size() - 1, list));
        // first in list
        assertEquals(list.get(0),binarySearch(-11111, 0, list.size() - 1, list));
        // last in list
        assertEquals(list.get(list.size() - 1),binarySearch(list.get(list.size() - 1), 0, list.size() - 1, list));
        // mid
        int mid = (listSize)/2;
        assertEquals(list.get(mid),binarySearch(list.get(mid), 0, list.size() - 1, list));
        assertEquals(list.get(mid-1),binarySearch(list.get(mid-1), 0, list.size() - 1, list));
        assertEquals(list.get(mid+1),binarySearch(list.get(mid+1), 0, list.size() - 1, list));
        // random
        assertEquals(list.get(17),binarySearch(list.get(17), 0, list.size() - 1, list));
        // random
        assertEquals(list.get(5),binarySearch(list.get(5), 0, list.size() - 1, list));
        // greater than max
        assertEquals(-1,binarySearch(11111, 0, list.size() - 1, list));
    }
}
