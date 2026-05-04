import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HuffmanDecoder {

    private HashMap<String, Character> dictionary;

    public HuffmanDecoder(String codeFile) {
        dictionary = new HashMap<String, Character>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(codeFile));

            char previous;
            int count = 0;
            String frequency = "";

            while (br.ready()) {
                previous = (char) br.read();
                if (previous == (char) '\n') {
                    if (!frequency.equals("")) {
                        dictionary.put(frequency.trim(), (char) count);
                        frequency = "";
                    }
                    count++;
                } else {
                    frequency += previous;
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println("bad");
        }
    }

    public boolean isCode(String binary) {
        return dictionary.containsKey(binary);
    }

    public char decodeChar(String binary) {
        return dictionary.get(binary);
    }

    public void decodeFileFromHuffmanCodes(String encodedFile, String decodedFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(encodedFile));
            PrintWriter pw = new PrintWriter(decodedFile);
            int previous;
            String binary = "";
            while (br.ready()) {
                previous = br.read();
                binary += (char) previous;
                if (isCode(binary)) {
                    if (decodeChar(binary) == (char) 26) {
                        break;
                    }
                    pw.write(decodeChar(binary));
                    binary = "";
                }
            }
            br.close();
            pw.close();
        } catch (Exception e) {
            System.out.println("bad");
        }
    }

    public void decodeFile(String encodedFile) {
        if (!(encodedFile.substring(encodedFile.length() - 4).equals(".huf"))) {
            throw new IllegalArgumentException();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(encodedFile));
            PrintWriter pw = new PrintWriter(encodedFile.substring(0, encodedFile.length() - 4));

            StringBuilder current = new StringBuilder();
            int charAsInt;

            while(!(charAsInt == )){

            }
            
            
            // while (br.ready()) {
            //     previous = (char) br.read();
            //     int charAsInt = (int) previous;
            //     binary += previous;
            //     String convert = Integer.toBinaryString(charAsInt);
            //     if (charAsInt == (char) 26) {
            //         break;
            //     }
            //     pw.write(decodeChar(binary));
            //     binary = "";

            // }
            // br.close();
            // pw.close();
        } catch (Exception e) {
            System.out.println("bad");
        }
    }
}

