package Round_833.C;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt();
        int[] a = new int[n + 50], sum = new int[n + 50];
        long cnt = 0, ma = 0, curSum = 0;
        boolean found = false;
        HashMap<Long, Long> freq = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            if (a[i] == 0) {
                if (found) cnt += ma;
                else cnt += freq.getOrDefault(0L, 0L);

                found = true;
                freq.clear();
                ma = 0;
            }
            curSum += a[i];
            ma = Math.max(ma, freq.merge(curSum, 1L, Long::sum));
        }

        if (found) cnt += ma;
        else cnt += freq.getOrDefault(0L, 0L);

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}