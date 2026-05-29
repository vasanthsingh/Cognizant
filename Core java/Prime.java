import java.util.Scanner;
public class Prime{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean p=n>1;
        for(int i=2;i*i<=n;i++) if(n%i==0){p=false;break;}
        System.out.println(p?"Prime":"Not prime");
        sc.close();
    }
}
