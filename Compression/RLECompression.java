import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RLECompression {

    // Creates a compressed version with fileName + ".rle.bw"
    public static void compress(String fileName) throws IOException {
        bwTransform(fileName);
        encode(fileName + ".bw");
    }

    // Decompresses a .rle.bw file
    public static void decompress(String fileName) throws IOException {
        decode(fileName);
        invertBWTransform(fileName.substring(0, fileName.length() - 4));
    }

    // Encodes the contents of a file using the RLE compression scheme:
    // single characters are left alone, and runs of 2+ characters are encoded as
    // that letter twice, followed by the length of the run, cast as a char
    public static void encode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName + ".rle");

        char previousChar = (char) br.read();
        int count = 1;

        while (br.ready()) {
            char c = (char) br.read();
            if (previousChar == c) {
                count++;
            } else {
                if (count == 1) {
                    pw.write(previousChar);
                } else {
                    pw.write(previousChar + previousChar + count);
                }
            }
        }

        br.close();
        pw.close();
    }

    public static boolean isNumber(char c) {
        if (c < 48 || c > 57) {
            return false;
        } else {
            return true;
        }
    }

    // Decodes the above scheme
    public static void decode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 4));

        char previousChar = (char) br.read();

        while (br.ready()) {
            char c = (char) br.read();
            if (!(isNumber(c)) && isNumber(previousChar) && previousChar != c) {
                pw.write(previousChar);
            } else if (isNumber(c) && !(isNumber(previousChar))) {
                for (int i = 0; i < ((int) c) - 48; i++) {
                    pw.write(previousChar);
                }
            }
        }

        br.close();
        pw.close();
    }

    public static void bwTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // Add a null character at the beginning, as a
        // "beginning of file" character
        StringBuilder originalText = new StringBuilder("" + '\0');

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        String[] rotations = new String[originalText.length()];
        rotations[0] = originalText.toString();
        String toUse = rotations[0];
        for (int i = 0; i < originalText.length(); i++) {
            StringBuilder toAdd =  new StringBuilder(toUse.charAt(toUse.length() - 1) + toUse.substring(0, toUse.length() - 1));
            toUse = toAdd.toString();
            rotations[i] = toAdd.toString();
        }

        rotations = alphabetize(rotations);
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < rotations.length; i++) {
            toReturn.append(rotations[i].substring(rotations.length - 1));
        }

        // And then write the transformation into a file
        PrintWriter pw = new PrintWriter(fileName + ".bw");
        pw.write(toReturn.toString());
        pw.close();
    }

    public static String[] alphabetize(String[] rotations){
        ArrayList<String> rotationArray = new ArrayList<String>(rotations.length);
        for (int i = 0; i < rotations.length; i++) {
            rotationArray.add(rotations[i]);
        }
        Collections.sort(rotationArray);
        String[] newRotations = new String[rotations.length];
        for (int i = 0; i < rotations.length; i++) {
            newRotations[i] = rotationArray.get(i);
        }
        return newRotations;
    }

    public static void invertBWTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        StringBuilder originalText = new StringBuilder();

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        StringBuilder[] reconstructions = new StringBuilder[originalText.length()];
        for (int i = 0; i < reconstructions.length; i++) {
            reconstructions[i] = new StringBuilder("" + originalText.charAt(i));
        }
        // TO-DO
        // Now undo the Burrows-Wheeler transform

        // TO-DO
        // And write the appropriate reconstruction into the file, without the null char
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 3));
        pw.close();
    }
}
