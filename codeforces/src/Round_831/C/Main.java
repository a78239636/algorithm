package Round_831.C;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {


    static void solve(Scanner in) {

        int n = in.nextInt();

        List<Long> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            long x = in.nextLong();
            list.add(x);
        }
        list.sort(Comparator.comparingLong(o -> o));
        long ans1 = -999999999999L, ans2 = -999999999999L;
        for (int i = 0; i < list.size(); i++) {
            if (i >= 1 && i < list.size() - 1) {
                if (ans1 == -999999999999L) ans1 = list.get(i) - 2 * list.get(i - 1);
                else ans1 = Math.max(ans1, list.get(i) - 2 * list.get(i - 1));
            }
            if (i > 1) {
                if (ans2 == -999999999999L) ans2 = 2 * list.get(i) - list.get(i - 1);
                else ans2 = Math.max(ans2, 2 * list.get(i) - list.get(i - 1));
            }
        }

        long big = list.get(list.size() - 1);
        long min = list.get(0);
        System.out.println(Math.max(ans1 + big, ans2 - min));
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

 5 1
 21 32 32 32 10
 1 5

 7 1
 0 1 0 1 0 1 0
 1 7
 */
