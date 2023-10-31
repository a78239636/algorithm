package Graph.MST;

import java.util.*;

public class Main {

    // 神奇 Comparable 不会超内存
    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static int[] parent = new int[5050];
    static Edge[] edgeList = new Edge[200005];


    static void init() {
        for (int i = 1; i <= n; i++) parent[i] = i;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void merge(int x, int y) {
        int finalParent = find(x);
        int son = find(y);
        parent[son] = finalParent;
    }

    static void input(Scanner in) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= m; i++) {
            int x, y, cost;
            x = in.nextInt();
            y = in.nextInt();
            cost = in.nextInt();
            edgeList[i] = new Edge(x, y, cost);
        }
    }

    static void solve() {
        init();
        Arrays.sort(edgeList, 1, m + 1);

        int sum = 0;
        for (int i = 1; i <= m; i++) {
            Edge edge = edgeList[i];
            if (find(edge.from) != find(edge.to)) {
                merge(edge.from, edge.to);
                sum+=edge.cost;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (find(parent[i]) == i) cnt++;
        }

        System.out.println(cnt > 1 ? "orz" : sum);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        input(in);
        solve();
    }
}