package by.dorosinec.traning.product;

import java.util.ArrayList;

/**
 *
 */
public class AveragePriceType extends Count {
    // Operation name
    private static final String NAME = "Average price type of products: ";

    /**
     * Sets the name of the operation
     * @return the number of types products
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * It counts the number average price only one product
     * @param products list products
     * @return average price only one product
     */
    @Override
    public double counting(ArrayList<Product> products) {
        double coust = 0;
        int count = 0;
        int indexType = products.size();
        for (int j = 0; j < products.size(); j++) {
            if (products.get(j).getName().equals(products.get(products.size()-1).getName())) {
                coust += products.get(j).getCost();
                count += products.get(j).getNumber();
            }
        }
        return coust/count;
    }
}
