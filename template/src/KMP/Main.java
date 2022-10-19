package KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    int[] next;

    void show(int len) {
        for (int i = 1; i <= len; i++) {
            System.out.printf("%d%c", next[i], i == len ? '\n' : ' ' );
        }
    }

    void computeNext(String t) {
        int len = t.length();
        next = new int[ len + 1];  // next[j] 表示从最大前后缀的长度
        // 算next[1..len]
        // next[1] 不用算，必定为0

        for (int i = 2; i <= len; i++) {
            // next[i] 现在还是未知的，需要用next[i-1] 辅助算出来
            // 要比较的其实是 i 和 j + 1, 但是string下标从0开始的，所以比较i-1 和 j
            int j = next[i-1];
            // 长度必须存在
            while(j != 0 && t.charAt(i-1) != t.charAt(j)) {
                j = next[j];
            }

            if (t.charAt(i-1) == t.charAt(j)) {
                next[i] = j + 1;
            }
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
    }

    void match(String s, String t) {
        computeNext(t);
        int[] ma = new int[ s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            int j = ma[i-1];
            while(j!=0 && (j == t.length() || s.charAt(i-1) != t.charAt(j))) {
                j = next[j];
            }
            if (s.charAt(i-1) == t.charAt(j)) {
                ma[i] = j + 1;
            }
            if (ma[i] == t.length()) {
                System.out.printf("%d\n", i + 1 - t.length());
            }
        }

    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine() , t = input.readLine();
        main.match(s, t);
        main.show(t.length());
    }

}
