public class SinglyLinkedListTester {
    public static void main(String[] args) {
        // // 1. Test empty constructor
        // SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        // System.out.println("Test empty constructor: " + list); // Expected: []

        // // 2. Test add(E obj)
        // list.add(10);
        // list.add(20);
        // list.add(30);
        // System.out.println("After adding 10, 20, 30: " + list); // Expected: [10, 20, 30]

        // // 3. Test size()
        // System.out.println("Size: " + list.size()); // Expected: 2 (BUG: should be 3)

        // // 4. Test isEmpty()
        // System.out.println("Is empty: " + list.isEmpty()); // Expected: false

        // // 5. Test getHead() and getTail()
        // System.out.println("Head: " + list.getHead().getValue()); // Expected: 10
        // System.out.println("Tail: " + list.getTail().getValue()); // Expected: 30

        // // 6. Test get(int i)
        // System.out.println("Get index 1: " + list.get(1)); // Expected: 20

        // // 7. Test set(int i, Object obj)
        // System.out.println("Set index 1 to 25: old value = " + list.set(1, 25));
        // System.out.println("After set: " + list); // Expected: [10, 25, 30]

        // // 8. Test add(int i, Object obj)
        // list.add(1, 15); // Insert 15 at index 1
        // System.out.println("After insert 15 at index 1: " + list); // Expected: [10, 15, 25, 30]

        // // 9. Test remove(int i)
        // System.out.println("Removed index 2: " + list.remove(2)); // Expected: 25
        // System.out.println("After removal: " + list); // Expected: [10, 15, 30]

        // // 10. Test contains(E obj)
        // System.out.println("Contains 15? " + list.contains(15)); // Expected: true
        // System.out.println("Contains 99? " + list.contains(99)); // Expected: false

        // // 11. Test indexOf(E obj)
        // System.out.println("Index of 30: " + list.indexOf(30)); // Expected: 2
        // System.out.println("Index of 99: " + list.indexOf(99)); // Expected: -1

        // // 12. Test remove(E obj)
        // System.out.println("Remove 15: " + list.remove((Integer)15)); // Expected: true
        // System.out.println("After removing 15: " + list); // Expected: [10, 30]

        // 13. Test array constructor
        Object[] values = {5, 6, 7};
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>(values);
        System.out.println("List created from array {5,6,7}: " + list2); // Expected: [5, 6, 7]

        // 14. Edge case: remove head
        list2.remove((Integer)5);
        System.out.println("After removing head (5): " + list2); // Expected: [6, 7]

        // 15. Edge case: remove tail
        list2.remove((Integer)7);
        System.out.println("After removing tail (7): " + list2); // Expected: [6]

        // 16. Edge case: add at index 0
        list2.add(0, 4);
        System.out.println("After inserting 4 at index 0: " + list2); // Expected: [4, 6]

        // 17. Edge case: remove only element
        list2.remove((Integer)6);
        list2.remove((Integer)4);
        System.out.println("After removing all elements: " + list2); // Expected: []

        // 18. Final check: isEmpty
        System.out.println("Is empty after all removals: " + list2.isEmpty()); // Expected: true
    }
}