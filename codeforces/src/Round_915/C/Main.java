package Round_915.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a;
    static List<Integer> list;
    static class Pair {
        int val, pos;

        Pair(int x, int y) {
            this.val = x;
            this.pos = y;
        }

        static Pair MakePair(int x, int y) {
            return new Pair(x, y);
        }
    }

    static void solve()  {
        n = Reader.nextInt();
        String s = Reader.next();
        int[] a = new int[s.length() + 5];
        Stack<Pair> stack = new Stack<>();
        int ma = 0;
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - 'a';
            ma = Math.max(ma, a[i]);
            while (!stack.isEmpty() && a[i] > stack.peek().val) {
                stack.pop();
            }
            stack.add(new Pair(a[i], i));
        }
        int num = 0, cnt = 0;
        List<Pair> list1 = new ArrayList<>();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if (pair.val == ma) {
               num = cnt;
               ma++;
            }
            cnt++;
            list1.add(pair);
        }

        for (int i = 0; i < list1.size(); i++) {
            int pos = list1.get(list1.size() - 1 - i).pos;
            a[pos] = list1.get(i).val;
        }
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (a[i] >= a[i-1]) continue;
            flag = false;
            break;
        }
        System.out.println(flag ? num : "-1");
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

}
/*
1
15
czddeneeeemigec



 */
