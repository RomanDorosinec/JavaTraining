
/**
 * Created by Dorosinec on 03.10.2016.
 */
public class Calculator {
    /**
     *
     */
    private final String
    public static void main(String[] args) {
        Double b;
        try {
            // Conversion from "string" to "double"
            Double a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            System.out.println("Adition: " + add(a, b));
            System.out.println("Difference: " + difference(a, b));
            System.out.println("Multiplicate: " + multiplicate(a, b));
            Double div = divide(a, b);
            // Check divide by zero
            if (Double.isInfinite(div) || Double.isNaN(div)) {
                System.out.println("Divide: Divide by zero");
            } else {
                System.out.println("Division: " + divide(a, b));
            }
            // Exception processing if entered string
        } catch (NumberFormatException e) {
            System.out.println("You entered not a number. Entere the number.");
            // Exception processing if not entered elements
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You did not enter anything. Entere the number");
        }
    }
    // A method that calculates the sum
    public static double add(double a, double b){
        return a + b;
    }
    // A method which calculates the difference
    public static double difference (double a,double b){
        return a - b;
    }
    // A method that calculates the multiplication
    public static double multiplicate (double a, double b){
        return a * b;
    }
    // A method which calculates the division
    public static double divide(double a, double b){
        return a / b;
    }
}
