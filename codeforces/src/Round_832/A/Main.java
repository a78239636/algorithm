package Round_832.A;

import java.util.Scanner;

public class Main {


    static void solve(Scanner in) {
        int n = in.nextInt();

        long sum1 = 0, sum2 = 0;
        for (int i = 1; i <= n; i++) {
            long x = in.nextInt();
            if (x > 0) sum1+=x;
            else sum2 += x;
        }
        System.out.println(Math.abs(Math.abs(sum1) - Math.abs(sum2)));

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}