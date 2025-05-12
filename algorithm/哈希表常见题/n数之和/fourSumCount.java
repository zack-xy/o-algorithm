package algorithm.哈希表常见题.n数之和;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * [454. 四数相加 II](https://leetcode.cn/problems/4sum-ii/description/)
 *
 */
public class fourSumCount {

    // 分组 + 哈希表
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 这个Map的key是两个数字和，value是这个和有几组
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : nums1) {
            for (int v : nums2) {
                countAB.put(u+v, countAB.getOrDefault(u+v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                if (countAB.containsKey(-u-v)) {
                    ans += countAB.get(-u-v);
                }
            }
        }
        return ans;
    }

}
