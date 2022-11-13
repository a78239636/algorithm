package Round_833.B;

import java.util.Scanner;

public class Main {

    static int cnt(String s, int st, int ed) {
        int num = 0;
        int[] vis = new int[10];
        int dis = 0;
        int ma = 0;
        for (int i = st; i <= ed; i++) {
            int cur = (s.charAt(i) - '0');
            if (vis[cur] == 0) {
                dis++;
            }
            vis[cur]++;
            ma = Math.max(ma, vis[cur]);
            if (ma <= dis) num++;
        }
        return num;
    }

    static void solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        //System.out.println("s = " + s);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int len = 100; len <= 100; len++) {
                  int ed = (i + len - 1 >= n) ? n - 1 : (i + len - 1);
                  int cur = cnt(s, i, ed);
                  //System.out.printf("st = %d ed = %d Num = %d\n", i, ed, cur);
                  sum += cur;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}