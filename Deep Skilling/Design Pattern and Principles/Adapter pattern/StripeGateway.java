public class StripeGateway {
    public void charge(double amountInCents) {
        System.out.println("Stripe API: Successfully charged " + amountInCents + " cents.");
    }
}