package by.dorosinets.training.quadraticequation;

import java.math.BigDecimal;
/**
 * This class is an entry point in the program
 * Receives and processes the command line arguments
 */
public class Runner {
    /**
     * It receives and processes the command line arguments
     * Handle exceptions
     *
     * @param args params that take from the command line
     */
    public static void main(String[] args) {
        try {
            // Out our quadratic equation
            System.out.println("Quadratic equation: " + args[0] + "x^2 +(" + args[1] + ")x + " + args[2] + " = 0");
            System.out.println(Equation.rootEquation(
                    new BigDecimal(args[0]),
                    new BigDecimal(args[1]),
                    new BigDecimal(args[2])
            ));
        } catch (ArrayIndexOutOfBoundsException e) {
            // Exception processing if not entered elements
            System.out.println("Empty parameters");
            // Exception processing if entered string
        } catch (NumberFormatException e) {
            System.out.println("Not valid format number");
        }
    }
}