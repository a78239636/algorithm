package Global_Round_23;

import java.util.Scanner;

public class B {

    static int T, n, k;
    static int[] a;


    static void solve() {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        while (T > 0) {
            n = in.nextInt();
            a = new int[n + 50];

            int num = 0;
            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
            }
            int l = 1, r = n;
            while(l < r) {
                if (a[l] == 1) {
                    while(a[r] == 1) r--;
                    if (r <= l) continue;
                    if (a[r] == 0) {
                        a[l] = 0; a[r] = 1;
                        num++;
                        r--;
                    }
                }
                l++;
            }
            System.out.println(num);
            T--;
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
