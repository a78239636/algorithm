package Round_832.C;

import java.util.Scanner;

public class Main {


    static void solve(Scanner in) {
        int n = in.nextInt();

        if (n == 2) {
            System.out.println(2);
            return;
        }
        if (n == 3) {
            System.out.println(3);
            return;
        }
        if(n % 2 == 0) {
            System.out.println(2);
        }else {
            System.out.println(3);
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