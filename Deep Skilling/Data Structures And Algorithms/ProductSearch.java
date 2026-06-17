import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    public String toString() {
        return productId + " - " + productName + " - " + category;
    }
}

public class ProductSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = {
            new Product(1, "Phone", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Laptop", "Electronics"),
            new Product(4, "Book", "Education"),
            new Product(5, "Watch", "Fashion")
        };

        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        System.out.print("Enter product name to search: ");
        String searchName = sc.next();

        System.out.println("Using Linear Search:");
        boolean found = false;
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(searchName)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Not Found");

        System.out.println("Using Binary Search:");
        int low = 0, high = products.length - 1;
        found = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(searchName);
            if (cmp == 0) {
                System.out.println(products[mid]);
                found = true;
                break;
            } else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        if (!found) System.out.println("Not Found");
    }
