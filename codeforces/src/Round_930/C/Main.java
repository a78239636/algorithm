package Round_930.C;

import java.util.Scanner;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt(), q = in.nextInt();

        //System.out.println("s = " + s);
        long[] a = new long[n + 50];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextLong();
        }

        in.nextInt();
        in.nextInt();
        long sum = 0, xor = 0, diff = 0, rsum = 0, rxor = 0;
        int l = 1, r = 1;
        for (int i = 1; i <= n; i++) {
            sum += a[i];
            xor = xor ^ a[i];
        //    System.out.println(sum + " " + xor + " "  + (sum - xor));
//            if (sum - xor == 0) {
//                sum = a[i];
//                xor = a[i];
//                diff = 0;
//                l = r = i;
//                continue;
//            }
            if (sum - xor > diff) {
                diff = sum - xor;
                rsum = sum;
                rxor = xor;
                r = i;
            }
        }
        for (int i = l ; i < r; i++) {
            rsum = rsum - a[i];
            rxor = rxor ^ a[i];
           // System.out.println("NewDiff = " + (rsum - rxor) + " Diff = " + diff);
            if (rsum - rxor == diff) {
                l++;
            }else  break;
        }
        for (int i = r ; i > l; i--) {
            rsum = rsum - a[i];
            rxor = rxor ^ a[i];
            // System.out.println("NewDiff = " + (rsum - rxor) + " Diff = " + diff);
            if (rsum - rxor == diff) {
                r--;
            }else  break;
        }


        System.out.println(l+ " " + r);
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

 5 1
 21 32 32 32 10
 1 5

 7 1
 0 1 0 1 0 1 0
 1 7
 */
