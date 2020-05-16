
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
        var list = Stream.generate(() -> random.nextInt(1000)).limit(23).sorted().collect(Collectors.toList());
        System.out.println(list);
        // lower number then min in the list
        assertEquals(list.get(0) ,binarySearch(-11111, 0, list.size() - 1, list));
        // first in list
        assertEquals(list.get(0),binarySearch(-11111, 0, list.size() - 1, list));
        // last in list
        assertEquals(list.get(22),binarySearch(list.get(22), 0, list.size() - 1, list));
        // mid
        assertEquals(list.get(12),binarySearch(list.get(12), 0, list.size() - 1, list));
        assertEquals(list.get(11),binarySearch(list.get(11), 0, list.size() - 1, list));
        assertEquals(list.get(13),binarySearch(list.get(13), 0, list.size() - 1, list));
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
        var list = Stream.generate(() -> random.nextInt(1000)).limit(24).sorted().collect(Collectors.toList());
        System.out.println(list);
        // lower number then min in the list
        assertEquals(list.get(0) ,binarySearch(-11111, 0, list.size() - 1, list));
        // first in list
        assertEquals(list.get(0),binarySearch(-11111, 0, list.size() - 1, list));
        // last in list
        assertEquals(list.get(22),binarySearch(list.get(22), 0, list.size() - 1, list));
        // mid
        assertEquals(list.get(12),binarySearch(list.get(12), 0, list.size() - 1, list));
        assertEquals(list.get(11),binarySearch(list.get(11), 0, list.size() - 1, list));
        assertEquals(list.get(13),binarySearch(list.get(13), 0, list.size() - 1, list));
        // random
        assertEquals(list.get(17),binarySearch(list.get(17), 0, list.size() - 1, list));
        // random
        assertEquals(list.get(5),binarySearch(list.get(5), 0, list.size() - 1, list));
        // greater than max
        assertEquals(-1,binarySearch(11111, 0, list.size() - 1, list));
    }
}
