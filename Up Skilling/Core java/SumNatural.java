import java.util.Scanner;

public class SumNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = (long) n * (n + 1) / 2;
        System.out.println(s);
        sc.close();
    }
}
