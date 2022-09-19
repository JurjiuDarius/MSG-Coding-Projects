import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Product> products;
    private String name;
    private int money;


    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return name + " - " + products;
    }
}
