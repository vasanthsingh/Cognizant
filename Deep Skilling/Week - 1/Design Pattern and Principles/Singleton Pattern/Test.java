public class Test{
    public static void main(String[] args){
        Logger lg1 = Logger.getLogger();
        Logger lg2 = Logger.getLogger();

        lg1.log();
        lg2.log();

        System.out.println("Bothe are same :" +(lg1 == lg2));
    }
}