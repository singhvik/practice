package vikram.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 * <p>
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 * <p>
 * Implement the Logger class:
 * <p>
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
 * <p>
 * Input
 * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
 * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
 * Output
 * [null, true, true, false, false, false, true]
 * <p>
 * Explanation
 * Logger logger = new Logger();
 * logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
 * logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
 * logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
 * logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
 * logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
 * logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= timestamp <= 109
 * Every timestamp will be passed in non-decreasing order (chronological order).
 * 1 <= message.length <= 30
 * At most 104 calls will be made to shouldPrintMessage.
 */
public class Logger {
    private HashMap<Integer, HashSet<String>> messages;
    public static final int RATE_LIMIT_TIME = 10;

    public Logger() {
        messages = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        deleteMessagesBeforeLimit(timestamp);
        if(canPrintMessage(message)){
            HashSet<String> bucket = messages.getOrDefault(timestamp, new HashSet<>());
            bucket.add(message);
            messages.put(timestamp,bucket);
            return true;
        }

        return false;
    }

    private void deleteMessagesBeforeLimit(int currentTime) {
        List<Integer> oldBuckets = messages.keySet().stream().filter(k -> k <= currentTime - RATE_LIMIT_TIME).collect(Collectors.toList());
        oldBuckets.stream().forEach(messages::remove);
    }

    public boolean canPrintMessage(String message) {
       return !messages.values().stream().anyMatch(bucket-> bucket.contains(message));
    }
}