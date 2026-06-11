import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            a[n + i] = sc.nextInt();
        StringBuilder out = new StringBuilder();
        for (int v : a)
            out.append(v).append(" ");
        System.out.println(out.toString().trim());
        sc.close();
    }
}
