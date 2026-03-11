import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Reader;

public class MiniGPT {
	private HashMap<String, ArrayList<Character>> map = new HashMap<String, ArrayList<Character>>();

	public MiniGPT(String fileName, int chainOrder) {
		try (BufferedReader reader = new BufferedReader(new FileReader("thegreatgatsby.txt"))) {
			int charAsInt;
			int index = 0;
			ArrayList<Character> chars = new ArrayList<>();
			StringBuilder newString = new StringBuilder();
			while ((charAsInt = reader.read()) != -1) {
				String currentString = "";
				char character = (char) charAsInt;
				chars.add((Character) character);
			}

			for (int i = 0; i < chars.size(); i++) {
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

	}

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
