public class RealImage implements Image {
    private String file;

    public RealImage(String file) {
        this.file = file;
        loadFromServer(file);
    }

    private void loadFromServer(String file) {
        System.out.println("Loading from remote server: " + file);
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + file);
    }
}