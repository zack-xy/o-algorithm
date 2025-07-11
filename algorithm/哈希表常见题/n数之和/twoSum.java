package algorithm.哈希表常见题.n数之和;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * [1. 两数之和](https://leetcode.cn/problems/two-sum/description/)
 *
 */
public class twoSum {

    // 解法一：两层循环
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i=0;i<n;++i) {
            for (int j=i+1;j<n;++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 解法二：哈希表
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i=0;i<nums.length;++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
