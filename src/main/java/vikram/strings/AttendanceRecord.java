package vikram.strings;

/**
 * You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
 *
 * 'A': Absent.
 * 'L': Late.
 * 'P': Present.
 * The student is eligible for an attendance award if they meet both of the following criteria:
 *
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Return true if the student is eligible for an attendance award, or false otherwi
 */
public class AttendanceRecord {
    private final char ABSENT='A';
    private final char LATE='L';
    public boolean checkRecord(String s) {
        int lateCount=0;
        int absentCount=0;
        char prev;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ABSENT) {
                absentCount++;
            }
            if (s.charAt(i) == LATE) {
                lateCount++;
            } else{
                lateCount=0;
            }
            if(absentCount>1 || lateCount>2) {
                return false;
            }
        }
        return true;
    }
}
