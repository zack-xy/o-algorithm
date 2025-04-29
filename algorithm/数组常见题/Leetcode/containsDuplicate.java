package algorithm.数组常见题.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    /**
     *
     * [217. 存在重复元素](https://leetcode.cn/problems/contains-duplicate/description/)
     *
     */

    // 解法一：使用Set
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

    // 解法二：排序后扫描相邻的数字
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n-1;i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    // 解法？？：n^2 超出时间限制 ❌
    public boolean containsDuplicate3(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
