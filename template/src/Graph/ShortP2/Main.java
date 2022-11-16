package Graph.ShortP2;

import java.util.*;

/**
 *
 * 最短路： SPFA 普通写法
 * 临接表存边
 */
public class Main {

    static int n, m, s;
    static List<Node> list[];
    static int[] dis;
    static boolean[] vis;
    final static int MAX = (1<<31) - 1;
    static int N;

    static class Node {
        int from, to, cost;

        public Node(int from, int to, int cost) {
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

    static void solve(Scanner in) {
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextInt();
        N = n + 10;
        dis = new int[ N ];
        list = new List[ N ];
        vis = new boolean[ N ];
        for (int i = 1; i <= n;i++) {
            list[i] = new ArrayList<>();
            dis[i] = MAX;
        }
        dis[s] = 0;

        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), cost = in.nextInt();
            list[x].add(new Node(x, y, cost));
        }
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.dis));
        queue.add(new Pair(s, 0));
        while(!queue.isEmpty()) {
            Pair top = queue.poll();
            int cur = top.x, curDis = top.dis;
            if (vis[cur]) continue;
            vis[cur] = true;
            for (Node node : list[cur]) {
                if (dis[node.to] > node.cost + curDis) {
                    dis[node.to] = curDis + node.cost;
                    queue.add(new Pair(node.to, dis[node.to]));
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