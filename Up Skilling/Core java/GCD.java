import java.util.Scanner;
public class GCD{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        a=Math.abs(a);
        b=Math.abs(b);
        while(b!=0)
        {
            int t=b;
            b=a%b;
            a=t;}
        System.out.println(a);
        sc.close();
    }
}
