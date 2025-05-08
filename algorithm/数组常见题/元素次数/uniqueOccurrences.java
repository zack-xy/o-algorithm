package algorithm.数组常见题.元素次数;

import java.util.*;

public class uniqueOccurrences {
    /**
     *
     * [1207. 独一无二的出现次数](https://leetcode.cn/problems/unique-number-of-occurrences/description/)
     *
     */

    // 解法一：统计次数
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(Integer time : map.values()) {
            if (set.contains(time)) return false;
            else set.add(time);
        }
        return true;
    }

    // 官方代码风格
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();
    }

}
