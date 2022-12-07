package Global_Round_24;

import java.util.Scanner;

public class A {

    static void solve(Scanner in) {
        int n = in.nextInt();
        int[] a = new int[n + 50];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println("1 " + n);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }

    }
}
