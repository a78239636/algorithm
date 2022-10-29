package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class S1 {
    long limit = 2098074743;

    static class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K, V>>  {
        K key;
        V val;
        Pair(K k, V v) {
            this.key = k;
            this.val = v;
        }

        @Override
        public int compareTo(Pair<K, V> o) {
            if (!val.equals(o.val)) {
                return val.compareTo(o.val);
            }
            if (!key.equals(o.key)) {
                return key.compareTo(o.key);
            }
            return 0;
        }
    }


    static void init() {
        List<String> list = new ArrayList<>();
        list.sort(Comparator.comparingInt(String::length));

        PriorityQueue<Pair<String, Integer>> queue = new PriorityQueue<>();
        queue.add(new Pair<>("Bob", 7));
        queue.add(new Pair<>("Alice", 1) );
        while (!queue.isEmpty()) {
            Pair<String, Integer> element = queue.poll();
            System.out.println(element.key + " :" + element.val);
        }
    }

    public static void main(String[] args) {
        init();
    }
}
