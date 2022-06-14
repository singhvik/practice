package vikram.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceRecordTest {

    Supplier<AttendanceRecord> attendanceRecordSupplier = AttendanceRecord::new;

    @Test
    void no3ConsecutiveLsOrMoreThan1A() {
        String input = "PPLLALLPPPLPPPPPPPPPPPPL";
        Assertions.assertTrue(attendanceRecordSupplier.get().checkRecord(input));
    }

    @Test
    void consecutive3LsJust2A() {
        String input = "PPLLALLAPPPLPPPPLLLPPPPPPPPL";
        Assertions.assertFalse(attendanceRecordSupplier.get().checkRecord(input));
    }

    @Test
    void consecutive3NoA() {
        String input = "PPLLPPPLPPPPLLLPPPPPPPPL";
        Assertions.assertFalse(attendanceRecordSupplier.get().checkRecord(input));
    }

    @Test
    void moreThan2AButNoConsecutive3L() {
        String input = "APPLLPPPLPPPPLLAPPPPPPPPLLA";
        Assertions.assertFalse(attendanceRecordSupplier.get().checkRecord(input));
    }

    @Test
    void moreThan2AAndConsecutive3L() {
        String input = "APPLLLPPPLPPPPLLAPPPPPPPPLLA";
        Assertions.assertFalse(attendanceRecordSupplier.get().checkRecord(input));
    }
    @Test
    void testMoreThan2AbsentsNoL() {
        String input = "PPPPAPPPPPPPPPPPPAPPPPPPAPPP";
        Assertions.assertFalse(attendanceRecordSupplier.get().checkRecord(input));
    }

    @Test
    void testManyLatesButNever3inRow() {
        String input = "PPPPPPPLPPPPPPPLPPPPPPPPPPPLLPLLPLLPLLPPPPLPPL";
        Assertions.assertTrue(attendanceRecordSupplier.get().checkRecord(input));
    }

    @Test
    void testManyLatesButNever3inRowAnd1A() {
        String input = "PPPPPPPLLPPPPPPPPPPLPPPPPPPPLLPLLALLPLLPPPPPPL";
        Assertions.assertTrue(attendanceRecordSupplier.get().checkRecord(input));
    }

    @Test
    void justP() {
        String input = "PPPPPPP";
        Assertions.assertTrue(attendanceRecordSupplier.get().checkRecord(input));
    }
}