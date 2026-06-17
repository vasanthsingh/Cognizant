import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagement {
    static class Product {
        int id;
        String name;
        int quantity;
        double price;

        Product(int id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Product> inventory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.nextLine();
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(inventory, scanner);
                    break;
                case 2:
                    updateProduct(inventory, scanner);
                    break;
                case 3:
                    removeProduct(inventory, scanner);
                    break;
                case 4:
                    displayInventory(inventory);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addProduct(Map<Integer, Product> inventory, Scanner scanner) {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (inventory.containsKey(id)) {
            System.out.println("Product already exists.");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Product newProduct = new Product(id, name, quantity, price);
        inventory.put(id, newProduct);
        System.out.println("Product added.");
    }

    static void updateProduct(Map<Integer, Product> inventory, Scanner scanner) {
        System.out.print("Enter id to update: ");
        int id = scanner.nextInt();
        if (!inventory.containsKey(id)) {
            System.out.println("Product not found.");
            scanner.nextLine();
            return;
        }
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Product existing = inventory.get(id);
        existing.quantity = quantity;
        existing.price = price;
        System.out.println("Product updated.");
    }

    static void removeProduct(Map<Integer, Product> inventory, Scanner scanner) {
        System.out.print("Enter id to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void displayInventory(Map<Integer, Product> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : inventory.values()) {
            System.out.println("ID: " + p.id + ", Name: " + p.name + ", Quantity: " + p.quantity + ", Price: " + p.price);
        }
    }
}