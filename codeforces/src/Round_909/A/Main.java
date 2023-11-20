package Round_909.A;

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

    static boolean  check(String s, int k) {
        int cnt = 0;
        for (int i = 0; i < s.length();i++)
            if (s.charAt(i) == 'B') cnt++;
        return cnt == k;
    }
    static void solve()  {
       n = Reader.nextInt();
       int k = Reader.nextInt();
       String s = Reader.next();
        //System.out.println("s=" + s);
       if (check(s, k)) {
           System.out.println("0");
           return;
       }

       for (int i = 1; i <= n; i++) {

           String sb1 = "", sb2 = "";
           for (int t = 1; t<=i; t++) {
               sb1 += "A";
               sb2 += "B";
           }

           String s1 =  sb1 +  s.substring(i);
           //System.out.println("s1=" + s1 + "sub= " + s.substring(i));
           String s2 =  sb2 + s.substring(i);
          //System.out.println("s2=" + s2 + "sub= " + s.substring(i));
           if (check(s1, k)) {
               System.out.println("1");
               System.out.println((i) + " " + "A");
               return;
           }
           if (check(s2, k)) {
               System.out.println("1");
               System.out.println((i ) + " " + "B");
               return;
           }
       }
        System.out.println("2");
        System.out.println(n + " " + "A");
        System.out.println(k + " " + "B");
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