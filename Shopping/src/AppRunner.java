import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppRunner {
    public static void main(String[] args) {
        List<Product> availaleProducts = new ArrayList<>();
        List<Person> availablePersons = new ArrayList<>();
        String input;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                input = scanner.nextLine();
                availablePersons = parsePersons(input);
                break;
            } catch (Exception e) {

            }
        }
        while (true) {

            try {
                input = scanner.nextLine();
                availaleProducts = parseProducts(input);
                break;
            } catch (Exception e) {

            }
        }

        String personName, productName;
        Person person;
        Product product;
        List<String> parsedPurchase;

        while (true) {
            input = scanner.nextLine();
            if (input.equals("END"))
                break;
            parsedPurchase = parsePurchase(input);
            personName = parsedPurchase.get(0);
            productName = parsedPurchase.get(1);
            try {
                person = getPersonByName(availablePersons, personName);
                product = getProductByName(availaleProducts, productName);
            } catch (RuntimeException e) {
                System.out.println("Person or product does not exist. Ending program...");
                break;
            }
            if (person.getMoney() >= product.getCost()) {
                person.addProduct(product);
                person.setMoney(person.getMoney() - product.getCost());
            } else {
                System.out.println(personName + " can' afford " + productName);
            }
        }
        for (int i = 0; i < availablePersons.size(); i++) {
            System.out.println(availablePersons.get(i));
        }

    }

    public static List<Person> parsePersons(String s) {
        List<String> separatePersons = List.of(s.split(";"));
        List<List<String>> personsAttributes = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < separatePersons.size(); i++) {
            personsAttributes.add(List.of(separatePersons.get(i).split("=")));
            String name = personsAttributes.get(i).get(0);
            int money = Integer.valueOf(personsAttributes.get(i).get(1));
            if (name.equals("")) {
                System.out.println("Name cannot be an empty string");
                throw new RuntimeException();
            }
            if (money < 0) {
                System.out.println("Sum of money cannot be negative");
                throw new RuntimeException();
            }
            Person person = new Person(name, money);
            personList.add(person);
        }
        return personList;
    }

    public static List<Product> parseProducts(String s) {
        List<String> separateProduts = List.of(s.split(";"));
        List<List<String>> productsAttributes = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < separateProduts.size(); i++) {
            productsAttributes.add(List.of(separateProduts.get(i).split("=")));
            String name = productsAttributes.get(i).get(0);
            int money = Integer.valueOf(productsAttributes.get(i).get(1));
            if (name.equals("")) {
                System.out.println("Name cannot be an empty string");
                throw new RuntimeException();
            }
            if (money < 0) {
                System.out.println("Sum of money cannot be negative");
                throw new RuntimeException();
            }
            Product product = new Product(name, money);
            productList.add(product);
        }
        return productList;
    }

    private static List<String> parsePurchase(String s) {
        return List.of(s.split(" "));
    }

    private static Person getPersonByName(List<Person> list, String s) {
        Person person = new Person("", 0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(s))
                person = list.get(i);

        }
        if (person.getName().equals("")) {
            throw new RuntimeException();
        }
        return person;

    }

    private static Product getProductByName(List<Product> list, String s) {
        Product product = new Product("", 0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(s))
                product = list.get(i);

        }
        if (product.getName().equals("")) {
            throw new RuntimeException();
        }
        return product;
    }

}
