package Round_828.B;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt(), q = in.nextInt();
        int odd = 0, even = 0;
        int[] a = new int[n + 50];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] % 2 == 0) even++;
            else odd++;
            sum += a[i];
        }
        for (int i = 0; i < q; i++) {
            int type = in.nextInt(),  number = in.nextInt();
            if (type == 0) {
                sum += (long) even * number;
                if (number % 2 != 0) {
                    odd += even;
                    even = 0;
                }
            }
            if (type == 1) {
                sum += (long) odd * (long) number;
                if (number %2 != 0) {
                    even += odd;
                    odd = 0;
                }
            }
            System.out.println(sum);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }

    }
}
