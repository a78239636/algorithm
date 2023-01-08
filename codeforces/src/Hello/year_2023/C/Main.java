package Hello.year_2023.C;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt(), m = in.nextInt();
        long[] a = new long[n + 50];
        for (int i = 1; i <= n; i++)
            a[i] = in.nextLong();
        int cnt = 0;

        long sum = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = m + 1; i <= n; i++) {
            if (a[i] < 0) queue.add(a[i]);
            sum += a[i];
            if (sum < 0) {
                if (!queue.isEmpty()) {
                    long rev = queue.poll();
                    sum -= 2 * rev;
                    cnt++;
                }
            }
        }

        sum = 0;
        queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = m; i >= 2; i--) {
            if (a[i] > 0) queue.add(a[i]);
            sum += a[i];
            if (sum > 0) {
                if (!queue.isEmpty()) {
                    long rev = queue.poll();
                    sum -= 2 * rev;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }

    }
}
