public class DecoratorPatternExample {
    public static void main(String[] args) {
        String msg = "Server is down!";

        System.out.println("Basic Notification");
        Notifier basic = new EmailNotifier();
        basic.send(msg);

        System.out.println("\nEmail + SMS Notification");
        Notifier smsAlert = new SMSNotifierDecorator(new EmailNotifier());
        smsAlert.send(msg);

        System.out.println("\nEmail + SMS + Slack Notification");
        Notifier allAlerts = new SlackNotifierDecorator(
            new SMSNotifierDecorator(
                new EmailNotifier()
            )
        );
        allAlerts.send(msg);
    }
}