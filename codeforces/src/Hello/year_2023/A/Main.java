package Hello.year_2023.A;

import java.util.Scanner;

public class Main {

    static void solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        if (s.contains("RL")) {
            System.out.println(0);
            return;
        }
        if (s.contains("LR")) {
            int k = s.indexOf("LR");
            System.out.println(k+1);
            return;
        }
        System.out.println("-1");
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
