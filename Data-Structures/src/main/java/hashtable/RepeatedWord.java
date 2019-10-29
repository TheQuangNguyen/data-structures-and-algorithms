package hashtable;

import java.util.regex.Pattern;

public class RepeatedWord {

    // Create a method that takes in a string and return the first repeated word in the input string
    public static String repeatedWord(String book) {

        // hash table to store the already seen words
        Hashtable<String, Integer> encounteredWordTable = new Hashtable<>();
        // string builder to build up each word letter by letter
        StringBuilder word = new StringBuilder();
        // regex that match anything that is a letter
        Pattern p = Pattern.compile("\\w");

        for (int i = 0; i < book.length(); i++) {
            String currentCharacter = book.substring(i, i+1).toLowerCase();
            // check in the case that there is a space after a special character like period
            if (currentCharacter.equals(" ") && word.length() == 0) {
                continue;
            }
            // if the current character is a letter then append it to word to build up the current word
            if (p.matcher(currentCharacter).matches()) {
                word.append(currentCharacter);
            } else {
                // checks for apostrophe that is between the word like can't or won't
                if (currentCharacter.equals("'") && word.length() > 0) {
                    word.append(currentCharacter);
                } else if (encounteredWordTable.contains(word.toString())) {
                    return word.toString();
                    // checks in case there are multiple special characters next to each other like ?!?!?
                } else if (word.length() == 0) {
                    continue;
                } else {
                    encounteredWordTable.add(word.toString(), 1);
                    word.delete(0, word.length());
                }
            }
        }
        return null;
    }
}
