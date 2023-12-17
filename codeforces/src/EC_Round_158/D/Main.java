package EC_Round_158.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a;
    static List<Integer> list;


  /*  static void init() {
        int N = 100000000;
        for (int i = 1; i <= N; i++) {
            for (int j = i * 2;j <= N; j += i) {
                double x1 = Math.pow(2, (double)  j - i);
                int x2 = j / i;
                if ( Math.abs(x1 - x2) <= 0.0001 ) {
                    System.out.printf("%d %d\n", i ,j);
                }
            }
        }
    }*/

    static void solve()  {
       n = Reader.nextInt();
       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 1; i <= n; i++) {
           int k = Reader.nextInt();
           map.merge(k, 1, Integer::sum);
       }
       long cnt = 0;
       for (Integer x : map.keySet()) {
           int val = map.get(x);
           cnt += (long) (val - 1) * val / 2;
       }
       cnt += (long) map.getOrDefault(1, 0) * map.getOrDefault(2, 0);
       System.out.println(cnt);
    }
    public static void main(String[] args)  {
       // init();
        Reader.init();
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