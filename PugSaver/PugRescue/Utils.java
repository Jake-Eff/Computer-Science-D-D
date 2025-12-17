public class Utils {
    public static int binarySearch(E[] arr, E key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // To prevent overflow
            if (arr[mid].equals(key)) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }

    public static <E extends Comparable<E>> int binarySearchRecursiveHelper(E[] arr, E key, int low,
            int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (arr[mid].equals(key)) {
            return mid;
        } else if (arr[mid].compareTo(key) > 0) {
            return binarySearchRecursiveHelper(arr, key, mid + 1, high);
        } else {
            return binarySearchRecursiveHelper(arr, key, low, mid - 1);
        }
    }

    public static <E extends Comparable<E>> int findPlace(E[] arr, E key, int low,
        int high) {
    if (low > high) {
        return -1;
    }

    int mid = low + (high - low) / 2;
    if(binarySearchRecursiveHelper(arr, key, low, mid - 1) < 0 && binarySearchRecursiveHelper(arr, key, low, mid + 1) > 0){
        return mid;
    } else if (arr[mid].compareTo(key) > 0) {
        return binarySearchRecursiveHelper(arr, key, mid + 1, high);
    } else {
        return binarySearchRecursiveHelper(arr, key, low, mid - 1);
    }
}
}
