package Round_909.E;

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
       a = new int[n + 10];
       int mi = Integer.MAX_VALUE;  // 最小值初始的不够大
       list = new ArrayList<>(n + 10);
       for (int i = 0; i < n; i++) {

           list.add(Reader.nextInt());
           //a[i] = Reader.nextInt();
           mi = Math.min(mi, list.get(i));
       }

       int cnt = 0;
       boolean flag = true;
       for (int i = 0; i < n; i++) {
           if (list.get(i) == mi) {
               for (int j = i + 1; j < n;j++) {
                   if (list.get(j) < list.get(j-1)) {
                       System.out.printf("-1\n");
                       return;
                   }
               }
               break;
           }
           cnt++;
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
/**
 *
 *
 * 基础类型的数组，没法直接自定义排序的
 *
 *
 */