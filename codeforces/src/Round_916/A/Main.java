package Round_916.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a;
    static List<Integer> list;

    static void solve()  {
       n = Reader.nextInt();
       String s = Reader.next();
       int[] num = new int[50];
       for (int i = 0; i < s.length(); i++) {
           num[s.charAt(i) - 'A' + 1]++;
       }
       int cnt = 0;
       for (int i = 1; i <= 26; i++) {
           if (num[i] >= i) cnt++;
       }
       System.out.println(cnt);
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
