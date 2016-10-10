package by.dorosinec.traning.chekLines;

/**
 * Checks for only characters in a line
 */
public class RuleOne {
    /**
     * The method checks the line consist only of symbols
     * @param s line we received from the command line
     * @return whether the line has the number or not
     */
    public String notNumber(String s) {
        // From the received line we creat the array of elements
        char [] lineSymbol = s.toCharArray();
        for (int i = 0; i < lineSymbol.length; i++) {
            // Check whether the element is a number or not
            if (Character.isDigit(lineSymbol[i])) {
                return "Line have a number";
            }
        }
        return "Line don't have number.";
    }
}
