import java.util.Scanner;
import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        System.out.println(Arrays.equals(x, y) ? "Anagram" : "Not anagram");
        sc.close();
    }
}
