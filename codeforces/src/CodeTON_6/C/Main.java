package CodeTON_6.C;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {




    static void solve() throws IOException {
        int n = Reader.nextInt();
        int k = Reader.nextInt();

        List<Pair> list = new ArrayList<>(n + 10);
        for (int i = 1; i <= n; i++) {
            int x = Reader.nextInt();
            list.add( new Pair(x, i) );
        }
        list.sort(Comparator.comparing(pair -> -pair.col));


        /*System.out.println("-----------------");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf(" %d", Math.min(a[i], a[j]));
            }
            System.out.println();
        }
        System.out.println("-----------------");*/
        int ma = 0, mi = 99999999;
        int[] sum = new int[k + 50];
        for (int i = 0; i < n; i++) {
            Pair pair = list.get(i);
            int col = pair.col;
            ma =  Math.max(ma, pair.pos);
            mi =  Math.min(mi, pair.pos);
            sum[ col ] = 2 * (ma - mi + 1);
        }
        for (int i = 1; i <= k; i++) {
            System.out.printf("%d%c", sum[i], i == k ? '\n' : ' ');
        }

    }

    public static void main(String[] args) throws IOException {
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
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
    static class Pair {
        int col, pos;
        Pair(int col, int pos) {
            this.col = col;
            this.pos = pos;
        }
    }
}
