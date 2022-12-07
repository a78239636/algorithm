package Round_835.C;

import java.util.*;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        int[][] a = new int[n + 50][n + 50];
        for (int i = 1; i <= n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < s.length(); j++) {
                a[i][j+1] = s.charAt(j) - '0';
            }
        }

        int[] chu = new int[n + 50], ru = new int[n + 50];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i][j] == 1) {
                    ru[j]++;
                    chu[i]++;
                }
            }
        }

        Set<Integer>[] ans = new HashSet[n + 50];
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = new HashSet<Integer>();
            if (ru[i] == 0) {
                queue.add(i);
                ans[i].add(++num);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (a[x][i] == 1) {
                    chu[x]--;
                    ru[i]--;
                    ans[i].addAll(ans[x]);
                    if (ru[i] == 0) {
                        ans[i].add(++num);
                        queue.add(i);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i].size());
            for (Integer x : ans[i]) {
                System.out.print(" " + x);
            }
            System.out.println();
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
/**
 *
 * if (a > b) {
 * 		swap(a, b);
 *        }
 * 	if (a == b) {
 * 		cout << 0 << endl;
 * 		return;
 *    }
 * 	if (b - a >= x) {
 * 		cout << 1 << endl;
 * 		return;
 *    }
 * 	if (r - a >= x && r - b >= x || a - l >= x && b - l >= x) {
 * 		cout << 2 << endl;
 * 		return;
 *    }
 * 	if (r - a >= x && r - l >= x && b - l >= x || a - l >= x && r - l >= x && r - b >= x) {
 * 		cout << 3 << endl;
 * 		return;
 *    }
 * 	cout << -1 << endl;
 *
 *
 */