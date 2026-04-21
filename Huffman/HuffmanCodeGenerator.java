import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class HuffmanCodeGenerator {
    private HashMap<Character, Integer> map;

    public HuffmanCodeGenerator(String frequencyFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(frequencyFile))) {
            map = new HashMap<Character, Integer>();
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

            FrequencyNode parent = new FrequencyNode(null, parentFrequency);
            parent.setChildOne(sorted.get(last));
            parent.setChildTwo(sorted.get(secondLast));
            sorted.get(last).setParent(parent);
            sorted.get(secondLast).setParent(parent);
            sorted.remove(last);
            sorted.remove(secondLast);
            sorted.add(parent);
            Collections.sort(sorted);
        }
    }
}
