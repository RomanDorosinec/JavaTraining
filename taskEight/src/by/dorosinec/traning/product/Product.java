package by.dorosinec.traning.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Structure of products. This structure describes all fields of products
 */
public class Product {
    private String type;
    private String name;
    private int number;
    private double cost;

    /**
     * Constructor Product create object of product
     * @param list List of products
     */
    public Product(ArrayList<String> list) {
        this.type = list.get(0);
        this.name = list.get(1);
        this.number = Integer.parseInt(list.get(2));
        this.cost = Double.parseDouble(list.get(3));
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getCost() {
        return cost;
    }
}
