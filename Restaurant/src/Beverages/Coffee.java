package Beverages;

public class Coffee extends HotBeverage {
    private static final double COFFEE_MILILITERS = 50;
    private static final float COFFE_PRICE = 3.5f;

    private final double CAFFEINE;

    public Coffee(String name, int price, double mililiters, double caffeine) {
        super(name, price, mililiters);
        CAFFEINE = caffeine;
    }
}
