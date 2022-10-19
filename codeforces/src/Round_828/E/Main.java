package Round_828.E;

import java.util.Scanner;

public class Main {

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static void solve(Scanner in) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        for (int i = a + 1; i <= c; i++) {
            long base = (long) a * b;
            long x = i;
            long com = gcd(base, x);
//            System.out.println("base= " + base);
//            System.out.println("gcd = " + com);
        //    x/=com;

            long y;

            long add = x / com;
            long k = add;
            while(true) {
                y = k * base / x;

                if (y > d) break;
                if (y > b && y <= d) {
                    System.out.println(i + " " + y);
                    return;
                }
                k+=add;
            }
        }
        System.out.println("-1 -1");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }

    }
}
