package Round_906.B;

import java.util.Scanner;

public class Main {


    static boolean check(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return false;
        }
        return true;
    }

    static void judge() {
        String[] a = new String[] { "0", "01", "01010110010", "0000"};
        for (String s : a) {
            System.out.println("S = " + s + "ans = "+ check(s));
        }
    }

    static void solve(Scanner in) {
        int n = in.nextInt(), m = in.nextInt();
        String s = in.next(), t = in.next();
        if (check(s)) {
            System.out.println("Yes");
            return;
        }
        if (!check(s) && !check(t)) {
            System.out.println("No");
            return;
        }
        char left = t.charAt(0), right = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (s.charAt(i) == left || s.charAt(i + 1) == right) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        //judge();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}