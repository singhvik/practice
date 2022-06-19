package vikram.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingsRodsTest {


    @Test
    void zeroCountPointsLessThan3rings() {
        RingsRods ringsRods = new RingsRods();
        Assertions.assertEquals(0,ringsRods.countPoints("R1"));
        Assertions.assertEquals(0,ringsRods.countPoints("R1B0"));
    }

    @Test
    void noCountPoints() {
        RingsRods ringsRods = new RingsRods();
        Assertions.assertEquals(0,ringsRods.countPoints("R1B2G3"));
        Assertions.assertEquals(0,ringsRods.countPoints("R1B1G0"));
        Assertions.assertEquals(0,ringsRods.countPoints("R1B1R1B1G2"));
    }
    @Test
    void SingleCountPoint() {
        RingsRods ringsRods = new RingsRods();
        Assertions.assertEquals(1,ringsRods.countPoints("R1B1G2G1"));
        Assertions.assertEquals(1,ringsRods.countPoints("R1B1R1B1G2G1G1"));
    }
    @Test
    void MultipleCountPoint() {
        RingsRods ringsRods = new RingsRods();
        Assertions.assertEquals(1,ringsRods.countPoints("R1B1G2G1"));
        Assertions.assertEquals(2,ringsRods.countPoints("R1R9B1B3G5R7R1B1G2G1G1B7R3B5G7"));
    }

}