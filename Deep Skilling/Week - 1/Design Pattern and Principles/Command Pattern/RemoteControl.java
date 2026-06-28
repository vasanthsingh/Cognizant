public class RemoteControl {
    private Command cmd;

    public void setCommand(Command cmd) {
        this.cmd = cmd;
    }

    public void pressButton() {
        if (cmd != null) {
            cmd.execute();
        } else {
            System.out.println("No command assigned to this button.");
        }
    }
}