import java.util.Scanner;
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }

    public String toString() {
        return orderId + " - " + customerName + " - ₹" + totalPrice;
    }
}

public class OrderSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Order ID, Customer Name, and Total Price:");
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();
            orders[i] = new Order(id, name, price);
        }

        System.out.println("\nSorted using Bubble Sort:");
        bubbleSort(orders.clone());

        System.out.println("\nSorted using Quick Sort:");
        quickSort(orders, 0, n - 1);
        for (Order o : orders) System.out.println(o);
    }

    static void bubbleSort(Order[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        for (Order o : arr) System.out.println(o);
    }

    static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
