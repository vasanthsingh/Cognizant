public class Logger {
    private static final Logger inst = new Logger();

    private Logger(){
        System.out.println("This is the Logger Constructor");
    }

    public static Logger getLogger(){
        return inst;
    }

    public void log(){
        System.out.println("The is logger");
    }

}
