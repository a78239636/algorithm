package Round_834.E;

import java.util.Arrays;
import java.util.Scanner;

// 贪心写法
public class Main2 {

    static int n;
    static long[] a ;
    static int ma = 0;

    static void dfs(int i, int remain2, int remain3, long power) {

        if (i > n) return ;
        if (a[i] < power) {
            ma = Math.max(ma, i);
            dfs(i + 1, remain2, remain3, power + a[i] / 2);
        }else {
            if (remain2 > 0 && remain3 > 0) {
                dfs(i , remain2 - 1, remain3 - 1, power * 6);
                if (ma >= n) return;
            }
            if (remain2 > 0) {
                dfs(i , remain2 - 1, remain3, power * 2);
                if (ma >= n) return;
            }
            if (remain3 > 0) {
                dfs(i , remain2, remain3 - 1, power * 3);
                if (ma >= n) return;
            }
        }
    }

    static void solve(Scanner in) {
        n = in.nextInt();
        long h = in.nextLong();
        a = new long[ n + 50 ];
        // 要吸取第n个人，是否
        long[][][]  power = new long[n + 50][3][2];

        for (int i = 1; i <= n; i++)
            a[i] = in.nextLong();
        Arrays.sort(a, 1, n + 1);
        ma = 0;

        dfs(1, 2, 1, h);


        System.out.println(ma);
        //System.out.println("");

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }

}
