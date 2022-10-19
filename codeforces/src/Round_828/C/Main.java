package Round_828.C;

import java.util.Scanner;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt();
        String cur = in.next();
        in.nextLine();
        String s = in.nextLine();
        s += s;
        int step = 0, ma = 0;

        if (cur.charAt(0) == 'g') {
            System.out.println("0");
            return;
        }

        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {

            if (cur.charAt(0) == s.charAt(i)) {
                if (!flag) {
                    step = 0;
                    flag = true;
                }
            }
            if (s.charAt(i) == 'g') {
                if (flag) {
                    ma = Math.max(ma, step);
                }
                step = 0;
                flag = false;
            }
            step++;
        }

        System.out.println(ma);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }

    }
}
