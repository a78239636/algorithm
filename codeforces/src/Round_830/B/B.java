package Round_830.B;

import java.util.Scanner;

public class B {

    static void solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        //System.out.println("s = " + s);
        boolean start = false;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && !start) {
                start = true;
               // System.out.println("begin = " + i);
                continue;
            }
            if (start && s.charAt(i) != s.charAt(i-1)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}
