package by.dorosinec.traning.chekLines;

/**
 * Check the line if it contains a word from the "DICTIONARY"
 */
public class RuleFour {
    public static final String [] DICTIONARY = {"qwer","asdf","xzcv"};
    /**
     * This method replaces all characters with spaces
     * Splits the string into words
     * Checks the words in the string from the dictionary
     * @param s line we received from the command line
     * @return
     */
    public String containsDictionaryWord(String s) {
        // From the received line we creat the array of elements
        char [] lineSymbol = s.toCharArray();
        for (int i = 0; i < lineSymbol.length; i++) {
            // Check whether the element is a number or not
            if (!(Character.isAlphabetic(lineSymbol[i])) && !(Character.isDigit(lineSymbol[i]))) {
                // It replaces each character with a space
                lineSymbol[i] = ' ';
            }
        }
        // Of char to string
        String lineWithoutSymbols = new String(lineSymbol);
        // Line division into an array of words
        String arrayWords[] = lineWithoutSymbols.split(" ");
        // This cycle through all elements  of the array "arrayWords" and "DICTIONARY"
        for (int i = 0; i < arrayWords.length; i++) {
            for (int j = 0; j < DICTIONARY.length; j++) {
                // Check for matches in the "arrayWords" and "DICTIONARY"
                if (arrayWords[i].equals(DICTIONARY[j])) {
                    return "Line contains a dictionary word";
                }
            }
        }
        return "Line don't contain a dictionary words";
    }
}
