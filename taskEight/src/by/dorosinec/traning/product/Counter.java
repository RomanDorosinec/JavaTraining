package by.dorosinec.traning.product;

import java.util.ArrayList;

/**
 * Class contains a list with all the commands
 */
public class Counter {
    private ArrayList<Count> differentCounts = new ArrayList<>();

    /**
     * Adds calculation options
     * @param count
     * @return a reference to itself
     */
    public Counter add(Count count) {
        differentCounts.add(count);
        return this;
    }

    /**
     * This method performs all the commands
     * @param products list products
     */
    public void execute(ArrayList<Product> products) {
        for(Count count : differentCounts) {
            System.out.println(count.getName() + count.counting(products));
        }
    }
}
