package by.dorosinec.traning.product;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class reads and writes data to the list of products
 */
public class ReaderAndWrite {
    // List of class instances
    private ArrayList<Product> products = new ArrayList<>();

    /**
     * This method ask user< to input parameters of product
     * then use this parameter to create list of products
     */
    public void readConsole() {
        try {
            String instructions = "Enter comand:\n" +
                    "Yes - if you want to enter or add the product.\n" +
                    "No - if you don't want to enter or add the product.\n" +
                    "Exit - if you want exit the program.\n" +
                    "Comand: ";
            // List of products
            ArrayList<String> valueProducts = new ArrayList<>();
            System.out.print(instructions);
            // Auxiliary variable to exit or continue the program
            String enterIntoProgram = new Scanner(System.in).nextLine();
            // Cycle to add element to list product
            while (!(enterIntoProgram.equals("Exit")) || enterIntoProgram.equals("Yes")) {
                System.out.println("Enter product type: ");
                valueProducts.add(new Scanner(System.in).nextLine());
                System.out.println("Enter product name: ");
                valueProducts.add(new Scanner(System.in).nextLine());
                System.out.println("Enter product namber: ");
                valueProducts.add(new Scanner(System.in).nextLine());
                System.out.println("Enter product cost: ");
                valueProducts.add(new Scanner(System.in).nextLine());
                Product product = new Product(valueProducts);
                products.add(product);
                System.out.print(instructions);
                enterIntoProgram = new Scanner(System.in).nextLine();
                // Clean up to create a new object
                valueProducts.clear();
            }
            // Exception processing if not entered elements
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You didn't enter anything. Program finalized.");
        }
    }

    /**
     *
     * @return returns a list of products created
     */
    public ArrayList<Product> getProducts() {
        return products;
    }
}
