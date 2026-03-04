import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MarkovPredictor {

    // Please define your own variables and data structures
    //
    public ArrayList<String[]> readData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            ArrayList<String[]> newList = new ArrayList<String[]>();
            while ((line = br.readLine()) != null) {
                newList.add(line.split(","));
            }
            return newList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Method to predict the next state given a current state
    public String predictNextState(String currentState) {
        
    }

}
