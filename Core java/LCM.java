import java.util.Scanner;
public class LCM{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int aa=Math.abs(a),bb=Math.abs(b);
        int g=aa;int y=bb;while(y!=0){int t=y;y=g%y;g=t;}
        long l=(long)aa/ g * bb;
        System.out.println(l);
        sc.close();
    }
}
