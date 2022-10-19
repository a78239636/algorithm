package Round_828.D;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int[] nums = new int[ 200000 + 50];
    static Map<Integer, Integer>[] cntDict = new Map[20000 + 50];
    static void init() {
        for (int i = 1; i <= 200000; i++) {
            int x = i, cnt = 0;
            while (x % 2== 0) {
                cnt++;
                x/=2;
            }
            nums[i] = cnt;
        }
    }

    static void solve(Scanner in) {
        int n = in.nextInt();

        int cur = 0;
        for (int i = 1; i <= n; i++) {
            int x  = in.nextInt();
            while (x % 2== 0) {
                cur++;
                x/=2;
            }
        }
   //     System.out.println("cur = " + cur);
        if (cur >= n) {
            System.out.println("0");
            return;
        }
        int add = 0;
        for (int i = 1; i <=n; i++)  {
            add += nums[i];
        }
        if (cur + add < n) {
            System.out.println("-1");
            return;
        }
        add = 0;
        Map<Integer, Integer> map = new HashMap<>(20);
        for (int i = 1; i <= n; i++) {
            Integer cnt = map.get(nums[i]);
            map.put(nums[i], cnt ==  null ? 1 : cnt + 1);
        }
        int result = 0;
        for (int i = 20; i >= 1; i--) {
            Integer cnt = map.get(i);
            if (cnt == null) continue;
            if (cnt * i + cur >= n) {
                int need = n - cur;
                if (need % i == 0) {
                    System.out.println(result + (need / i));
                    return;
                }else {
                    System.out.println(result + (need / i + 1));
                    return;
                }
            }else {
                result += cnt;
                cur += i * cnt;
            }
        }
    }

    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }

    }
}
