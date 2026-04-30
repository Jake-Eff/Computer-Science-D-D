import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class HuffmanEncoder {

    private HashMap<Character, String> dictionary;

    public HuffmanEncoder(String codeFile) {
        dictionary = new HashMap<Character, String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(codeFile));

            char previous;
            int count = 0;
            String frequency = "";

            while (br.ready()) {
                previous = (char) br.read();
                if (previous == (char) '\n') {
                    if (!frequency.equals("")) {
                        dictionary.put((char) count, frequency);
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

    public String encodeChar(char input) {
        if (dictionary.get(input) == null) {
            return "";
        }
        return dictionary.get(input);
    }

    public void encodeFileToHuffmanCodes(String fileToCompress, String encodedFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileToCompress));
            PrintWriter pw = new PrintWriter(encodedFile);
            int count = 0;
            char previous;
            while (br.ready()) {
                previous = (char) br.read();
                pw.write(encodeChar(previous));
                count += encodeChar(previous).length();
            }
            pw.write(encodeChar((char) 26));
            count += encodeChar((char) 26).length();
            int adding = ((8 - (count % 8)) % 8);
            for (int i = 0; i < adding; i++) {
                pw.write('0');
            }
            br.close();
            pw.close();
        } catch (Exception e) {
            System.out.println("bad");
        }
    }

    public void encodeFile(String fileToCompress) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileToCompress));
            PrintWriter pw = new PrintWriter(fileToCompress + ".huf");
            int count = 0;
            char previous;
            String binary = "";
            while (br.ready()) {
                previous = (char) br.read();
                String binaryCode = encodeChar(previous);
                count += encodeChar(previous).length();
                binary += binaryCode;
                if (binary.length() >= 8) {
                    String add = binary.substring(0, 8);
                    pw.write(Integer.parseInt(add, 2));
                    binary = binary.substring(8);
                }
            }
            binary = (encodeChar((char) 26));
            count += encodeChar((char) 26).length();
            int adding = ((8 - (count % 8)) % 8);
            for (int i = 0; i < adding; i++) {
                binary += '0';
            }

            for (int i = 0; i < binary.length() / 8; i++) {
                String toAdd = binary.substring(0, 8);
                pw.write((char) Integer.parseInt(toAdd, 2));
                binary = binary.substring(2);
            }

            br.close();
            pw.close();
        } catch (Exception e) {
            System.out.println("bad");
        }
    }
}
