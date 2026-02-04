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
		if (row >= numRows || row < 0 || col >= numCols || col < 0 || cookieGrid[row][col] == -1) {
			return false;
		}
		return true;
	}

	/*
	 * RECURSIVELY calculates the route which grants the most cookies. Returns the maximum number of
	 * cookies attainable.
	 */
	public int recursiveCookies() {
		if (cookieGrid[0][0] == -1) {
			return 0;
		}
		return recursiveCookies(0, 0);
	}

	// Returns the maximum number of cookies edible starting from (and including)
	// cookieGrid[row][col]
	public int recursiveCookies(int row, int col) {

		if (row == numRows - 1 && col == numCols - 1) {
			return cookieGrid[row][col];
		}

		int cookies = cookieGrid[row][col];
		int down = 0;
		int right = 0;

		if (validPoint(row + 1, col)) {
			right = recursiveCookies(row + 1, col);
		}

		if (validPoint(row, col + 1)) {
			down = recursiveCookies(row, col + 1);
		}

		if (right >= down) {
			return cookies + right;
		} else {
			return cookies + down;
		}
		// int rightVal = -1;
		// int downVal = -1;
		// if (row == numRows - 1 && col == numCols - 1) {
		// return cookieGrid[row][col];
		// }
		// if (row + 1 < numRows && validPoint(row + 1, col)) {
		// rightVal = recursiveCookies(row + 1, col);
		// }
		// if (col + 1 < numCols && validPoint(row, col + 1)) {
		// downVal = recursiveCookies(row, col + 1);
		// }
		// if (rightVal != -1 && downVal != -1) {
		// if (rightVal > downVal) {
		// return rightVal + cookieGrid[row][col];
		// } else {
		// return downVal + cookieGrid[row][col];
		// }
		// } else if (rightVal == -1) {
		// return downVal + cookieGrid[row][col];
		// } else if (downVal == -1) {
		// return rightVal + cookieGrid[row][col];
		// } else {
		// return -1;
		// }
	}


	/*
	 * Calculate which route grants the most cookies using a QUEUE. Returns the maximum number of
	 * cookies attainable.
	 */
	/* From any given position, always add the path right before adding the path down */
	public int queueCookies() {
		if (cookieGrid[0][0] == -1) {
			return 0;
		}

		ArrayDeque<OrphanScout> newQueue = new ArrayDeque<OrphanScout>();
		int row = 0;
		int col = 0;
		OrphanScout bebe1 = new OrphanScout(row, col, cookieGrid[0][0]);
		int max = cookieGrid[0][0];
		newQueue.add(bebe1);

		while (!newQueue.isEmpty()) {
			OrphanScout current = newQueue.poll();
			row = current.getEndingRow();
			col = current.getEndingCol();
			int cookies = current.getCookiesDiscovered();

			if (validPoint(row + 1, col)) {
				OrphanScout rightKid =
						new OrphanScout(row + 1, col, cookies + cookieGrid[row + 1][col]);
				if (!(rightKid.getCookiesDiscovered() < cookies)) {
					if (rightKid.getCookiesDiscovered() > max) {
						max = rightKid.getCookiesDiscovered();
					}
				}
				newQueue.add(rightKid);
			}

			if (validPoint(row, col + 1)) {
				OrphanScout downKid =
						new OrphanScout(row, col + 1, cookies + cookieGrid[row][col + 1]);
				if (!(downKid.getCookiesDiscovered() < cookies)) {
					if (downKid.getCookiesDiscovered() > max) {
						max = downKid.getCookiesDiscovered();
					}
				}
				newQueue.add(downKid);
			}
		}

		return max;
		// ArrayDeque<OrphanScout> newQueue = new ArrayDeque<OrphanScout>();
		// int row = 0;
		// int col = 0;
		// OrphanScout bebe1 = new OrphanScout(row, col, cookieGrid[0][0]);
		// newQueue.add(bebe1);
		// int newCount = 0;
		// while (!(newQueue.peek().getEndingRow() == numRows - 1
		// && newQueue.peek().getEndingCol() == numCols - 1)) {
		// row = newQueue.peek().getEndingRow();
		// col = newQueue.peek().getEndingCol();
		// if (validPoint(row + 1, col)) {
		// newCount = newQueue.peek().getCookiesDiscovered() + cookieGrid[row + 1][col];
		// newQueue.add(new OrphanScout(row + 1, col, newCount));
		// }
		// if (validPoint(row, col + 1)) {
		// newCount = newQueue.peek().getCookiesDiscovered() + cookieGrid[row][col + 1];
		// newQueue.add(new OrphanScout(row, col + 1, newCount));
		// }
		// newQueue.remove();
		// }
		// int cookies = 0;
		// while (newQueue.peek() != null) {
		// int current = newQueue.remove().getCookiesDiscovered();
		// if (current > cookies) {
		// cookies = current;
		// }
		// }
		// return cookies;
	}


	/*
	 * Calculate which route grants the most cookies using a stack. Returns the maximum number of
	 * cookies attainable.
	 */
	/* From any given position, always add the path right before adding the path down */
	public int stackCookies() {
		if (cookieGrid[0][0] == -1) {
			return 0;
		}

		Stack<OrphanScout> newStack = new Stack<OrphanScout>();
		int row = 0;
		int col = 0;
		OrphanScout bebe1 = new OrphanScout(row, col, cookieGrid[0][0]);
		int max = cookieGrid[0][0];
		newStack.push(bebe1);

		while (!newStack.isEmpty()) {
			OrphanScout current = newStack.pop();
			row = current.getEndingRow();
			col = current.getEndingCol();
			int cookies = current.getCookiesDiscovered();

			if (validPoint(row + 1, col)) {
				OrphanScout rightKid =
						new OrphanScout(row + 1, col, cookies + cookieGrid[row + 1][col]);
				if (!(rightKid.getCookiesDiscovered() < cookies)) {
					if (rightKid.getCookiesDiscovered() > max) {
						max = rightKid.getCookiesDiscovered();
					}
				}
				newStack.push(rightKid);
			}

			if (validPoint(row, col + 1)) {
				OrphanScout downKid =
						new OrphanScout(row, col + 1, cookies + cookieGrid[row][col + 1]);
				if (!(downKid.getCookiesDiscovered() < cookies)) {
					if (downKid.getCookiesDiscovered() > max) {
						max = downKid.getCookiesDiscovered();
					}
				}
				newStack.push(downKid);
			}

		}

		return max;

		// Stack<OrphanScout> newStack = new Stack<OrphanScout>();
		// int row = 0;
		// int col = 0;
		// int maxCookies = 0;
		// OrphanScout bebe1 = new OrphanScout(row, col, cookieGrid[0][0]);
		// int rightCount = 0;
		// int leftCount = 0;
		// newStack.push(bebe1);
		// while (!(newStack.isEmpty())) {
		// OrphanScout current = newStack.pop();
		// row = current.getEndingRow();
		// col = current.getEndingCol();
		// if (row == numRows - 1 && col == numCols - 1) {
		// if (current.getCookiesDiscovered() > maxCookies) {
		// maxCookies = current.getCookiesDiscovered();
		// }
		// }
		// OrphanScout rightKid = new OrphanScout(0, 0, 0);
		// OrphanScout downKid = new OrphanScout(0, 0, 0);
		// if (validPoint(row + 1, col)) {
		// rightCount = current.getCookiesDiscovered() + cookieGrid[row + 1][col];
		// rightKid = new OrphanScout(row + 1, col, rightCount);
		// }
		// if (validPoint(row, col + 1)) {
		// leftCount = current.getCookiesDiscovered() + cookieGrid[row][col + 1];
		// downKid = new OrphanScout(row, col + 1, leftCount);
		// }
		// if (validPoint(row, col + 1)) {
		// newStack.push(downKid);
		// }
		// if (validPoint(row + 1, col)) {
		// newStack.push(rightKid);
		// }
		// }
		// return maxCookies;
		// }
	}
}
