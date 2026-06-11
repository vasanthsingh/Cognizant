import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(n > 0 && (n & (n - 1)) == 0 ? "Yes" : "No");
        sc.close();
    }
}
