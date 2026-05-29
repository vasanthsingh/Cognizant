import java.util.Scanner;
public class SumArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long s=0;
        for(int i=0;i<n;i++) s+=sc.nextLong();
        System.out.println(s);
        sc.close();
    }
}
