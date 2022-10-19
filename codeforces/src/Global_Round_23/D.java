package Global_Round_23;

import java.util.*;

public class D {
    static int T, n, k;
    static int[] a, parent;
    static List<Node> nodeList;
    static Map<Pair, Long> dp;
    static long ma = 0;

    static class Node {
        int x;
        int score;
        Node parent;
        Node(int x) {
            this.x = x;
        }
        List<Node> sons = new ArrayList<>(2);

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", score=" + score +
                    ", parent=" + (parent != null ? parent.x : "root") +
                    '}';
        }
    }

    static class Pair {
        int x, num;
        Pair(int x, int num) {
            this.x = x;
            this.num = num;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && num == pair.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, num);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "点=" + x +
                    ", 次数=" + num +
                    '}';
        }
    }


    static void findMax(List<Node> list, int index, int yu, int base, long total) {
        if (index == list.size()) {
            ma = Math.max(ma, total);
            return;
        }
        Node cur = list.get(index);
        if (yu > 0) {
            long num = dfs(cur.x, base + 1);
            findMax(list, index + 1, yu - 1, base,total + num);
        }
        long num = dfs(cur.x, base);
        findMax(list, index + 1, yu, base, total + num);
    }

    static long dfs(int x, int num) {

        Pair pair = new Pair(x, num);
        if (dp.get(pair) != null) return dp.get(pair);

        Node cur = nodeList.get(x);
        long sum = (long) num *  cur.score;
        int sonNum = cur.sons.size();

        if (sonNum == 0) {
            dp.put(pair, sum);
            return sum;
        }

        int base = num / sonNum, surplus = num % sonNum;
        for (int i = 0; i < sonNum; i++) {
            Node son = cur.sons.get(i);
            dfs(son.x, base);
            if(surplus != 0) {
                dfs(son.x, base + 1);
            }
        }
        findMax(cur.sons, 0, surplus, base, 0);
        sum += ma;
        ma = 0;
        dp.put(pair, sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        while (T > 0) {
            n = in.nextInt();
            k = in.nextInt();
            nodeList = new ArrayList<>(n + 50);
            dp = new HashMap<>(n + 50);

            for (int i = 0; i <=n; i++) {
                nodeList.add(new Node(i));
            }

            for (int i = 2; i <= n; i++) {
                int x = in.nextInt();
                Node cur = new Node(i);
                Node parent = nodeList.get(x);
                cur.parent = parent;
                parent.sons.add(cur);
                nodeList.add(cur);
            }

            for (int i = 1; i <= n; i++) {
                Node cur = nodeList.get(i);
                cur.score = in.nextInt();
            }
            long ans = dfs(1, k);
            System.out.println(ans);
            T--;
        }
    }
}
/**
 * 总结：泛型数组
 *
 *
 */
