import java.util.Scanner;
public class AreaOfCircle{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double r=sc.nextDouble();
        System.out.println(3.141592653589793*r*r);
        sc.close();
    }
}
