import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppRunner {
    public static void main(String[] args) {
        List<Product> availaleProducts;
        List<Person> availablePersons;
        String input;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                input = scanner.nextLine();
                availablePersons = parsePersons(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {

            try {
                input = scanner.nextLine();
                availaleProducts = parseProducts(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
                break;
            }
            if (person.getMoney() >= product.getCost()) {
                person.addProduct(product);
                person.setMoney(person.getMoney() - product.getCost());
            } else {
                System.out.println(personName + " can' afford " + productName);
            }
        }
        for (Person availablePerson : availablePersons) {
            System.out.println(availablePerson);
        }

    }

    public static List<Person> parsePersons(String s) {
        List<String> separatePersons = List.of(s.split(";"));
        List<String> personsAttributes;
        List<Person> personList = new ArrayList<>();
        for (String separatePerson : separatePersons) {
            personsAttributes = List.of(separatePerson.split("="));
            String name = personsAttributes.get(0);
            int money = Integer.parseInt(personsAttributes.get(1));
            if (name.equals("")) {
                throw new RuntimeException("Name cannot be an empty string");
            }
            if (money < 0) {
                throw new RuntimeException("Sum of money cannot be negative");
            }
            Person person = new Person(name, money);
            personList.add(person);
        }
        return personList;
    }

    public static List<Product> parseProducts(String s) {
        List<String> separateProduts = List.of(s.split(";"));
        List<String> productsAttributes;
        List<Product> productList = new ArrayList<>();
        for (String separateProdut : separateProduts) {
            productsAttributes = List.of(separateProdut.split("="));
            String name = productsAttributes.get(0);
            int money = Integer.parseInt(productsAttributes.get(1));
            if (name.equals("")) {
                throw new RuntimeException("Name cannot be an empty string");
            }
            if (money < 0) {
                throw new RuntimeException("Sum of money cannot be negative");
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
        for (Person value : list) {
            if (value.getName().equals(s))
                person = value;

        }
        if (person.getName().equals("")) {
            throw new RuntimeException("Person could not be found");
        }
        return person;

    }

    private static Product getProductByName(List<Product> list, String s) {
        Product product = new Product("", 0);
        for (Product value : list) {
            if (value.getName().equals(s))
                product = value;

        }
        if (product.getName().equals("")) {
            throw new RuntimeException("Product could not be found");
        }
        return product;
    }

}
