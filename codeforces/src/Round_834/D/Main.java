package Round_834.D;

import java.util.Scanner;

public class Main {

    static long[] num = new long[100];

    static void cal(long x, int k) {
        while (x % k == 0) {
            num[k]++;
            x /= k;
        }
    }

    static void solve(Scanner in) {
        long n = in.nextLong();
        long m = in.nextLong();
        num = new long[10];
        cal(n, 2);
        cal(n, 5);

        long cur = 1;
        long mi = Math.min(num[2], num[5]);
        long ma = Math.max(num[2], num[5]);
        for (long i = mi; i < ma; i++) {
            long mul = (num[2] < num[5] ? 2 : 5);
            if (mul * cur <= m) {
                cur *= mul;
            }else break;
        }

        //System.out.prlongln("初始倍数 = " + cur);

        for (long i = 10;  ; ) {
            if (i * cur <= m) {
                cur *= i;
            }else break;
        }

        cur = m / cur * cur;
        //System.out.prlongln("最终倍数 = " + cur);
        System.out.println(cur * n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}