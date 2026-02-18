import java.lang.StringBuilder;

public class Hash {

    public Hash() {
        return;
    }

    public static int hashFunction(String name) {
        String lowerCase = name.toLowerCase();
        StringBuilder toReturn = new StringBuilder("");
        for (int i = 0; i < lowerCase.length(); i++) {
            if(lowerCase.charAt(i) == ' '){
                i++;
            }
            String temp = String.valueOf(lowerCase.charAt(i));
            toReturn.append(temp);
        }
        int finalInt = Integer.parseInt(toReturn.toString());
        return (finalInt % 500) / 500;


    }

}
