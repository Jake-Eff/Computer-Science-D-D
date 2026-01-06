public class MyBSTTester {
    public static void main(String[] args) {
        MyBST<Integer> newThing = new MyBST<>();
        newThing.add(10);
        newThing.add(5);
        newThing.add(6);
        newThing.add(21);
        newThing.add(10);
        System.out.println(newThing.toString());
    }
}
