import java.util.Scanner;

public class FinancialForecasting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial amount: ");
        double amount = sc.nextDouble();
        System.out.print("Enter growth rate (%): ");
        double rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = forecast(amount, rate, years);
        System.out.printf("Future value after %d years: ₹%.2f\n", years, futureValue);
    }

    static double forecast(double amount, double rate, int years) {
        if (years == 0)
            return amount;
        return forecast(amount * (1 + rate / 100), rate, years - 1);
    }
}

