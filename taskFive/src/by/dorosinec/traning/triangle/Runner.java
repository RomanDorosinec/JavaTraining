package by.dorosinec.traning.triangle;

import java.math.BigDecimal;
import java.util.InputMismatchException;

/**
 * This class is an entry point in the program. Get sides from console
 * and print type of the triangle
 */
public class Runner {
    private final static int NUMBER_OF_SIDES = 3;

    /**
     * Entry point in the program
     * Handle exceptions
     *
     * @param args params that take from the command line
     */
    public static void main(String[] args) {
        try {
            BigDecimal[] inputSides = new InputParams().getSides(NUMBER_OF_SIDES);
            Triangle triangle = new Triangle(inputSides[0], inputSides[1], inputSides[2]);
            System.out.println(triangle.getTriangleType());
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Not valid format input data");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
