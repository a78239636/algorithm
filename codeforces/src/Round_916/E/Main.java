package Round_916.E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean DEBUG = false;
    static int N, M;

    static int n, m;
    static int[] a, b;
    static List<Integer> list;

    static void init() {
        N = n + 10;
        a = new int[N];
        b = new int[N];
    }

    static void solve()  {
        n = Reader.nextInt();

        init();

        List<Pair<Integer, Integer>> list = new ArrayList<>(N);
        for (int i = 1; i <= n; i++) a[i] = Reader.nextInt();
        for (int i = 1; i <= n; i++) {
            b[i] = Reader.nextInt();
            list.add(new Pair<>(a[i] + b[i], i));
        }
        long ans = 0;
        list.sort(Comparator.comparingInt(x -> -x.key));
        for (int i = 1; i <= n; i++) {
            int pos = list.get(i - 1).value;
            if (i % 2 == 1) ans += a[pos] - 1;
            else ans -= b[pos] - 1;
        }
        System.out.println(ans);
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

        @Override
        public String toString() {
            return "Pair(" + key + ", " + value + ')';
        }
    }
    static class Tuple<F, S, T> {
        F a;
        S b;
        T c;
        Tuple(F first, S second, T third) {
            this.a = first;
            this.b = second;
            this.c = third;
        }

        @Override
        public String toString() {
            return "Tuple(" + a + ", " + b + ", " + c + ')';
        }
    }
}
/*





 */
