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
            // Check if all arguments have correct number of digits after
            if (validateArgs(args)) {
                System.out.println("Quadratic equation: " + args[0] + "x^2 +(" + args[1] + ")x + " + args[2] + " = 0");
                Equation equation = new Equation(
                        Double.parseDouble(args[0]),
                        Double.parseDouble(args[1]),
                        Double.parseDouble(args[2]));
                System.out.println(equation.rootEquation());
            } else {
                System.out.println("Not valid amount of numbers after .");
            }
            // Exception processing if not entered elements
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Empty parameters");
            // Exception processing if entered string
        } catch (NumberFormatException e) {
            System.out.println("Not valid format number");
        }
    }

    /**
     * Check our arguments on the amount of numbers after the decimal point
     * @param args params that take from the command line
     * @return true if arguments are valid, false otherwise
     */
    public static boolean validateArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            // Looks for '.' in parameter, it means, define if number is integer
            // Define the length of string after '.' and compare it to MAX_SIZE
            if ((args[i].indexOf('.') != -1) && (args[i].substring(args[i].indexOf('.')).length() > Equation.MAX_SIZE)) {
                return false;
            }
        }
        return true;
    }
}