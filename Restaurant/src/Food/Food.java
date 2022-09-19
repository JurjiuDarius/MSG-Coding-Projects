package Food;

import Product.Product;

public abstract class Food extends Product {
    private final double GRAMS;

    public Food(String name, float price, double GRAMS) {
        super(name, price);
        this.GRAMS = GRAMS;
    }
}
