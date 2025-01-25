import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GameBoardClassTest {
    @Test
        public void testInitialGameBoard(){
            // create a new gameboard
            GameBoard gameBoard = new GameBoard();

            // retrieve the grid
            String[][] grid = gameBoard.getGrid();

            // verify the grid size
            assertEquals(4, grid.length, "Grid should have 4 rows");
            for (int row = 0; row < grid.length; row++) {
                assertEquals(4, grid[row].length, "Each row should have 4 columns");
            }
            // verify all cells are initialized to correct numbers
            int expectedNumber = 1;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    assertEquals(String.valueOf(expectedNumber), grid[row][col],
                        "Cell should be initialized to sequential numbers starting from 1");
                expectedNumber++;
                }
            }
        }

    @Test
    public void testPolulateGrid(){
        // create a LettersPool and GameBoard
        LettersPool lettersPool = new LettersPool();
        GameBoard gameBoard = new GameBoard();

        // populate the grid with diagonal 'A's
        gameBoard.populateGrid(lettersPool.getLetter("A"), 1);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 6);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 11);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 16);

        // retrieve the grid and verify
        String[][] grid = gameBoard.getGrid();


        // verify the diagonal is filled with 'A'
        for (int i = 0; i < 4; i++) {
            assertEquals("A", grid[i][i], 
            "Diagonal cell [" + i + "][" + i + "] should be 'A'");
        }

            // Check the filled positions list
        List<Integer> filledPositions = gameBoard.getFilledPositions();
        List<Integer> expectedPositions = List.of(1, 6, 11, 16); // Expected positions

        assertEquals(expectedPositions.size(), filledPositions.size(),
            "The filled positions list should contain the correct number of entries.");
        assertTrue(filledPositions.containsAll(expectedPositions),
            "The filled positions list should match the expected positions.");

        String[] remainingLetters = lettersPool.getShuffledLetters();
        int countA = 0;

        for (String letter : remainingLetters) {
            if (letter == "A") {
                countA++;
            }
        }

        // there should be 2 'A's left in the pool (initially 6, 4 are removed so 2 left)
        assertEquals(2, countA, 
        "The pool should contain 2 remaining 'A's after populating the grid.");
    }
}
