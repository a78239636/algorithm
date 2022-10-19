package justtry;

import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007;

    int[] next, nums;

    void  computeNext(String t) {
        long res = 1;

        int len = t.length();
        next = new int[len + 1];  // next[j] 表示从最大前后缀的长度
        nums = new int[len + 1];
        // 算next[1..len]
        // next[1] 不用算，必定为0sdfsdf

        for (int i = 2; i <= len; i++) {
            // next[i] 现在还是未知的，需要用next[i-1] 辅助算出来
            // 要比较的其实是 i 和 j + 1, 但是string下标从0开始的，所以比较i-1 和 j
            int j = next[i - 1];
            // 长度必须存在
            while (j != 0 && t.charAt(i - 1) != t.charAt(j)) {
                j = next[j];
            }
            if (t.charAt(i - 1) == t.charAt(j)) {
                next[i] = j + 1;
            }

            int k = next[i];
            int cnt = 0;
            while(k!= 0) {
                if (i >= k * 2) cnt++;
                k = next[k];
            }
            nums[i] = cnt;
        }


//        for (int i = 1; i<= len; i++) {
//            System.out.printf("%s ", i);
//        }
//        System.out.println();
//        for (int i = 1; i<= len; i++) {
//            System.out.printf("%s ", t.charAt(i-1));
//        }
//        System.out.println();
//        for (int i = 1; i<= len; i++) {
//            System.out.printf("%s ", next[i]);
//        }
//        System.out.println();
//        for (int i = 1; i<= len; i++) {
//            System.out.printf("%s ", nums[i]);
//        }
        for (int i = 1; i<= len; i++) {
            res = (res *  (nums[i] + 1)) % MOD;
        }
        System.out.println(res);
    }


    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0) {
            String s = in.next();
            main.computeNext(s);
            T--;
        }
    }
}