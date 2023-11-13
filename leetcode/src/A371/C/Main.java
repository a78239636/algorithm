package A371.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a;
    static List<Integer> list;

    public int minOperations(int[] nums1, int[] nums2) {

        int n = nums1.length;
        boolean upBig = nums1[n - 1] >= nums2[n - 1];
        int ma1 = nums1[n - 1], ma2 = nums2[n - 1];
        int mi = Math.min(ma1, ma2);
        System.out.println("mi =" + mi);
        int cnt1 = 0, cnt2 = 0, res = 0;
        for (int i = 0; i <= n - 2; i++) {
            int cur1 = nums1[i], cur2 = nums2[i];
            if (cur1 > mi) {
                cnt1++;
            }
            if (cur2 > mi) {
                cnt2++;
            }
            if (cur1 > mi && cur2 > mi) {
                return -1;
            }
        }
        if (upBig) {
            return Math.min(cnt2, cnt1 + 1);
        }else {
            return Math.min(cnt1, cnt2 + 1);
        }
    }


    static void solve()  {
       n = Reader.nextInt();
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