package A351.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    static int get1(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') num++;
        }
        return num;
    }

    static void judge() {
        String[] a = new String[] { "0", "01", "00011", "001", "0101", "0001"};
        for (String s : a) {
            System.out.println("S = " + s + " ans = "+ check(s));
        }
    }

    static void solve(Scanner in) {
        int n = in.nextInt();
        String s = in.next();

        if (s.length() % 2 == 1 ||  s.length() / 2  != get1(s)) {
            System.out.println("-1");
            return;
        }

        if (check(s)) {
            System.out.println("0\n");
            return;
        }

        int p = 0, remove = 0;
        StringBuilder ss = new StringBuilder(s);
        List<Integer> list = new ArrayList<>();
        while (!ss.isEmpty()) {
            if (ss.charAt(0) != ss.charAt(ss.length() - 1)) {
                ss.deleteCharAt(ss.length() - 1);
                ss.deleteCharAt(0);
                remove++;
                continue;
            }
            p++;
            if (ss.charAt(0) == '0') {
                ss.append("01");
                list.add(remove + ss.length() - 2);
                //System.out.println("insert " + (remove + ss.length() - 2));
            }else {
                ss.insert(0, "01");
                list.add(remove);
                //System.out.println("insert " + (remove));
            }
        }
        if (p > 300) {
            System.out.println("-1");
            return;
        }
        System.out.println(p);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d%c", list.get(i),  i == list.size() - 1 ? '\n' : ' ');
        }
    }

    public static void main(String[] args) {
        //judge();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}
/**
2
8
11000011
8
00111100



 */