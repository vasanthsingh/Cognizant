import java.util.Scanner;
public class ReverseNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=0;
        int sign=n<0?-1:1;
        n=Math.abs(n);
        while(n>0){r=r*10+n%10;n/=10;}
        System.out.println(r*sign);
        sc.close();
    }
}
