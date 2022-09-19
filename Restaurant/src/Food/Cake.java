package Food;

public class Cake extends Dessert {
    private static final double DEFAULT_GRAMS = 250;
    private static final int DEFAULT_CALORIES = 1000;
    private static final float DEFAULT_PRICE = 5;

    public Cake(String name, int price, double GRAMS, int CALORIES) {
        super(name, price, GRAMS, CALORIES);
    }

    public Cake(String name) {
        super(name, DEFAULT_PRICE, DEFAULT_GRAMS, DEFAULT_CALORIES);
    }
}
