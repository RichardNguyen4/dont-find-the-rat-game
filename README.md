# Don't Find the Rat
** Don't Find the Rat is a fun and strategic tile-placement game built in Java. 
Inspired by Alex Cheddar's "Don't Find the Fox," this game challenges players to avoid forming a specific pattern on a 4x4 grid. 
It's a simple yet engaging way to test your logic and planning skills.

Why I Made This Game
I created "Don't Find the Rat" as a personal project to:

Improve My Java Skills:
 - Practice object-oriented programming, data structures, and problem-solving in Java.
Learn Game Development:
- Design a simple game from scratch to understand game mechanics and logic.
Have Fun While Learning:
- Combine creativity with coding by building something interactive and engaging.

## How the Game Works

### Game Setup:
- The game board is a 4x4 grid.
- The main diagonal (from top-left to bottom-right) is pre-filled with the letter 'A'.
- A randomized set of tiles, consisting of:
- 5 'R's,
- 5 'T's,
- 2 additional 'A's, is shuffled and placed on the remaining grid cells.

### The Objective:
-The goal is not to spell "RAT" anywhere on the board:
-Horizontally (across rows),
-Vertically (down columns),
-Diagonally (on either diagonal).

### Game Logic:
- Tiles are drawn randomly from the pool.
- Players take turns selecting a position (1–16) to place a tile on the grid.
- After each move:
  - The grid is updated and displayed.
  - The game checks for any occurrence of "RAT."
- **You Lose:** If "RAT" is found anywhere on the board.
- **You Win:** If all positions are filled without "RAT" appearing.

---

## How to Play

### Prerequisites
Before running the game, ensure you have:
- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) installed.
- A terminal or IDE capable of running Java applications.

### Running the Game
1. Clone or download the project files.
2. Navigate to the project directory.
3. Compile the game with:
   ```bash
   javac DontFindTheRat.java


