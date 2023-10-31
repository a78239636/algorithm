package Round_907.A;

import java.util.Scanner;

public class Main {



    static void solve(Scanner in) {
        int n = in.nextInt();
        int[] a = new int[100050], b = new int[50];
        boolean flag = true;

        for (int i = 1; i <=n; i++) {
            a[i] = in.nextInt();
        }

        b[0] = 1;
        for (int i = 1; i <= 10; i++) {
            b[i] = b[i-1] * 2;
        }

        for (int i = 1; i <= 10 ; i++) {
            int st = b[i], ed = b[i+1];
            if (ed - st <= 1) continue;
            for (int j = st + 1; j < ed && j < n; j++) {
                //System.out.println(j);
                if (a[j] > a[j+1]) flag = false;
            }
            //System.out.println();
        }

        if (flag) System.out.println("Yes");
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