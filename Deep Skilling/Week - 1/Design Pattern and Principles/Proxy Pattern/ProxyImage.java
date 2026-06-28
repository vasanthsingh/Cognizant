public class ProxyImage implements Image {
    private RealImage img;
    private String file;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (img == null) {
            img = new RealImage(file);
        }
        img.display();
    }
}