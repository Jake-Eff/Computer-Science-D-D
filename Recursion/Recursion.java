import java.util.ArrayList;
import java.lang.StringBuilder;

public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode current = head;
		if (current.getNext() == null) {
			System.out.println(current.getValue());
		} else {
			printListInReverse(current.getNext());
			System.out.println(current.getValue());
		}
	}

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
			return;
		}
		if (grid[r][c] == "vaccinated" || grid[r][c] == "infected") {
			return;
		} else {
			grid[r][c] = "infected";
			infect(grid, r, c + 1);
			infect(grid, r, c - 1);
			infect(grid, r + 1, c);
			infect(grid, r - 1, c);
		}
	}

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	// The other subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// Precondition: n > 0
	// its literally fibonacci bro
	public static long countNonConsecutiveSubsets(int n) {
		if (n == 1 || n == 2) {
			return n + 1;
		} else {
			return countNonConsecutiveSubsets(n - 1) + countNonConsecutiveSubsets(n - 2);
		}
	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		if (n == 1 || n == 2) {
			return n;
		} else if (n == 3) {
			return n + 1;
		} else {
			return countWaysToJumpUpStairs(n - 1) + countWaysToJumpUpStairs(n - 2)
					+ countWaysToJumpUpStairs(n - 3);
		}
	}

	// Everything above this line does NOT require a recursive helper method
	// ----------------------------------
	// Everything below this line requires a recursive helper method
	// Any recursive helper method you write MUST have a comment describing:
	// 1) what the helper method does/returns
	// 2) your description must include role of each parameter in the helper method

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice

	// creatSubsets returns every subset of the original string, which is inputed by the parameter
	// str. It does this recursively, repeating itself until the size of the string it intakes is 1.
	// When this happens, the method will return an array list with a blank element and the string
	// with length 1. For any other case, the method saves the first character of the string as a
	// variable, then will return each subset of the string without this character and with it,
	// ensuring that every subset is returned.

	public static ArrayList<String> createSubsets(String str) {
		if (str.length() == 1) {
			ArrayList<String> end = new ArrayList<String>();
			end.add("");
			end.add(str);
			return end;
		} else {
			String first = str.substring(0, 1);
			ArrayList<String> previous = createSubsets(str.substring(1, str.length()));
			ArrayList<String> returning = new ArrayList<String>();
			for (int i = 0; i < previous.size(); i++) {
				returning.add(first + previous.get(i));
			}
			returning.addAll(previous);
			return returning;
		}
	}

	public static void printSubsets(String str) {
		ArrayList<String> printing = createSubsets(str);
		// StringBuilder thing = new StringBuilder();
		for (int i = 0; i < printing.size(); i++) {
			System.out.println(printing.get(i));
		}
		// for (int i = 0; i < printing.size() - 1; i++) {
		// thing.append("" + printing.get(i) + "");
		// }
		// thing.append("" + printing.get(printing.size() - 1) + "");
		// System.out.println(thing);
	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice

	// This method generates all permutations of a given string using recursion. For strings of
	// length 1 or 2, it directly returns the only possible permutations. For longer strings, it
	// recursively computes all permutations of the substring that excludes the first character.
	// Then, for each of these smaller permutations, it inserts the original first character into
	// every possible position within that permutation building each unique combination. All these
	// smaller arrays are then combined into one larger array and returned.

	public static ArrayList<String> createPerm(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if (str.length() == 1) {
			list.add(str);
			return list;
		} else if (str.length() == 2) {
			list.add(str);
			list.add(str.substring(1, 2) + str.substring(0, 1));
			return list;
		}
		ArrayList<String> perms = createPerm(str.substring(1));
		for (int i = 0; i < perms.size(); i++) {
			for (int j = 0; j <= perms.get(i).length(); j++) {
				String adding = "";
				if (j == 0) {
					adding = str.substring(0, 1) + perms.get(i);
				} else if (j == perms.get(i).length()) {
					adding = perms.get(i) + str.substring(0, 1);
				} else {
					adding = perms.get(i).substring(0, j) + str.substring(0, 1)
							+ perms.get(i).substring(j, perms.get(i).length());
				}
				list.add(adding);
			}

		}
		return list;
	}

	public static void printPermutations(String str) {
		ArrayList<String> printing = createPerm(str);
		// StringBuilder thing = new StringBuilder();
		for (int i = 0; i < printing.size(); i++) {
			System.out.println(printing.get(i));
		}
		// for (int i = 0; i < printing.size() - 1; i++) {
		// thing.append("" + printing.get(i) + "");
		// }
		// thing.append("" + printing.get(printing.size() - 1) + "");
		// System.out.println(thing);
	}


	// Combine takes two array lists and combines them into one. Then it copies the items from the
	// original lists into the new larger list. It makes sure that the items from the first list are
	// in the same order when copied over, and does the same for the second list. The second list is
	// placed after the first list.

	public static ArrayList<Integer> combine(ArrayList<Integer> first, ArrayList<Integer> second) {
		ArrayList<Integer> combined = new ArrayList<Integer>(first.size() + second.size());

		int firstIndex = 0;
		int secondIndex = 0;

		while (firstIndex < first.size() && secondIndex < second.size()) {
			if (first.get(firstIndex) < second.get(secondIndex)) {
				combined.add(first.get(firstIndex));
				firstIndex++;
			} else {
				combined.add(second.get(secondIndex));
				secondIndex++;
			}
		}

		for (int i = firstIndex; i < first.size(); i++) {
			combined.add(first.get(i));
		}
		for (int i = secondIndex; i < second.size(); i++) {
			combined.add(second.get(i));
		}
		return combined;
	}

	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeSort(int[] ints) {
		if (ints.length == 1 || ints.length == 0) {
			return;
		}
		int[] right;
		if (ints.length % 2 == 1) {
			right = new int[(ints.length / 2 + 1)];
		} else {
			right = new int[ints.length / 2];
		}
		int[] left = new int[ints.length / 2];
		for (int i = 0; i < ints.length; i++) {
			if (i < ints.length / 2) {
				left[i] = ints[i];
			} else {
				right[i - ints.length / 2] = ints[i];
			}
		}
		mergeSort(left);
		mergeSort(right);
		ArrayList<Integer> firstHalf = new ArrayList<Integer>();
		ArrayList<Integer> secondHalf = new ArrayList<Integer>();
		for (int i = 0; i < left.length; i++) {
			firstHalf.add(left[i]);
		}
		for (int i = 0; i < right.length; i++) {
			secondHalf.add(right[i]);
		}
		ArrayList<Integer> finalList = combine(firstHalf, secondHalf);
		for (int i = 0; i < finalList.size(); i++) {
			ints[i] = finalList.get(i);
		}
	}


	// The divide method takes in a pivot index and then divides a list into two smaller list. One
	// list contains all the vlaues that are less than the pivot value, and the other contains all
	// those that are greater. It does this recursively until each list only has one item in it, and
	// then all the original items will be sorted.

	public static int[] divide(int[] ints, int pivot) {
		if (ints.length == 0 || ints.length == 1) {
			return ints;
		}
		int numLess = 0;
		int numGreater = 0;
		for (int i = 0; i < ints.length; i++) {
			if (i != pivot) {
				if (ints[i] > ints[pivot]) {
					numGreater++;
				} else {
					numLess++;
				}
			}
		}

		int[] lessThan = new int[numLess];
		int[] greaterThan = new int[numGreater];
		int lessIndex = 0;
		int greaterIndex = 0;

		for (int i = 0; i < ints.length; i++) {
			if (i != pivot) {
				if (ints[i] > ints[pivot]) {
					greaterThan[greaterIndex] = ints[i];
					greaterIndex++;
				} else {
					lessThan[lessIndex] = ints[i];
					lessIndex++;
				}
			}
		}

		int leftPivot = lessThan.length / 2;
		int rightPivot = greaterThan.length / 2;
		int[] leftSide = divide(lessThan, leftPivot);
		int[] rightSide = divide(greaterThan, rightPivot);
		int[] finalArray = new int[ints.length];
		for (int i = 0; i < finalArray.length; i++) {
			if (i < leftSide.length) {
				finalArray[i] = leftSide[i];
			} else if (i == leftSide.length) {
				finalArray[i] = ints[pivot];
			} else {
				finalArray[i] = rightSide[i - leftSide.length - 1];
			}
		}
		return finalArray;


	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static void quickSort(int[] ints) {
		int[] toPrint = divide(ints, ints.length / 2);
		for (int i = 0; i < ints.length; i++) {
			ints[i] = toPrint[i];
		}
		for (int i = 0; i < toPrint.length; i++) {
			System.out.println(toPrint[i]);
		}

	}

	// solveOnMiddle helps to solve the tower of hanoi. It moves the top disk of the starting post
	// to the free post, then moves the remaining disks on starting post to the end post, then moves
	// the disks from the free post to the end post. This follows the rules of the tower of hanoi
	// game and solves the puzzle in the optimal amount of moves.


	public static void solveOnMiddle(int startingDisks, int start, int end, int free) {
		if (startingDisks == 1) {
			System.out.println("" + start + " -> " + end + "");
			return;
		} else if (startingDisks == 2) {
			System.out.println("" + start + " -> " + free + "");
			System.out.println("" + start + " -> " + end + "");
			System.out.println("" + free + " -> " + end + "");
			return;
		} else {
			solveOnMiddle(startingDisks - 1, start, free, end);
			System.out.println("" + start + " -> " + end + "");
			solveOnMiddle(startingDisks - 1, free, end, start);

		}

	}

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void solveHanoi(int startingDisks) {
		solveOnMiddle(startingDisks - 1, 0, 1, 2);
		System.out.println("0 -> 2");
		solveOnMiddle(startingDisks - 1, 1, 2, 0);
	}


	// This method finds the maximum reward possible from the given "scavenger hunt". A tally of the
	// largest amount of points is kept, and this method searches through the arrays of times and
	// points to determine what the max reward is. When it finds a large point value, it looks 4
	// time slots ahead to check if that value is larger. It continues to do this until the largest
	// point value is determined

	public static int maxReward(int[] times, int[] points, int index) {
		if (times.length - index - 1 == 0) {
			return points[index];
		} else if (times.length - index - 1 < 0) {
			return 0;
		} else {
			int newIndex = -1;
			if (times.length - index - 1 > 5) {
				for (int i = 1; i < 6; i++) {
					if (times[i + index] > (times[index] + 4)) {
						newIndex = i + index;
						break;
					}
				}
			} else {
				for (int i = 0; i < times.length - index; i++) {
					if (times[i + index] > (times[index] + 4)) {
						newIndex = i + index;
						break;
					}
				}
			}
			int leftOver = 0;
			if (newIndex == -1) {
				for (int i = index; i < points.length; i++) {
					if (points[i] > leftOver) {
						leftOver = points[i];
					}
				}
				return leftOver;
			}
			int taken = points[index] + maxReward(times, points, newIndex);
			int notTaken = maxReward(times, points, index + 1);
			if (taken > notTaken) {
				return taken;
			} else {
				return notTaken;
			}
		}
	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.
	public static int scavHunt(int[] times, int[] points) {
		return maxReward(times, points, 0);
	}

}
