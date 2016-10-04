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
    public String rootEquation () {
        double discriminant;
        double rootOne;
        double rootTwo;
        if (numberA == 0.0) {
            return "This is not a quadratice Equation";
        }
        discriminant = numberB*numberB - 4 * numberA * numberC;
        rootOne = (-numberB + sqrt(discriminant)) / 2 * numberA;
        rootTwo = (-numberB - sqrt(discriminant)) / 2 * numberA;
        if (0 != discriminant) {
            return "rootOne: " + rootOne + "\nrootTwo: " + rootTwo;
        } else
            return "Discriminant is zero. Equation has one root.\nSingle root: " + rootOne;

    }
}