import java.util.Scanner;
public class Power{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        int b=sc.nextInt();
        double p=1;
        for(int i=0;i<b;i++) p*=a;
        System.out.println(p);
        sc.close();
    }
}
