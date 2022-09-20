package food;

import product.Product;

public abstract class Food extends Product {
    private double grams;

    public Food(String name, float price, double grams) {
        super(name, price);
        this.grams = grams;
    }
}
