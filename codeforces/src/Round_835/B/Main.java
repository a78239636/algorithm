package Round_835.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static List<Integer> erase(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        if (list.size() <= 1) return list;
        int cur = list.get(0);
        newList.add(cur);
        for (int k = 1; k < list.size(); k++) {
            if (list.get(k) == cur || (k == list.size() - 1 && list.get(0).equals(list.get(k)))) continue;
            cur = list.get(k);
            newList.add(cur);
        }
        return newList;
    }

    static List<Integer> select(List<Integer> list) {
        if (list.size() == 1) return new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int left = i == 0 ? list.get(list.size() - 1) : list.get(i - 1);
            int right = i == list.size() - 1 ? list.get(0) : list.get(i + 1);
            if (left != right) {
                list.remove(i);
                return list;
            }
        }
        list.remove(0);
        return list;
    }

    static void solve(Scanner in) {
        int n = in.nextInt();

        int[] a = new int[110];
        int[] num = new int[110];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            num[ a[i] ]++;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int left = (i == 1 ? a[n] : a[i-1]);
            int right  = (i == n ? a[1] : a[i + 1]);
            cnt += (left == right ? 1 : 0);
        }
        //System.out.println("cnt ");

        if (cnt == n) {
            System.out.println( (n + 2) / 2);
        }else System.out.println(n);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}
/*

5
5
1 2 3 1 2
5
3 2 1 2 1


 */