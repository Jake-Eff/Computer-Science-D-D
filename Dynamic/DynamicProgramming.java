import java.util.HashMap;

public class DynamicProgramming {

    // Every day for the rest of the year, you're going to be given a choice between two jobs to do:
    // one that is LOW stress, and one that is HIGH stress. Each job pays out a dollar amount;
    // *usually* the high stress jobs pay more. However, after doing a high stress job, you need to
    // REST for a day.

    // Given a list of all the payouts for all the low stress and high stress jobs,
    // what is the most amount of money you can get?

    // You can assume lowPayouts.length == highPayouts.length
    public static int hiLoStress(int[] lowPayouts, int[] highPayouts) {
        return hiLoHelper(lowPayouts, highPayouts, new HashMap<Integer, Integer>(), 0);
    }

    public static int hiLoHelper(int[] lowPayouts, int[] highPayouts,
            HashMap<Integer, Integer> expectedPay, int day) {
        if (day >= lowPayouts.length) {
            return 0;
        }
        if (expectedPay.get(day) != null) {
            return expectedPay.get(day);
        }
        int highPayout =
                highPayouts[day] + hiLoHelper(lowPayouts, highPayouts, expectedPay, day + 2);
        int lowPayout = lowPayouts[day] + hiLoHelper(lowPayouts, highPayouts, expectedPay, day + 1);
        int maxPayout = highPayout;
        if (lowPayout > highPayout) {
            maxPayout = lowPayout;
        }
        expectedPay.put(day, maxPayout);
        return maxPayout;
    }


    // You are partaking in a scavenger hunt!
    // You've gotten a secret map to find many of the more difficult
    // items, but they are only available at VERY specific times at
    // specific places. You have an array, times[], that lists at which
    // MINUTE an item is available, in increasing order.
    // Items in the ScavHunt are worth varying numbers of points.
    // You also have an array, points[], same length as times[],
    // that lists how many points each of the corresponding items is worth.
    // Problem is: to get from one location to the other takes 5 minutes,
    // so if there is an item, for example, available at time 23 and another
    // at time 27, it's just not possible for you to make it to both: you'll
    // have to choose!
    // Write a method that returns the maximum POINTS you can get.
    public static int scavHunt(int[] times, int[] points) {
        HashMap<Integer, Integer> expectedPay = new HashMap<Integer, Integer>();
        return scavHelper(times, points, expectedPay, 0);
    }

    public static int scavHelper(int[] times, int[] points, HashMap<Integer, Integer> expectedPay,
            int index) {

        if (index == times.length - 1) {
            return points[index];
        }
        if (index >= times.length) {
            return 0;
        }
        if (expectedPay.get(index) != null) {
            return expectedPay.get(index);
        }
        int next = getFive(index, times);
        int take = 0;
        if (next != -1) {
            take = points[index] + scavHelper(times, points, expectedPay, next);
        }
        int dontTake = scavHelper(times, points, expectedPay, index + 1);
        int max = take;
        if (take < dontTake) {
            max = dontTake;
        }
        expectedPay.put(index, max);
        return max;
    }

    public static int getFive(int current, int[] times) {
        for (int i = current; i < times.length; i++) {
            if (times[i] >= times[current] + 5) {
                return i;
            }
        }
        return -1;
    }



    /*
     * Uses memoization to calculate the route which grants the most cookies, starting at [0][0],
     * only going right or down at each point
     */
    public static int dynamicCookies(int[][] cookieGrid) {
        
        private boolean goodPoint(int row, int col, int[][] cookieGrid) {
            int numRows = cookieGrid.length;
            int numCols = cookieGrid[0].length;
            return (row >= 0 && row < numRows && 
           
            col >= 0 && col < numCols && 
           
            cookieGrid[row][col] >= 0); 
        }
           
            
           
            /* RECURSIVELY calculates the route which grants the most cookies.
           
            * Returns the maximum number of cookies attainable. */
           
        public int recursiveCookies() {
           return recursiveOptimalPath(0, 0);
        } 
           
            
           
            /* Helper function for the above, which returns the maximum number of cookies 
           
            * edible starting at coordinate (row, col). */
           
            /* From any given position, always check right before checking down */
           
            
           
            private int recursiveOptimalPath(int row, int col) {
                if (!goodPoint(row, col)) {
           
                    return 0;
           
                }
            int down = recursiveOptimalPath(row+1, col);    
            int right = recursiveOptimalPath(row, col+1);
            return cookieGrid[row][col] + Math.max(right, down); 
            }
    
    }



}
