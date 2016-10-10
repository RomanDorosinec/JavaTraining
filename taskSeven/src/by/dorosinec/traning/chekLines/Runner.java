package by.dorosinec.traning.chekLines;

import java.util.Scanner;

/**
 * This class is an entry point in the program
 */
public class Runner {
    /**
     *  Method receives and processes the command line arguments
     * @param args  params that take from the command line
     */
    public static void main(String[] args) {
        System.out.println("Enter the string:");
        String stringToCheck = new Scanner(System.in).nextLine();
        // Check if the user has not entered anything
        if (stringToCheck.equals("")) {
            System.out.println("You don't enter the string.");
        } else {
            RuleOne ruleOne = new RuleOne();
            RuleTwo ruleTwo = new RuleTwo();
            RuleThree ruleThree = new RuleThree();
            RuleFour ruleFour = new RuleFour();
            System.out.println("Rule 1: " + ruleOne.notNumber(stringToCheck));
            System.out.println("Rule 2: " + ruleTwo.notSymbols(stringToCheck));
            System.out.println("Rule 3: " + ruleThree.moreThenFiveWords(stringToCheck));
            System.out.println("Rule 3: " + ruleFour.containsDictionaryWord(stringToCheck));
        }
    }
}
