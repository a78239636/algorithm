package EC_Round_155.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static long MOD = 998244353;
    static int N = 3 * 100000 + 50;
    static long[] mul = new long[ N ];
    static void init() {
        mul[0] = 1;
        for (int i = 1; i < N; i++) {
            mul[i] = (mul[i - 1] % MOD * i) % MOD;
        }
    }
    static void solve()  {
        String s = Reader.next();
        int del = 0;
        long cnt = 1;
        int subLen = 1;
        int tot = 0;
        List<Long> lens = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                del++;
                subLen++;
            }else {
                //cnt = (cnt % MOD * mul[subLen]) % MOD;
                if (subLen > 1) {
                    tot += subLen - 1;
                    cnt = (cnt * subLen % MOD);
                }
                subLen = 1;
            }
        }
        if (subLen > 1) {
            tot += subLen - 1;
            cnt = (cnt * subLen % MOD);
        }
      /*  System.out.println(tot);*/
        cnt = (cnt % MOD * mul[tot]) % MOD;

        System.out.println(del + " "+ cnt);
    }
    public static void main(String[] args)  {
        Reader.init();
        init();
        int T = Reader.nextInt();
        while(T-- > 0) {
            solve();
        }
    }



    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * 初始化 从字节流到字符流，初始化分词器
         */
        static void init() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next()  {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    // ignore
                }
            }
            return tokenizer.nextToken();
        }

        static int nextInt()  {
            return Integer.parseInt(next());
        }

        static double nextDouble()  {
            return Double.parseDouble(next());
        }
    }
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        static Pair MakePair(int x, int y) {
            return new Pair(x, y);
        }

    }
}
