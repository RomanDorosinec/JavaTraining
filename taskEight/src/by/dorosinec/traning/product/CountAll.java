package by.dorosinec.traning.product;

import java.util.ArrayList;

/**
 *
 */
public class CountAll extends Count {
    // Operation name
    private static final String NAME = "Count all type of products: ";

    /**
     * Sets the name of the operation
     * @return the number of types products
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * It counts the number of all products
     * @param products list products
     * @return the number of all products
     */
    @Override
    public double counting(ArrayList<Product> products) {
        int count = 0;
        for (int j = 0; j < products.size(); j++) {
            count += products.get(j).getNumber();
        }
        return count;
    }
}
