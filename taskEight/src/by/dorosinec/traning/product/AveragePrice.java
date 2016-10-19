package by.dorosinec.traning.product;

import java.util.ArrayList;

/**
 *
 */
public class AveragePrice extends Count {
    // Operation name
    private static final String NAME = "Average price of products: ";

    /**
     * Sets the name of the operation
     * @return the number of types products
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * It counts the number average price of products
     * @param products list products
     * @return average price all product
     */
    @Override
    public double counting(ArrayList<Product> products) {
        double coust = 0;
        int count = 0;
        for (int j = 0; j < products.size(); j++) {
            count += products.get(j).getNumber();
            coust += products.get(j).getCost();
        }
        return coust/count;
    }
}
