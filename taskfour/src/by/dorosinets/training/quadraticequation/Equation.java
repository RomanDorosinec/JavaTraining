package by.dorosinets.training.quadraticequation;
import static java.lang.Math.*;

public class Equation {
    private double numberA;
    private double numberB;
    private double numberC;

    public Equation(double a, double b, double c) {
        
    }

    public double getNumberA() {
        return numberA;
    }
    public double getNumberB() {
        return numberB;
    }
    public double getNumberC() {
        return numberC;
    }
    public double rootEquation () {
        double discriminant;
        double rootOne;
        double rootTwo;
        discriminant = numberB*numberB - 4 * numberA * numberC;
        rootOne = (-numberB + sqrt(discriminant)) / 2 * numberA;
        rootTwo = (-numberB - sqrt(discriminant)) / 2 * numberA;
        if (0 != discriminant) {
            System.out.println("rootOne: " + rootOne + "\nrootTwo: " + rootTwo);
        }
        else System.out.println("Discriminant is zero. Equation has one root.\nSingl root: " + rootOne);
        return 0;
    }
}