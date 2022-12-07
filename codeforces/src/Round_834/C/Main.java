package Round_834.C;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static boolean judge(long l, long r, long x) {
        return  (l <= x && x <= r);
    }

    static void solve(Scanner in) {
        long l = in.nextLong(), r = in.nextLong(), x = in.nextLong();
        long a = in.nextLong(), b = in.nextLong();

        long dis =  b - a;
        if (dis == 0) {
            System.out.println(0);
            return;
        }
        if (dis >= x) {
            System.out.println(1);
            return;
        }
        if ( judge(l, r, a + x + dis) && Math.abs(x + dis) >= x) {
            System.out.println(2);
            return;
        }

        for (int i = 1; i <= 3; i++) {

            long step ; boolean flag = false;
            long cur = a;
            for (int j = 1; j <= 3; j++) {
                if (j == i) step = 2 * x - dis;
                else  step = x;
                if (Math.abs(step) < x) break;
                if (!judge(l, r, cur + step)) break;
                cur += step;
                if (i == 3) flag = true;
            }
            if (flag) {
                System.out.println(3);
                return;
            }
        }


        for (int i = 1; i <= 3; i++) {

            long step ; boolean flag = false;
            long cur = a;
            for (int j = 1; j <= 3; j++) {
                if (j == i) step = 2 * x - dis;
                else  step = -x;
                if (Math.abs(step) < x) break;
                if (!judge(l, r, cur + step)) break;
                cur += step;
                if (i == 3) flag = true;
            }
            if (flag) {
                System.out.println(3);
                return;
            }
        }

        System.out.println(-1);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}
/**
 *
 * if (a > b) {
 * 		swap(a, b);
 *        }
 * 	if (a == b) {
 * 		cout << 0 << endl;
 * 		return;
 *    }
 * 	if (b - a >= x) {
 * 		cout << 1 << endl;
 * 		return;
 *    }
 * 	if (r - a >= x && r - b >= x || a - l >= x && b - l >= x) {
 * 		cout << 2 << endl;
 * 		return;
 *    }
 * 	if (r - a >= x && r - l >= x && b - l >= x || a - l >= x && r - l >= x && r - b >= x) {
 * 		cout << 3 << endl;
 * 		return;
 *    }
 * 	cout << -1 << endl;
 *
 *
 */