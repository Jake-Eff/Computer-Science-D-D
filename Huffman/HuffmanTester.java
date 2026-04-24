import java.io.IOException;

public class HuffmanTester {
    public static void main(String[] args) {
        try {
            HuffmanCodeGenerator newGenerator = new HuffmanCodeGenerator("ABCDEFG.txt");
            HuffmanTester.printTree(newGenerator.getRoot(), 0);
            System.out.println(newGenerator.getCode('A'));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        // System.out.println(newGenerator.getFrequency('A'));
        // System.out.println(newGenerator.getFrequency('B'));
        // newGenerator.createTree();
        // System.out.println(newGenerator.getRoot().getFrequency());



    }

    public static void printTree(FrequencyNode node, int depth) {
        char root = node.getValue();
        int rootFrequency = node.getFrequency();
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
        System.out.println("{" + root + "}" + " | Frequency: " + rootFrequency + " | Binary: "
                + node.getBinary());
        if (node.getChildOne() != null) {
            printTree(node.getChildOne(), depth + 1);
        }
        if (node.getChildTwo() != null) {
            printTree(node.getChildTwo(), depth + 1);
        }
    }

}
