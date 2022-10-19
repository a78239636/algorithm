package Round_828.A;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt();
        int[] a = new int[n + 50];
        Map<Integer, Character> map = new HashMap<>(n + 50);
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.nextLine();
        String s = in.nextLine();
        for (int i = 0; i < n; i++) {
            if (map.get(a[i]) == null) {
                map.put(a[i], s.charAt(i));
            }else {
                if (map.get(a[i]) != s.charAt(i)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }

    }
}
