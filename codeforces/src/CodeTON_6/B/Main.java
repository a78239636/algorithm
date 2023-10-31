package CodeTON_6.B;

import java.util.Scanner;

public class Main {
    static void solve(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n + 10];
        int[] b = new int[m + 10];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            sum ^= a[i];
        }
        for (int i = 1; i <= m; i++) b[i] = in.nextInt();

        int mi = sum, ma = sum;
        if ((n & 1) == 0) {
            for (int i = 1; i <= m; i++) {
                mi = (mi | b[i]) ^ b[i];
            }
        }else {
            // 奇数
            for (int i = 1; i <= m; i++) {
                ma = ma | b[i];
            }
        }
        System.out.printf("%d %d%n", mi, ma);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }

    }
}
