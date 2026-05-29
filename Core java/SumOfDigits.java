import java.util.Scanner;
public class SumOfDigits{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=0;
        n=Math.abs(n);
        while(n>0){s+=n%10;n/=10;}
        System.out.println(s);
        sc.close();
    }
}
