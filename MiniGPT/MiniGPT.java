import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Reader;
import java.util.Map;
import java.util.Set;
import java.lang.StringBuilder;

public class MiniGPT {
    private HashMap<String, ArrayList<Character>> map = new HashMap<String, ArrayList<Character>>();

    public MiniGPT(String fileName, int chainOrder) {
        try (BufferedReader reader = new BufferedReader(new FileReader("thegreatgatsby.txt"))) {
            int charAsInt;
            int index = 0;
            ArrayList<Character> chars = new ArrayList<>();
            while ((charAsInt = reader.read()) != -1) {
                String currentString = "";
                char character = (char) charAsInt;
                chars.add((Character) character);
            }

            for (int i = 0; i <= chars.size() - chainOrder - 1; i++) {
                StringBuilder newString = new StringBuilder();
                for (int j = 0; j < chainOrder; j++) {
                    newString.append(chars.get(j + i));
                }
                if (map.containsKey(newString.toString())) {
                    map.get(newString.toString()).add(chars.get(i + chainOrder));
                } else {
                    ArrayList<Character> others = new ArrayList<Character>();
                    others.add(chars.get(i + chainOrder));
                    map.put(newString.toString(), others);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void generateText(String outputFileName, int numChars) {
        MiniGPT newGPT = new MiniGPT(outputFileName, 6);
        String[] keys = newGPT.map.keySet().toArray(new String[0]);
        StringBuilder current = new StringBuilder();
        current.append(keys[0]);
        System.out.print(current.toString());
        for (int i = 0; i < numChars; i++) {
            String curr = current.toString();
            int index = (int) (Math.random() * newGPT.map.get(curr).size());
            char next = newGPT.map.get(curr).get(index);
            System.out.print(next);
            current.deleteCharAt(0);
            current.append(next);
        }
    }
}
