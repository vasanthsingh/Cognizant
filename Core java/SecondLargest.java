import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v > first) {
                second = first;
                first = v;
            } else if (v > second && v < first)
                second = v;
        }
        System.out.println(second == Integer.MIN_VALUE ? first : second);
        sc.close();
    }
}
