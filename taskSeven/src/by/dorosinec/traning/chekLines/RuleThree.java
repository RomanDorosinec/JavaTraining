package by.dorosinec.traning.chekLines;

/**
 * Check the number of words per line
 */
public class RuleThree {
    /**
     * This method replaces all characters with spaces
     * Splits the string into words
     * It counts the number of words
     * @param s line we received from the command line
     * @return
     */
    public String moreThenFiveWords(String s) {
        // From the received line we creat the array of elements
        char [] lineSymbol = s.toCharArray();
        int countLetter = 0;
        int numberOfWords = 0;
        for (int i = 0; i < lineSymbol.length; i++) {
            // Check whether the element is a symbols or not
            if (!(Character.isAlphabetic(lineSymbol[i])) && !(Character.isDigit(lineSymbol[i]))) {
                // It replaces each character with a space
                lineSymbol[i] = ' ';
            }
        }
        // Of char to string
        String lineWithoutSymbols = new String(lineSymbol);
        // line division into an array of words
        String arrayWords[] = lineWithoutSymbols.split(" ");
        // This cycle counts the number of words
        for (int i = 0; i < arrayWords.length; i++) {
            // Check each word of the array "arrayWords" so that it consisted only of letters
            char [] value = arrayWords[i].toCharArray();
            for (int j = 0; j < value.length; j++) {
                if (Character.isAlphabetic(value[j])) {
                    countLetter++;
                }
            }
            // If "qw3t" that countLetter = 3, but qw3t.length = 4, so "numberOfWords" does not increase
            if (countLetter == value.length ) {
                numberOfWords++;
            }
            // At each iteration, the number of counts new word letters
            countLetter = 0;
        }
        if (numberOfWords > 5) {
            return "Line consist more then five words.";
        }
        return "Line consist less than five words.";
    }
}
