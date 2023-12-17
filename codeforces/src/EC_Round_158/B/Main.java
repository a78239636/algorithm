package EC_Round_158.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a, sum;
    static List<Integer> list;

    static void solve()  {
       n = Reader.nextInt();
       a = new int[n + 10];
       for (int i = 1; i <= n; i++) {
           a[i] = Reader.nextInt();
       }
      // System.out.println("你输出你妈呢");
       int mi = Integer.MAX_VALUE;
       long cnt = 0;
       Stack<Integer> stack = new Stack<>();
       for (int i = 1;i <= n;i++) {
           if (stack.empty() || stack.peek() <= a[i]) {
               stack.add(a[i]);
               System.out.printf("i = %d 入栈 = %d\n" , i,  a[i]);
               mi = Math.min(mi, a[i]);
           }else { //
               int len = 1, pre = -1;
               while (!stack.empty() && stack.peek() > a[i]) {
                   int cur = stack.pop();
                   System.out.println("出栈 " + cur);
                   if (stack.isEmpty()) {
                       cnt += (long) (cur - a[i]) * len;
                       System.out.printf("贡献 : %d = %d * %d\n", (cur - a[i]) * len, (cur - a[i]), len);
                   }
                   if (pre != -1) {
                       cnt += (long) (pre - cur);
                       System.out.printf("贡献 = %d pre = %d cur = %d \n" , (pre - cur), pre, cur);
                   }
                   pre = cur;
                   len++;
               }

           }
       }



        int len = 1, pre = -1;
        while (!stack.empty()) {
            int cur = stack.pop();
            if (stack.isEmpty()) {
                cnt += (long) (cur) * len;
                break;
            }
            if (pre != -1) {
                cnt += (long) (pre - cur);
            }
            pre = cur;
            len++;
        }
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
/***

80
3
3 99001 1000
3
3 100000000 10000001


 *
 *
 */