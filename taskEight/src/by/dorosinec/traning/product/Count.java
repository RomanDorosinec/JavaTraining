package by.dorosinec.traning.product;

import java.util.ArrayList;

/**
 * Base class Count has only two method
 */
public abstract class Count {
    /**
     * Return name of count type
     * @return line with the name of count type
     */
    public abstract String getName();

    /**
     * Considers necessary data in accordance with condition
     * @param product list of product
     * @return value after counting
     */
    public abstract double counting (ArrayList<Product> product);
}
