import java.util.Scanner;


public class DontFindTheRat {
    
    public static void main(String[] args) {

        // initialize the LettersPool and GameBoard
        LettersPool lettersPool = new LettersPool();
        GameBoard gameBoard = new GameBoard();
        Checker checker = new Checker();

        // populate the grid with "A"s
        gameBoard.populateGrid(lettersPool.getLetter("A"), 1);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 6);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 11);
        gameBoard.populateGrid(lettersPool.getLetter("A"), 16);

        System.out.println("Welcome to Don't Find the Rat!");
        System.out.println("Here is the game board:");
        gameBoard.displayGrid();
        lettersPool.displayLetterPool();
        System.out.println("Type a number (1-16) to place a letter from the letter pool (or type 0 to exit):");

        // create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Check if "RAT" exists on the board
            if (checker.hasRat(gameBoard.getGrid())) {
                System.out.println("RAT found on the board! You lose!");
                break; // Exit the loop if the game is lost
            } else if (gameBoard.getFilledPositions().size() == 16) {
                System.out.println("YOU DIDN'T FIND THE RAT! YOU WIN!");
                break; // Exit the loop if the game is won
            }
        
            int position = scanner.nextInt(); // Read the user input
        
            if (position == 0) {
                System.out.println("Exiting the game. Goodbye!");
                break; // Exit the loop if the player chooses to quit
            }
        
            // validate the position
            if (position < 1 || position > 16) {
                System.out.println("Invalid position! Please enter a number between 1 and 16.");
                continue; // Prompt the user again
            }
        
            try {
                // try to place the letter on the grid
                gameBoard.populateGrid(lettersPool.getRandomLetter(), position);
                System.out.println("Updated game board:");
                gameBoard.displayGrid();
                lettersPool.displayLetterPool();
            } catch (IllegalArgumentException e) {
                // Handle invalid letters or placements
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close(); // close the scanner after the loop
    }
}