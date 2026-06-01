import java.util.Scanner;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long s = 0;
        for (long i = 1; i <= n; i++)
            s += i * i;
        System.out.println(s);
        sc.close();
    }
}
