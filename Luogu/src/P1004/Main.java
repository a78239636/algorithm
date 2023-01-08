package P1004;

import java.util.*;

public class Main {


    static int getMax(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    static void solve(Scanner in) {
        int n = in.nextInt();
        int x, y, val;
        int[][] a = new int[20][20];
        int[][][][] dp = new int[11][11][11][11];

        while ( (x = in.nextInt()) != 0 && (y = in.nextInt()) != 0  && (val = in.nextInt()) != 0  ) {
            a[x][y] = val;
        }
        dp[1][1][1][1] = a[1][1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 1; k <= n; k++)
                    for (int g = 1; g <= n; g++) {
                        if (i + j == k + g && i != k) {
                            dp[i][j][k][g] = Math.max(dp[i][j][k][g],  getMax(dp[i-1][j][k-1][g], dp[i-1][j][k][g-1], dp[i][j-1][k-1][g], dp[i][j-1][k][g-1]) + a[i][j] + a[k][g]);
                        }
                    }

        System.out.println(dp[n-1][n][n][n-1] + a[n][n]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        solve(in);
    }
}
