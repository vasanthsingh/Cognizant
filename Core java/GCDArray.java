import java.util.Scanner;

public class GCDArray {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g = 0;
        for (int i = 0; i < n; i++)
            g = (i == 0 ? Math.abs(sc.nextInt()) : gcd(g, sc.nextInt()));
        System.out.println(g);
        sc.close();
    }
}
