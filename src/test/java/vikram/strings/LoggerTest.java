package vikram.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class LoggerTest {
    public static final String MESSAGE = "new Message";
    Supplier<Logger> loggerSupplier = Logger::new;

    @Test
    void testShouldPrintDifferentMessageOnSameTimeStamp() {
        Logger logger = loggerSupplier.get();
        Assertions.assertTrue(logger.shouldPrintMessage(1, MESSAGE));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message1"));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message2"));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message3"));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message4"));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message5"));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message6"));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message7"));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message8"));
        Assertions.assertTrue(logger.shouldPrintMessage(1, "new Message9"));
    }

    @Test
    void testShouldNotPrintSameMessageOnSameTimeStamp() {
        Logger logger = loggerSupplier.get();
        Assertions.assertTrue(logger.shouldPrintMessage(1, MESSAGE));
        Assertions.assertFalse(logger.shouldPrintMessage(1, MESSAGE));
    }

    @Test
    void testShouldPrintNotPrintOldMessageWithInLimit() {
        Logger logger = loggerSupplier.get();
        Assertions.assertTrue(logger.shouldPrintMessage(1, MESSAGE));
        Assertions.assertFalse(logger.shouldPrintMessage(2, MESSAGE));
    }

    @Test
    void testShouldPrintNotPrintOldMessageWithInLimitMiddleCase() {
        Logger logger = loggerSupplier.get();
        Assertions.assertTrue(logger.shouldPrintMessage(1, MESSAGE));
        Assertions.assertFalse(logger.shouldPrintMessage(5, MESSAGE));
    }

    @Test
    void testShouldNotPrintNewMessageEdgeCase() {
        Logger logger = loggerSupplier.get();
        Assertions.assertTrue(logger.shouldPrintMessage(1, MESSAGE));
        Assertions.assertFalse(logger.shouldPrintMessage(10, MESSAGE));
    }

    @Test
    void testShouldPrintRepeatMessageAfterLimitExceeds() {
        Logger logger = loggerSupplier.get();
        Assertions.assertTrue(logger.shouldPrintMessage(1, MESSAGE));
        Assertions.assertTrue(logger.shouldPrintMessage(11, MESSAGE));
    }

}