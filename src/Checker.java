    public class Checker {
        private static final String TARGET = "RAT";
        private static final String REVERSE_TARGET = "TAR";

        // method to check if "RAT" is found anywhere
        public boolean hasRat(String[][] grid) {
            int gridSize = grid.length;

            for (int row = 0; row < gridSize; row++) {
                if (checkRow(grid, row)) {
                    return true;
                }
            }

            for (int col = 0; col < gridSize; col++) {
                if (checkCol(grid, col)) {
                    return true;
                }
            }

            if (checkMainDiagonal(grid) || checkAntiDiagonal(grid)) {
                return true;
            }

            return false;
        }
        

        private boolean checkRow(String[][] grid, int row) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < grid[row].length; col++) {
                sb.append(grid[row][col]);
            }
            if (sb.toString().contains(TARGET) || sb.toString().contains(REVERSE_TARGET)) {;
                return true;
            } else {
                return false;
            }
        }

        private boolean checkCol(String[][] grid, int col) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < grid.length; row++) {
                sb.append(grid[row][col]);
            }
            if (sb.toString().contains(TARGET) || sb.toString().contains(REVERSE_TARGET)) {;
                return true;
            } else {
                return false;
            }
        }

        private boolean checkMainDiagonal(String[][] grid) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][i]);
            }
            if (sb.toString().contains(TARGET) || sb.toString().contains(REVERSE_TARGET)) {;
                return true;
            } else {
                return false;
            }
        }

        private boolean checkAntiDiagonal(String[][] grid) {
            StringBuilder sb = new StringBuilder();
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][n - 1 - i]);
            }
            if (sb.toString().contains(TARGET) || sb.toString().contains(REVERSE_TARGET)) {;
                return true;
            } else {
                return false;
            }

        }
    }
