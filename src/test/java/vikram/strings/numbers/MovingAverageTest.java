package vikram.strings.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingAverageTest {

    @Test
    void getAverageFirstNumber() {
        MovingAverage movingAverage = new MovingAverage(3);
        Assertions.assertEquals(1d, movingAverage.next(1));
    }

    @Test
    void getAverageStreamIsSize() {
        MovingAverage movingAverage = new MovingAverage(3);
        Assertions.assertEquals(1d, movingAverage.next(1));
        Assertions.assertEquals((1d + 11) / 2, movingAverage.next(11));
        Assertions.assertEquals((1d + 11 + 59) / 3, movingAverage.next(59));
    }

    @Test
    void getAverageOneNumberOverSize() {
        MovingAverage movingAverage = new MovingAverage(3);
        Assertions.assertEquals(1d, movingAverage.next(1));
        Assertions.assertEquals((1d + 11) / 2, movingAverage.next(11));
        Assertions.assertEquals((1d + 11 + 59) / 3, movingAverage.next(59));
        Assertions.assertEquals((11d + 59 + 2) / 3, movingAverage.next(2));
    }

    @Test
    void getAverageOneNumberOverSizeSameNumberOutAndIn() {
        MovingAverage movingAverage = new MovingAverage(3);
        Assertions.assertEquals(1d, movingAverage.next(1));
        Assertions.assertEquals((1d + 11) / 2, movingAverage.next(11));
        Assertions.assertEquals((1d + 11 + 59) / 3, movingAverage.next(59));
        Assertions.assertEquals((11d + 59 + 1) / 3, movingAverage.next(1));
    }

    @Test
    void getAverageDoubleTheSizeSteam() {
        MovingAverage movingAverage = new MovingAverage(3);
        Assertions.assertEquals(1d, movingAverage.next(1));
        Assertions.assertEquals((1d + 11) / 2, movingAverage.next(11));
        Assertions.assertEquals((1d + 11 + 59) / 3, movingAverage.next(59));
        Assertions.assertEquals((11d + 59 + 2) / 3, movingAverage.next(2));
        Assertions.assertEquals((59d + 2 + 105) / 3, movingAverage.next(105));
        Assertions.assertEquals((2d + 105 + 99) / 3, movingAverage.next(99));
    }

    @Test
    void getAverageAllNegatives() {
        MovingAverage movingAverage = new MovingAverage(3);
        Assertions.assertEquals(-1d, movingAverage.next(-1));
        Assertions.assertEquals((-1d + -11) / 2, movingAverage.next(-11));
        Assertions.assertEquals((-1d + -11 + -59) / 3, movingAverage.next(-59));
        Assertions.assertEquals((-11d + -59 + -2) / 3, movingAverage.next(-2));
    }

    @Test
    void getAverageMixedSigned() {
        MovingAverage movingAverage = new MovingAverage(3);
        Assertions.assertEquals(-1d, movingAverage.next(-1));
        Assertions.assertEquals((-1d + 11) / 2, movingAverage.next(11));
        Assertions.assertEquals((-1d + 11 + -59) / 3, movingAverage.next(-59));
        Assertions.assertEquals((11d + -59 + 2) / 3, movingAverage.next(2));
        Assertions.assertEquals((-59d + 2 + -100) / 3, movingAverage.next(-100));
    }
}