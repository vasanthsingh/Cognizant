import java.util.Scanner;

public class SumEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = 0;
        for (int i = 2; i <= n; i += 2)
            s += i;
        System.out.println(s);
        sc.close();
    }
}
