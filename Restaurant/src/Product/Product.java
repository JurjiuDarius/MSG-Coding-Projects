package Product;

public abstract class Product {

    private final String NAME;
    private final float PRICE;

    public Product(String name, float price) {
        this.NAME = name;
        this.PRICE = price;
    }
}
