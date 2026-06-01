import java.util.Scanner;

public class BinToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long val = 0;
        for (char c : s.toCharArray()) {
            val = val * 2 + (c == '1' ? 1 : 0);
        }
        System.out.println(val);
        sc.close();
    }
}
