package P2324;

import java.util.Scanner;

public class Main {

    static int[][] a, target;
    static int maxDep;

    static boolean checkStatus() {
        for (int i = 1; i <= 5; i++)
            for (int j = 1; j <= 5; j++)
                if (target[i][j] != a[i][j]) return false;
        return true;
    }

    static int cnt() {
        int num = 0;
        for (int i = 1; i <= 5; i++)
            for (int j = 1; j <= 5; j++) {
                if (a[i][j] != target[i][j]) num++;
            }
        return num;
    }

    static boolean dfs(int curDep, int sx, int sy) {
        if (curDep == maxDep) {
            if (checkStatus()) {
//                System.out.println();
//                System.out.println(curDep +" x =" + sx + " y = " + sy);
//                for (int i = 1;  i<=5;i++)
//                    for (int j =1;j<=5;j++)
//                        System.out.printf("%d%c", a[i][j], j==5 ? '\n' : ' ');

                return true;
            }
            return false;
        }
        int diff = cnt();
        if (curDep + diff > 16) return false;


        int[] dx = new int[] {-2, -1,  1, 2};
        int[] dy = new int[] {-2, -1,  1, 2};
        for (int i = 0; i < 4; i++) {
            for (int j = 0;j < 4;j++) {
                if (Math.abs(dx[i]) + Math.abs(dy[j]) != 3) continue;
                int nx = dx[i] + sx;
                int ny = dy[j] + sy;
                if (nx < 1 || nx > 5 || ny < 1 || ny > 5) continue;
                int tar = a[nx][ny];
                a[sx][sy] = tar;
                a[nx][ny] = -1;
                boolean res = dfs(curDep + 1, nx, ny);
                if (res) return true;
                a[nx][ny] = tar;
                a[sx][sy] = -1;
            }
        }
        return false;
    }


    static void solve(Scanner in) {

        int sx = 0, sy = 0;
        a = new int[6][6];

        for (int i = 1; i <= 5; i++) {
            String s = in.nextLine();
        //    System.out.println("line = " + s);
            for (int j = 1; j <= 5; j++) {
                if (s.charAt(j-1) == '0') a[i][j] = 0;
                if (s.charAt(j-1) == '1') a[i][j] = 1;
                if (s.charAt(j-1) == '*') {
                    a[i][j] = -1;
                    sx = i;
                    sy = j;
                }
            }
        }

        for (int i = 0; i <= 15; i++) {
            maxDep = i;
            if (dfs(0, sx, sy)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {

        target = new int[6][6];
        target[1][1] = target[2][2] = 1;
        target[3][3] = -1;
        for (int i = 1; i <= 4; i++)
            for (int j = 1; j <= 5; j++) {
                if (i < j) target[i][j] = 1;
            }
//        for (int i = 1;  i<=5;i++)
//            for (int j =1;j<=5;j++)
//                System.out.printf("%d%c", target[i][j], j==5 ? '\n' : ' ');


        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        while (T-- > 0) {
            solve(in);
        }
    }
}
/**
 *
 *     怎么搜索呢
 *
 *
 * A*  因为一次移动最多，消除两个不一样的地方，所以当前步数 + 消除至少需要的步数 > 15
 */
