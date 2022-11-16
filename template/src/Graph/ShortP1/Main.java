package Graph.ShortP1;

import java.util.*;

/**
 *
 * 最短路： SPFA
 * 写法: 链式前向星 存边
 *
 *
 */
public class Main {

    final static int MAX = (1<<31) - 1;
    static int N;

    static int n, m, s, cnt;
    static Edge[] edges;
    static int[] dis, head;
    static boolean[] vis;


    static class Edge {
        int from, to, cost, next = 0;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    static class Pair {
        int x, dis;
        public Pair(int x, int dis) {
            this.x = x;
            this.dis = dis;
        }
    }

    static void addEdge(int from, int to, int cost) {
        Edge node = new Edge(from, to, cost);
        edges[++cnt] = node;
        edges[cnt].next = head[from];
        head[from] = cnt;
    }

    static void solve(Scanner in) {
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextInt();
        N = n + 10;
        dis = new int[ N ];
        head = new int[ N ];
        edges = new Edge[ m + 10 ];
        vis = new boolean[ N ];
        for (int i = 1; i <= n;i++) {
            dis[i] = MAX;
        }
        dis[s] = 0;

        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), cost = in.nextInt();
            addEdge(x, y, cost);
        }
        Queue<Pair> queue = new PriorityQueue<>(200000, Comparator.comparingInt(a -> a.dis));
        queue.add(new Pair(s, 0));
        while(!queue.isEmpty()) {
            Pair top = queue.poll();
            int cur = top.x, curDis = top.dis;
            if (vis[cur]) continue;
            vis[cur] = true;
            for (int i = head[cur]; i != 0; i = edges[i].next) {
                Edge edge = edges[i];
                if (dis[edge.to] > edge.cost + dis[edge.from]) {
                    dis[edge.to] = edge.cost + dis[edge.from];
                    queue.add(new Pair(edge.to, dis[edge.to]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d%s",dis[i], i == n ? "\n" : " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        solve(in);
    }
}