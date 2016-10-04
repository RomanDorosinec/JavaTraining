package by.dorosinets.training.quadraticequation;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Quadratic equation: " + args[0]+ "x^2 +(" + args[1] + ")x + " + args[2] + " = 0");
        Equation equation = new Equation(
                Double.parseDouble(args[0]),
                Double.parseDouble(args[1]),
                Double.parseDouble(args[2]));

        System.out.println(equation.rootEquation());
    }
}
