package Food;

public abstract class Dessert extends Food {
    public final int CALORIES;

    public Dessert(String name, float price, double GRAMS, int CALORIES) {
        super(name, price, GRAMS);
        this.CALORIES = CALORIES;
    }
}
