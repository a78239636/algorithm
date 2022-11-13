package Round_833.D;

import java.util.Scanner;

public class Main {


    static void solve(Scanner in) {
        int n = in.nextInt();
        System.out.println(n - (n/3));
        int num = n;
        int a = 1, b = 3;
        while (num-- > 0) {
            System.out.println(a +" " + b);
            a++;
            b+=3;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}