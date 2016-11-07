package by.dorosinec.traning.triangle;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class InputParams {
    /**
     * Get sides which enter user in console
     *
     * @param numberSides number of side, which should enter user
     * @return array with sides of triangle
     * @throws InputMismatchException invalid input sides
     */
    public BigDecimal[] getSides(int numberSides) throws InputMismatchException {
        BigDecimal[] sides = new BigDecimal[numberSides];
        for (int i = 0; i < numberSides; i++) {
            System.out.print("Enter " + (i + 1) + " side of triangle: ");
            sides[i] = new Scanner(System.in).nextBigDecimal();
        }
        return sides;
    }
}
