public class CommandPatternExample {
    public static void main(String[] args) {
        Light roomLight = new Light();
        Command on = new LightOnCommand(roomLight);
        Command off = new LightOffCommand(roomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("Testing Light ON");
        remote.setCommand(on);
        remote.pressButton();

        System.out.println("\nTesting Light OFF");
        remote.setCommand(off);
        remote.pressButton();
    }
}