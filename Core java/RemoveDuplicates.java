import java.util.Scanner;
import java.util.ArrayList;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (!res.contains(v))
                res.add(v);
        }
        StringBuilder out = new StringBuilder();
        for (int v : res)
            out.append(v).append(" ");
        System.out.println(out.toString().trim());
        sc.close();
    }
}
