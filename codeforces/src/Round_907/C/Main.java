package Round_907.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * C题目丑陋的解法
 *
 * 优雅的解法是算一个 target = sum >> 1;
 * 然后从大到小减少a[i], 最后把剩下的加起来
 *
 *
 */
public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a;
    static List<Integer> list;

    static void solve()  {
        n = Reader.nextInt();
        a = new int[ n + 50];
        for (int i = 0; i < n; i++) {
            a[i] = Reader.nextInt();
        }
        Arrays.sort(a, 0, n);
        int l = 0, r = n - 1;
        long cnt = 0, sum = 0;
       /* for (int i = 0; i < n; i++) {
            System.out.printf("%d%c", a[i],  i == n - 1 ? '\n' : ' ');
        }*/

        while (l < r) {
            int lvalue = a[l], rvalue = a[r];

            if (sum + lvalue < rvalue) {
                sum+= lvalue;
                a[l] = 0;
                l++;
                cnt += lvalue;
                //System.out.println("决策 : 吞并" + (l-1) + " " + cnt);
                continue;
            }
            if(sum + lvalue == rvalue) {
                sum = 0;
                a[r] = a[l] = 0;
                l++;
                r--;
                cnt+= lvalue + 1;
                //System.out.println("决策 : 吞并且消除" + (l-1) + " " + cnt);
                continue;
            }
            if (sum + lvalue > rvalue) {
                a[l] -= (int) Math.abs(sum - rvalue);
                r--;
                cnt += Math.abs(sum - rvalue) + 1;
                sum = 0;
            }
        }
        if (a[l] != 0) {
            if(sum >= a[l]) cnt+=1;
            else {
                cnt += (a[l] - sum + 1)/2 + (a[l] > 1 ? 1 : 0);
            }
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
