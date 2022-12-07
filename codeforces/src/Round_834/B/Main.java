package Round_834.B;

import java.util.Scanner;

public class Main {



    static void solve(Scanner in) {
        int n = in.nextInt(), s = in.nextInt();
        int ma = 0;
        for (int i = 1; i <= n; i++) {
            int x = in.nextInt();
            ma = Math.max(ma, x);
            s += x;
        }
        boolean flag = false;

        for (int i = 1; i <= 100; i++) {
            // 错的离谱呀，太菜了。 你组成的排列，至少也应该有数组里最大的数字
            // 比如 sum = 6, 但是有两种情况 [1,2,3]、
            if ( i * (i + 1) / 2 == s && i >= ma)  {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        }else System.out.println("NO");

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}