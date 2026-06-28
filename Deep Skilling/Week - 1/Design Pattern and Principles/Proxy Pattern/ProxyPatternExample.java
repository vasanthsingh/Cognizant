public class ProxyPatternExample {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("vacation_photo.png");
        Image img2 = new ProxyImage("family_portrait.jpg");

        System.out.println("--- First call to img1 ---");
        img1.display(); 

        System.out.println("\n--- Second call to img1 ---");
        img1.display(); 

        System.out.println("\n--- First call to img2 ---");
        img2.display();
    }
}