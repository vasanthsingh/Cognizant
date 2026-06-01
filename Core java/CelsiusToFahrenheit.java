import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double c = sc.nextDouble();
        System.out.println(c * 9.0 / 5.0 + 32.0);
        sc.close();
    }
}
