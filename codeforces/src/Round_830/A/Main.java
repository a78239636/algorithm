package Round_830.A;

import java.util.Scanner;

public class Main {

    static  int[] a = new int[ 50 ];

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int allGcd(int n) {
        int x = a[1];
        for(int i = 2; i <=n; i++) {
            x = gcd(a[i], x);
        }
        return x;
    }

    static void solve(Scanner in) {
        int n = in.nextInt();

        for (int i = 1; i <= n; i++)
            a[i] = in.nextInt();

        int total = 0;
        int com = allGcd(n);
    //    System.out.println("AllGcd = " + com);
        if (com == 1) {
            System.out.println("0");
            return;
        }


        for (int i = n; i >= n - 1 && i >= 1; i--) {

            if (gcd(com, i) == 1) {
                System.out.println( (n - i + 1));
                return;
            }
        }

        System.out.println("3");

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}