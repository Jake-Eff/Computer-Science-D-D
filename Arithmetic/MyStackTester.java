public class MyStackTester {
    public static void main(String[] args) {
        MyStack<String> s = new MyStack<String>();
        s.push("Derp");
        s.push("Blah");
        String str = s.peek();
        System.out.println(str.toString());
        str = s.pop();
        System.out.println(str.toString());

    }
}
