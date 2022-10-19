package Global_Round_23;

import java.util.Scanner;

public class A {

    static int T, n, k;
    static int[] a;


    static void read() {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        while (T > 0) {
            n = in.nextInt();
            k = in.nextInt();
            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                int x = in.nextInt();
                if (x == 1) flag = true;
            }
            System.out.println(flag ? "YES" : "NO");
            T--;
        }
    }

    public static void main(String[] args) {
        read();
    }
}
