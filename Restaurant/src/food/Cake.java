package food;

public class Cake extends Dessert {
    private static final double DEFAULT_GRAMS = 250;
    private static final int DEFAULT_CALORIES = 1000;
    private static final float DEFAULT_PRICE = 5;

    public Cake(String name, int price, double grams, int calories) {
        super(name, price, grams, calories);
    }

    public Cake(String name) {
        super(name, DEFAULT_PRICE, DEFAULT_GRAMS, DEFAULT_CALORIES);
    }
}
