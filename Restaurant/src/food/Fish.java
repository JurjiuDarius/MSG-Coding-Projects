package food;

public class Fish extends MainDish {
    public static final double DEFAULT_GRAMS = 22;

    public Fish(String name, int price, double grams) {
        super(name, price, grams);
    }

    public Fish(String name, int price) {
        super(name, price, DEFAULT_GRAMS);
    }
}
