import java.io.*;
import java.util.*;

// You are allowed (and expected!) to use either Java's ArrayDeque or LinkedList class to make
// stacks and queues


public class CookieMonster {

	private int[][] cookieGrid;
	private int numRows;
	private int numCols;

	// Constructs a CookieMonster from a file with format:
	// numRows numCols
	// <<rest of the grid, with spaces in between the numbers>>
	public CookieMonster(String fileName) {
		int row = 0;
		int col = 0;
		try {
			Scanner input = new Scanner(new File(fileName));

			numRows = input.nextInt();
			numCols = input.nextInt();
			cookieGrid = new int[numRows][numCols];

			for (row = 0; row < numRows; row++)
				for (col = 0; col < numCols; col++)
					cookieGrid[row][col] = input.nextInt();

			input.close();
		} catch (Exception e) {
			System.out.print("Error creating maze: " + e.toString());
			System.out.println("Error occurred at row: " + row + ", col: " + col);
		}

	}

	public CookieMonster(int[][] cookieGrid) {
		this.cookieGrid = cookieGrid;
		this.numRows = cookieGrid.length;
		this.numCols = cookieGrid[0].length;
	}

	// You may find it VERY helpful to write this helper method. Or not!
	private boolean validPoint(int row, int col) {
		if (cookieGrid[row][col] == -1) {
			return false;
		}
		return true;
	}

	/*
	 * RECURSIVELY calculates the route which grants the most cookies. Returns the maximum number of
	 * cookies attainable.
	 */
	public int recursiveCookies() {
		return recursiveCookies(0, 0);
	}

	// Returns the maximum number of cookies edible starting from (and including)
	// cookieGrid[row][col]
	public int recursiveCookies(int row, int col) {
		int rightVal = -1;
		int downVal = -1;
		if (row == numRows - 1 && col == numCols - 1) {
			return cookieGrid[row][col];
		}
		if (row + 1 < numRows && validPoint(row + 1, col)) {
			rightVal = recursiveCookies(row + 1, col);
		}
		if (col + 1 < numCols && validPoint(row, col + 1)) {
			downVal = recursiveCookies(row, col + 1);
		}
		if (rightVal != -1 && downVal != -1) {
			if (rightVal > downVal) {
				return rightVal + cookieGrid[row][col];
			} else {
				return downVal + cookieGrid[row][col];
			}
		} else if (rightVal == -1) {
			return downVal + cookieGrid[row][col];
		} else if (downVal == -1) {
			return rightVal + cookieGrid[row][col];
		} else {
			return -1;
		}
	}


	/*
	 * Calculate which route grants the most cookies using a QUEUE. Returns the maximum number of
	 * cookies attainable.
	 */
	/* From any given position, always add the path right before adding the path down */
	public int queueCookies() {
		ArrayDeque<OrphanScout> newQueue = new ArrayDeque<OrphanScout>();
		return 0;
	}


	/*
	 * Calculate which route grants the most cookies using a stack. Returns the maximum number of
	 * cookies attainable.
	 */
	/* From any given position, always add the path right before adding the path down */
	public int stackCookies() {
		// CODE THIS
		return 0;
	}

}
