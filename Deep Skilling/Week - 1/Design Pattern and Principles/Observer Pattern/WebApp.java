public class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String symbol, double price) {
        System.out.println(name + " (Web Dashboard) | Live Ticker: " + symbol + " updated to $" + price);
    }
}