import java.util.Scanner;

public class DecToBin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Integer.toBinaryString(n));
        sc.close();
    }
}
