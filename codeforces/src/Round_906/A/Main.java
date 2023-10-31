package Round_906.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {



    static void solve(Scanner in) {
        int n = in.nextInt();
        int[] a = new int[100050];
        int num = 0, ma = 0;

        for (int i = 1; i <=n; i++) {
            int x = in.nextInt();
            if (a[x] == 0) {
                num++;
            }

            a[x]++;
            ma = Math.max(ma, a[x]);
        }

        if (num == 1 ||  (num == 2 && ma == (n + 1)/2)) System.out.println("Yes");
        else System.out.println("No");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}