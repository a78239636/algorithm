package CodeTON_6.A;

import java.util.Scanner;

public class Main {
    static void solve(Scanner in) {
        int n = in.nextInt();
        int mex = in.nextInt();
        int ma = in.nextInt();

        if (mex > n || mex > ma + 1) {
            System.out.println("-1");
            return;
        }
        int sum = (mex) * (mex - 1) / 2;
        n -= (mex);
        if (n > 0 ) {
            if (ma > mex)
                sum += (n * ma);
            else
                sum += (n * (mex - 1));
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
