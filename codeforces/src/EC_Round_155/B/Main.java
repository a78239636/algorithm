package EC_Round_155.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static void solve()  {
        int n = Reader.nextInt();
        int[] a = new int[n + 50];
        int[] b = new int[n + 50];
        long sum1 = 0, sum2 = 0, minx = 99999999999L, miny = 99999999999L;
        for (int i = 1; i <= n; i++) {
            a[i] = Reader.nextInt();
            sum1+=a[i];
            minx = Math.min(minx, a[i]);
        }
        for (int i = 1; i <= n; i++) {
            b[i] = Reader.nextInt();
            sum2+=b[i];
            miny = Math.min(miny, b[i]);
        }
/*
        Arrays.sort(a, 1, n + 1);
        Arrays.sort(b, 1, n + 1);*/
        long x = sum1 + (long) n * miny;
        long y = sum2 + (long) n * minx;
        System.out.println(Math.min(x, y));
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
