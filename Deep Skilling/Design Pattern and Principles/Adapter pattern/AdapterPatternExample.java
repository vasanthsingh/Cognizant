public class AdapterPatternExample {
    public static void main(String[] args) {
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        
        System.out.println("Initiating Stripe Checkout");
        stripeProcessor.processPayment(50.00); 

        System.out.println();

        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway, "store@mybusiness.com");
        
        System.out.println("Initiating PayPal Checkout");
        payPalProcessor.processPayment(75.50);
    }
}