import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = new StringBuilder(s).reverse().toString();
        System.out.println(s.equals(t) ? "Palindrome" : "Not palindrome");
        sc.close();
    }
}
