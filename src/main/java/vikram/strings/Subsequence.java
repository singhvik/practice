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
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://techdevguide.withgoogle.com/paths/foundational/find-longest-word-in-dictionary-that-subsequence-of-given-string#code-challenge
 * Given a string Source and a set of words "Dictionary", find the longest word in Dictionary that is a subsequence of Source.
 * Word W is a subsequence of Source if some number of characters, possibly zero, can be deleted from Source to form W,
 * without reordering the remaining characters.
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

    /**
     * Find smallest index greater than or equal to the input param minIndex.
     *
     * @param minIndex
     * @param matchingList
     * @return
     */
    public static final Optional<Integer> findSmallestIndex(int minIndex, List<Integer> matchingList) {
        // This can be expensive on a big list.
        // matchingList.stream().filter(index -> index >= searchStartIndex).findFirst();
        //
        return Optional.of(binarySearch(minIndex,0,matchingList.size()-1,matchingList));

    }

    /**
     * This method is not looking for exact match but the smallest
     *
     * @param start
     * @param end
     * @param matchingList
     * @return
     */
    public static int binarySearch(int minIndex, int start, int end, List<Integer> matchingList) {
        if (matchingList.isEmpty() || minIndex > matchingList.get(end)|| start > end) {
            // no match reject;
            return -1;
        }
        if (matchingList.get(start) >= minIndex) {
            return matchingList.get(start);
        }
        int mid = (end - start + 1) / 2;
        if (minIndex > matchingList.get(start+ mid)) {
            return binarySearch(minIndex, start + mid + 1, end, matchingList);
        } else if (minIndex < matchingList.get(start+mid)) {
            return binarySearch(minIndex, start, start+mid - 1, matchingList);
        }
        // exact match.
        return matchingList.get(start+ mid);

    }
}