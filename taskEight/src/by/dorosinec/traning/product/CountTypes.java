package by.dorosinec.traning.product;

import java.util.ArrayList;

/**
 *
 */
public class CountTypes extends Count {
    // Operation name
    private static final String NAME = "Count type of products: ";

    /**
     * Sets the name of the operation
     * @return the number of types products
     */
    @Override
    public  String getName() {
        return NAME;
    }

    /**
     * It counts the number of types of products
     * @param products list products
     * @return the number of types
     */
    @Override
    public double counting(ArrayList<Product> products) {
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).getType().equals(products.get(j).getType())) {
                    count ++;
                }
            }
        }
        return products.size() - count;
    }
}
