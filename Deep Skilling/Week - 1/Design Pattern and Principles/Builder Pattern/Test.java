public class Test {
    public static void main(String[] args) {
        Computer gamingPc = new Computer.Builder()
                .cpu("Intel Core i9")
                .ram("32 GB")
                .storage("1 TB SSD")
                .build();

        Computer officePc = new Computer.Builder()
                .cpu("Intel Core i5")
                .ram("16 GB")
                .storage("512 GB SSD")
                .build();

        System.out.println(gamingPc);
        System.out.println(officePc);
    }
}