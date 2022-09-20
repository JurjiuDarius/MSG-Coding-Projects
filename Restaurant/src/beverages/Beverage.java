package beverages;

import product.Product;

public abstract class Beverage extends Product {
    private final double mililiters;

    public Beverage(String name, float price, double mililiters) {
        super(name, price);
        this.mililiters = mililiters;
    }
}
