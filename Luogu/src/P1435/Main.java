package P1435;

import java.util.Scanner;

public class Main {

    static Scanner in;

    //TODO: ed 是字符串中的位置吗？
    /** ed是字符串中的位置 */
    static boolean check(String s, int st, int ed) {
        for (int l = 0; l <= (ed - st); l++) {
            if (s.charAt(st + l) != s.charAt(ed - l)) return false;
        }
        return true;
    }

    static void solve() {
        String s = in.nextLine();
        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int l = 1; l < s.length(); l++) {
            for (int st = 0; st + l < s.length(); st++) {
                int ed = st + l;
                if (s.charAt(st) == s.charAt(ed)) {
                    if (ed - st >= 2)
                        dp[st][ed] = dp[st+1][ed-1];   // check(s, st, ed)
                    else
                        dp[st][ed] = 0;
                }
                else {
                    dp[st][ed] = Math.min(dp[st + 1][ed], dp[st][ed - 1]) + 1;
                }
            }
        }

        System.out.println(dp[0][s.length() - 1]);
        /*for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                System.out.printf("(%d, %d) = %s %d\n", i, j, s.substring(i, j + 1), dp[i][j]);
            }
        }*/
    }

    public static void main(String[] args) {
       in = new Scanner(System.in);
       solve();
       //test();
    }



    static void test() {
        String a = "abcba";
        for (int i = 0; i < a.length(); i++) {
            for (int j = i; j < a.length(); j++) {
                System.out.printf("(%d, %d) = %s %c\n", i, j, a.substring(i, j + 1), check(a, i, j) ? 'Y' : 'N');
            }
        }
    }
}
// abcdb        ans=2