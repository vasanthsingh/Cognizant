public class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNum;

    public CreditCardPayment(String name, String cardNum) {
        this.name = name;
        this.cardNum = cardNum;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card ending in " + cardNum.substring(cardNum.length() - 4));
    }
}