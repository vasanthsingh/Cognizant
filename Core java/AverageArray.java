import java.util.Scanner;

public class AverageArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double s = 0;
        for (int i = 0; i < n; i++)
            s += sc.nextDouble();
        System.out.println(s / n);
        sc.close();
    }
}
