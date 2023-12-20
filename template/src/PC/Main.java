package PC;


/**
 * 排列、组合、子集枚举
 */
public class Main {

    // 生成下一个排列并返回true, 如果无下一个返回false
    static boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1;; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
    }

    static void allPermutation() {
        int n = 5;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        do {
            for (int i = 0; i < n; i++) System.out.printf("%d%c", a[i], i == n - 1 ? '\n' : ' ');
        } while (next_permutation(a));
    }


    // 0...n-1 subset
    static void printSubset(int n, int s) {
        for (int i = 0; i < n; i++) {
            if ( (s & (1<<i)) != 0) System.out.printf("%d", i + 1);
        }
        System.out.println();
    }

    static void allSubSet() {
        int n = 5;
        for (int i = 0; i < (1<<n); i++) {
            printSubset(n, i);
        }
    }

    public static void main(String[] args) {
        //allPermutation();
        allSubSet();

    }
}
