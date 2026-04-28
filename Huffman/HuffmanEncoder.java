import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class HuffmanEncoder {
    
    private HashMap<Character, Integer> dictionary;

    public HuffmanEncoder(String codeFile){
        try {
            BufferedReader br = new BufferedReader(new FileReader(codeFile));
            PrintWriter pw = new PrintWriter(codeFile + ".huf");

            char previous = (char) br.read();
            int count = 1;
            String frequency = "";

            while (br.ready()) {
                previous = (char) br.read();
                if(previous == (char) '\n'){
                    if(!frequency.equals("")){
                        dictionary.put(previous, count);
                        frequency = "";
                    }
                    count++;
                } else{
                    frequency += previous;
                }
            }

            br.close();
            pw.write(toReturn.toString());
            pw.close();
        } catch (Exception e) {
            System.out.println("bad");
        }
    }

    public String encodeChar(char input){

    }

    public void encodeFileToHuffmanCodes(String fileToCompress, String encodedFile){

    }
}
