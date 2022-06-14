package vikram.strings.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {
    private HappyNumber happyNumber = new HappyNumber();
    @Test
    void checksForHappyNumberSuccess() {
        Assertions.assertTrue(happyNumber.isHappy(82));
    }
    @Test
    void checksForHappyNumberFailure() {
        Assertions.assertFalse(happyNumber.isHappy(3));
    }
    @Test
    void checkForALargeNumber() {
        Assertions.assertFalse(happyNumber.isHappy(1234534));
    }

}