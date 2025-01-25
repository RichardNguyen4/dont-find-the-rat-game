import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckerClassTest {

    @Test
    public void testRowDetection() {
        Checker checker = new Checker();

        // Test grid where "RAT" appears in the first row
        String[][] grid = {
            {"R", "A", "T", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        assertTrue(checker.hasRat(grid), "Checker should detect 'RAT' in the first row.");
    }

    @Test
    public void testColumnDetection() {
        Checker checker = new Checker();

        // Test grid where "RAT" appears in the first column
        String[][] grid = {
            {"R", "2", "3", "4"},
            {"A", "6", "7", "8"},
            {"T", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        assertTrue(checker.hasRat(grid), "Checker should detect 'RAT' in the first column.");
    }

    @Test
    public void testMainDiagonalDetection() {
        Checker checker = new Checker();

        // Test grid where "RAT" appears on the main diagonal
        String[][] grid = {
            {"R", "2", "3", "4"},
            {"5", "A", "7", "8"},
            {"9", "10", "T", "12"},
            {"13", "14", "15", "16"}
        };

        assertTrue(checker.hasRat(grid), "Checker should detect 'RAT' on the main diagonal.");
    }

    @Test
    public void testAntiDiagonalDetection() {
        Checker checker = new Checker();

        // Test grid where "RAT" appears on the anti-diagonal
        String[][] grid = {
            {"1", "2", "3", "R"},
            {"5", "6", "A", "8"},
            {"9", "T", "11", "12"},
            {"13", "14", "15", "16"}
        };

        assertTrue(checker.hasRat(grid), "Checker should detect 'RAT' on the anti-diagonal.");
    }

    @Test
    public void testReverseDetection() {
        Checker checker = new Checker();

        // Test grid where "TAR" appears in the first row
        String[][] grid = {
            {"T", "A", "R", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        assertTrue(checker.hasRat(grid), "Checker should detect 'TAR' in the first row.");
    }

    @Test
    public void testNoDetection() {
        Checker checker = new Checker();

        // Test grid with no "RAT" or "TAR"
        String[][] grid = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        assertFalse(checker.hasRat(grid), "Checker should not detect 'RAT' or 'TAR' when they are not present.");
    }
}
