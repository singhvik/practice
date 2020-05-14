package vikram.strings;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://techdevguide.withgoogle.com/paths/foundational/find-longest-word-in-dictionary-that-subsequence-of-given-string#code-challenge
 */
public class Subsequence {
    public static void main(String[] args) {
        String source = "abpppleed";
        List<String> dictionary = Arrays.asList("ad", "able", "ale", "apple", "bale", "kangaroo", "bled", "oh my this is too big");
        System.out.println(largestSubSequence(source, dictionary));
        System.out.println("=======================================================================");
        System.out.println(largestSubSequenceGreedy(source, dictionary));

    }

    /**
     * Basic approach scan source for each word in dictionary.
     * For a very large dictionary its gonna be small.
     *
     * @param source
     * @param dictionary
     * @return
     */
    public static String largestSubSequence(String source, List<String> dictionary) {
        Instant begin = Instant.now();

        String largestSubSequence = null;
        for (String word : dictionary) {
            if (largestSubSequence != null && largestSubSequence.length() > word.length()) {
                System.out.println("Already found a bigger subsequence, Rejecting: " + word);
                continue;
            }
            if (word.length() > source.length()) {
                System.out.println("Word is bigger than the source " + word);
            }
            int processIndex = 0;
            int searchStartIndex = 0;
            boolean rejected = false;
            while (processIndex < word.length()) {
                int matchIndex = source.indexOf(word.charAt(processIndex), searchStartIndex);
                if (matchIndex == -1) {
                    rejected = true;
                    System.out.println("Rejected:" + word + " at index " + processIndex);
                    break;
                } else {
                    // its a match but do we have enough characters left in source string
                    if (word.length() - processIndex > source.length() - matchIndex) {
                        rejected = true;
                        System.out.println("Rejected:" + word + " at index " + processIndex + " not enough source chars left");
                        break;
                    }
                    // keep moving to next char;
                    processIndex++;
                    searchStartIndex = matchIndex + 1;
                }
            }
            if (!rejected) {
                System.out.println(word + " is subsequence");
                if (largestSubSequence == null || largestSubSequence.length() < word.length()) {
                    largestSubSequence = word;
                }
            }
        }
        System.out.println("Largest Subsequence is " + largestSubSequence);
        System.out.println("Time taken is " + Duration.between(begin, Instant.now()));
        return largestSubSequence;
    }

    /**
     * Take the greedy approach save results in a map.
     * Space usage is high.
     *
     * @param source
     * @param dictionary
     * @return
     */
    public static String largestSubSequenceGreedy(String source, List<String> dictionary) {
        Instant begin = Instant.now();
        // Step 1: from source build a map, key is chars in source and value is list of indices where they are present;
        Map<Integer, List<Integer>> sourceMap = new HashMap<>();
        for (int index = 0; index < source.length(); index++) {
            sourceMap.merge((int) source.charAt(index), List.of(index), (originalList, newList) ->
                    //merge if already a list present
                    Stream.of(originalList, newList).flatMap(Collection::stream).collect(Collectors.toList())
            );

        }
        System.out.println(sourceMap);
        // Step 2: now use source map to find the largest subsequence;
        String largestSubSequence = null;
        for (String word : dictionary) {
            if (largestSubSequence != null && largestSubSequence.length() > word.length()) {
                System.out.println("Already found a bigger subsequence, Rejecting: " + word);
                continue;
            }
            int processIndex = 0;
            int searchStartIndex = 0;
            boolean rejected = false;
            while (processIndex < word.length()) {
                List<Integer> matchingIndices = sourceMap.getOrDefault((int) word.charAt(processIndex), Collections.emptyList());
                int matchIndex = findSmallestIndex(searchStartIndex, matchingIndices).orElse(-1);
                if (matchingIndices == null || matchIndex == -1) {
                    rejected = true;
                    System.out.println("Rejected:" + word + " at index " + processIndex);
                    break;
                } else {
                    // its a match but do we have enough characters left in source string
                    if (word.length() - processIndex > source.length() - matchIndex) {
                        rejected = true;
                        System.out.println("Rejected:" + word + " at index " + processIndex + " not enough source chars left");
                        break;
                    }
                    // keep moving to next char;
                    processIndex++;
                    searchStartIndex = matchIndex + 1;
                }
            }
            if (!rejected) {
                System.out.println(word + " is subsequence");
                if (largestSubSequence == null || largestSubSequence.length() < word.length()) {
                    largestSubSequence = word;
                }
            }
        }
        System.out.println("Largest Greedy Subsequence is " + largestSubSequence);
        System.out.println("Time taken is " + Duration.between(begin, Instant.now()));
        return largestSubSequence;

    }

    public static final Optional<Integer> findSmallestIndex(int searchStartIndex, List<Integer> matchingList) {
        return matchingList.stream().filter(index -> index >= searchStartIndex).findFirst();

    }
}
