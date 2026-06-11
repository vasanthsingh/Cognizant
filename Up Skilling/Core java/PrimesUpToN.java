import java.util.Scanner;

public class PrimesUpToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] is = new boolean[n + 1];
        for (int i = 2; i <= n; i++)
            is[i] = true;
        for (int p = 2; p * p <= n; p++)
            if (is[p])
                for (int q = p * p; q <= n; q += p)
                    is[q] = false;
        StringBuilder out = new StringBuilder();
        for (int i = 2; i <= n; i++)
            if (is[i])
                out.append(i).append(" ");
        System.out.println(out.toString().trim());
        sc.close();
    }
}
