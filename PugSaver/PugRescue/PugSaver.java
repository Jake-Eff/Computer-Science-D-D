import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Golden" in the list to the back of the list
	public static void rescueGoldens(ArrayList<Dog> list) {
		ArrayList<Dog> Saved = new ArrayList<Dog>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getBreed().toLowerCase().contains("golden")){
				Saved.add(list.get(i));
				list.remove(i);
			}
		}
		
	}
}
