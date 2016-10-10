package by.dorosinec.traning.chekLines;

/**
 * Check only availability of the number in the line
 */
public class RuleTwo {
    /**
     * The method checks the line consist only of number
     * @param s line we received from the command line
     * @return whether the line has the symbols or not
     */
    public String notSymbols(String s) {
        // From the received line we creat the array of elements
        char [] lineSymbol = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < lineSymbol.length; i++) {
            /*Check whether the element is a number or not
             * If there is at least one symbol flag = false and the cycle is completed
             */
            if (Character.isDigit(lineSymbol[i])) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return "Line consist only number.";
        } else {
            return "Line have a symbols.";
        }
    }
}
