package Round_831.D;

import java.util.*;

public class Main {

    static int[] a;
    static int num1, num2, n;

    static void solve(Scanner in) {
        num1 = in.nextInt();
        num2 = in.nextInt();
        n = in.nextInt();
        a = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        boolean flag = true;
        int target = n, bound = (num1 ) * (num2 ) - 3;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= n; i++) {
            queue.add(a[i]);
            while (!queue.isEmpty() && queue.peek() == target) {
                queue.poll();
                target--;
            }
            if (queue.size() >= bound) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YA" : "TIDAK");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}
/**
  题解 : 上限是 n*m - 3个位置，此时即使是想要的数字来了也没用了


 */