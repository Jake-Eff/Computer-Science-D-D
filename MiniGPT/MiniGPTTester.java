public class MiniGPTTester {
    public static void main(String[] args) {
        MiniGPT newGPT = new MiniGPT("thegreatgatsby.txt", 6);
        newGPT.generateText("thegreatgatsby.txt", 500);
    }
}
