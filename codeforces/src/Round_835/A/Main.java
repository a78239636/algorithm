package Round_835.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    static void solve(Scanner in) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        if (a == n && b == n) {
            System.out.println("Yes");
            return;
        }
        if (a + b + 2 <= n) System.out.println("Yes");
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