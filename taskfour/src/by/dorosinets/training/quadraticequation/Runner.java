package by.dorosinets.training.quadraticequation;
// This class is an entry point in the program
public class Runner {
    public static void main(String[] args) {
        // Helps to look after amount of numbers after '.'
        boolean flag = true;
        try {
            for (int i = 0; i<args.length; i++) {
                // Looks for '.' in parameter, it means, define if number is integer
                if (args[i].indexOf('.') != -1)
                    // Define the length of string after '.' and compare it to MAX_SIZE
                    if (args[i].substring(args[i].indexOf('.')).length() > Equation.MAX_SIZE)
                        flag = false;
            }

            if (flag) {
                System.out.println("Quadratic equation: " + args[0] + "x^2 +(" + args[1] + ")x + " + args[2] + " = 0");
                Equation equation = new Equation(
                        Double.parseDouble(args[0]),
                        Double.parseDouble(args[1]),
                        Double.parseDouble(args[2]));
                System.out.println(equation.rootEquation());
            }
            else
                System.out.println("Not valid amount of numbers after .");
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Empty parameters");
            }catch (NumberFormatException e) {
                System.out.println("Not valid format number");
            }
    }
}
