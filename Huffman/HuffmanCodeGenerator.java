import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class HuffmanCodeGenerator {
    private HashMap<Character, Integer> map;
    private HashMap<Character, String> dictionary;
    private FrequencyNode root;

    public FrequencyNode getRoot() {
        return root;
    }

    public void setRoot(FrequencyNode root) {
        this.root = root;
    }

    public HuffmanCodeGenerator(String frequencyFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(frequencyFile))) {
            map = new HashMap<Character, Integer>();
            dictionary = new HashMap<Character, String>();
            int charAsInt;
            while ((charAsInt = reader.read()) != -1) {
                char character = (char) charAsInt;
                if (map.containsKey(character)) {
                    map.put(character, map.get(character) + 1);
                } else {
                    map.put(character, 1);
                }
            }
            map.put(((char) 26), 1);

            createTree();
            assignBinary(root);
            makeCodeFile(frequencyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getFrequency(char c) {
        if (map.containsKey(c)) {
            return map.get(c);
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<FrequencyNode> frequencySort() {
        ArrayList<FrequencyNode> sorted = new ArrayList<FrequencyNode>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sorted.add(new FrequencyNode(entry.getKey(), entry.getValue()));
        }
        Collections.sort(sorted);
        return sorted;
    }

    @SuppressWarnings("unchecked")
    public void createTree() {
        ArrayList<FrequencyNode> sorted = frequencySort();
        while (sorted.size() > 1) {
            int last = sorted.size() - 1;
            int secondLast = sorted.size() - 2;
            int parentFrequency =
                    sorted.get(last).getFrequency() + sorted.get(secondLast).getFrequency();

            FrequencyNode parent = new FrequencyNode((char) 0, parentFrequency);
            parent.setChildOne(sorted.get(last));
            parent.getChildOne().setBinary("0");
            parent.setChildTwo(sorted.get(secondLast));
            parent.getChildTwo().setBinary("1");
            sorted.get(last).setParent(parent);
            sorted.get(secondLast).setParent(parent);
            sorted.remove(last);
            sorted.remove(secondLast);
            sorted.add(parent);
            Collections.sort(sorted);
            root = parent;
        }
    }

    public void assignBinary(FrequencyNode node) {
        String currentNode = node.getBinary();
        if (node.getChildOne() == null && node.getChildTwo() == null) {
            dictionary.put(node.getValue(), currentNode);
        }
        if (node.getChildOne() != null) {
            node.getChildOne().setBinary(currentNode + "0");
            assignBinary(node.getChildOne());
        }
        if (node.getChildTwo() != null) {
            node.getChildTwo().setBinary(currentNode + "1");
            assignBinary(node.getChildTwo());
        }

    }

    public FrequencyNode getNode(FrequencyNode node, char c) {
        if (c == (char) 0) {
            return null;
        }
        if (node.getValue() == c) {
            return node;
        } else {
            if (node.getChildOne() != null) {
                FrequencyNode left = getNode(node.getChildOne(), c);
                if (left != null) {
                    return left;
                }
            }
            if (node.getChildTwo() != null) {
                FrequencyNode right = getNode(node.getChildTwo(), c);
                if (right != null) {
                    return right;
                }
            }
        }
        return null;

    }

    public String getCode(char c) {
        if (dictionary.get(c) == null) {
            return "";
        } else {
            return dictionary.get(c);
        }
    }

    public void makeCodeFile(String codeFile) {
        try {
            PrintWriter pw = new PrintWriter("studentCodeFile.txt");
            for (int i = 0; i < 128; i++) {
                pw.println(getCode((char) i));
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("bad");
        }

    }
}
