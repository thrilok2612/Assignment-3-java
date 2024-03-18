import java.io.*;
import java.util.Scanner;

class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product category:");
        String category = scanner.nextLine();
        System.out.println("Enter product price:");
        double price = scanner.nextDouble();

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("product.ser"))) {
            Product product = new Product(id, name, category, price);
            out.writeObject(product);
            System.out.println("Product serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("product.ser"))) {
            Product deserializedProduct = (Product) in.readObject();
            System.out.println("\nDeserialized Product Details:");
            deserializedProduct.printDetails();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
