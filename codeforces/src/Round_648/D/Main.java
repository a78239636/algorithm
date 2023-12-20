package Round_648.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static boolean DEBUG = false;
    static int n, m;
    static char[][] a = new char[52][52];
    static List<Pair<Integer, Integer>> good, bad;
    static boolean[][] vis = new boolean[52][52];

    final static int[] dx = new int[] { -1, 0, 1,  0};
    final static int[] dy = new int[] {  0, 1, 0, -1};


    static boolean check() {
        for (Pair<Integer, Integer> cur : good) {
            int x = cur.key, y = cur.value;
            if (!vis[x][y]) return false;
        }
        return true;
    }

    static void endBad() {
        for (Pair<Integer, Integer> cur : bad) {
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + cur.key;
                int ny = dy[k] + cur.value;
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (a[nx][ny] == '.') a[nx][ny] = '#';
            }
        }
    }

    static void solve()  {
        n = Reader.nextInt();
        m = Reader.nextInt();
        good = new ArrayList<>();
        bad = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String line = Reader.next();
            for (int j = 1; j <= m; j++) {
                a[i][j] = line.charAt(j - 1);
                if(a[i][j] == 'G') good.add(new Pair<>(i, j));
                if(a[i][j] == 'B') bad.add(new Pair<>(i, j));
            }

        }
        int cnt = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
      /*  for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                vis[i][j] = false;


        queue.add(new Pair<>(n, m));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            vis[cur.key][cur.value] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.key;
                int ny = dy[i] + cur.value;
                if (nx < 1 || ny < 1 || nx > n || ny > m || vis[nx][ny] ||  a[nx][ny] == '#') continue;
                queue.add(new Pair<>(nx, ny));
            }
        }

        boolean flag = check();
        if (!flag) {
            System.out.println("NO");
            return;
        }*/

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                vis[i][j] = false;
        endBad();
        if (a[n][m] == '.')
            queue.add(new Pair<>(n, m));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            if (vis[cur.key][cur.value]) continue; // TODO ：非常关键, 原来是我bfs写丑了, 需要进一步思考和调查
            vis[cur.key][cur.value] = true;
            if (a[cur.key][cur.value] == 'G') cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.key;
                int ny = dy[i] + cur.value;
                if (nx < 1 || ny < 1 || nx > n || ny > m || vis[nx][ny] ||  a[nx][ny] == '#') continue;
                if (a[nx][ny] == 'B') {
                    System.out.println("NO");
                    return;
                }
                queue.add(new Pair<>(nx, ny));
            }
        }
        boolean flag = cnt == good.size();
        System.out.println(flag ? "YES" : "NO");
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

        @Override
        public String toString() {
            return "Pair(" + key + ", " + value + ')';
        }
    }
    static class Tuple<F, S, T> {
        F a;
        S b;
        T c;
        Tuple(F first, S second, T third) {
            this.a = first;
            this.b = second;
            this.c = third;
        }

        @Override
        public String toString() {
            return "Tuple(" + a + ", " + b + ", " + c + ')';
        }
    }
}
/*

5
2 5
B.GGG
.B.G.
3 6
BB#.GG
B.#B.G
.#.#G.
3 2
..
..
..
1 4
BBB.
4 9
###B##.B#
.####.##G
##.###.#.
...B#.B#.


总结：
8 = TLE*4 + WA*3 + RT*1
错了8次，有四次都是失智提交，接近试出来的
最后才发现BFS写的有问题，同一个节点可能入队多次
 */
