import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanCodeGenerator {
    private HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public HuffmanCodeGenerator(String frequencyFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(frequencyFile))) {
            int charAsInt;
            ArrayList<Character> chars = new ArrayList<>();
            while ((charAsInt = reader.read()) != -1) {
                char character = (char) charAsInt;
                int value = map.get(character);
                map.put(character, value + 1);
            }
            map.put(((char) 26), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getFrequency(char c){
        return map.get(c);
    }
}
