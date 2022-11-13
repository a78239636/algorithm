package Util;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 寻找好的HashMap初始化和更新的写法
 *
 */
public class HashMapTest {

    static String key = "Item1";

    // 如果 key 为插入过，则 v == null, 因此无法初始化，不推荐使用
    @Deprecated
    public static void testComputeMethod() {
        HashMap<String, Integer> cntMap = new HashMap<>();
        cntMap.computeIfPresent(key, (k, v) -> v + 1);
        System.out.println(cntMap.get("Item1"));
    }

    // 很好用！！！
    public static void testMergeMethod() {
        HashMap<String, Integer> cntMap = new HashMap<>();
        cntMap.merge(key, 1, Integer::sum);
        System.out.println(cntMap.get(key));
    }


    public static void main(String[] args) {
        //testComputeMethod();
        testMergeMethod();
    }
}
