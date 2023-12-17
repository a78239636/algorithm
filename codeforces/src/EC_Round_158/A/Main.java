package EC_Round_158.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean DEBUG = false;
    static int n, x;
    static int[] a;
    static List<Integer> list;


    static void solve()  {
       n = Reader.nextInt();
       x = Reader.nextInt();
       int mi = 0;
       a = new int[n + 50];
       a[n + 1] = x;
       for (int i = 1; i <= n; i++) {
           a[i] =  Reader.nextInt();
       }
        for (int i = 1; i <= n + 1; i++) {
            mi = Math.max(mi, (a[i] - a[i-1]) * (i == n + 1 ? 2 : 1));
        }
        System.out.println(mi);
    }
    public static void main(String[] args)  {
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