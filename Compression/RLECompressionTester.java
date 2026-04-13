public class RLECompressionTester {
    public static void main(String[] args) {
        try {
            RLECompression.compress("words.txt");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
