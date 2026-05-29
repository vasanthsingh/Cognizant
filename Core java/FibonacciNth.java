import java.util.Scanner;
public class FibonacciNth{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<=0){System.out.println(0);sc.close();return;}
        long a=0,b=1;for(int i=2;i<=n;i++){long t=a+b;a=b;b=t;} 
        System.out.println(n==1?0:b);
        sc.close();
    }
}
