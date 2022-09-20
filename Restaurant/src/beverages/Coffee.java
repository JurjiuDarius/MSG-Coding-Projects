package beverages;

public class Coffee extends HotBeverage {
    private static final double COFFEE_MILILITERS = 50;
    private static final float COFFE_PRICE = 3.5f;
    private double caffeine;

    public Coffee(String name, int price, double mililiters, double caffeine) {
        super(name, price, mililiters);
        this.caffeine = caffeine;
    }
    public Coffee(String name,double caffeine){
        super(name,COFFE_PRICE,COFFEE_MILILITERS);
        this.caffeine=caffeine;
    }
}
