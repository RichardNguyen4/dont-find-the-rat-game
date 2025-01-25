import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LettersPoolClassTest {
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
            String removedLetter = lettersPool.getRandomLetter();
            System.out.println("Removed: " + removedLetter);
            assertTrue(removedLetter == "R" || removedLetter == "A" || removedLetter == "T", 
            "Removed letter should be R, A, or T");

        }

        String[] remainingLetters = lettersPool.getShuffledLetters();
        // Check the remaining
        assertEquals(12, remainingLetters.length, "Pool size after removing 4 letters should be 12");
        
    }

    @Test
    public void testRemainLettersCounts() {
        LettersPool lettersPool = new LettersPool();

        for (int i = 0; i < 4; i++) {
            lettersPool.getRandomLetter();
    }

    String[] remainingLetters = lettersPool.getShuffledLetters();
        int countR = 0, countA = 0, countT = 0;

        // Count remaining letters
        for (String letter : remainingLetters) {
            if (letter == "R") {
                countR++;
            } else if (letter == "A") {
                countA++;
            } else if (letter == "T") {
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

    @Test
    public void testDisplayLettersPool() {
        // create a letters pool instance
        LettersPool pool = new LettersPool();

        // capture the printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // call the display letter pool method
        pool.displayLetterPool();

        System.setOut(System.out);

        // get the captured output as a string
        String output = outContent.toString().trim();

        // check the expected value
        assertTrue(output.contains("R-31.25%"), "Output should contain correct R percentage");
        assertTrue(output.contains("A-37.50%"), "Output should contain correct A percentage");
        assertTrue(output.contains("T-31.25%"), "Output should contain correct T percentage");

        // check overall formatting
        assertTrue(output.startsWith("Letter Pool: "), "Output should start with 'Letter Pool: '");
        assertTrue(output.endsWith("T-31.25%"), "Output should end with the last letter's percentage");


    }

}
