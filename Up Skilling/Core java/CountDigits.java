import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Math.abs(sc.nextInt());
        if (n == 0) {
            System.out.println(1);
            sc.close();
            return;
        }
        int c = 0;
        while (n > 0) {
            c++;
            n /= 10;
        }
        System.out.println(c);
        sc.close();
    }
}
