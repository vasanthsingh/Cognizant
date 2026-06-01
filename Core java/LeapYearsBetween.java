import java.util.Scanner;

public class LeapYearsBetween {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;
        for (int y = Math.min(a, b); y <= Math.max(a, b); y++)
            if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0))
                cnt++;
        System.out.println(cnt);
        sc.close();
    }
}
