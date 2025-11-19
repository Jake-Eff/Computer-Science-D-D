import java.util.ArrayList;

public class RecursionTester {
    public static void main(String[] args) {
        System.out.println("TEST printListInReverse");
        ListNode n3 = new ListNode("C", null);
        ListNode n2 = new ListNode("B", n3);
        ListNode n1 = new ListNode("A", n2);
        Recursion.printListInReverse(n1); // Expect: C B A (in that order)
        System.out.println();

        System.out.println("=== TEST infect ===");
        String[][] grid =
                {{"ok", "ok", "vaccinated"}, {"ok", "ok", "ok"}, {"vaccinated", "ok", "ok"}};
        Recursion.infect(grid, 0, 0);

        for (String[] row : grid) {
            for (String s : row) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("=== TEST countNonConsecutiveSubsets ===");
        System.out.println("n = 4  → " + Recursion.countNonConsecutiveSubsets(4));
        System.out.println("n = 5  → " + Recursion.countNonConsecutiveSubsets(5));
        System.out.println();

        System.out.println("=== TEST countWaysToJumpUpStairs ===");
        System.out.println("n = 1  → " + Recursion.countWaysToJumpUpStairs(1));
        System.out.println("n = 5  → " + Recursion.countWaysToJumpUpStairs(5));
        System.out.println();

        System.out.println("=== TEST subsets ===");
        Recursion.printSubsets("hmu");
        System.out.println();

        System.out.println("=== TEST permutations ===");
        Recursion.printPermutations("hmu");
        System.out.println();

        System.out.println("=== TEST combine ===");
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1); A.add(2); A.add(3);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(4); B.add(5);

        System.out.println("Combined → " + Recursion.combine(A, B));
        System.out.println();

        System.out.println("=== TEST mergeSort ===");
        int[] arr = {10, 3, 7, 2, 8, 1};
        Recursion.mergeSort(arr);
        for (int x : arr) System.out.print(x + " ");
        System.out.println("\n");

        System.out.println("=== TEST quickSort ===");
        int[] arr2 = {9, 4, 8, 1, 6, 3};
        Recursion.quickSort(arr2);
        System.out.println();

        System.out.println("=== TEST solveHanoi ===");
        Recursion.solveHanoi(3);
        System.out.println();

        System.out.println("=== TEST scavHunt ===");
        int[] times = {3, 7, 9};
        int[] points = {10, 15, 10};

        System.out.println("Max reward → " + Recursion.scavHunt(times, points)); // Expect 20
    }
}
