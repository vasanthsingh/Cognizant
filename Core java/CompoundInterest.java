import java.util.Scanner;
public class CompoundInterest{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double p=sc.nextDouble();
        double r=sc.nextDouble();
        int n=sc.nextInt();
        double a=p*Math.pow(1+r/100,n);
        System.out.println(a);
        sc.close();
    }
}
