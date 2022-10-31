package Round_831.B;

import java.util.Scanner;

public class Main {



    static void solve(Scanner in) {
        int n = in.nextInt();

        int[][] a = new int[n + 50][2];
        long ma = 0;
        long total = 0;
        for (int i = 1; i <=n; i++) {
             a[i][0] = in.nextInt();
             a[i][1] = in.nextInt();
             ma = Math.max(ma, Math.max(a[i][0], a[i][1]));
             total += Math.min(a[i][0], a[i][1]);
        }
        System.out.println((ma + total) * 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}
