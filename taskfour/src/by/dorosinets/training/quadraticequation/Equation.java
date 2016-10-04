package by.dorosinets.training.quadraticequation;
import static java.lang.Math.*;

/**
 * Class for working with equations
 */
public class Equation {
    private double numberA;
    private double numberB;
    private double numberC;
    // Amount of numbers after '.'
    public final static int MAX_SIZE = 4;

    /**
     * Creates new equation
     * @param a coefficient near x^2
     * @param b coefficient near x
     * @param c free coefficient
     */
    public Equation(double a, double b, double c) {
        this.numberA = a;
        this.numberB = b;
        this.numberC = c;
    }

    /**
     * Calculates equation roots
     * @return a string with equation solution - no roots, one root or two roots
     */
    public String rootEquation () {
        // Handles the case when coefficient A is zero
        if (numberA == 0.0) {
            return "This is not a quadratice Equation";
        }
        double discriminant = numberB * numberB - 4 * numberA * numberC;
        // Handles the case when discriminant less then zero
        if (discriminant < 0) {
            return "Discriminant is less than zero. The roots of no";
        }
        double rootOne = (-numberB + sqrt(discriminant)) / 2 * numberA;
        double rootTwo = (-numberB - sqrt(discriminant)) / 2 * numberA;
        // Event processing when the discriminant is zero
        if (discriminant != 0) {
            return "rootOne: " + rootOne + "\nrootTwo: " + rootTwo;
        } else {
            return "Discriminant is zero. Equation has one root.\nSingle root: " + rootOne;
        }
    }
}