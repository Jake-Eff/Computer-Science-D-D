import java.util.ArrayList;

public class PugSaverTester {
    public static void main(String[] args) {
        ArrayList<Dog> test = new ArrayList<Dog>();
        for (int i = 0; i < 100000; i++) {
            test.add(new Dog("Sammy", "Golden Retriever"));
            test.add(new Dog("Ziggy"));
            test.add(new Dog("Charlie", "Golden Retriever"));
            test.add(new Dog("Zack"));
            test.add(new Dog("Peter", "Golden Retriever"));
            test.add(new Dog("Rover"));
        }
        
        PugSaver.rescuePugs(test);
        System.out.println(test);
        
    }
}
