public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    private String merchantEmail;

    public PayPalAdapter(PayPalGateway payPalGateway, String merchantEmail) {
        this.payPalGateway = payPalGateway;
        this.merchantEmail = merchantEmail;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayment(merchantEmail, amount);
    }
}