package Round_834.E;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    static void solve(Scanner in) {
        int n = in.nextInt();
        long h = in.nextLong();
        // 要吸取第n个人，是否
        long[][][]  power = new long[n + 50][3][2];
        long[] a = new long[ n + 50 ];
        for (int i = 1; i <= n; i++)
            a[i] = in.nextLong();
        Arrays.sort(a, 1, n + 1);
        power[0][2][1] = h;
     /*   power[0][0][1] = h * 2;
        power[0][1][0] = h * 3;
        power[0][0][0] = h * 6;*/

        for (int i = 0; i <= n; i++) {
            for (int j = 2; j >= 0; j--)
                for (int k = 1; k >= 0; k--) {
                    if (i >= 1) {
                        // power[i][j][k] = power[i - 1][j][k];

                        if (power[i-1][j][k] > a[i]) {
                            //System.out.println("i = " + i + " power " + power[i][j][k]);
                            power[i][j][k] = Math.max(power[i][j][k], power[i - 1][j][k] + a[i] / 2);
                        }
                    }

                    if (j == 0) { // 已经使用
                        power[i][j][k] = Math.max(power[i][j][k], power[i][j + 1][k] * 2);
                        power[i][j][k] = Math.max(power[i][j][k], power[i][j + 2][k] * 4);
                    }

                    if (j == 1) {
                        power[i][j][k] = Math.max(power[i][j][k], power[i][j + 1][k] * 2);
                    }

                    if (k == 0) {
                        power[i][j][k] = Math.max(power[i][j][k], power[i][j][k + 1] * 3);
                    }
                }
        }

        for (int i = 0; i <= n + 1; i++) {
            if (power[i][0][0] == 0) {
                System.out.println((i - 1));
                break;
            }
        }


        /*for (int i = 0; i <= n; i++){
            System.out.print("i=" + i + " : ");
            for (int j = 0; j <= 2; j++)
                for (int k = 0; k <= 1; k++) {
                    System.out.print(power[i][j][k] + " ");
                }
            System.out.println();
        }*/


        //System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}
