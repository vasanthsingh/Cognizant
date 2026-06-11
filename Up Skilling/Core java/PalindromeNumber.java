import java.util.Scanner;
public class PalindromeNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=Math.abs(n);int r=0;while(t>0){r=r*10+t%10;t/=10;} 
        System.out.println((r==Math.abs(n))?"Palindrome":"Not palindrome");
        sc.close();
    }
}
