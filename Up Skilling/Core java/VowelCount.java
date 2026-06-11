import java.util.Scanner;

public class VowelCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        int c = 0;
        for (char ch : s.toCharArray())
            if ("aeiou".indexOf(ch) >= 0)
                c++;
        System.out.println(c);
        sc.close();
    }
}
