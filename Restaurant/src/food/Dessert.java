package food;

public abstract class Dessert extends Food {
    private int calories;

    public Dessert(String name, float price, double grams, int calories) {
        super(name, price, grams);
        this.calories = calories;
    }
}
