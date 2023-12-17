package Round_915.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a;
    static List<Integer> list;

    static void solve()  {
        n = Reader.nextInt();
        a = new int[n + 50];
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>(n);
        HashSet<Integer> set = new HashSet<>();
        int mex = 0;
        long sum = 0, ma = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = Reader.nextInt();
            set.add(a[i]);
            while (set.contains(mex)) {
                mex++;
            }
            sum += mex;
            deque.addLast(Pair.MakePair(mex, 1));
        }
        ma = sum;
        //System.out.println("i=0 Sum_Mex=" + sum);
        for (int i = 1; i < n; i++) {
            Pair<Integer, Integer> first = deque.getFirst();
            sum -= first.key;
            first.value--;
            if (first.value == 0) {
                deque.pollFirst();
            }
            Pair<Integer, Integer> cur = new Pair<>(a[i], 0);
            while (!deque.isEmpty() && deque.getLast().key > a[i]) {
                Pair<Integer, Integer> pair =  deque.getLast();
                sum -= (long) pair.key * pair.value;
                cur.value += pair.value;
                deque.pollLast();
            }
            deque.addLast(cur);
            deque.addLast(Pair.MakePair(n, 1));
            sum += (long) cur.key * cur.value + n;
            ma = Math.max(ma, sum);
            //System.out.printf("i=%d Sum_Mex=%d\n", i, sum);
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

        @Override
        public String toString() {
            return key.toString() + "=" + value.toString();
        }
    }
}
/**
 1
 8
 2 3 6 7 0 1 4 5



 */