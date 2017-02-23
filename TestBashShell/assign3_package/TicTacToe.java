/* Brian Young, 8026098, brianjyoung@umail.ucsb.edu */
package ProgAssignment3;
public class TicTacToe {
	public enum Cell {
		X, O, EMPTY
	}
	
	private Cell[][] grid;
	
	public TicTacToe() {
		grid = new Cell[5][5];
		for (int y=0; y<5; y++)
			for (int x=0; x<5; x++)
				grid[y][x] = Cell.EMPTY;
	}
	
	public boolean setCell(int xPos, int yPos, Cell mark) {
		if (xPos < 0 || xPos > 4 || yPos < 0 || yPos > 4) return false;
		if (mark == Cell.EMPTY || grid[yPos][xPos] != Cell.EMPTY) return false;
		grid[yPos][xPos] = mark;
		return true;
	}
	
	public Cell getCell(int xPos, int yPos) {
		if (xPos < 0 || xPos > 4 || yPos < 0 || yPos > 4) return null;
		return grid[yPos][xPos];
	}
	
	public Cell[][] getCell() {
		return grid;
	}
	
	public boolean isEmpty(int xPos, int yPos) {
		// returns true if cell is out of bounds
		//  i.e. "out of bounds" is treated as "empty"
		if (xPos < 0 || xPos > 4 || yPos < 0 || yPos > 4) return true;
		return (grid[yPos][xPos] == Cell.EMPTY);
	}
	
	public void clearBoard() {
		for (int y=0; y<5; y++)
			for (int x=0; x<5; x++)
				grid[y][x] = Cell.EMPTY;
	}
	
	public int[] moveByRandom() {
		// check if board is full
		for (int y=0; y<5; y++)
			for (int x=0; x<5; x++) {
				if (grid[y][x] == Cell.EMPTY) {
					y = 5;
					break;
				}
				if (x == 4 && y == 4) return null;
			}
		// find random empty position
		int[] pos = new int[2];
		java.util.Random rand = new java.util.Random();
		do {
			pos[0] = rand.nextInt(5);
			pos[1] = rand.nextInt(5);
		} while (grid[pos[1]][pos[0]] != Cell.EMPTY);
		return pos;
	}
	
	public boolean gameEnd() {
		// check rows
		for (int y=0; y<5; y++)
			if (grid[y][0] != Cell.EMPTY)
				for (int x=1; x<5; x++) {
					if (grid[y][0] != grid[y][x]) break;
					if (x == 4) return true;
				}
		// check columns
		for (int x=0; x<5; x++)
			if (grid[0][x] != Cell.EMPTY)
				for (int y=1; y<5; y++) {
					if (grid[0][x] != grid[y][x]) break;
					if (y == 4) return true;
				}
		// check diagonals
		if (grid[2][2] != Cell.EMPTY) {
			for (int i=0; i<5; i++) {
				if (grid[i][i] != grid[2][2]) break;
				if (i == 4) return true;
			}
			for (int i=0; i<5; i++) {
				if (grid[i][4-i] != grid[2][2]) break;
				if (i == 4) return true;
			}
		}
		// check for empty spaces
		for (int y=0; y<5; y++)
			for (int x=0; x<5; x++)
				if (grid[y][x] == Cell.EMPTY) return false;
		return true;
	}
	
	public int scoreOfRandom() {
		// return value is gibberish if 5-in-a-row and board is full
		// check for empty spaces
		for (int y=0; y<5; y++)
			for (int x=0; x<5; x++)
				if (grid[y][x] == Cell.EMPTY) return 0;
		
		// count X's
		int threes = 0;
		int fours = 0;
		// check rows
		for (int y=0; y<5; y++) {
			for (int x=1; x<4; x++) {
				if (grid[y][x] == Cell.X && grid[y][x-1] == Cell.X && grid[y][x+1] == Cell.X) {
					if (x > 1 && grid[y][x-2] == Cell.X) fours++;
					else if (x < 3 && grid[y][x+2] == Cell.X) fours++;
					else threes++;
					break;
				}
			}
		}
		// check columns
		for (int x=0; x<5; x++) {
			for (int y=1; y<4; y++) {
				if (grid[y][x] == Cell.X && grid[y-1][x] == Cell.X && grid[y+1][x] == Cell.X) {
					if (y > 1 && grid[y-2][x] == Cell.X) fours++;
					else if (y < 3 && grid[y+2][x] == Cell.X) fours++;
					else threes++;
					break;
				}
			}
		}
		return (fours*3) + threes;
	}
	
	public int scoreOfHuman() {
		// return value is gibberish if 5-in-a-row and board is full
		// check for empty spaces
		for (int y=0; y<5; y++)
			for (int x=0; x<5; x++)
				if (grid[y][x] == Cell.EMPTY) return 0;
		
		// count O's
		int threes = 0;
		int fours = 0;
		// check rows
		for (int y=0; y<5; y++) {
			for (int x=1; x<4; x++) {
				if (grid[y][x] == Cell.O && grid[y][x-1] == Cell.O && grid[y][x+1] == Cell.O) {
					if (x > 1 && grid[y][x-2] == Cell.O) fours++;
					else if (x < 3 && grid[y][x+2] == Cell.O) fours++;
					else threes++;
					break;
				}
			}
		}
		// check columns
		for (int x=0; x<5; x++) {
			for (int y=1; y<4; y++) {
				if (grid[y][x] == Cell.O && grid[y-1][x] == Cell.O && grid[y+1][x] == Cell.O) {
					if (y > 1 && grid[y-2][x] == Cell.O) fours++;
					else if (y < 3 && grid[y+2][x] == Cell.O) fours++;
					else threes++;
					break;
				}
			}
		}
		return (fours*3) + threes;
	}
	
	public void showBoard() {
		for (int y=0; y<5; y++) {
			for (int x=0; x<4; x++)
				System.out.printf( "%s ", cellChar(x,y) );
			System.out.println( cellChar(4,y) );
		}
	}
	
	private char cellChar(int xPos, int yPos) {
		// returns the character corresponding to cell value
		// because method is private, no sanity check on parameters
		switch (grid[yPos][xPos]) {
			case X: return 'X';
			case O: return 'O';
			default: return '-';
		}
	}
}