package by.dorosinets.training.quadraticequation;
import static java.lang.Math.*;

public class Equation {
    private double numberA;
    private double numberB;
    private double numberC;
    // Amount of numbers after '.'
    public final static int MAX_SIZE = 4;

    public Equation(double a, double b, double c) {
        this.numberA = a;
        this.numberB = b;
        this.numberC = c;
    }

    // Method count descriminant
    public String rootEquation() {
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
