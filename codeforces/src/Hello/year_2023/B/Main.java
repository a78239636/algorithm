
package Hello.year_2023.B;

import java.util.Scanner;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt();
        if (n % 2 == 0) {
            System.out.println("YES");
            for (int i = 1;  i <= n/2; i++) {
                System.out.printf("1 -1%c", i == (n/2) ? '\n' : ' ');
            }
        }else {
            if (n == 3) {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            int a = -(n - 3), b = n - 1;
            for (int i = 1; i <= n; i++) {
                System.out.printf("%d%c", i%2 == 1 ? a : b , i == n ? '\n' : ' ');
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        //System.out.println("T = " + T);
        while(T-- > 0) {
            solve(in);
        }
    }
}
