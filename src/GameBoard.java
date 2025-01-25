import java.util.ArrayList;
import java.util.List;


public class GameBoard {
    private static final int GRID_SIZE = 4;
    private String [][] grid;
    private List<Integer> filledPositions;

    public GameBoard() {
        grid = new String[GRID_SIZE][GRID_SIZE];
        filledPositions = new ArrayList<>();
        initializeGrid();
    }

    public String [][] getGrid() {
        return grid;
    }

    public List<Integer> getFilledPositions() {
        return filledPositions;
    }

    private void initializeGrid(){
        int number = 1;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                    grid[row][col] = String.valueOf(number);
                    number++;
                }
            }
        }

    public void displayGrid(){
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(String.format("%-4s", grid[row][col]));
            }
            System.out.println();
        }
    }

    public void populateGrid(String letter, int position){
        if (position < 0 || position > 16) {
            throw new IllegalArgumentException("Position out of bounds for grid size.");
        }
        
        int row = (position - 1) / GRID_SIZE;
        int col = (position - 1) % GRID_SIZE;

        grid[row][col] = letter;
        filledPositions.add(position);

    }
}



