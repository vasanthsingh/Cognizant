public class PayPalGateway {
    public void sendPayment(String merchantEmail, double amount) {
        System.out.println("PayPal API: Successfully routed $" + amount + " to " + merchantEmail + ".");
    }
}