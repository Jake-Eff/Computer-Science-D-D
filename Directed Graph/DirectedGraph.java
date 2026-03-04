import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class DirectedGraph {
    public static List<String> readAllLines(Path file) throws IOException {
        try{

        } catch (Exception e){
            System.out.println("Couldn't read file");
        }
        Path p = Paths.get("relationships.txt");
        return Files.readAllLines(p);
    }
}

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.List;
// import java.nio.file.Path;
// import java.nio.file.Paths;


// public class DirectedGraph {


//     public static List<String> readAllLines() {
//        List<String> names = new ArrayList<String>();
//         try {


//         	  // Each element is one line from the file
//         	  Path p = Paths.get(“relationships.txt");
//    return (List<String>)Files.readAllLines(p);
//        } catch (Exception e) {
// 	System.out.println(“Couldn’t read file”);
//        }
//       return names;
//     }
// }

