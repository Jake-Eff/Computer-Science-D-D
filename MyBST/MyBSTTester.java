public class MyBSTTester {
    public static void main(String[] args) {
        MyBST<Integer> newThing = new MyBST<>();
        newThing.add(1);
        newThing.add(5);
        newThing.add(3);
        newThing.add(4);
        System.out.println(newThing.toString());

        newThing.remove(1);
        System.out.println(newThing.toString());

        
    }
}
