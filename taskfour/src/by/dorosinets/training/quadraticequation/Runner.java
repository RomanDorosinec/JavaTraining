package by.dorosinets.training.quadraticequation;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Quadratic equation: " + args[0]+ "x^2 +(" + args[1] + ")x + " + args[2] + " = 0");
        Equation equation = new Equation();
        equation.setNumberA(Double.parseDouble(args[0]));
        equation.setNumberB(Double.parseDouble(args[1]));
        equation.setNumberC(Double.parseDouble(args[2]));
        equation.rootEquation();
        //System.out.println(equation.rootEquation());
    }
}
