package Round_916.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a, b;
    static List<Integer> list;

    static void solve()  {
       n = Reader.nextInt();
       int k = Reader.nextInt();
       int[] sum = new int[n + 50];
       int[] mValue = new int[n + 50];
       a = new int[n + 50];
       b = new int[n + 50];
       for (int i = 1; i <= n; i++) {
           a[i] = Reader.nextInt();
           sum[i] = sum[i-1] + a[i];
       }
       for (int i = 1; i <= n; i++) {
           b[i] = Reader.nextInt();
           mValue[i] = Math.max(mValue[i-1], b[i]);
       }
       long ma = 0;
       for (int i = 1; i <= n; i++) {
           if (k < i) break;
           long cur = sum[i];
           cur += (long) (k - i) * mValue[i];
           //System.out.printf("i=%d sum=%d\n",i, cur);
           ma = Math.max(ma, cur);
       }
       System.out.println(ma);
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
    static class Pair<K, V> {
        K key;
        V value;

        Pair(K x, V y) {
            this.key = x;
            this.value = y;
        }
        public static <K, V> Pair<K, V> MakePair(K x, V y) {
            return new Pair<K, V>(x, y);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
