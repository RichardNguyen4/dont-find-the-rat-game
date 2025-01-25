import java.util.Scanner;


public class DontFindTheRat {
    
    public static void main(String[] args) {

        // initialize the LettersPool and GameBoard
        LettersPool lettersPool = new LettersPool();
        GameBoard gameBoard = new GameBoard();

        // populate the grid with "A"s
        gameBoard.populateGrid(lettersPool.getLetter("A"), 1);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 6);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 11);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 16);

        System.out.println("Welcome to Don't Find the Rat!");
        System.out.println("Here is the game board:");
        gameBoard.displayGrid();
        lettersPool.displayLetterPool();

        // create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Type a number (1-16) to place a letter from the letter pool (or type 0 to exit):");
            int position = scanner.nextInt(); // Read the user input

            if (position == 0) {
                System.out.println("Exiting the game. Goodbye!");
                break;
            }
            // Validate the position
            if (position < 1 || position > 16) {
                System.out.println("Invalid position! Please enter a number between 1 and 16.");
                continue;
            }

            try {
                // Try to place the letter on the grid
                gameBoard.populateGrid(lettersPool.getRandomLetter(), position);
                System.out.println("Updated game board:");
                gameBoard.displayGrid();
            } catch (IllegalArgumentException e) {
                // Handle invalid letters or placements
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

}