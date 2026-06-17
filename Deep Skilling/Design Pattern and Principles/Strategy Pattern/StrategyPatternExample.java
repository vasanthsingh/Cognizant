public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext ctx = new PaymentContext();
        
        System.out.println("First Transaction");
        ctx.setStrategy(new CreditCardPayment("Vasanth", "1234-5678-9876-5432"));
        ctx.executePayment(150.75);

        System.out.println("\nSecond Transaction");
        ctx.setStrategy(new PayPalPayment("vasanth@example.com"));
        ctx.executePayment(45.00);
    }
}