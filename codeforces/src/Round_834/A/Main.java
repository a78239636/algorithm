package Round_834.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static boolean judge(String s) {

        List<Character> ch = new ArrayList<>();
        ch.add('Y');
        ch.add('e');
        ch.add('s');

        int index = ch.indexOf(s.charAt(0));
        if (index < 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ch.get( (index + i) % 3) ) return  false;
        }
        return true;
    }

    static void solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= n; i++) {
            String s = in.nextLine();
            System.out.println( judge(s) ? "YES" : "NO");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        solve(in);
    }
}