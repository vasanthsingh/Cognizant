public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer iosApp = new MobileApp("iOS Trader");
        Observer adminWeb = new WebApp("Admin Panel");

        market.register(iosApp);
        market.register(adminWeb);

        System.out.println("Market Open");
        market.setPrice("AAPL", 150.25);
        
        System.out.println("\nPrice Update");
        market.setPrice("GOOGL", 2800.50);

        System.out.println("\niOS App Disconnects");
        market.deregister(iosApp);
        
        market.setPrice("MSFT", 310.15); 
    }
}