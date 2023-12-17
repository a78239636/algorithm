package Round_915.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cnt = 0;
    static int[] a;
    static List<Integer> list;

    static void solve()  {
       n = Reader.nextInt();
       int[] du = new int[n + 50];
       for (int i = 1; i < n; i++) {
           int x = Reader.nextInt();
           int y = Reader.nextInt();
           du[x]++;
           du[y]++;
       }
       int num = 0;
       for (int i =1; i<=n;i++) {
           if (du[i] == 1) num++;
       }
        System.out.println( (num + 1) / 2);
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

}
