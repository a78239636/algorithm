package Round_907.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {



    static void solve() {
        int n = Reader.nextInt(), q = Reader.nextInt();
        int[]  b = new int[q + 50], c = new int[500], num = new int[500];
        long[] a = new long[ n + 50];
        c[0] = 1;
        for (int i = 1; i <= 30; i++) {
            c[i] = c[i - 1] * 2;
        }

        for (int i = 1; i <=n ; i++) {
            a[i] = Reader.nextInt();
        }
        for (int i = 1; i <= q; i++) {
            b[i] = Reader.nextInt();
            num[b[i]]++;
        }


            for (int j = 30; j >=1; j--) {
                int md = c[ j ];
                for (int i = 1; i <= n; i++) {
                    //System.out.printf("i = %d md = %d\n", i ,  md);
                    if (a[i] % md == 0) {
                        a[i] += (long) c[j - 1] * num[j];
                    }
                }
            }


        for (int i = 1; i <= n; i++) {
            System.out.printf("%d%c",  (long) a[i], i != n ? ' ' : '\n');
        }

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

        static long nextLong()  {
            return Long.parseLong(next());
        }
        static double nextDouble()  {
            return Double.parseDouble(next());
        }
    }
}