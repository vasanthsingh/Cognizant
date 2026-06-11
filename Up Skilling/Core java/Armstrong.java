import java.util.Scanner;
public class Armstrong{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=n;int s=0;int digits=String.valueOf(Math.abs(n)).length();
        while(t!=0){int d=Math.abs(t%10);s+=Math.pow(d,digits);t/=10;}
        System.out.println(s==n?"Armstrong":"Not Armstrong");
        sc.close();
    }
}
