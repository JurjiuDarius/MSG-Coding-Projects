package Beverages;

import Product.Product;

public abstract class Beverage extends Product {
    private final double MILILITERS;

    public Beverage(String name, int price, double MILILITERS) {
        super(name, price);
        this.MILILITERS = MILILITERS;
    }
}
