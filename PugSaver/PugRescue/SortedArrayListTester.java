public class SortedArrayListTester {
    public static void main(String[] args) {
        SortedArrayList<String> bruh = new SortedArrayList<>();
        bruh.add("monkey");
        bruh.add("orangutang");
        bruh.add("gorilla");
        bruh.add("silverback");
        bruh.add("zack");
        bruh.add("jackson");
        System.out.println(bruh.toString());
        bruh.remove("orangutang");
        System.out.println(bruh.toString());
        System.out.println(bruh.max());
        System.out.println(bruh.min());
    }
}
