package algorithm.数组常见题.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
    /**
     *
     * [228. 汇总区间](https://leetcode.cn/problems/summary-ranges/description/)
     *
     */

    // 解法一：
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        // slow初始指向第1个区间的起始位置
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (fast + 1 == nums.length || nums[fast] + 1 != nums[fast+1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[slow]);
                if (slow != fast) {
                    sb.append("->").append(nums[fast]);
                }
                res.add(sb.toString());
                slow = fast + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        List<String> list = summaryRanges(nums);
        list.stream().forEach(System.out::println);
    }
}
