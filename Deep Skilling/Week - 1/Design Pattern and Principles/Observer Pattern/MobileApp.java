public class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String symbol, double price) {
        System.out.println("📱 " + name + " (Mobile) | " + symbol + ": $" + price);
    }
}