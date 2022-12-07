package Global_Round_24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    static int T, n, k;
    static int[] a;
    List[] nodes = new ArrayList[200];  // 不支持泛型数组

    static void solve() {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        while (T > 0) {
            n = in.nextInt();
            a = new int[n + 50];

            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                if (i==1) System.out.printf("%d", i);
                else System.out.printf(" %d", i);
            }
            System.out.println();

            T--;
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
