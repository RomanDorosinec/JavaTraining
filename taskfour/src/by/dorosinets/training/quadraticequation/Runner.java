package by.dorosinets.training.quadraticequation;

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
            // Out our quadratic equation
            System.out.println("Quadratic equation: " + args[0] + "x^2 +(" + args[1] + ")x + " + args[2] + " = 0");
            Equation equation = new Equation(
                    Double.parseDouble(args[0]),
                    Double.parseDouble(args[1]),
                    Double.parseDouble(args[2]));
            System.out.println(equation.rootEquation());
            // Exception processing if not entered elements
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Empty parameters");
            // Exception processing if entered string
        } catch (NumberFormatException e) {
            System.out.println("Not valid format number");
        }
    }
}