package Global_Round_24;

import java.util.*;

public class B {


    static void solve(Scanner in) {
        int n = in.nextInt();
        long ma = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            map.merge(x, 1, Integer::sum);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>( map.entrySet()  );
        list.sort(Map.Entry.comparingByKey());
        if (list.size() == 1) {
            System.out.println(list.get(0).getValue() / 2);
            return;
        }

        long top = 0, low = n;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            Map.Entry<Integer, Integer> pair = list.get(i);
            top += pair.getValue();
            low -= pair.getValue();
            ma = Math.max(ma, top * low);
        }
        System.out.println(ma);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0) {
            solve(in);
        }
    }
}