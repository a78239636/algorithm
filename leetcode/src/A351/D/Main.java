package A351.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {



    static void solve() {
        int n = Reader.nextInt(), c = Reader.nextInt();
        long sum = 0;
        boolean flag = true;
        List<Pair> list = new ArrayList<>(n + 50);
        for (int i = 1; i <= n; i++) {
            long val = Reader.nextLong();
            if (i == 1) sum = val;
            if (i != 1)
                list.add(new Pair(i, val, val - (long) i * c));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Pair cur = list.get(i);
            if (sum + cur.val >= (long) cur.i * c) {
                sum += cur.val;
            }else {
                flag = false;
            }
        }
        System.out.println(flag ? "Yes" : "No");
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


    static class Pair implements Comparable<Pair>{
        int i;
        long val, rate;

        Pair(int x, long y, long rate) {
            this.i = x;
            this.val = y;
            this.rate = rate;
        }


        @Override
        public int compareTo(Pair other) {
            if (this.rate < other.rate) {
                return 1;
            } else if (this.rate > other.rate) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}