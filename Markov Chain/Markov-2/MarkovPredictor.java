import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MarkovPredictor {

    // Please define your own variables and data structures
    //
    public static HashMap<String, ArrayList<String>> readData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            ArrayList<String[]> newList = new ArrayList<String[]>();
            while ((line = br.readLine()) != null) {
                newList.add(line.split(","));
            }
            HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
            for (int i = 0; i < newList.size(); i++) {
                if (map.containsKey(newList.get(i)[0])) {
                    map.get(newList.get(i)[0]).add(newList.get(i)[1]);
                } else {
                    ArrayList<String> others = new ArrayList<String>();
                    others.add(newList.get(i)[1]);
                    map.put(newList.get(i)[0], others);
                }
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to predict the next state given a current state
    public static String predictNextState(String currentState, String filePath) {
        HashMap<String, ArrayList<String>> map = readData(filePath);
        ArrayList<String> list = map.get(currentState);
        int n = (int) (Math.random() * list.size());
        return list.get(n);
    }

}
