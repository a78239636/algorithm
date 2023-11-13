package A371.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static int[] a;
    static List<Integer> list;


    public boolean check(List<String> list) {
        list.sort(Comparator.comparing(x -> x));
        for (int i = 0; i < list.size(); i++) {
            int start = Integer.parseInt(list.get(i));
            int num = 1;
            for (int j = i+1; j < list.size(); j++) {
                int end = Integer.parseInt(list.get(j));
                if (end - start < 100) {
                    System.out.println("start=" + start  + " end = " + end);
                    num++;
                    if (num >= 3) return true;
                }
            }
        }
        return false;
    }

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> record : access_times) {
            String user = record.get(0);
            String time = record.get(1);
            List<String> tmp = map.getOrDefault(user, new ArrayList<String>(10));
            tmp.add(time);
            map.put(user, tmp);
        }
        List<String> res = new ArrayList<>();
        for (String user : map.keySet()) {
            System.out.println("检测的是 " + user);
            if (check(map.get(user))) res.add(user);
        }
        return res;
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
/*
map 的写法
map 的遍历


 */