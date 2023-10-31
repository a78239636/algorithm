package A351.B;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {



    static void solve(Scanner in) {

    }


    public int maximumPoints(int[][] edges, int[] coins, int k) {
        List<Integer>[] lists = new ArrayList[coins.length + 5];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int x = edge[0], y = edge[1];
            List<Integer> list = lists[x];
            if (list == null) {
                lists[x] = new ArrayList<>(3);
                list = lists[x];
            }
            list.add(y);

            list = lists[y];
            if (list == null) {
                lists[y] = new ArrayList<>(3);
                list = lists[y];
            }
            list.add(x);
        }

        return dfs(0, -1, lists, coins, k, 0);
    }

    int dfs(int i, int fa, List<Integer>[] lists, int[] coins, int k, int ce) {
        List<Integer> list = lists[i];
        int sum1 = 0, sum2 = 0;
        for (int next : list) {
            if (next != fa) {
                sum1 += dfs(next, i, lists,  coins,  k, ce);
                if (ce + 1 <= 16)
                    sum2 += dfs(next, i, lists,  coins,  k, ce + 1);
            }
        }
        sum1 += (coins[i] >> (ce) ) - k;
        sum2 += ( coins[i] >> (ce + 1) );
        System.out.println("i = " + i + "sum1 = " + sum1 + " sum2 = " + sum2);
        return Math.max(sum1 ,sum2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}