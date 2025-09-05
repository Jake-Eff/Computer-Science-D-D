import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	// Moves every dog whose breed is "Golden" in the list to the back of the list
	public static void rescueGoldens(MyArrayList<Dog> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBreed().toLowerCase().contains("golden")) {
				for (int j = list.size(); j > 0; j--) {
					if (i >= j) {
						break;
					}
					if (!(list.get(i).getBreed().toLowerCase().contains("golden"))) {
						Dog temp = list.get(j);
						list.set(j, list.get(i));
						list.set(i, temp);
						count++;
					}
				}
				if (count + i > list.size()) {
					break;
				}
			}
		}

	}
}
