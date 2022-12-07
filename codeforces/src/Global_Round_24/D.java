package Global_Round_24;

import java.util.*;

public class D {
    static void solve(Scanner in) {
        long n = in.nextInt(), p = in.nextInt();

        long cur = 3;
        for (long i = 5; i <= n; i+=2) {
            cur = i * ( 2 + 2 * (cur))% p;
            System.out.println(" i = " + i + " Ans = " + cur);
        }
        System.out.println(cur);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = 1;
        while(T-- > 0) {
            solve(in);
        }
    }
}
/**
 *
 * 74184767
 * 105242108
 *
 *
 */
