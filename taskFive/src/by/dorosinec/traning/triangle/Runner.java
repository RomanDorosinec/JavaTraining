package by.dorosinec.traning.triangle;

import java.math.BigDecimal;
/**
 * This class is an entry point in the program
 * Receives and processes the command line arguments
 */
public class Runner {
    /**
     * It receives and processes the command line arguments
     * Handle exceptions
     * @param args params that take from the command line
     */
    public static void main(String[] args) {
        try {
            System.out.println(Triangle.getTriangleType(
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
