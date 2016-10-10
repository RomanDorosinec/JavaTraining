package by.dorosinets.training.quadraticequation;
import java.math.BigDecimal;

import static java.lang.Math.*;

/**
 * Class for working with equations
 */
public class Equation {
    /**
     * Calculates equation roots
     * @return a string with equation solution - no roots, one root or two roots
     * @param numberA coefficient near x^2
     * @param numberB coefficient near x
     * @param numberC free coefficient
     */
    public static String rootEquation(BigDecimal numberA, BigDecimal numberB, BigDecimal numberC) {
        // Handles the case when coefficient A is zero
        if (numberA.compareTo(BigDecimal.ZERO) == 0) {
            return "This is not a quadratice Equation";
        }
        BigDecimal discriminant = numberB.pow(2).subtract(BigDecimal.valueOf(4).multiply(numberA).multiply(numberC));
        // Handles the case when discriminant less then zero
        if (discriminant.signum() < 0) {
            return "Discriminant is less than zero. The roots of no";
        }
        BigDecimal rootOne = numberB.negate().add(BigDecimal.valueOf(Math.sqrt(discriminant.doubleValue()))).divide(BigDecimal.valueOf(2)).multiply(numberA);
        BigDecimal rootTwo = numberB.negate().subtract(BigDecimal.valueOf(Math.sqrt(discriminant.doubleValue()))).divide(BigDecimal.valueOf(2)).multiply(numberA);
        // Event processing when the discriminant is zero
        if (discriminant.signum() != 0) {
            return "rootOne: " + rootOne + "\nrootTwo: " + rootTwo;
        } else {
            return "Discriminant is zero. Equation has one root.\nSingle root: " + rootOne;
        }
    }
}
