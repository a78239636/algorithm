package Round_833.A;

import java.util.Scanner;

public class Main {


    static void solve(Scanner in) {
        long n = in.nextLong();
      /*  long sum = 0;
        for (int i = 1; i <= n; i++)
            sum += (i+1)/2;*/
        System.out.println((n + 1)/2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}