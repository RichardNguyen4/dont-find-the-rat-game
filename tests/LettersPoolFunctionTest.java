import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class LettersPoolFunctionTest {
    @Test
    public void testInitialPoolSize(){
        LettersPool lettersPool = new LettersPool();
        assertEquals(16, lettersPool.getShuffledLetters().length, "Initial letter pool size should be 16");

    }
       
    @Test
    public void testRandomLetterRemoval() {
        LettersPool lettersPool = new LettersPool();
        System.out.println("Randomly removing letters");

        // Remove 4 Charaters 
        for (int i = 0; i < 4; i++){
            char removedLetter = lettersPool.getRandomLetter();
            System.out.println("Removed: " + removedLetter);
            assertTrue(removedLetter == 'R' || removedLetter == 'A' || removedLetter == 'T', 
            "Removed letter should be R, A, or T");

        }

        char[] remainingLetters = lettersPool.getShuffledLetters();
        // Check the remaining
        assertEquals(12, remainingLetters.length, "Pool size after removing 4 letters should be 12");
        
    }

    @Test
    public void testRemainLettersCounts() {
        LettersPool lettersPool = new LettersPool();

        for (int i = 0; i < 4; i++) {
            lettersPool.getRandomLetter();
    }

    char[] remainingLetters = lettersPool.getShuffledLetters();
        int countR = 0, countA = 0, countT = 0;

        // Count remaining letters
        for (char letter : remainingLetters) {
            if (letter == 'R') {
                countR++;
            } else if (letter == 'A') {
                countA++;
            } else if (letter == 'T') {
                countT++;
            }
        } 

        // Assert total counts
        int totalRemaining = countR + countA + countT;
        assertEquals(12, totalRemaining, "Total remaining letters should be 12 after 4 removals");

        // Optionally verify the individual counts (if required)
        assertTrue(countR <= 5, "Remaining R count should not exceed 5");
        assertTrue(countA <= 6, "Remaining A count should not exceed 6");
        assertTrue(countT <= 5, "Remaining T count should not exceed 5");
    }
}
