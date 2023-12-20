package Round_916.D;

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
       List<Pair<Integer, Integer>> listA = new ArrayList<>();
       List<Pair<Integer, Integer>> listB = new ArrayList<>();
       List<Pair<Integer, Integer>> listC = new ArrayList<>();

       for (int i = 1; i <= n; i++) {
           int val = Reader.nextInt();
           listA.add(new Pair<>(val, i));
       }
       for (int i = 1; i <= n; i++) {
            int val = Reader.nextInt();
            listB.add(new Pair<>(val, i));
       }
       for (int i = 1; i <= n; i++) {
            int val = Reader.nextInt();
            listC.add(new Pair<>(val, i));
       }
       listA.sort(Comparator.comparing(x -> -x.key));
       listB.sort(Comparator.comparing(x -> -x.key));
       listC.sort(Comparator.comparing(x -> -x.key));

       int ma = 0;
       n = Math.min(n, 5);
       for (int i = 0; i < n; i++)
           for (int j = 0; j < n; j++)
               for (int k = 0; k < n; k++) {
                   int posA = listA.get(i).value;
                   int posB = listB.get(j).value;
                   int posC = listC.get(k).value;

                   if (posA != posB && posA != posC && posC != posB) {
                       int cur = listA.get(i).key + listB.get(j).key + listC.get(k).key;
                       ma = Math.max(ma, cur);
                   }
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
/*

1
10
5 19 12 3 18 18 6 17 10 13
15 17 19 11 16 3 11 17 17 17
1 17 18 10 15 8 17 3 13 12


 */